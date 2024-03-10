package com.main.radiology.services;


import com.main.radiology.dao.SignUpAuthDao;
import com.main.radiology.dao.LoggedInAuthDao;
import com.main.radiology.dao.SignedUserDao;
import com.main.radiology.entities.LogInAuth;
import com.main.radiology.entities.LogInDetails;
import com.main.radiology.entities.SignUpAuth;
import com.main.radiology.entities.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private SignedUserDao userDao;

    @Autowired
    private LoggedInAuthDao loginDao;

    @Autowired
    private EmailService emailService;

    @Autowired
    private SignUpAuthDao authDao;

    public Object addUser(UserDetails requestUserDetails){
        /*
            Here uniqueness of Email is checked.
            Only 1 account is kept with 1 Phone Number since it is also a Primary key in DataBase.
        */
        Optional<UserDetails> signUpDetails = userDao.findById(requestUserDetails.getEmailId());

        if (signUpDetails.isEmpty()){
            /*
                Here we check the uniqueness of the emailId.
                Here password is converted into hash form and then saved to Database.
            */
//            authDao.deleteById(requestUserDetails.getEmailId());
            requestUserDetails.setPassword(convertToStringHash(requestUserDetails.getPassword()));
            String userId = "user:" + UUID.randomUUID();
//            final String token = userId + UUID.randomUUID();
            requestUserDetails.setUserId(userId);
//            LogInAuth auth = new LogInAuth(requestUserDetails, token);
//            auth.setIp(ip);
//            loginDao.save(auth);
            userDao.save(requestUserDetails);
            return requestUserDetails; // a new class need to be created and done here
        }
        else
            return " Email Already Registered! ";
    }

    public Boolean sendMail(String email){
        Optional<UserDetails> optional = userDao.findById(email);
        if (optional.isPresent()){
            return null;
        }
        String subject = "";
        int code = 0;
        String body = "";
        boolean success = emailService.sendMail(email, subject, body);
        SignUpAuth verify= new SignUpAuth();
        verify.setEmailId(email);
        verify.setCode(code);
        authDao.save(verify);
        return success;
    }

    public Object logIn(LogInDetails details){
        Optional<UserDetails> optional = userDao.findByEmailId(details.getEmailId());
        if (optional.isPresent()){
            details.setPassword(convertToStringHash(details.getPassword()));
            if (details.getPassword().equals(optional.get().getPassword())){
//                final String token = optional.get().getUserId() + UUID.randomUUID();
//                LogInAuth auth = new LogInAuth(token, details.getEmailId(), optional.get().getUserId(), ip, optional.get().getImageList());
//                loginDao.save(auth);
                return optional.get(); // new class
            }
            else return "Wrong Password";
        }
        return "Email not registered";
    }

    public boolean logOut(String token, String ip){
        Optional<LogInAuth> optional = loginDao.findById(token);
        if (optional.isPresent() && optional.get().getIp().equals(ip)){
            loginDao.delete(optional.get());
            return true;
        }
        return false;
    }
    private String convertToStringHash(String str){
        return Integer.toString(str.hashCode());
    }
}
