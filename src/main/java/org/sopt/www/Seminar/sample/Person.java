package org.sopt.www.Seminar.sample;
//ex for builder pattern

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

//1. class에 builder 붙이면 클래스 내의 모든 생성자에 대해 @builder를 붙이는 효과
//2. 각각의 생성자에 따로 따로 builder를 붙이면 각 생성자가 갖고있는 매개변수에 대해서만 빌더패턴 사용가능
@Getter
@Builder
@AllArgsConstructor//-> 이경우에는 모든 필드에 대해 빌더를 쓸 수 있겠지.//모든 필드 갖는 생성자 위에 빌더 어노테이션을 붙이니
public class Person {
    private String lastName;
    private String firstName;
}
