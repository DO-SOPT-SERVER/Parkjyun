package org.sopt.www.Seminar.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass//super class 임을 indicate -> 사용하겠다고 SerminarApplication에서 annotation 달아줘야함 아니면 config따로 만들어서 빈으로 등록, 거기다가//자신을 테이블로 만들지는 않음
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate//생성시각
    private LocalDateTime createdAt;// = LocalDateTime.now();를 annotation이 실행

    @LastModifiedDate//마지막 수정 시간
    private LocalDateTime updatedAt;

}
