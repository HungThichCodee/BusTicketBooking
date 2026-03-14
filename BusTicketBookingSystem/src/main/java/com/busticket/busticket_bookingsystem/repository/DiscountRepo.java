package com.busticket.busticket_bookingsystem.repository;

import com.busticket.busticket_bookingsystem.entity.booking.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DiscountRepo extends JpaRepository<Discount, Long> {

    Optional<Discount> findByCode(String code);

    @Query("""
                    select d from Discount d where d.endDateTime > current_timestamp 
            """)
    List<Discount> findAllAvailable();
}
