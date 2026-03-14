package com.busticket.busticket_bookingsystem.service.imple;

import com.busticket.busticket_bookingsystem.dto.response.PageResponse;
import com.busticket.busticket_bookingsystem.entity.identity.Location;
import com.busticket.busticket_bookingsystem.exception.ExistingResourceException;
import com.busticket.busticket_bookingsystem.exception.ResourceNotFoundException;
import com.busticket.busticket_bookingsystem.repository.LocationRepo;
import com.busticket.busticket_bookingsystem.repository.TripRepo;
import com.busticket.busticket_bookingsystem.repository.UtilRepo;
import com.busticket.busticket_bookingsystem.service.inter.LocationService;
import com.busticket.busticket_bookingsystem.validator.ObjectValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepo locationRepo;
    private final ObjectValidator<Location> objectValidator;
    private final UtilRepo utilRepo;
    private final TripRepo tripRepo;

    @Override
    @Transactional
    public Location findById(Long id) {
        return locationRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found with ID: " + id));
    }

    @Override
    @Transactional
    public List<Location> findAll() {
        return locationRepo.findAllByIsActiveFalse();
    }

    @Override
    @Cacheable(cacheNames = {"locations_paging"}, key = "{#page, #limit}")
    public PageResponse<Location> findAll(Integer page, Integer limit) {
        Page<Location> pageSlice = locationRepo.findAll(PageRequest.of(page, limit));
        PageResponse<Location> pageResponse = new PageResponse<>();
        pageResponse.setDataList(pageSlice.getContent());
        pageResponse.setPageCount(pageSlice.getTotalPages());
        pageResponse.setTotalElements(pageSlice.getTotalElements());
        return pageResponse;
    }

    @Override
    @Transactional
    public List<Location> findByProvinceId(Long provinceId) {
        return locationRepo.findAllByProvince_IdAndIsActiveTrue(provinceId);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = {"locations", "locations_paging"}, allEntries = true)
    public Location saveLocation(Location location) {
        location.setId(null);
        objectValidator.validate(location);
        if (!checkDuplicateLocationInfo("ADD", location.getId(), "address", location.getAddress())) {
            throw new ExistingResourceException("Location address <%s> is already exist".formatted(location.getAddress()));
        }
        return locationRepo.save(location);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = {"locations", "locations_paging"}, allEntries = true)
    public Location updateLocation(Location location) {
        objectValidator.validate(location);
        if (!checkDuplicateLocationInfo("EDIT", location.getId(), "address", location.getAddress())) {
            throw new ExistingResourceException("Location address <%s> is already exist".formatted(location.getAddress()));
        }

//        if (!checkDuplicateLocationInfo("EDIT", location.getId(), "district", location.getDistrict())) {
//            throw new ExistingResourceException("Location district <%s> is already exist".formatted(location.getDistrict()));
//        }
//
//        if (!checkDuplicateLocationInfo("EDIT", location.getId(), "ward", location.getWard())) {
//            throw new ExistingResourceException("Location ward <%s> is already exist".formatted(location.getWard()));
//        }
        return locationRepo.save(location);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = {"locations", "locations_paging"}, allEntries = true)
    public String deleteLocation(Long id) {
        Location foundLocation = findById(id);

        boolean isLocationInUse = tripRepo.existsByLocationId(id);

        if (isLocationInUse) {
            throw new ExistingResourceException("Location <%d> is being used in trips, can't be delete.".formatted(id));
        }
        foundLocation.setIsActive(false);
        locationRepo.save(foundLocation);

        return "Delete Location <%d> successfully!".formatted(id);
    }

    @Override
    public Boolean checkDuplicateLocationInfo(String mode, Long locationId, String field, String value) {
        List<Location> foundLocations = utilRepo.checkDuplicateByStringField(Location.class, mode, "id",
                locationId, field, value);
        return foundLocations.isEmpty();
    }
}
