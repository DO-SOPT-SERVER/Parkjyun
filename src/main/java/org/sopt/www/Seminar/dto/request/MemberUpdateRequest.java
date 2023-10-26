package org.sopt.www.Seminar.dto.request;

import org.sopt.www.Seminar.domain.Member;
import org.sopt.www.Seminar.domain.Part;

public record MemberUpdateRequest(int generation, Part part) {
}
