package com.main.radiology.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProcessingController {

    @PostMapping("/uploadImage")
    public void addImage(@RequestBody MultipartFile file, String token){
        int c ;
    }

}
