package com.work.service;

import com.work.entity.Sprint;
import com.work.entity.User;
import com.work.exception.LoginLogoutException;
import com.work.exception.SprintException;
import com.work.exception.UserException;

import java.util.List;
import java.util.Map;

public interface SprintServ {
    public Sprint addSprint( Integer userId,Sprint sprint,String otp)throws SprintException,UserException, LoginLogoutException;
    public List<Map<String, Object>> getSprintInfoByFullName(String fullName);
}
