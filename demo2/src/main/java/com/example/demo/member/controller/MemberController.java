package com.example.demo.member.controller;

import com.example.demo.member.domain.dto.MemberDto;
import com.example.demo.member.domain.entity.Member;
import com.example.demo.member.domain.request.MemberRequest;
import com.example.demo.member.domain.response.MemberResponse;import com.example.demo.member.repository.MemberRepository;
import com.example.demo.member.service.MemberService;
import com.example.demo.todo.domain.entity.Todo;
import com.example.demo.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberService service;
    private final TodoService todoService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(
            @RequestBody MemberRequest request
    ){
        boolean existsEmail = service.existsEmail(request.email());
        if (existsEmail) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Member member = new Member();
        member.setEmail(request.email());
        member.setPassword(request.password());
        member.setName(request.name());
        member.setAge(request.age());

        service.signUp(member);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    private ResponseEntity<MemberResponse> logInMember(
            @RequestBody MemberRequest request
    ){
        String email = request.email();
        String password = request.password();

        Member member = service.logIn(email, password);
        if(member == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        MemberDto memberDto = new MemberDto(member.getId(), member.getName(), member.getAge());
        MemberResponse response = new MemberResponse(Collections.singletonList(memberDto));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<MemberResponse> getMembers(
            @RequestParam(name = "page", defaultValue = "0")Integer page,
            @RequestParam(name = "size", defaultValue = "10")Integer size
    ){
        Page<Member> memberPage = service.getMembers(page, size);
        List<Member> members = memberPage.getContent();
        List<MemberDto> memberDtos = members.stream()
                .map(member -> new MemberDto(member.getId(), member.getName(), member.getAge()))
                .collect(Collectors.toList());

        MemberResponse memberResponse = new MemberResponse(memberDtos);
        return ResponseEntity.ok(memberResponse);
    }
}