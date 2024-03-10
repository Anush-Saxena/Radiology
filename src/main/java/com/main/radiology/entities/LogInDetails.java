package com.main.radiology.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class LogInDetails {

    @Id
    private String emailId;
    private String password;
}
