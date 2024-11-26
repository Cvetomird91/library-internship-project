package com.scalefocus.libraryproject.entities;

import com.scalefocus.libraryproject.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements UserDetails {
    private @Id Long id;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private ZonedDateTime createdAt;
    private short status; //= 1; might have to initialize this but the sql query should handle it

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

}

