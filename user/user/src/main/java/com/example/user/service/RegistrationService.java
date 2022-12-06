package com.example.user.service;

import com.example.user.model.User;
import com.example.user.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
     RegistrationRepository repo;

    public User saveUser(User user){
        return repo.save(user);

    }
    public User fetchUserByEmailId(String userEmail){
        return repo.findByUserEmail(userEmail);

    }

    public User fetchUserByEmailIdAndPassword(String userEmail, String userPassword ){
        return repo.findByUserEmailAndUserPassword(userEmail, userPassword);

    }


}

