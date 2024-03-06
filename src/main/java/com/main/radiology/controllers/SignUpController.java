package com.main.radiology.controllers;

import com.main.radiology.entities.SignUpDetails;
import com.main.radiology.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ResponseEntity<Object> addUser(@RequestBody SignUpDetails signUpDetails) {
        return new ResponseEntity<>(signUpService.addUser(signUpDetails), HttpStatus.CREATED);
    }
}
