package com.example.demo.hobby.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HobbyRequest {
    private String name;
    private Long memberId;
}
