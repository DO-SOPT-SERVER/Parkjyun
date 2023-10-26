package org.sopt.www.Seminar.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.sopt.www.Seminar.domain.Member;
import org.sopt.www.Seminar.domain.Sopt;

@Data//dto임을 나타내기 위해 간단하게 표현
@AllArgsConstructor
public class MemberGetResponse {
    private String name;
    private String nickname;
    private int age;
    private Sopt sopt;

    public static MemberGetResponse of(Member member) {
        return new MemberGetResponse(member.getName(), member.getNickname(), member.getAge(),member.getSopt());
    }

}

