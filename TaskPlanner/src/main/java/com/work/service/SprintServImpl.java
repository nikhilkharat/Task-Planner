package com.work.service;

import com.work.entity.CurrentSession;
import com.work.entity.Sprint;
import com.work.entity.User;
import com.work.exception.LoginLogoutException;
import com.work.exception.SprintException;
import com.work.exception.UserException;
import com.work.repository.SessionRepo;
import com.work.repository.SprintRepo;
import com.work.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SprintServImpl implements SprintServ{

    @Autowired
    private SessionRepo sRepo;

    @Autowired
    private SprintRepo sprintRepo;

    @Override
    public Sprint addSprint(Sprint sprint,String otp) throws SprintException, UserException, LoginLogoutException {


        CurrentSession loginAdmin=sRepo.findByUuid(otp);

        if(loginAdmin==null)
            throw new LoginLogoutException("Admin Not Login in System or Provide valid AdminOTP");

        if(loginAdmin.getType().equalsIgnoreCase("Admin")){

            Boolean bool = sprintRepo.findById(sprint.getSprintId()).isPresent();

            if(bool)
                throw new SprintException("Sprint Already Exists..");

            sprint.setDateTime(sprint.getDateTime());
            sprint.setDepartment(sprint.getDepartment());
            return sprintRepo.save(sprint);
        }else
            throw new UserException("Admin OTP not Valid");
    }
}
