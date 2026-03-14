package com.busticket.busticket_bookingsystem.controller;

import com.busticket.busticket_bookingsystem.dto.response.PageResponse;
import com.busticket.busticket_bookingsystem.entity.operate.Driver;
import com.busticket.busticket_bookingsystem.service.inter.DriverService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/drivers")
@Tag(name = "Driver Controller")
public class DriverController {

    private final DriverService driverService;

    @GetMapping("/all")
    public List<Driver> getAllDrivers() {
        return driverService.findAll();
    }

    @GetMapping("/paging")
    public PageResponse<Driver> getPageOfDrivers(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer limit) {
        return driverService.findAll(page, limit);
    }

    @GetMapping("/{driverId}")
    public ResponseEntity<Driver> getDriver(@PathVariable Long driverId) {
        return ResponseEntity
                .status(200)
                .body(driverService.findById(driverId));
    }

    @PostMapping
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
        return ResponseEntity
                .status(201)
                .body(driverService.save(driver));
    }

    @PutMapping
    public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver) {
        return ResponseEntity
                .status(200)
                .body(driverService.update(driver));
    }

    @DeleteMapping("/{driverId}")
    public ResponseEntity<?> deleteDriver(@PathVariable Long driverId) {
        return ResponseEntity
                .status(200)
                .body(driverService.delete(driverId));
    }

    @GetMapping("/checkDuplicate/{mode}/{driverId}/{field}/{value}")
    public ResponseEntity<?> checkDuplicateDriverInfo(
            @PathVariable String mode,
            @PathVariable Object driverId,
            @PathVariable String field,
            @PathVariable String value
    ) {
        return ResponseEntity.ok(driverService.checkDuplicateDriverInfo(mode, driverId, field, value));
    }
}
