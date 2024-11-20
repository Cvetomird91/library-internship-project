package com.scalefocus.libraryproject.models;

import com.scalefocus.libraryproject.enums.Role;
import jakarta.persistence.Id;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Role role;
    private ZonedDateTime createdAt;
}
