package com.work.service;

import com.work.entity.Sprint;
import com.work.entity.User;
import com.work.exception.LoginLogoutException;
import com.work.exception.SprintException;
import com.work.exception.UserException;

public interface SprintServ {

    public Sprint addSprint(Sprint sprint,String otp)throws SprintException,UserException, LoginLogoutException;
}
