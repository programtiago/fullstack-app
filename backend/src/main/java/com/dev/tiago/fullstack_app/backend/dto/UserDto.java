package com.dev.tiago.fullstack_app.backend.dto;

import com.dev.tiago.fullstack_app.backend.enums.UserRole;
import lombok.Data;

import java.util.Date;

@Data
public class UserDto{

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private UserRole userRole;
    private Date createdAt = new Date();

    public UserDto(Long id, String firstName, String lastName, String email, String password){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userRole = UserRole.EMPLOYEE;
        this.createdAt = new Date();
    }
}
