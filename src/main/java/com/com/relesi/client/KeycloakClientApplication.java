package com.com.relesi.client;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class KeycloakClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeycloakClientApplication.class, args);

		@Component
		@AllArgsConstructor
		class Runner implements ApplicationRunner {

			WebClient webClient;

			@Override
			public void run(ApplicationArguments args) throws Exception {
				webClient
						.get()
						.uri("http://localhost:8888/auth")
						.retrieve()
						.bodyToMono(String.class)
						.subscribe(System.out::println);
			}

		}
	}
}