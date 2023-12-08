package org.sopt.www.Seminar.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)//protected인 기본 생성자를 만든다. @transaction은 proxy객체를 활용하는데 proxy객체 위해 protected이상의 생성자 필요
@Getter
@Table(name = "post")//디비 테이블의 이름을 post
public class Post extends BaseTimeEntity {//원래는 snakecase로 바뀌어서 테이블명 됨

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//디비에게 pk생성을 위임-> 1차 캐시에 저장되기 위해서는pk필요 -> em.persist되는 순간 쿼리 한번 나감
    //@Column(name = "id") 디비 상에서 컬럼이 id로 들어감
    private Long postId;//얘도 snakecase로 들어감 post_id

    private String title;

    //@Column(columnDefinition = "TEXT") 디비 컬럼의 자료형 바꿈(varchar -> text)
    private String content;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)//한명의 멤버가 여러개의 post, post가 다 -> 외래키, 연관관계의 주인, 지연로딩, manytoone은 기본은 즉시로딩
    @JoinColumn(name = "member_id")//외레키 매핑
    private Member member;

    @Column(name = "category_id")
    private CategoryId categoryId;
    public void updateContent(String content) {
        this.content = content;
    }

    @Builder
    public Post(String title, String content, Member member, CategoryId categoryId) {
        this.title = title;
        this.content = content;
        this.member = member;
        this.categoryId = categoryId;
    }

    @Builder(builderMethodName = "builderWithImageUrl")
    public Post(String title, String content, String imageUrl, Member member) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.member = member;
    }
}