package com.main.radiology.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class SignUpAuth {

    @Id
    private String emailId;
    private int code;
}
