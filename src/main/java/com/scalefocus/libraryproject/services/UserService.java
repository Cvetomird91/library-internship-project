package com.scalefocus.libraryproject.services;

import com.scalefocus.libraryproject.models.LoginRequest;
import com.scalefocus.libraryproject.entities.UserEntity;
import com.scalefocus.libraryproject.models.LoginResponse;
import com.scalefocus.libraryproject.models.UserModel;
import com.scalefocus.libraryproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private final AuthService authService;
    private final JwtService jwtService;

    @Autowired
    public UserService(UserRepository userRepository, AuthService authService, JwtService jwtService) {
        this.userRepository = userRepository;
        this.authService = authService;
        this.jwtService = jwtService;
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
    public String updateUser(Long id, UserModel user) {
        UserEntity userEntity = userRepository.getReferenceById(id);
        userEntity.setUsername(user.getUsername());
        userEntity.setEmail(user.getEmail());
        userEntity.setRole(user.getRole());
        userRepository.save(userEntity);
        return "Saved changes to account with id: " + id;
    }

    public boolean deleteUser(Long id) {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            user.setStatus((short) 0);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        UserEntity authenticatedUser = authService.authenticate(loginRequest);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return loginResponse;
    }
}