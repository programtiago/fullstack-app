package com.dev.tiago.fullstack_app.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String loginAttempt;
    private String ipAddressSource;
    private String userAgent;

    String dateFormatted = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

    public LoginAttempt(String email, String ipAddressSource, String userAgent) {
        this.email = email;
        this.loginAttempt = dateFormatted;
        this.ipAddressSource = ipAddressSource;
        this.userAgent = userAgent;
    }

    private String getLoginAttempt(){
        loginAttempt = dateFormatted;
        return loginAttempt;
    }

}
