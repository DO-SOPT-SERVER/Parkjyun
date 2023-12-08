package org.sopt.www.Seminar.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.www.Seminar.dto.post.PostCreateRequest;
import org.sopt.www.Seminar.service.PostServiceV2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

@RestController
@RequestMapping("/api/v2/posts")
@RequiredArgsConstructor
public class PostControllerV2 {

    private static final String CUSTOM_AUTH_ID = "X-Auth-Id";
    private final PostServiceV2 postService;

    @PostMapping
    public ResponseEntity<Void> createPostV2(@RequestHeader(CUSTOM_AUTH_ID) Long memberId, @RequestPart MultipartFile image
            , PostCreateRequest request) {
        URI location = URI.create("/api/posts/v2" + postService.createV2(request, image, memberId));
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deleteByIdV2(postId);
        return ResponseEntity.noContent().build();
    }
}
