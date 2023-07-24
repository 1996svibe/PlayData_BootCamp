package com.example.demo.config.repository;

import com.example.demo.config.domain.entity.MemberLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface MemberLoginRepository extends JpaRepository<MemberLogin, Long> {
    // 새로운 메서드 추가
    Optional<MemberLogin> findFirstByMemberIdAndEndAtAfterOrderByEndAtDesc(Long memberId, LocalDateTime endTime);
}