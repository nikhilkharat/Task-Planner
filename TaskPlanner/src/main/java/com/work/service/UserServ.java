package com.work.service;

import com.work.entity.User;
import com.work.entity.UserTaskDto;
import com.work.exception.UserException;

import java.util.List;

public interface UserServ {

    public User addUser(User user)throws UserException;

    //public List<UserTaskDto> findDetailsByName(String fullName) throws UserException;
}
