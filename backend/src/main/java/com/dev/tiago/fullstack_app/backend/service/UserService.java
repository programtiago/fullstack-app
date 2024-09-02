package com.dev.tiago.fullstack_app.backend.service;

import com.dev.tiago.fullstack_app.backend.dto.UserDto;
import com.dev.tiago.fullstack_app.backend.entity.User;

import java.util.List;

public interface UserService {

    List<UserDto> getUsers();
    UserDto getById(Long id);

}
