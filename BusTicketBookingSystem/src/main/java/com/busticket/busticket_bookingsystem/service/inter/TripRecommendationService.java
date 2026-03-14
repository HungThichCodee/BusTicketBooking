package com.busticket.busticket_bookingsystem.service.inter;


import com.busticket.busticket_bookingsystem.dto.TripRecommendationDTO;

import java.util.List;

public interface TripRecommendationService {
    List<TripRecommendationDTO> getRecommendedTrips(String username);
    List<TripRecommendationDTO> getAvailableTrips();
}
