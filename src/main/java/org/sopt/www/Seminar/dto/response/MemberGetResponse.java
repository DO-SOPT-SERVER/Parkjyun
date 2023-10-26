package org.sopt.www.seminar.dto.response;

import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.sopt.www.seminar.domain.Member;
import org.sopt.www.seminar.domain.Sopt;

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
