package com.example.demo.member.service;
import com.example.demo.config.service.MemberLoginService;
import com.example.demo.member.domain.entity.Member;
import com.example.demo.member.domain.request.LoginRequest;
import com.example.demo.member.domain.request.SignUpRequest;
import com.example.demo.member.domain.response.LoginResponse;
import com.example.demo.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberLoginService memberLoginService;
    public void insert(SignUpRequest request){
        memberRepository.save(request.toEntity());
    }
    public LoginResponse login(LoginRequest request){
        Optional<Member> byEmailAndPassword =
                memberRepository
                        .findByEmailAndPassword(request.email(), request.password());
        Member member = byEmailAndPassword.orElseThrow(() -> new RuntimeException("없는유저"));
        memberLoginService.insert(member);
        return new LoginResponse(member.getId(), member.getName(), member.getAge());
    }

}
