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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SprintServImpl implements SprintServ{

    @Autowired
    private SessionRepo sRepo;

    @Autowired
    private UserRepo uRepo;

    @Autowired
    private SprintRepo sprintRepo;

    @Override
    public Sprint addSprint(Integer userId,Sprint sprint,String otp ) throws SprintException,UserException, LoginLogoutException {


        CurrentSession login=sRepo.findByUuid(otp);

        if(login==null)
            throw new LoginLogoutException("Admin Not Login in System or Provide valid AdminOTP");
//
        User user=uRepo.findById(userId).orElseThrow(()-> new UserException("No User Present with given Id"));
        if(login.getType().equalsIgnoreCase("Admin")){
            if(user.getSprintList().add(sprint)){
                sprint.setDuration(sprint.getDuration());
                sprint.setLocalDateTime(LocalDateTime.now());
                sprint.setDuration(sprint.getDuration());
                sprint.setUser(user);
                Sprint newSprint=sprintRepo.save(sprint);
                return newSprint;
            }else{
                throw new SprintException("Sprint Already Exist or ");
            }

        }else
            throw new UserException("Admin OTP not Valid");
    }

    @Override
    public List<Map<String, Object>> getSprintInfoByFullName(String fullName) {
        List<Object[]> results = sprintRepo.findSprintInfoByFullName(fullName);
        List<Map<String, Object>> sprintInfoList = new ArrayList<>();
        for (Object[] row : results) {
            Map<String, Object> sprintInfo = new HashMap<>();
            sprintInfo.put("fullName", row[0]);
            sprintInfo.put("duration", row[1]);
            sprintInfo.put("localDateTime", row[2]);
            sprintInfo.put("department", row[3]);
            sprintInfo.put("taskName", row[4]);
            sprintInfo.put("taskDetails", row[5]);
            sprintInfoList.add(sprintInfo);
        }
        return sprintInfoList;
    }


}
