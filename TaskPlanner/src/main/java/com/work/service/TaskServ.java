package com.work.service;

import com.work.entity.Sprint;
import com.work.entity.Task;
import com.work.exception.LoginLogoutException;
import com.work.exception.SprintException;
import com.work.exception.TaskException;
import com.work.exception.UserException;

public interface TaskServ {

    public Task addTask(Task task, String otp)throws TaskException, UserException, LoginLogoutException;
}
