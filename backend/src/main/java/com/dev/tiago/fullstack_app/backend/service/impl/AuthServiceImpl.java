package com.dev.tiago.fullstack_app.backend.service.impl;

import com.dev.tiago.fullstack_app.backend.entity.User;
import com.dev.tiago.fullstack_app.backend.enums.UserRole;
import com.dev.tiago.fullstack_app.backend.repository.UserRepository;
import com.dev.tiago.fullstack_app.backend.service.AuthService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;


    @Override
    @PostConstruct
    public void createAdminAccount() {
        Optional<User> optionalUser = userRepository.findByUserRole(UserRole.ADMIN);

        if (optionalUser.isEmpty()){
            User admin = new User();

            admin.setFirstName("Tiago");
            admin.setLastName("Silva");
            admin.setEmail("admin@gmail.com");
            admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
            admin.setCreatedAt(new Date());
            admin.setUserRole(UserRole.ADMIN);

            userRepository.save(admin);
            System.out.println("Admin created sucessfully");
        }

        System.out.printf("Cannot create admin account");

    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
