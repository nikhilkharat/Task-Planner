package com.work.service;

import com.work.entity.CurrentSession;
import com.work.entity.User;
import com.work.entity.UserDTO;
import com.work.exception.LoginLogoutException;
import com.work.repository.SessionRepo;
import com.work.repository.UserRepo;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LoginLogoutServImpl implements LoginLogoutServ{

    @Autowired
    private UserRepo uRepo;

    @Autowired
    private SessionRepo sRepo;


    @Override
    public String userLogin(UserDTO dto) throws LoginLogoutException {
        User extUser=uRepo.findByMobileNumber(dto.getMobileNumber());
        if(extUser==null)
            throw new LoginLogoutException("Please Enter Mobile Number");

        Optional<CurrentSession> validSessionOpt =  sRepo.findById(extUser.getUserId());

        if(validSessionOpt.isPresent()) {
            throw new LoginLogoutException("Consumer already Logged In");
        }

        if(extUser.getPassword().equals(dto.getPassword())) {

            String otp= RandomString.make(4);

            CurrentSession currentSession = new CurrentSession(extUser.getUserId(),extUser.getUserType(),otp, LocalDateTime.now());

            sRepo.save(currentSession);

            return currentSession.toString();
        }
        else
            throw new LoginLogoutException("Please Enter a valid password");
    }

    @Override
    public String userLogout(String otp) throws LoginLogoutException {
        CurrentSession validConsumerSession = sRepo.findByUuid(otp);

        if(validConsumerSession == null) {
            throw new LoginLogoutException("User Not Logged In with this number");

        }
        sRepo.delete(validConsumerSession);
        return "Logged Out !";
    }


}
