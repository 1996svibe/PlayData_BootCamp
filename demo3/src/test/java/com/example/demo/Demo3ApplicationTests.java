package com.example.demo;

import com.example.demo.config.repository.MemberLoginRepository;
import com.example.demo.member.domain.entity.Member;
import com.example.demo.member.domain.entity.QMember;
import com.example.demo.member.repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
class Demo3ApplicationTests {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberLoginRepository memberLoginRepository;
    @Autowired
    EntityManager em;


    @Test @Transactional
    void contextLoads() {
        memberLoginRepository.findFirstByMemberIdAndEndAtAfterOrderByEndAtDesc(1l, LocalDateTime.now());
    }
    @Test
    void test(){
        QMember member = new QMember ("");
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        JPAQuery<Member> from = queryFactory
                .select(member)
                .from(member);
        List<Member> fetch = from.fetch();
        System.out.println();
    }

}