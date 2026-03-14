package com.busticket.busticket_bookingsystem.service.inter;


import com.busticket.busticket_bookingsystem.dto.request.ReviewRequest;
import com.busticket.busticket_bookingsystem.dto.response.PageResponse;
import com.busticket.busticket_bookingsystem.entity.operate.Review;

import java.util.List;

public interface ReviewService {
    Review createReview(ReviewRequest reviewRequest);
    Review getReviewByTripId(Long tripId);
    List<Review> findAll();
    Review findById(Long id);
    PageResponse<Review> findAll(Integer page, Integer limit);


}
