package com.dev.tiago.fullstack_app.backend.controller;

import com.dev.tiago.fullstack_app.backend.dto.AuthenticationRequest;
import com.dev.tiago.fullstack_app.backend.dto.AuthenticationResponse;
import com.dev.tiago.fullstack_app.backend.entity.LoginAttempt;
import com.dev.tiago.fullstack_app.backend.entity.User;
import com.dev.tiago.fullstack_app.backend.repository.LoginAttemptRepository;
import com.dev.tiago.fullstack_app.backend.repository.UserRepository;
import com.dev.tiago.fullstack_app.backend.service.impl.UserServiceImpl;
import com.dev.tiago.fullstack_app.backend.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final LoginAttemptRepository loginAttemptRepository;

    private final JwtUtil jwtUtil;
    private final UserServiceImpl userService;
    private final AuthenticationManager authManager;

    private final Logger LOG =
            Logger.getLogger(AuthController.class.getName());


    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest authenticationRequest){
        try{
            authManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                    authenticationRequest.getPassword()));
        }catch (BadCredentialsException e){
            LoginAttempt loginAttempt = new LoginAttempt(authenticationRequest.getEmail());
            loginAttemptRepository.save(loginAttempt);

            throw new BadCredentialsException("Incorrect username or password");
        }

        final UserDetails userDetails = userService.userDetailsService().loadUserByUsername(authenticationRequest.getEmail());
        Optional<User> optionalUser = userRepository.findFirstByEmail(authenticationRequest.getEmail());

        final String jwtToken = jwtUtil.generateToken(userDetails);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();

        if (optionalUser.isPresent()){
            authenticationResponse.setToken(jwtToken);
            authenticationResponse.setUserId(optionalUser.get().getId());
            authenticationResponse.setUserRole(optionalUser.get().getUserRole());
        }

        System.out.printf("LOGGED IN AS: " + optionalUser.get().getEmail() + " is sucessfully authenticated and has the autorities " + optionalUser.get().getUserRole());
        return authenticationResponse;
    }
}
