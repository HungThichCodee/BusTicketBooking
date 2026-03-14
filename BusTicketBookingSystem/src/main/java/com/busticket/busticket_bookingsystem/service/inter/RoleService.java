package com.busticket.busticket_bookingsystem.service.inter;


import com.busticket.busticket_bookingsystem.entity.identity.Role;

import java.util.List;

public interface RoleService {
    Role findById(Long id);

    List<Role> findAll();

    Role update(Role role);
}
