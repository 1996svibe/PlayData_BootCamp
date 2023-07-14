package com.example.demo.store;

import com.example.demo.hobby.domain.entity.Hobby;
import com.example.demo.member.domain.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity @AllArgsConstructor
@NoArgsConstructor @Getter
@Builder @Setter
@Table(name = "member_hobby")
public class MemberHobby {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Member member;
    @ManyToOne
    private Hobby hobby;
}
