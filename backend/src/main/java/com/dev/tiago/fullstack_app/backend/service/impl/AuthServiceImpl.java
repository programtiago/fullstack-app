package com.dev.tiago.fullstack_app.backend.service.impl;

import com.dev.tiago.fullstack_app.backend.repository.UserRepository;
import com.dev.tiago.fullstack_app.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;


    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
