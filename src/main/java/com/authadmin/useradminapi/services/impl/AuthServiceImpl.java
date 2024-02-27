package com.authadmin.useradminapi.services.impl;

import com.authadmin.useradminapi.dto.SignupRequest;
import com.authadmin.useradminapi.entity.Role;
import com.authadmin.useradminapi.entity.User;
import com.authadmin.useradminapi.repository.UserRepository;
import com.authadmin.useradminapi.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User signup(SignupRequest signupRequest){

        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setFirstName(signupRequest.getFirstName());
        user.setLastName(signupRequest.getLastName());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        return userRepository.save(user);

    }

}
