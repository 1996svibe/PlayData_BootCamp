package com.example.demo.member.repository;
import com.example.demo.member.domain.entity.Member;
import com.example.demo.member.domain.response.MemberResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository
        extends JpaRepository<Member,Long> {
    List<Member> findAllByNameContaining(String name);
    @Query("select m from Member m " +
            "left join fetch m.hobbies " +
            "where m.name like : name")
    List<Member> findAllFetchByNameContaining(@Param("name") String name);


    @Query("select MemberResponse(m) from Member m " +
            "left join fetch m.hobbies " +
            "where m.name like : name")
    List<MemberResponse> findAllFetchByNameContainingToResponse(@Param("name") String name);
}