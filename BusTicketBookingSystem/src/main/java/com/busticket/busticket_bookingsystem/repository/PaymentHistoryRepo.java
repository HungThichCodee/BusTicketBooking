package com.busticket.busticket_bookingsystem.repository;

import com.busticket.busticket_bookingsystem.entity.booking.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentHistoryRepo extends JpaRepository<PaymentHistory, Long> {

    List<PaymentHistory> findAllByBookingId(Long id);
}
