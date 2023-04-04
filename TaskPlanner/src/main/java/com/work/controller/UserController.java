package com.work.controller;

import com.work.entity.Sprint;

import com.work.entity.Task;
import com.work.entity.User;
import com.work.entity.UserTaskDto;
import com.work.exception.LoginLogoutException;
import com.work.exception.SprintException;

import com.work.exception.TaskException;
import com.work.exception.UserException;

//import com.work.service.TaskServ;
import com.work.service.SprintServ;
import com.work.service.TaskServ;
import com.work.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserServ uServ;

    @Autowired
    private SprintServ spServ;

    @Autowired
    private TaskServ tServ;

    @PostMapping("/add User")
    public ResponseEntity<User> saveConsumer(@RequestBody User user)throws UserException {
        User user1= uServ.addUser(user);
        return new ResponseEntity<User>(user1, HttpStatus.OK);
    }

    @PostMapping("/add Sprint/{userId}")
    public ResponseEntity<Sprint> addNewSprint(@PathVariable Integer userId,@RequestBody Sprint sprint, @RequestParam (required = false) String otp ) throws SprintException, UserException, LoginLogoutException {
        Sprint savedSprint = spServ.addSprint(userId,sprint,otp);
        return new ResponseEntity<Sprint>(savedSprint, HttpStatus.CREATED);
    }



    @PostMapping("/add Task/{sprintId}")
    public ResponseEntity<Task> addTask(@PathVariable Integer sprintId,@RequestBody Task task, @RequestParam(required = false) String otp) throws  LoginLogoutException,  TaskException, SprintException {
        Task savedTask = tServ.addTask(sprintId,task,otp);
        return new ResponseEntity<Task>(savedTask, HttpStatus.CREATED);
    }
    

        @GetMapping("/getAllDetails/{fullName}")
    public ResponseEntity<List<Map<String, Object>>> getDetails(@RequestParam("fullName") String fullName) {

        List<Map<String, Object>> l = spServ.getSprintInfoByFullName(fullName);

        return new ResponseEntity<List<Map<String, Object>>>(l, HttpStatus.CREATED);
    }
}
