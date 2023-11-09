package org.sopt.www.Seminar.domain;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
@Getter
@EqualsAndHashCode
public class CategoryId implements Serializable {

    private String categoryId;
}
