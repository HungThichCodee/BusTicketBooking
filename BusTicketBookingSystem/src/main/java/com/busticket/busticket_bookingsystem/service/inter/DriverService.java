package com.busticket.busticket_bookingsystem.service.inter;


import com.busticket.busticket_bookingsystem.dto.response.PageResponse;
import com.busticket.busticket_bookingsystem.entity.operate.Driver;

import java.util.List;

public interface DriverService {

    Driver findById(Long id);

    List<Driver> findAll();

    PageResponse<Driver> findAll(Integer page, Integer limit);

    Driver save(Driver driver);

    Driver update(Driver driver);

    String delete(Long id);

    Boolean checkDuplicateDriverInfo(String mode, Object driverId, String field, String value);
}
