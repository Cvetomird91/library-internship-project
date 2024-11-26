package com.scalefocus.libraryproject.services;

import com.scalefocus.libraryproject.entities.UserEntity;
import com.scalefocus.libraryproject.exceptions.RegisterException;
import com.scalefocus.libraryproject.models.UserModel;
import com.scalefocus.libraryproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

import static com.scalefocus.libraryproject.enums.Role.USER;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel getUser(Long id) {
        UserEntity userEntity = userRepository.getReferenceById(id);
        return UserModel.builder().id(userEntity.getId())
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .role(userEntity.getRole())
                .createdAt(userEntity.getCreatedAt()).build();
    }

    public String createUser(UserModel userModel){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userModel.getUsername());
        userEntity.setEmail(userModel.getEmail());
        userEntity.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userEntity.setRole(USER);
        userEntity.setCreatedAt(ZonedDateTime.now());
        try{
            userRepository.save(userEntity);
            return "User created";
        }
        catch(Exception e) {
                return new RegisterException("User already exists").getMessage();
        }
    }
}