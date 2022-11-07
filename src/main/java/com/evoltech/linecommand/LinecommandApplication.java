package com.evoltech.linecommand;

import com.evoltech.linecommand.components.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LinecommandApplication {

	@Bean
	public ApplicationRunner applicationStartupRunner() {
		System.out.println("Dentro de Bean application Runner");
		return new ApplicationRunner();
	}

	public static void main(String[] args) {
		SpringApplication.run(LinecommandApplication.class, args);
	}

}
