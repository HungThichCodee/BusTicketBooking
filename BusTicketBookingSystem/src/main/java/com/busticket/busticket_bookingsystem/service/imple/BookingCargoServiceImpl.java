package com.busticket.busticket_bookingsystem.service.imple;

import com.busticket.busticket_bookingsystem.dto.request.CargoRequest;
import com.busticket.busticket_bookingsystem.entity.booking.Booking;
import com.busticket.busticket_bookingsystem.entity.booking.BookingCargo;
import com.busticket.busticket_bookingsystem.entity.booking.Cargo;
import com.busticket.busticket_bookingsystem.exception.ResourceNotFoundException;
import com.busticket.busticket_bookingsystem.repository.BookingCargoRepo;
import com.busticket.busticket_bookingsystem.repository.CargoRepo;
import com.busticket.busticket_bookingsystem.service.inter.BookingCargoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingCargoServiceImpl implements BookingCargoService {
    private final CargoRepo cargoRepo;
    private final BookingCargoRepo bookingCargoRepo;

    @Override
    @Transactional
    public BookingCargo addCargoToBooking(Booking booking, CargoRequest cargoRequest) {
        Cargo cargo = cargoRepo.findById(cargoRequest.getCargoId())
                .orElseThrow(() -> new ResourceNotFoundException("Cargo not found"));

        BigDecimal totalCargoPrice = cargo.getBasePrice().multiply(new BigDecimal(cargoRequest.getQuantity()));

        BookingCargo bookingCargo = BookingCargo.builder()
                .booking(booking)
                .cargo(cargo)
                .quantity(cargoRequest.getQuantity())
                .price(totalCargoPrice)
                .build();

        return bookingCargoRepo.save(bookingCargo);
    }

    @Override
    public BigDecimal calculateTotalCargoPrice(List<BookingCargo> bookingCargos) {
        return bookingCargos.stream()
                .map(BookingCargo::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
