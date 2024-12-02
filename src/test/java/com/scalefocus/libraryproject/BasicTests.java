package com.scalefocus.libraryproject;

import com.scalefocus.libraryproject.entities.UserEntity;
import com.scalefocus.libraryproject.enums.Role;
import com.scalefocus.libraryproject.models.UserModel;
import com.scalefocus.libraryproject.repositories.UserRepository;
import com.scalefocus.libraryproject.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class BasicTests {

    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Test
    public void updateUserTest() {
        Long id = 2L;
        UserModel userModel = new UserModel();
        userModel.setUsername("updatedUsername");
        userModel.setEmail("updated@example.com");
        userModel.setRole(Role.valueOf("USER"));

        UserEntity existingUser = new UserEntity();
        existingUser.setId(id);
        existingUser.setUsername("oldUsername");
        existingUser.setEmail("old@example.com");
        existingUser.setRole(Role.valueOf("ADMIN"));

        Mockito.when(userRepository.getReferenceById(id)).thenReturn(existingUser);

        UserEntity userEntity = userRepository.getReferenceById(id);
        userEntity.setUsername(userModel.getUsername());
        userEntity.setEmail(userModel.getEmail());
        userEntity.setRole(userModel.getRole());
        userRepository.save(userEntity);

        Assertions.assertEquals(userModel.getUsername(), userEntity.getUsername());
        Assertions.assertEquals(userModel.getEmail(), userEntity.getEmail());
        Assertions.assertEquals(userModel.getRole(), userEntity.getRole());
    }
}
