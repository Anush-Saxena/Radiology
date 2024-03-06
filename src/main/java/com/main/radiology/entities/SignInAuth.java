package com.main.radiology.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInAuth {

    @Id
    private String token;
    private String emailId;
    private String userId;
    private String hashedPassword;

    public SignInAuth(SignUpDetails signUpDetails, String token){
        this.token = token;
        this.emailId = signUpDetails.getEmailId();
        this.userId = signUpDetails.getUserId();
        this.hashedPassword = signUpDetails.getPassword();
    }
}
