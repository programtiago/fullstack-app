package com.dev.tiago.fullstack_app.backend.dto;

import com.dev.tiago.fullstack_app.backend.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String token;
    private Long userId;
    private UserRole userRole;

}
