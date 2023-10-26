package org.sopt.www.seminar.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Part {//이넘 안에 변수를 넣으면 속성을 가질 수 있다. 원래는 SERVER,WEB<ANDROID이렇게만 있지만 name을 선언했기에 내부에 서버같은 속성을 선언 가능
    SERVER("서버"),
    WEB("웹"),
    ANDROID("안드로이드"),
    IOS("iOS"),
    PLAN("기획"),
    DESIGN("디자인");

    private final String name;
}

