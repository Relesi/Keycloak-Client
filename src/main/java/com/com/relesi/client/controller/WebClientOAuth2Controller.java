package com.com.relesi.client.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class WebClientOAuth2Controller {

    WebClient webClient;

    @RequestMapping(method = RequestMethod.GET, value = "/external-auth")
    Mono<String> getExternalHello() {
        return webClient
                .get()
                .uri("http://localhost:8888/auth")
                .retrieve()
                .bodyToMono(String.class)
                .map(retorno -> "I received a " + retorno);
    }
}