package com.busticket.busticket_bookingsystem.service.inter;

import com.busticket.busticket_bookingsystem.dto.response.PageResponse;
import com.busticket.busticket_bookingsystem.entity.operate.TripLog;
import java.util.List;

public interface TripLogService {
    List<TripLog> findAll();
    TripLog findById(Long id);
    List<TripLog> getTripLogsByTripId(Long tripId);
    PageResponse<TripLog> findAll(Integer page, Integer limit);
    TripLog save(TripLog tripLog);
    TripLog update(TripLog tripLog);
    String delete (Long id);
}
