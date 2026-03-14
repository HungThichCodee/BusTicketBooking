package com.busticket.busticket_bookingsystem.repository;

import com.busticket.busticket_bookingsystem.entity.identity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepo extends JpaRepository<Location, Long> {

    List<Location> findAllByIsActiveFalse();
    List<Location> findAllByProvince_IdAndIsActiveTrue(Long provinceId);
}

