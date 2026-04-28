package com.eder.reservas.controllers;

import com.eder.reservas.domain.user.User;
import com.eder.reservas.dtos.LoginRequest;
import com.eder.reservas.dtos.LoginResponse;
import com.eder.reservas.dtos.RegisterRequest;
import com.eder.reservas.dtos.RegisterResponse;
import com.eder.reservas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        RegisterResponse response = new RegisterResponse(userService.register(new User(request)));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = new LoginResponse(userService.login(request.email(), request.password()));

        return ResponseEntity.ok(response);
    }
}
