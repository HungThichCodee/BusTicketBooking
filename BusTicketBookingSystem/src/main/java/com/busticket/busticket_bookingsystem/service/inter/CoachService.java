package com.busticket.busticket_bookingsystem.service.inter;


import com.busticket.busticket_bookingsystem.dto.response.PageResponse;
import com.busticket.busticket_bookingsystem.entity.operate.Coach;

import java.util.List;

public interface CoachService {

    Coach findById(Long id);

    List<Coach> findAll();

    PageResponse<Coach> findAll(Integer page, Integer limit);

    Coach save(Coach coach);

    Coach update(Coach coach);

    String delete(Long id);

    Boolean checkDuplicateCoachInfo(String mode, Long coachId, String field, String value);
}
