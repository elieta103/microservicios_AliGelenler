package com.microservices.demo.kafka.admin.config;

import com.microservices.demo.config.KafkaConfigData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    private final KafkaConfigData kafkaConfigData;

    public WebClientConfig(KafkaConfigData kafkaConfigData) {
        this.kafkaConfigData = kafkaConfigData;
    }

    //Se crea el bean para verificar el status del Schema-Registry, mediante una llamada Rest.
    //Se pone como @Bean y @Configuration para que Spring lo inyecte y no cree uno nuevo, en cada peticion
    @Bean
    WebClient webClient() {
        return WebClient.builder().baseUrl(kafkaConfigData.getSchemaRegistryUrl()).build();
    }
}