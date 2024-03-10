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
public class LogInAuth {

    @Id
    private String token;
    private String emailId;
    private String userId;
    private String ip;

    @ElementCollection
    private List<String> imageList;

    public LogInAuth(UserDetails userDetails, String token){
        this.token = token;
        this.emailId = userDetails.getEmailId();
        this.userId = userDetails.getUserId();
    }
}
