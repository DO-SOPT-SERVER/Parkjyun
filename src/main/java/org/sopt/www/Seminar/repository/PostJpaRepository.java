package org.sopt.www.Seminar.repository;

import jakarta.persistence.EntityNotFoundException;
import org.sopt.www.Seminar.domain.Member;
import org.sopt.www.Seminar.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByMemberId(Long memberId);
    List<Post> findAllByMember(Member member);

    default Post findByIdOrThrow(Long postId) {
        return findById(postId).orElseThrow(() -> new EntityNotFoundException("post가 없습니다"));

    }
}
