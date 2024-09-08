package com.dev.tiago.fullstack_app.backend.dto.mapper;

import com.dev.tiago.fullstack_app.backend.dto.UserDto;
import com.dev.tiago.fullstack_app.backend.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user){
        if (user == null){
            return null;
        }

        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
    }

    public User toEntity(UserDto userDto){
        if (userDto == null){
            return null;
        }


        User user = new User();

        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
        user.setUserRole(userDto.getUserRole());
        user.setCreatedAt(userDto.getCreatedAt());

        return user;
    }
}
