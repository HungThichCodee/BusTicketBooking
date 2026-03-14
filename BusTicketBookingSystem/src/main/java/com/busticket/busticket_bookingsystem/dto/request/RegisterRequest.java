package com.busticket.busticket_bookingsystem.dto.request;

import com.busticket.busticket_bookingsystem.enums.RoleCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private String phone;

    private RoleCode role;
}
