package com.scalefocus.libraryproject.controllers;

import com.scalefocus.libraryproject.models.UserModel;
import com.scalefocus.libraryproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users/{id}")
    public UserModel getUser(@PathVariable Long id){
        return userService.getUser(id);
    }
    @PostMapping("/auth/register")
    public String registerUser(@RequestBody UserModel userModel){
        return userService.createUser(userModel);
    }
}
