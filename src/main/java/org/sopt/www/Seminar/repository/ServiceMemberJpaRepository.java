package org.sopt.www.Seminar.repository;

import org.sopt.www.Seminar.domain.ServiceMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceMemberJpaRepository extends JpaRepository<ServiceMember, Long> {
    Optional<ServiceMember> findByNickname(String nickname);

}
