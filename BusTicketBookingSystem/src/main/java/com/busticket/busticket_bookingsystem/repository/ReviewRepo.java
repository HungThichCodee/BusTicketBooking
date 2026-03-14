package com.busticket.busticket_bookingsystem.repository;

import com.busticket.busticket_bookingsystem.entity.operate.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {
    Review findByTripId(Long tripId);
    boolean existsByTrip_IdAndUser_Username(Long tripId, String username);
}
