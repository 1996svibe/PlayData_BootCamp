package com.example.demo.hobby;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.store.MemberHobby;
import com.example.demo.store.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class HobbyService {
    private final MemberService memberService;

    public void save(HobbyRequest request) {
//        Member byId = memberService.findById(request.memberId());
        Hobby hobby = new Hobby(null, request.getName(), null);
        Store.hobbies.add(hobby);
//        MemberHobby memberHobby = new MemberHobby(byId, hobby);

//        byId.addMemberHobby(memberHobby);
    }
    public void connect(ConnectRequest request){
        Member member = memberService.findById(request.memberId());
        Hobby hobby = Store.hobbies
                .stream()
                .filter(h -> h.getId().equals(request.hobbyId()))
                .findFirst()
                .get();
        new MemberHobby(member,hobby);
    }
    public List<HobbyResponse> findByLikeName(String name){
       return Store.hobbies
                .stream()
                .filter(h -> h.getName().contains(name))
               .map(HobbyResponse::new)
               .toList();


    }

}