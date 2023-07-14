package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.store.Store.members;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
//    @Autowired
    private final MemberService memberService;

    @GetMapping
    public List<MemberResponse> findAll(){
        return memberService.findAll();
    }
    @GetMapping("{id}")
    public Member findById(@PathVariable("id") Integer id){
        return memberService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody MemberRequest member){
        memberService.save(member.toEntity());
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        memberService.deleteById(id);
    }

    @PutMapping("{id}")
    public Member update(@PathVariable("id") Integer id,
        @RequestBody MemberRequest request){
    return memberService.update(id, request);
        }
}

