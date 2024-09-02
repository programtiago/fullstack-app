package com.dev.tiago.fullstack_app.backend.service;

import com.dev.tiago.fullstack_app.backend.entity.User;
import com.dev.tiago.fullstack_app.backend.service.impl.UserServiceImpl;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    User getById(Long id);

}
