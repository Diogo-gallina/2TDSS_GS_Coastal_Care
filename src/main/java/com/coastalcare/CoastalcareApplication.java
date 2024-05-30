package com.coastalcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CoastalcareApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoastalcareApplication.class, args);
	}

}
