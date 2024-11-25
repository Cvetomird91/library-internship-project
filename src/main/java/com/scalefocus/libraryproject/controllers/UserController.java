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
    @PutMapping("/users/{id}")
    public UserModel updateUser(@PathVariable Long id, @RequestBody UserModel userModel){
        UserModel updatedUser = userService.getUser(id);
        updatedUser.setUsername(userModel.getUsername());
        updatedUser.setEmail(userModel.getEmail());
        updatedUser.setRole(userModel.getRole());
        userService.updateUser(updatedUser);
        return updatedUser;
    }
}
