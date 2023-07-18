package com.example.demo.member.domain.request;

import com.example.demo.member.domain.entity.Member;

public record SignUpRequest(String email
        , String password
        , String name
        , Integer age) {
    public Member toEntity(){
        return Member.builder()
                .email(email)
                .password(password)
                .age(age)
                .name(name)
                .build();
    }
}