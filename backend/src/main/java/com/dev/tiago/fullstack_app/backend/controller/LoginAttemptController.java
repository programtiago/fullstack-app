package com.dev.tiago.fullstack_app.backend.controller;

import com.dev.tiago.fullstack_app.backend.service.impl.LoginAttemptServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login-attempt")
@RequiredArgsConstructor
public class LoginAttemptController{

    private final LoginAttemptServiceImpl loginAttemptService;

    @GetMapping
    public ResponseEntity<?> getLoginAttempts(){
        return ResponseEntity.ok(loginAttemptService.getLoginAttempts());
    }
}
