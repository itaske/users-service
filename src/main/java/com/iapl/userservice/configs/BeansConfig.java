package com.iapl.userservice.configs;

import com.iapl.userservice.exceptions.RestTemplateResponseErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class BeansConfig {

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(6000000))
                .setReadTimeout(Duration.ofMillis(6000000))
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }

}
