package com.busticket.busticket_bookingsystem.repository;

import com.busticket.busticket_bookingsystem.entity.operate.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver, Long> {
}
