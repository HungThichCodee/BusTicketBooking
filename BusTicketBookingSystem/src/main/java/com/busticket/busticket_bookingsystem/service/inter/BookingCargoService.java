package com.busticket.busticket_bookingsystem.service.inter;


import com.busticket.busticket_bookingsystem.dto.request.CargoRequest;
import com.busticket.busticket_bookingsystem.entity.booking.Booking;
import com.busticket.busticket_bookingsystem.entity.booking.BookingCargo;

import java.math.BigDecimal;
import java.util.List;

public interface BookingCargoService {
    BookingCargo addCargoToBooking(Booking booking, CargoRequest cargoRequest);
    BigDecimal calculateTotalCargoPrice(List<BookingCargo> bookingCargos);
}
