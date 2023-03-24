package com.work.service;

import com.work.entity.User;
import com.work.exception.UserException;

public interface UserServ {

    public User addUser(User user)throws UserException;
}
