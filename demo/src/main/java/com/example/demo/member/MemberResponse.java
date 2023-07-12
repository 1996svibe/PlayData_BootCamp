package com.example.demo.member;

import com.example.demo.hobby.Hobby;
import com.example.demo.store.MemberHobby;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class MemberResponse {
    private Integer id;
    private String name;
    private Integer age;
    private List<HobbyDto> hobbies = new ArrayList<>();

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.age = member.getAge();
        this.name = member.getName();

//        List<MemberHobby> memberHobbies = member.getMembers();
//        for (MemberHobby memberHobby : memberHobbies) {
//            Hobby hobby = memberHobby.getHobby();
//            HobbyDto hobbyDto = new HobbyDto(hobby.getId(), hobby.getName());
            this.hobbies = member.getMembers()
                    .stream()
                    .map(MemberHobby::getHobby)
                    .map(HobbyDto::new)
                    .toList();
    }

    @Getter
    @AllArgsConstructor
    class HobbyDto {
        private Integer id;
        private String name;

        public HobbyDto(Hobby hobby) {
            this.id = hobby.getId();
            this.name = hobby.getName();
        }
    }
}
