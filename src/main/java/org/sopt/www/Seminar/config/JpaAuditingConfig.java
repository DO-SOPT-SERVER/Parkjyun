package org.sopt.www.Seminar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration//스프링 빈으로
@EnableJpaAuditing
public class JpaAuditingConfig {
}
