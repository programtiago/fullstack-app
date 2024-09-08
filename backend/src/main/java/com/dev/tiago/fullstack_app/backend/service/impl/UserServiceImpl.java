package com.dev.tiago.fullstack_app.backend.service.impl;

import com.dev.tiago.fullstack_app.backend.dto.UserDto;
import com.dev.tiago.fullstack_app.backend.dto.mapper.UserMapper;
import com.dev.tiago.fullstack_app.backend.enums.UserRole;
import com.dev.tiago.fullstack_app.backend.repository.UserRepository;
import com.dev.tiago.fullstack_app.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findFirstByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getUserRole() == UserRole.EMPLOYEE)
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getById(Long id) {
        return userRepository.findById(id).map(userMapper::toDto).orElseThrow();
    }

    @Override
    public UserDto create(UserDto user) {
        return userMapper.toDto(userRepository.save(userMapper.toEntity(user)));
    }
}
