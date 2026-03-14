package com.busticket.busticket_bookingsystem.service.inter;


import com.busticket.busticket_bookingsystem.dto.request.AuthenticationRequest;
import com.busticket.busticket_bookingsystem.dto.request.ChangePwdRequest;
import com.busticket.busticket_bookingsystem.dto.request.ForgotRequest;
import com.busticket.busticket_bookingsystem.dto.request.RegisterRequest;
import com.busticket.busticket_bookingsystem.dto.response.AuthenticationResponse;

public interface AuthenticationService {

    AuthenticationResponse login(AuthenticationRequest authRequest);

    AuthenticationResponse register(RegisterRequest registerRequest);

    String forgot(ForgotRequest forgotRequest);

    String changePwd(ChangePwdRequest pwdRequest);

    Boolean checkExistUsername(String username);

    Boolean checkExistEmail(String email);

    Boolean checkExistPhone(String phone);

    Boolean checkActiveStatus(String username);
}
