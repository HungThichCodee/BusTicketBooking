package com.busticket.busticket_bookingsystem.repository;

import com.busticket.busticket_bookingsystem.entity.operate.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepo extends JpaRepository<Coach, Long> {
}
