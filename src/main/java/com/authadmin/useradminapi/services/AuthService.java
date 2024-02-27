package com.authadmin.useradminapi.services;

import com.authadmin.useradminapi.dto.SignupRequest;
import com.authadmin.useradminapi.entity.User;

public interface AuthService {

    User signup(SignupRequest signupRequest);
}
