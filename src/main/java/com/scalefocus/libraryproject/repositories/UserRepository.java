package com.scalefocus.libraryproject.repositories;

import com.scalefocus.libraryproject.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}