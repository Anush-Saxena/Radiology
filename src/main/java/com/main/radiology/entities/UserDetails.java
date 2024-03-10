package com.main.radiology.entities;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {

    @Id
    private String userId;     // userName of the person's account
    private String emailId;    // Email Id of the user
    private String name;       // Account Holder's Name
    private String password;

    @ElementCollection
    List<String> imageList;
}
