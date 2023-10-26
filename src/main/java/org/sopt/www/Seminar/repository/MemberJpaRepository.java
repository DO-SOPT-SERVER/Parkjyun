package org.sopt.www.seminar.repository;

import jakarta.persistence.EntityNotFoundException;
import org.sopt.www.seminar.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    //default붙이면 인터페이스에도 함수 구현체 넣기 간으
    default Member findByIdOrThrow(Long memberId) {
        return findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 회원이 없습니다"));
    }
}
