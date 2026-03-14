package com.busticket.busticket_bookingsystem.repository;

import com.busticket.busticket_bookingsystem.entity.booking.LoyaltyTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoyaltyTransactionRepo extends JpaRepository<LoyaltyTransaction, Long> {
    List<LoyaltyTransaction> findByUserUsernameOrderById(String username);
    Page<LoyaltyTransaction> findByUserUsernameOrderById(String username, Pageable pageable);

    boolean existsByBookingId(Long id);
}
