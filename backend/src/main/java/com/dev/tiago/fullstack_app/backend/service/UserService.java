package com.dev.tiago.fullstack_app.backend.service;

import com.dev.tiago.fullstack_app.backend.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {

    UserDetailsService userDetailsService();

    List<UserDto> getUsers();
    UserDto getById(Long id);
    UserDto create(UserDto user);


}
