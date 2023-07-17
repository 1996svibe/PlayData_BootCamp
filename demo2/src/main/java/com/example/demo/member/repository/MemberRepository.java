package com.example.demo.member.repository;

import com.example.demo.member.domain.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Page<Member> findByEmail(String email, Pageable pageable);
    boolean existsByEmail(String email);

   Member findByEmailAndPassword(String email, String password);
}
