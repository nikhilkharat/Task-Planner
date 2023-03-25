package com.work.controller;

import com.work.entity.Sprint;
import com.work.entity.Task;
import com.work.entity.User;
import com.work.exception.LoginLogoutException;
import com.work.exception.SprintException;
import com.work.exception.TaskException;
import com.work.exception.UserException;
import com.work.service.SprintServ;
import com.work.service.TaskServ;
import com.work.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/add Sprint")
    public ResponseEntity<Sprint> addSprint(@RequestBody Sprint sprint, @RequestParam(required = false) String otp) throws SprintException, UserException, LoginLogoutException {
        Sprint savedSprint = spServ.addSprint(sprint,otp);
        return new ResponseEntity<Sprint>(savedSprint, HttpStatus.CREATED);
    }

    @PostMapping("/add Task")
    public ResponseEntity<Task> addTask(@RequestBody Task task, @RequestParam(required = false) String otp) throws  UserException, LoginLogoutException, TaskException {
        Task savedTask = tServ.addTask(task,otp);
        return new ResponseEntity<Task>(savedTask, HttpStatus.CREATED);
    }
}
