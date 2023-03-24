package com.work.service;

import com.work.entity.User;
import com.work.exception.UserException;
import com.work.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServImpl implements UserServ{

    @Autowired
    private UserRepo uRepo;


    @Override
    public User addUser(User user) throws UserException {
        User extUser = uRepo.findByMobileNumber(user.getMobileNumber());
        if (extUser != null)
            throw new UserException("User Exist in System");

        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setMobileNumber(user.getMobileNumber());
        user.setEmail(user.getEmail());
        user.setUserType(user.getUserType());
        user.setGender(user.getGender());
        user.setPassword(user.getPassword());


        User nUser=uRepo.save(user);

        return nUser;
    }


}
