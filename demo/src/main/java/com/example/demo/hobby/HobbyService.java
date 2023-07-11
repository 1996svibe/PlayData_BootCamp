package com.example.demo.hobby;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.store.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class HobbyService {
        private final MemberService memberService;
        public void save(HobbyRequest request){
            Member byId = memberService.findById(request.memberId());
            Hobby hobby = (new Hobby(null, request.name(), byId));
            Store.hobbies.add(hobby);
            byId.getHobbies().add(hobby);
    }
}