package org.sopt.www.seminar.dto.request;

import lombok.Data;
import org.sopt.www.seminar.domain.Member;
import org.sopt.www.seminar.domain.Sopt;

public record MemberCreateRequest (String name, String nickname, int age, Sopt soptInfo) {
    public static MemberCreateRequest of(Member member) {//staticmethod는 사용 가능 factory메서드
        return new MemberCreateRequest(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }
}
