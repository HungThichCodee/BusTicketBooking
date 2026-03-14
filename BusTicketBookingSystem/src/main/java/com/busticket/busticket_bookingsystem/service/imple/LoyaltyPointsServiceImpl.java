package com.busticket.busticket_bookingsystem.service.imple;


import com.busticket.busticket_bookingsystem.dto.LoyaltyTransactionDTO;
import com.busticket.busticket_bookingsystem.dto.response.PageResponse;
import com.busticket.busticket_bookingsystem.entity.booking.Booking;
import com.busticket.busticket_bookingsystem.entity.booking.LoyaltyTransaction;
import com.busticket.busticket_bookingsystem.entity.entityUser.User;
import com.busticket.busticket_bookingsystem.entity.operate.Trip;
import com.busticket.busticket_bookingsystem.enums.TransactionType;
import com.busticket.busticket_bookingsystem.exception.ResourceNotFoundException;
import com.busticket.busticket_bookingsystem.repository.BookingRepo;
import com.busticket.busticket_bookingsystem.repository.LoyaltyTransactionRepo;
import com.busticket.busticket_bookingsystem.repository.UserRepo;
import com.busticket.busticket_bookingsystem.service.inter.LoyaltyPointsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class LoyaltyPointsServiceImpl implements LoyaltyPointsService {
    private static final BigDecimal POINTS_RATE = new BigDecimal("0.005");

    private final UserRepo userRepo;

    private final BookingRepo bookingRepo;

    private final LoyaltyTransactionRepo loyaltyTransactionRepo;

    @Override
    @Transactional
    public void earnPoints(Long bookingId) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        User user = userRepo.findByUsername(booking.getUser().getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        BigDecimal pointsEarned = booking.getTotalPayment().multiply(POINTS_RATE);

        if (pointsEarned == null || pointsEarned.compareTo(BigDecimal.ZERO) < 0) {
            pointsEarned = BigDecimal.ZERO;
        }

        booking.setPointsEarned(pointsEarned);
        bookingRepo.save(booking);

        LoyaltyTransaction transaction = new LoyaltyTransaction();
        transaction.setUser(user);
        transaction.setBooking(booking);
        transaction.setAmount(pointsEarned);
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setTransactionType(TransactionType.EARN);
        loyaltyTransactionRepo.save(transaction);

        userRepo.addLoyaltyPoints(user.getUsername(), pointsEarned);
    }

    @Override
    public PageResponse<LoyaltyTransactionDTO> getLoyaltyTransactions(String username, Integer page, Integer limit) {
        Page<LoyaltyTransaction> transactionPage = loyaltyTransactionRepo.findByUserUsernameOrderById(username, PageRequest.of(page, limit));
        PageResponse<LoyaltyTransactionDTO> pageResponse = new PageResponse<>();
        pageResponse.setDataList(transactionPage.getContent().stream().map(this::convertToDTO).toList());
        pageResponse.setPageCount(transactionPage.getTotalPages());
        pageResponse.setTotalElements(transactionPage.getTotalElements());
        return pageResponse;
    }

    @Override
    @Transactional
    public void usePoints(Long bookingId, BigDecimal pointsToUse) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        User user = userRepo.findByUsername(booking.getUser().getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (user.getLoyaltyPoints().compareTo(pointsToUse) < 0) {
            throw new ResourceNotFoundException("Not enough loyalty points");
        }

        booking.setPointsUsed(pointsToUse);
        booking.setTotalPayment(booking.getTotalPayment().subtract(pointsToUse));
        bookingRepo.save(booking);

        LoyaltyTransaction transaction = new LoyaltyTransaction();
        transaction.setUser(user);
        transaction.setBooking(booking);
        transaction.setAmount(pointsToUse.negate());
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setTransactionType(TransactionType.USE);
        loyaltyTransactionRepo.save(transaction);

        userRepo.deductLoyaltyPoints(user.getUsername(), pointsToUse);
    }

   @Override
    public BigDecimal getLoyaltyPoints(String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return user.getLoyaltyPoints();
    }

    @Override
    public List<LoyaltyTransactionDTO> getLoyaltyTransactions(String username) {
        List<LoyaltyTransaction> transactions = loyaltyTransactionRepo.findByUserUsernameOrderById(username);

        return transactions.stream()
                .map(transaction -> {
                    LoyaltyTransactionDTO dto = new LoyaltyTransactionDTO();
                    dto.setTransactionId(transaction.getId());
                    dto.setAmount(transaction.getAmount());
                    dto.setTransactionDate(transaction.getTransactionDate());
                    dto.setTransactionType(transaction.getTransactionType().name());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public LoyaltyTransactionDTO convertToDTO(LoyaltyTransaction transaction) {
        Booking booking = transaction.getBooking();
        Trip trip = booking.getTrip();
        User user = transaction.getUser();

        return LoyaltyTransactionDTO.builder()
                .transactionId(transaction.getId())
                .amount(transaction.getAmount())
                .transactionDate(transaction.getTransactionDate())
                .transactionType(transaction.getTransactionType().name())

                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())

                .bookingId(booking.getId())
                .seatNumber(booking.getSeatNumber())
                .totalPayment(booking.getTotalPayment())
                .bookingDateTime(booking.getBookingDateTime())

                .tripId(trip.getId())
                .source(trip.getSource().getName())
                .destination(trip.getDestination().getName())
                .departureDateTime(trip.getDepartureDateTime())
                .price(trip.getPrice())
                .build();
    }
}
