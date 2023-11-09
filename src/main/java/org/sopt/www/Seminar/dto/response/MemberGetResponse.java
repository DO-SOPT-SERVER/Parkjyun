package org.sopt.www.Seminar.dto.response;

import org.sopt.www.Seminar.domain.Member;
import org.sopt.www.Seminar.domain.Sopt;


public record MemberGetResponse(String name, String nickname, int age, Sopt sopt) {
    public static MemberGetResponse of(Member member) {
        return new MemberGetResponse(member.getName(), member.getNickname(), member.getAge(),member.getSopt());
    }

}

