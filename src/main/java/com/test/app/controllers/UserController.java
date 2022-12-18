package com.test.app.controllers;


import com.test.app.entities.User;
import com.test.app.requests.UserRequest;
import com.test.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<?> users(){
        return userService.getUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestBody UserRequest user){
        return userService.addUser(user);
    }


}
