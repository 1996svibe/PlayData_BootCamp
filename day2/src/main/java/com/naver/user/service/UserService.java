package com.naver.user.service;

import com.naver.user.dao.UserMapper2;
import com.naver.user.domain.dto.UserUpdate;
import com.naver.user.domain.entity.User;
import com.naver.user.domain.request.LoginRequest;
import com.naver.user.domain.request.SignUpRequest;
import com.naver.user.domain.request.UserUpdateRequest;

public interface UserService {
    User login(LoginRequest request);

    boolean signup(SignUpRequest request);


    int update(UserUpdate update);
}