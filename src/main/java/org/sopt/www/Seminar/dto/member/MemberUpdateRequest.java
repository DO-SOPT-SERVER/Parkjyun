package org.sopt.www.Seminar.dto.member;

import org.sopt.www.Seminar.domain.Part;

public record MemberUpdateRequest(int generation, Part part) {
}
