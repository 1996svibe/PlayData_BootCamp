package com.example.demo.member;

import com.example.demo.hobby.Hobby;
import com.example.demo.store.MemberHobby;
import com.example.demo.store.Store;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class Member {
    private Integer id;
    private String name;
    private Integer age;
    private List<MemberHobby> members;

    public Member(String name, Integer age) {
        this.id = Store.memberIndex++;
        this.name = name;
        this.age = age;

    }
    public void addMemberHobby(MemberHobby memberHobby) {
        members.add(memberHobby);
    }
}