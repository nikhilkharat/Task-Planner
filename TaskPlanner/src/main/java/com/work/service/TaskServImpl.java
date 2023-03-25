package com.work.service;

import com.work.entity.CurrentSession;
import com.work.entity.Task;
import com.work.exception.LoginLogoutException;
import com.work.exception.SprintException;
import com.work.exception.TaskException;
import com.work.exception.UserException;
import com.work.repository.SessionRepo;
import com.work.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServImpl implements TaskServ {

    @Autowired
    private TaskRepo tRepo;

    @Autowired
    private SessionRepo sRepo;


    @Override
    public Task addTask(Task task, String otp) throws TaskException, UserException, LoginLogoutException {
        CurrentSession loginAdmin=sRepo.findByUuid(otp);

        if(loginAdmin==null)
            throw new LoginLogoutException("Admin Not Login in System or Provide valid AdminOTP");

        if(loginAdmin.getType().equalsIgnoreCase("Admin")){
            Boolean bool = tRepo.findById(task.getTaskId()).isPresent();

            if(bool)
                throw new TaskException("Task Already Exists..");

            task.setTaskName(task.getTaskName());
            task.setTaskDetails(task.getTaskDetails());
            task.setDuration(task.getDuration());
            return tRepo.save(task);
        }else
            throw new UserException("Admin OTP not Valid");
    }
}
