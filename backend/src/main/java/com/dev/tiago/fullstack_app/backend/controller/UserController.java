package com.dev.tiago.fullstack_app.backend.controller;

import com.dev.tiago.fullstack_app.backend.dto.UserDto;
import com.dev.tiago.fullstack_app.backend.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(userService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(UserDto userDto){
        return new ResponseEntity<>(userService.create(userDto), HttpStatus.CREATED);
    }

}
