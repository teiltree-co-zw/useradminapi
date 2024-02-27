package com.authadmin.useradminapi.controller;

import com.authadmin.useradminapi.dto.SignupRequest;
import com.authadmin.useradminapi.entity.User;
import com.authadmin.useradminapi.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> signup(@RequestBody SignupRequest signupRequest){

        return ResponseEntity.ok(authService.signup(signupRequest));
    }
}
