package com.test.app.services;


import com.test.app.entities.User;
import com.test.app.repo.UserRepo;
import com.test.app.requests.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @GetMapping
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok(userRepo.findAll());
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserRequest user){
        UserRequest userRequest = user;
        User finalUser = new User(userRequest.getUsername(), userRequest.getPassword(), userRequest.getEmail());
        userRepo.save(finalUser);
        return ResponseEntity.ok("saved");
    }
}
