package com.busticket.busticket_bookingsystem.service.inter;

import com.busticket.busticket_bookingsystem.dto.LoyaltyTransactionDTO;
import com.busticket.busticket_bookingsystem.dto.response.PageResponse;

import java.math.BigDecimal;
import java.util.List;

public interface LoyaltyPointsService {
    List<LoyaltyTransactionDTO> getLoyaltyTransactions(String username);
    BigDecimal getLoyaltyPoints(String username);
    void usePoints(Long bookingId, BigDecimal pointsToUse);
    void earnPoints(Long bookingId);
    PageResponse<LoyaltyTransactionDTO> getLoyaltyTransactions(String username, Integer page, Integer limit);
}
