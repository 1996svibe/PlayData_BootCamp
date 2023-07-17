package com.example.demo.member.domain.response;

import com.example.demo.member.domain.dto.MemberDto;
import com.example.demo.member.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@NoArgsConstructor
public class MemberResponse {
    private List<MemberDto> members;

    public MemberResponse(List<MemberDto> members) {
        this.members = members;
    }
}