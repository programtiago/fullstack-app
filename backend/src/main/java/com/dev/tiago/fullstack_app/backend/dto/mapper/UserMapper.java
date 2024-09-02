package com.dev.tiago.fullstack_app.backend.dto.mapper;

import com.dev.tiago.fullstack_app.backend.dto.UserDto;
import com.dev.tiago.fullstack_app.backend.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user){
        if (user == null){
            return null;
        }

        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getUserRole(), user.getCreatedAt());
    }

    public User toEntity(UserDto userDto){
        if (userDto == null){
            return null;
        }

        User user = new User();

        if (userDto.id() != null){
            user.setId(userDto.id());
        }

        user.setFirstName(userDto.firstName());
        user.setLastName(userDto.lastName());
        user.setEmail(userDto.email());
        user.setUserRole(userDto.userRole());
        user.setCreatedAt(userDto.createdAt());

        return user;
    }
}
