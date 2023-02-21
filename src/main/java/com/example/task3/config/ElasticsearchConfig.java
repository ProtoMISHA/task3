package com.example.task3.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

public class ElasticsearchConfig extends ElasticsearchConfiguration {

    @Value("${elasticsearch.host}")
    private String host;
    @Value("${elasticsearch.port}")
    private int port;


    @Override
    @Bean
    public ClientConfiguration clientConfiguration() {
        String hostAndPort = String.format("%s:%d", host, port);
        return ClientConfiguration.builder()
                .connectedTo(hostAndPort)
                .build();
    }

}
