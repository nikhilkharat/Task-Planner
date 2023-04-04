package com.work.service;

import com.work.entity.CurrentSession;
import com.work.entity.Sprint;
import com.work.entity.Task;
import com.work.entity.User;
import com.work.exception.LoginLogoutException;
import com.work.exception.SprintException;
import com.work.exception.TaskException;
import com.work.exception.UserException;
import com.work.repository.SessionRepo;
import com.work.repository.SprintRepo;
import com.work.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskServImpl implements TaskServ {

    @Autowired
    private TaskRepo tRepo;

    @Autowired
    private SessionRepo sRepo;

    @Autowired
    private SprintRepo sprintRepo;

    @Override
    public Task addTask(Integer sprintId,Task task, String otp) throws TaskException, SprintException, LoginLogoutException {
        CurrentSession login=sRepo.findByUuid(otp);

        if(login==null)
            throw new LoginLogoutException("Admin Not Login in System or Provide valid AdminOTP");
//
        Sprint sprint=sprintRepo.findById(sprintId).orElseThrow(()-> new SprintException("No User Present with given Id"));
        if(login.getType().equalsIgnoreCase("Admin")){
            if(sprint.getTaskList().add(task)){
                task.setTaskName(task.getTaskName());
                task.setTaskDetails(task.getTaskDetails());
                task.setSprint(sprint);

                Task newTask=tRepo.save(task);
                return newTask;
            }else{
                throw new TaskException("Sprint Already Exist or ");
            }

        }else
            throw new SprintException("Sprint not Exist");
    }
}
