package com.main.radiology.controllers;

import com.main.radiology.entities.LogInDetails;
import com.main.radiology.entities.UserDetails;
import com.main.radiology.services.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

//    @PostMapping(value = "/verifyEmail")
//    public ResponseEntity<String> sendMail(@RequestParam String email, HttpServletRequest request){
//        Object response = accountService.sendMail(email);
//        if (response.equals(true)){
//            return new ResponseEntity<>("Enter the code to Verify", HttpStatus.OK);
//        }
//        else if (response.equals(false)){
//            return new ResponseEntity<>("Wrong Email entered", HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>("Email already Exists", HttpStatus.BAD_REQUEST);
//    }

    @PostMapping(value = "/signUp")
    @CrossOrigin
    public ResponseEntity<Object> addUser(@RequestBody UserDetails userDetails) {
        Object response = accountService.addUser(userDetails);
        if (response.getClass() != "".getClass()){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/signIn")
    @CrossOrigin
    public ResponseEntity<?> logIn(@RequestBody LogInDetails logInDetails){
        Object response = accountService.logIn(logInDetails);
        if (response.getClass() == "".getClass()){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/signOut")
    @CrossOrigin
    public ResponseEntity<?> logOut(@RequestParam String token, HttpServletRequest request){
        boolean response = accountService.logOut(token, request.getRemoteAddr());
        if (response){
            return new ResponseEntity<>("Logged Out Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("No account SignedIn", HttpStatus.OK);
    }

}
