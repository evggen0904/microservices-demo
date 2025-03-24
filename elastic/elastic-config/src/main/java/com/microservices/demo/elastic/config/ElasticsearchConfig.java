package com.microservices.demo.elastic.config;

import com.microservices.demo.config.ElasticConfigData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Slf4j
@EnableElasticsearchRepositories(basePackages = "com.microservices.demo.elastic.index.client.repository")
@Configuration
public class ElasticsearchConfig extends ElasticsearchConfiguration {

    private final ElasticConfigData elasticConfigData;

    public ElasticsearchConfig(ElasticConfigData configData) {
        this.elasticConfigData = configData;

        log.info("ElasticsearchConfig created with configuration {}", elasticConfigData);
    }


    @Bean
    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo(elasticConfigData.getConnectionUrl())
                .withConnectTimeout(elasticConfigData.getConnectionTimeout())
                .withSocketTimeout(elasticConfigData.getSocketTimeout())
                .build();
    }
}
