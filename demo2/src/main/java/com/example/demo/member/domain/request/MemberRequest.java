package com.example.demo.member.domain.request;

import com.example.demo.member.domain.entity.Member;

public record MemberRequest(String email, String password, String name, Integer age) {
    public Member toEntity() {
        return new Member(email, password, name, age);
    }
}