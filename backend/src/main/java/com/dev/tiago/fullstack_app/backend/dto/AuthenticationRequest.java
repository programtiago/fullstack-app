package com.dev.tiago.fullstack_app.backend.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String email;
    private String password;
}
