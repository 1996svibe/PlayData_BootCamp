package com.naver.user.service;

import com.naver.user.domain.dto.User;
import com.naver.user.domain.request.LoginRequest;
import com.naver.user.domain.request.SignUpRequest;

public interface UserService {
    User login(LoginRequest request);

    boolean signup(SignUpRequest request);

}