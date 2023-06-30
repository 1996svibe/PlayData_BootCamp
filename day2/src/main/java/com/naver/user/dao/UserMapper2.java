package com.naver.user.dao;

import com.naver.user.domain.dto.UserUpdate;
import com.naver.user.domain.entity.User;
import com.naver.user.domain.request.LoginRequest;
import com.naver.user.domain.request.SignUpRequest;
import com.naver.user.domain.request.UserUpdateRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper2 {
     User login(LoginRequest request);
     int signup(SignUpRequest request);
     int update(UserUpdate update);
}
