package com.main.radiology.services;


import com.main.radiology.dao.LoginDao;
import com.main.radiology.entities.SignInAuth;
import com.main.radiology.entities.SignUpDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SignUpService {

    @Autowired
    private LoginDao loginDao;

    public Object addUser(SignUpDetails requestSignUpDetails){
        /*
            Here uniqueness of Phone Number is checked.
            Only 1 account is kept with 1 Phone Number since it is also a Primary key in DataBase.
        */
        Optional<SignUpDetails> signUpDetails = loginDao.findById(requestSignUpDetails.getEmailId());
        if (signUpDetails.isEmpty()){
            /*
                Here we check the uniqueness of the emailId.
                Here password is converted into hash form and then saved to Database.
            */
            requestSignUpDetails.setPassword(convertToStringHash(requestSignUpDetails.getPassword()));
            String userId = "user:"+ UUID.randomUUID();
            String token = userId+UUID.randomUUID();
            SignInAuth auth = new SignInAuth(requestSignUpDetails, token);
            requestSignUpDetails.setUserId(userId);
            loginDao.save(requestSignUpDetails);
            return auth;
        }
        else
            return " Email Already Registered! ";
    }
    private String convertToStringHash(String dwwe){
        return "";
    }
}
