package org.sopt.www.Seminar.repository;

import jakarta.persistence.EntityNotFoundException;
import org.sopt.www.Seminar.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<Category, Short> {
    default Category findByIdOrThrow(Short id) {
        return findById(id).orElseThrow(() -> new EntityNotFoundException("해당하는 카테고리가 없습니다"));
    }
}
