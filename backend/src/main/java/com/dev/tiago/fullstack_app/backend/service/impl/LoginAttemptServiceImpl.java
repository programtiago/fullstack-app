package com.dev.tiago.fullstack_app.backend.service.impl;

import com.dev.tiago.fullstack_app.backend.entity.LoginAttempt;
import com.dev.tiago.fullstack_app.backend.repository.LoginAttemptRepository;
import com.dev.tiago.fullstack_app.backend.service.LoginAttemptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginAttemptServiceImpl implements LoginAttemptService {

    private final LoginAttemptRepository loginAttemptRepository;

    @Override
    public List<LoginAttempt> getLoginAttempts() {
        return loginAttemptRepository.findAll();
    }
}
