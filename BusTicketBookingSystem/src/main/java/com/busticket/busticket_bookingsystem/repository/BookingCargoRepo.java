package com.busticket.busticket_bookingsystem.repository;

import com.busticket.busticket_bookingsystem.entity.booking.BookingCargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingCargoRepo extends JpaRepository<BookingCargo, Long> {
}
