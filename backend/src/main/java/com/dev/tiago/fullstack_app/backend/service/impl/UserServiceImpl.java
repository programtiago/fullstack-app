package com.dev.tiago.fullstack_app.backend.service.impl;

import com.dev.tiago.fullstack_app.backend.entity.User;
import com.dev.tiago.fullstack_app.backend.repository.UserRepository;
import com.dev.tiago.fullstack_app.backend.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findByUserRole("ADMIN").stream().toList();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
