package com.example.demo.member;

import com.example.demo.store.Store;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    public List<MemberResponse> findAll() {

        return Store.members
                .stream()
                .map(MemberResponse::new)
                .toList();
    }

    public Member findById(Integer id) {
        for (int i = 0; i < Store.members.size(); i++) {
            if (Store.members.get(i).getId() == id)
                return Store.members.get(i);
        }
        Optional<Member> first = Store.members
                .stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
//        first.orElse(new Member());
//        Member member = new Member();
//        if(first.isPresent()) member = first.get();
        Member member = first.orElseThrow(NullPointerException::new);
        return member;
    }

    public void save(Member member) {
        Store.members.add(member);
    }

    public void deleteById(Integer id) {
        Store.members.remove(findById(id));
    }

    public Member update(Integer id, MemberRequest request){
        Member byId = findById(id);
        byId.setAge(request.age());
        byId.setName(request.name());
        return byId;
    }
}
