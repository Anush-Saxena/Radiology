package com.main.radiology.controllers;

import com.main.radiology.dao.LoggedInAuthDao;
import com.main.radiology.entities.LogInAuth;
import com.main.radiology.services.ProcessingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Controller
public class ProcessingController {

    @Autowired
    LoggedInAuthDao authDao;

    @Autowired
    ProcessingService service;

    @PostMapping("/uploadImage")
    @CrossOrigin
    public ResponseEntity<?> addImage(@RequestBody MultipartFile file){
        System.out.println("image vaale sec k andr");
        System.out.println(file.isEmpty());
//        String ip = request.getRemoteAddr();
        if (file.isEmpty())
            return new ResponseEntity<>("No Image detected", HttpStatus.OK);

        if (!file.getContentType().equals("image/png"))
            return new ResponseEntity<>("The Image should be in .png format only", HttpStatus.OK);

        return new ResponseEntity<>(service.processImage(file), HttpStatus.OK);

//        Optional<LogInAuth> optionalAuth = authDao.findById(token);
//        if (optionalAuth.isPresent() && optionalAuth.get().getIp().equals(ip)){
//
//
//        }
//        else {
//            return new ResponseEntity<>("No user SignedIn", HttpStatus.OK);
//        }
    }

}
