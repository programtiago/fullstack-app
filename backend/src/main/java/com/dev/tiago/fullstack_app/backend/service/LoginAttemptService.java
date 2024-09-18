package com.dev.tiago.fullstack_app.backend.service;

import com.dev.tiago.fullstack_app.backend.entity.LoginAttempt;

import java.util.List;

public interface LoginAttemptService {

    List<LoginAttempt> getLoginAttempts();
}
