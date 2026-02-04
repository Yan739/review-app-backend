package com.yann.review_app_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.hibernate.autoconfigure.HibernateJpaAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class ReviewAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewAppBackendApplication.class, args);
	}

}
