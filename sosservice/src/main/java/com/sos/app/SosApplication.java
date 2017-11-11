package com.sos.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class 	SosApplication {

	public static void main(String[] args) {
		System.setProperty("java.net.preferIPv4Stack","true");
		SpringApplication.run(SosApplication.class, args);

	}
}
