package com.busticket.busticket_bookingsystem.controller;

import com.busticket.busticket_bookingsystem.entity.booking.PaymentHistory;
import com.busticket.busticket_bookingsystem.service.inter.PaymentHistoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/paymentHistories")
@Tag(name = "PaymentHistory Controller")
public class PaymentHistoryController {

    private final PaymentHistoryService paymentHistoryService;

    @GetMapping("/all/{id}")
    public List<PaymentHistory>  getHistoriesPaymentOfBooking(@PathVariable Long id) {
        return paymentHistoryService.findHistoriesByBookingId(id);
    }
}
