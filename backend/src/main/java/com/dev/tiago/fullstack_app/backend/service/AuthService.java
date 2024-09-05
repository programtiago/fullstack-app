package com.dev.tiago.fullstack_app.backend.service;

public interface AuthService {

    void createAdminAccount(); //for testing
    boolean hasUserWithEmail(String email);
}
