package com.busticket.busticket_bookingsystem.service.inter;


import com.busticket.busticket_bookingsystem.entity.identity.Province;

import java.util.List;

public interface ProvinceService {

    Province findById(Long id);

    Province findByCodeName(String codeName);

    List<Province> findAll();
}
