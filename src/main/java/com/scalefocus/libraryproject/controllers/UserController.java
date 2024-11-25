package com.scalefocus.libraryproject.controllers;

import com.scalefocus.libraryproject.entities.UserEntity;
import com.scalefocus.libraryproject.models.UserModel;
import com.scalefocus.libraryproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;



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
    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody UserModel userModel){
        return userService.updateUser(id, userModel);
    }
}
