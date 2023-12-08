package org.sopt.www.Seminar.service;


import lombok.RequiredArgsConstructor;
import org.sopt.www.Seminar.domain.Member;
import org.sopt.www.Seminar.domain.Post;
import org.sopt.www.Seminar.dto.post.PostCreateRequest;
import org.sopt.www.Seminar.exception.BusinessException;
import org.sopt.www.Seminar.exception.ErrorMessage;
import org.sopt.www.Seminar.external.S3Service;
import org.sopt.www.Seminar.repository.MemberJpaRepository;
import org.sopt.www.Seminar.repository.PostJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceV2 {

    private static final String POST_IMAGE_FOLDER_NAME = "posts/";//posts/member1/1.jpg하면 s3에 패키지 만들어지면서 사진 저장 + 폴더링을 하는게 속도가 빠름

    private final MemberJpaRepository memberJpaRepository;
    private final PostJpaRepository postJpaRepository;
    private final S3Service s3Service;

    @Transactional
    public String createV2(PostCreateRequest request, MultipartFile image, Long memberId) {
        try {
            final String imageUrl = s3Service.uploadImage(POST_IMAGE_FOLDER_NAME, image);
            Member member = memberJpaRepository.findByIdOrThrow(memberId);
            Post post = postJpaRepository.save(
                    Post.builderWithImageUrl()
                            .title(request.title())
                            .content(request.content())
                            .imageUrl(imageUrl)
                            .member(member)
                            .build());
            return post.getPostId().toString();
        } catch (RuntimeException | IOException e) {//uploadImage에서 exception throw -> 이를 처리해줘야 함
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    public void deleteByIdV2(Long postId) {
        try {
            Post post = postJpaRepository.findById(postId)
                    .orElseThrow(() -> new BusinessException(ErrorMessage.POST_NOT_FOUND_EXCEPTION));
            s3Service.deleteImage(post.getImageUrl());
            postJpaRepository.deleteById(postId);
        } catch (IOException | RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
