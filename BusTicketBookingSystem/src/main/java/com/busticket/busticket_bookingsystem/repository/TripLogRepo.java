package com.busticket.busticket_bookingsystem.repository;

import com.busticket.busticket_bookingsystem.entity.operate.TripLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripLogRepo extends JpaRepository<TripLog, Long> {
    List<TripLog> findByTripIdOrderByLogTimeDesc(Long tripId);
}
