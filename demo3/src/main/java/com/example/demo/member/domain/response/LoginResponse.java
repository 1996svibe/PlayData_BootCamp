package com.example.demo.member.domain.response;

import com.example.demo.member.domain.entity.Member;

public record LoginResponse(
        Long id, String name, Integer age, String token ) {
}