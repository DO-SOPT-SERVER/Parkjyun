package org.sopt.www.Seminar.dto.post;

import org.sopt.www.Seminar.domain.Category;
import org.sopt.www.Seminar.domain.Post;

public record PostGetResponse(
        Long id,
        String title,
        String content,
        String Content
) {
    public static PostGetResponse of(Post post, Category category) {
        return new PostGetResponse(
                post.getPostId(),
                post.getTitle(),
                post.getContent(),
                category.getContent()

        );
    }
}