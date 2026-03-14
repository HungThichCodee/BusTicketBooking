package com.busticket.busticket_bookingsystem.service.inter;


import com.busticket.busticket_bookingsystem.dto.response.PageResponse;
import com.busticket.busticket_bookingsystem.entity.booking.Cargo;

import java.util.List;

public interface CargoService {
    List<Cargo> findAll();
    PageResponse<Cargo> findAll(Integer page, Integer limit);
    Cargo findById(Long id);
    Cargo save(Cargo cargo);
    Cargo update (Cargo cargo);
    String deleteById(Long id);
    Boolean checkDuplicateDiscountInfo(String mode, Long cargoId, String field, String value);
}
