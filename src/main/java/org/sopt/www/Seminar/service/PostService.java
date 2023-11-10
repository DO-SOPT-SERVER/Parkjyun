package org.sopt.www.Seminar.service;

import lombok.RequiredArgsConstructor;
import org.sopt.www.Seminar.domain.Category;
import org.sopt.www.Seminar.domain.Member;
import org.sopt.www.Seminar.domain.Post;
import org.sopt.www.Seminar.dto.post.PostCreateRequest;
import org.sopt.www.Seminar.dto.post.PostGetResponse;
import org.sopt.www.Seminar.dto.post.PostUpdateRequest;
import org.sopt.www.Seminar.repository.MemberJpaRepository;
import org.sopt.www.Seminar.repository.PostJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor//for repository 의존성 주입
@Transactional(readOnly = true)
public class PostService {

    private final CategoryService categoryService;
    private final PostJpaRepository postJpaRepository;
    private final MemberJpaRepository memberJpaRepository;

    @Transactional//셍성이니깐 readonlt = true 영향을 안 받도록 @Transactional 생성
    public String create(PostCreateRequest request, Long memberId) {
       Member member = memberJpaRepository.findByIdOrThrow(memberId);
       Post post = postJpaRepository.save(
                        Post.builder()
                       .title(request.title())
                       .content(request.content())
                       .member(member)
                       .build());
       return post.getPostId().toString();
    }

    public PostGetResponse getById(Long postId) {
        //Post post = postJpaRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
        Post post = postJpaRepository.findByIdOrThrow(postId);
        return PostGetResponse.of(post, getCategoryByPost(post));
    }


    public List<PostGetResponse> getPosts(Long memberId) {
        return postJpaRepository.findAllByMemberId(memberId)
                .stream()
                .map(post -> PostGetResponse.of(post, getCategoryByPost(post)))
                .toList();
    }

    private Category getCategoryByPost(Post post) {
        return categoryService.getByCategoryId(post.getCategoryId());
    }

    @Transactional
    public void editContent(Long postId, PostUpdateRequest request) {
        Post post = postJpaRepository.findByIdOrThrow(postId);
        post.updateContent(request.content());
    }

    //삭제시 delete(entity) 와 deletebyid(id)차이점 -> delete는 findbyId와 함께씀 -> 개발자가 예외(조회된것이 없을 때)를 커스텀할 수 있음 by orelsethrow
    @Transactional
    public void deleteById(Long postId) {
        Post post = postJpaRepository.findByIdOrThrow(postId);
        postJpaRepository.delete(post);
    }
}
