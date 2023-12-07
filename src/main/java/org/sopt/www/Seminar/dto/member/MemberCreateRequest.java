package org.sopt.www.Seminar.dto.member;

import org.sopt.www.Seminar.domain.Member;
import org.sopt.www.Seminar.domain.Sopt;

public record MemberCreateRequest(String name, String nickname, int age, Sopt soptInfo) {
    public static MemberCreateRequest of(Member member) {//staticmethod는 사용 가능 factory메서드
        return new MemberCreateRequest(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }
}
