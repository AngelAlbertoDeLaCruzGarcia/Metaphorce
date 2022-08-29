package com.backend.metaphorce.controller;

import com.backend.metaphorce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.metaphorce.dto.UserDto;
import com.backend.metaphorce.entity.User;
import com.backend.metaphorce.exception.Response;
import com.backend.metaphorce.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
/*
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    */
    @Autowired
    PasswordEncoder passwordEncoder;
    UserService userService;



    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody UserDto login){
        //User user = userService.findUser(login.getUsername());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto){
        try {
            User user = new User();
            user.setUsername(userDto.getUsername());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            userService.save(user);
            return new ResponseEntity(new Response("Usuario registrado exitosamente", 201),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.toString(),HttpStatus.BAD_REQUEST);
        }

    }
}