package org.sopt.www.Seminar.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.www.Seminar.dto.post.PostCreateRequest;
import org.sopt.www.Seminar.dto.post.PostGetResponse;
import org.sopt.www.Seminar.dto.post.PostUpdateRequest;
import org.sopt.www.Seminar.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor//생성자 주입 생성자 하나면 자동적으로 autowirred
public class PostController {
    private static final String CUSTOM_AUTH_ID = "X-Auth-Id";
    private final PostService postService;

    @GetMapping("/{postId}")
    public ResponseEntity<PostGetResponse> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getById(postId));
    }

    @GetMapping
    public ResponseEntity<List<PostGetResponse>> getPosts(@RequestHeader(CUSTOM_AUTH_ID) Long memberId) {
        return ResponseEntity.ok(postService.getPosts(memberId));
    }

    @PostMapping//생성은 201, header에 location 담아줌
    public ResponseEntity<Void> createPost(@RequestHeader(CUSTOM_AUTH_ID) Long memberId, @RequestBody PostCreateRequest request) {
        URI location = URI.create("/api/posts" + postService.create(request, memberId));
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{postId}")
    public ResponseEntity<Void> updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequest request) {
        postService.editContent(postId, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deleteById(postId);
        return ResponseEntity.noContent().build();
    }
}
