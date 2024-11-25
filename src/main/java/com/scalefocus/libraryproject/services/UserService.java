package com.scalefocus.libraryproject.services;

import com.scalefocus.libraryproject.entities.UserEntity;
import com.scalefocus.libraryproject.models.UserModel;
import com.scalefocus.libraryproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

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
    public void updateUser(UserModel user){
        UserEntity userEntity = userRepository.getReferenceById(user.getId());
        userEntity.setUsername(user.getUsername());
        userEntity.setEmail(user.getEmail());
        userEntity.setRole(user.getRole());
        userRepository.save(userEntity);
    }
}