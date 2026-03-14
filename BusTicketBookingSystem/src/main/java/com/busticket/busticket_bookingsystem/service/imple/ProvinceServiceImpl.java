package com.busticket.busticket_bookingsystem.service.imple;

import com.busticket.busticket_bookingsystem.entity.identity.Province;
import com.busticket.busticket_bookingsystem.exception.ResourceNotFoundException;
import com.busticket.busticket_bookingsystem.repository.ProvinceRepo;
import com.busticket.busticket_bookingsystem.service.inter.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {
    private final ProvinceRepo provinceRepo;
    @Override
    public Province findById(Long id) {
        return provinceRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Province<%d>".formatted(id)));
    }

    @Override
    public Province findByCodeName(String codeName) {
        return null;
    }

    @Override
    @Cacheable(cacheNames = {"provinces"})
    public List<Province> findAll() {
        return provinceRepo.findAll();
    }
}