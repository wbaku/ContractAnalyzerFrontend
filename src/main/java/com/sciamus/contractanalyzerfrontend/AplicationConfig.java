package com.sciamus.contractanalyzerfrontend;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AplicationConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        System.out.println("wczytao sie");
        return Logger.Level.FULL;

    }
}
