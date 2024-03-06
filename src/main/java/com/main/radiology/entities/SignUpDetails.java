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
public class SignUpDetails {

    @Id
    private String userId;     // userName of the person's account
    private String emailId;    // Email Id of the user
    private String name;       // Account Holder's Name
    private String password;
}
