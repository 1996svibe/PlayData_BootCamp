package com.example.demo.config.domain.entity;

import com.example.demo.member.domain.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class MemberLogin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Member member;
    private LocalDateTime createAt;
    private LocalDateTime endAt;

    public MemberLogin( Member member, LocalDateTime createAt){
        this.member = member;
        this.createAt = createAt;
        this.endAt = createAt.plusMinutes(10);
    }
}
