package org.sopt.www.Seminar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaAuditing//추상클래스를 사용하겠다
public class SeminarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeminarApplication.class, args);
	}

}
