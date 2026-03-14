package com.busticket.busticket_bookingsystem.service.inter;


import com.busticket.busticket_bookingsystem.entity.booking.PaymentHistory;

import java.util.List;

public interface PaymentHistoryService {

    List<PaymentHistory> findHistoriesByBookingId(Long bookingId);

    List<PaymentHistory> findAll();

    List<PaymentHistory> findAll(Integer page, Integer limit, String sortBy);

}
