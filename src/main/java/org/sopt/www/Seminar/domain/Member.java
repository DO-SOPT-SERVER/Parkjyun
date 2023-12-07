package org.sopt.www.Seminar.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.sopt.www.Seminar.dto.member.MemberUpdateRequest;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)//protected인 기본 생성자를 만든다. @transaction은 proxy객체를 활용하는데 proxy객체 위해 protected이상의 생성자 필
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//pk를 자동으로 생성해준다. 이때 전략은 GenerationType.IDENTITY
    private Long id;
    private String name;
    private String nickname;
    private int age;

    @Embedded//멤버가 가지는 속성들을 모두 필드의 형태로 저장하면 클래스가 너무 지저분해짐 -> 멤버가 갖는 필드들을 Sopt라는 클래스로 묶어서 따로 뺌
    //공통적으로 관리할 수 있는 필드들은 한 객체의 속성으로 보고 객체로 관리
    //임베디드를 붙이면 나중에 데이터베이스에 sopt의 필드들이 멤버의 필드들로 들어감
    private Sopt sopt;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private final List<Post> posts = new ArrayList<>();

    @Builder
    public Member(String name, String nickname, int age, Sopt sopt) {//아이디빼고 생성자를 만듦 왜와이? pk는 generatedvalue로 자동으로 만들어주기에
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.sopt = sopt;
    }

    public void updateSopt(MemberUpdateRequest memberUpdateRequest) {
        sopt.changeGeneration(memberUpdateRequest.generation());
        sopt.changePart(memberUpdateRequest.part());
    }
}