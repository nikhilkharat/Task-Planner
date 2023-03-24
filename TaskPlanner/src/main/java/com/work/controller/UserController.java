package com.work.controller;

import com.work.entity.User;
import com.work.exception.UserException;
import com.work.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServ uServ;

    @PostMapping("/addUser")
    public ResponseEntity<User> saveConsumer(@RequestBody User user)throws UserException {
        User user1= uServ.addUser(user);
        return new ResponseEntity<User>(user1, HttpStatus.OK);
    }
}
