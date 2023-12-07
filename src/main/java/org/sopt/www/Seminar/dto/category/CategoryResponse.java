package org.sopt.www.Seminar.dto.category;

import org.sopt.www.Seminar.domain.Category;

public record CategoryResponse(Short id, String content) {
    public static CategoryResponse of(Category category) {
        return new CategoryResponse(category.getId(), category.getContent());
    }
}
