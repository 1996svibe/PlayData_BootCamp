package com.example.demo.member.domain.response;

import com.example.demo.hobby.domain.entity.Hobby;
import com.example.demo.member.domain.entity.Member;
import com.example.demo.store.MemberHobby;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor @Getter
public class MemberResponse {
    private Long id;
    private String name;
    private Integer age;
    private List<HobbyDto> hobbies;
    public MemberResponse(Member member){
        this.id = member.getId();
        this.age = member.getAge();
        this.name = member.getName();
        this.hobbies = member.getHobbies() != null ?
                member.getHobbies()
                .stream()
                .map(h-> new HobbyDto(h.getHobby()))
                .toList()
                :new ArrayList<>();
    }
    @Getter @AllArgsConstructor
    class HobbyDto{
        private Long id;
        private String name;
        public HobbyDto(Hobby hobby){
            this.id = hobby.getId();
            this.name = hobby.getName();
        }
    }
}
