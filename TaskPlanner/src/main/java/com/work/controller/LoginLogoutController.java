package com.work.controller;

import com.work.entity.UserDTO;
import com.work.exception.LoginLogoutException;
import com.work.service.LoginLogoutServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginLogoutController {

    @Autowired
    private LoginLogoutServ lServ;


    @PostMapping("/User Login")
    public ResponseEntity<String> logInUser(@RequestBody UserDTO dto) throws LoginLogoutException {

        String result = lServ.userLogin(dto);

        return new ResponseEntity<String>(result, HttpStatus.OK );
    }

    @PostMapping("/User logout")
    public String logoutUser(@RequestParam(required = false) String otp) throws  LoginLogoutException {
        return lServ.userLogout(otp);

    }
}
