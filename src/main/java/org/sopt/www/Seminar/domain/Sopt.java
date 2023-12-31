package org.sopt.www.Seminar.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Sopt {
    private int generation;

    @Enumerated(EnumType.STRING)//Enumtype ordinal == 이넘의 순서를 저장한다는 의미, Enumtype.string = enum이름을 디비에 저장
    private Part part;

    protected void changeGeneration(int generation) {
        this.generation = generation;
    }

    protected void changePart(Part part) {
        this.part = part;
    }
}