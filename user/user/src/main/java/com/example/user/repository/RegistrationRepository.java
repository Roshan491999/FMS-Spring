package com.example.user.repository;

import com.example.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepository extends CrudRepository<User, Integer> {
    public User findByUserEmail(String userEmail);
    public User findByUserEmailAndUserPassword(String userEmail, String userPassword);

}
