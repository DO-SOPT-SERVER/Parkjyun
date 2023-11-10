package org.sopt.www.Seminar.dto.post;

import org.sopt.www.Seminar.domain.CategoryId;

public record PostCreateRequest(String title, String content, String categoryId) {

}
