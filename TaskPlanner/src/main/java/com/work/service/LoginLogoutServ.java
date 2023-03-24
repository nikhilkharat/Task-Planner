package com.work.service;

import com.work.entity.UserDTO;
import com.work.exception.LoginLogoutException;

public interface LoginLogoutServ {

    public String userLogin(UserDTO dto)throws LoginLogoutException;

    public String userLogout(String otp)throws LoginLogoutException;
}
