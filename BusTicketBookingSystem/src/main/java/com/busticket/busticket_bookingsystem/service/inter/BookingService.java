package com.busticket.busticket_bookingsystem.service.inter;


import com.busticket.busticket_bookingsystem.dto.request.BookingRequest;
import com.busticket.busticket_bookingsystem.dto.response.PageResponse;
import com.busticket.busticket_bookingsystem.entity.booking.Booking;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {

    List<Booking> findAllByPhone(String phone);

    List<Booking> findAllByUsername(String username);

    Booking findById(Long id);

    List<Booking> findAll();

    PageResponse<Booking> findAll(Integer page, Integer limit);

    List<Booking> saveForRegisteredUser(BookingRequest bookingRequest);

    List<Booking> saveForWalkInCustomer(BookingRequest bookingRequest);

    Booking update(Booking booking);

    String delete(Long id);
    Booking confirmRefund(Long bookingId);

    List<Booking> getAllBookingFromTripAndDate(Long tripId);

    List<Booking> findBookingsByPhone(String phone);

    List<String> getAvailableSeats(Long tripId);
    Booking getBookingWithCargos(Long bookingId);
}
