package com.dev.tiago.fullstack_app.backend.dto;

import com.dev.tiago.fullstack_app.backend.enums.UserRole;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

//need some validations in future
public record UserDto(Long id, String firstName, String lastName, String email,
        UserRole userRole, Date createdAt){}
