package com.ntt.payment.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.ntt.payment.infrastructure.entity")
@EnableJpaRepositories(basePackages = "com.ntt.payment.infrastructure.repository")
@ComponentScan(basePackages = {"com.ntt.payment.application", "com.ntt.payment.infrastructure"})
public class PaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}

}
