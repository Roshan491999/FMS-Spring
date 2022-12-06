package com.example.user.controller;

import com.example.user.model.User;
import com.example.user.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    RegistrationService service;

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:4200")
    public User registerUser(@RequestBody User user) throws Exception{
        String tempEmailId = user.getUserEmail();
        if(tempEmailId !=null && !"".equals(tempEmailId)){
            User userObj = service.fetchUserByEmailId(tempEmailId);
            if(userObj != null){
                throw new Exception("User with"+tempEmailId+"is already exist");
            }
        }
        User userObj;
        userObj = service.saveUser(user);
        return userObj;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public User loginUser(@RequestBody User user) throws Exception{
        String tempUserEmail=user.getUserEmail();
        String tempUserPassword= user.getUserPassword();
        User userObj = null;
        if(tempUserEmail != null && tempUserPassword != null){
            userObj =service.fetchUserByEmailIdAndPassword(tempUserEmail, tempUserPassword);
        }
        if(userObj==null){
            throw new Exception("Bad Credentials");
        }
        return userObj;
    }


}

