package com.scalefocus.libraryproject.entities;

import com.scalefocus.libraryproject.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private @Id Long id;
    private String username;
    private String email;
    private String password;
    private Role role;
    private ZonedDateTime createdAt;
}

