package com.busticket.busticket_bookingsystem.service.inter;


import com.busticket.busticket_bookingsystem.dto.PermissionDto;
import com.busticket.busticket_bookingsystem.dto.ScreenPermissionDto;
import com.busticket.busticket_bookingsystem.dto.response.PageResponse;
import com.busticket.busticket_bookingsystem.entity.entityUser.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);

    List<User> findAll();

    PageResponse<User> findAll(Integer page, Integer limit);

    User save(User user);

    User update(User user);

    String delete(String username);

    Boolean checkDuplicateUserInfo(String mode, String username, String field, String value);

    PermissionDto getUserPermission(String username);

    PermissionDto updateUserScreenPermission(ScreenPermissionDto screenPermissionDto);
}
