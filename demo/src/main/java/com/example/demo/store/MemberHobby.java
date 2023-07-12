package com.example.demo.store;

import com.example.demo.hobby.Hobby;
import com.example.demo.member.Member;
import lombok.AllArgsConstructor;
import lombok.Data;



@Data
public class MemberHobby {
    private Member member;
    private Hobby hobby;

    public MemberHobby(Member member, Hobby hobby) {
        this.member = member;
        this.hobby = hobby;
        member.getMemberHobbies().add(this);
        hobby.getMemberHobbies().add(this);
    }
}
