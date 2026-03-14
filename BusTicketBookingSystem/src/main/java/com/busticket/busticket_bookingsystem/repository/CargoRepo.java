package com.busticket.busticket_bookingsystem.repository;

import com.busticket.busticket_bookingsystem.entity.booking.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepo extends JpaRepository<Cargo, Long> {
}
