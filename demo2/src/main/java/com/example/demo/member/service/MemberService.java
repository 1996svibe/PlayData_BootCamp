package com.example.demo.member.service;

import com.example.demo.member.domain.entity.Member;
import com.example.demo.member.domain.request.MemberRequest;
import com.example.demo.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    public final MemberRepository memberRepository;

    public boolean existsEmail(String email){
        return memberRepository.existsByEmail(email);
    }
    public void signUp(Member member){
        boolean emailExists = existsEmail(member.getEmail());
        if (emailExists) {
            throw new IllegalArgumentException("Email already exists.");
        }
        memberRepository.save(member);
    }
    public void insert(MemberRequest request) {
        Member save = memberRepository.save(request.toEntity());
    }

    public Member logIn(String email, String password){
        Member member = memberRepository.findByEmailAndPassword(email, password);
        if (member == null){
            throw new IllegalArgumentException("Invalid email or password.");
        }
        return member;
    }
    public Page<Member> getMembers(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return memberRepository.findAll(pageable);
    }

    public boolean isMemberLoggedIn(Member member){
        return member.isLoggedIn();
    }

}
