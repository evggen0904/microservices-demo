package com.microservices.demo.elastic.index.client.service.impl;

import com.microservices.demo.elastic.index.client.repository.TwitterElasticsearchIndexRepository;
import com.microservices.demo.elastic.index.client.service.ElasticIndexClient;
import com.microservices.demo.elastic.model.index.impl.TwitterIndexModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@ConditionalOnProperty(value = "elastic-config.is-repository", havingValue = "true", matchIfMissing = true)
@Service
public class TwitterElasticRepositoryIndexClient implements ElasticIndexClient<TwitterIndexModel> {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterElasticRepositoryIndexClient.class);

    private final TwitterElasticsearchIndexRepository twitterElasticsearchIndexRepository;

    public TwitterElasticRepositoryIndexClient(TwitterElasticsearchIndexRepository indexRepository) {
        this.twitterElasticsearchIndexRepository = indexRepository;
    }

    @Override
    public List<String> save(List<TwitterIndexModel> documents) {
        List<TwitterIndexModel> repositoryResponse =
                (List<TwitterIndexModel>) twitterElasticsearchIndexRepository.saveAll(documents);
        List<String> ids = repositoryResponse.stream().map(TwitterIndexModel::getId).collect(Collectors.toList());
        LOG.info("Documents indexed successfully with type: {} and ids: {}", TwitterIndexModel.class.getName(), ids);
        return ids;
    }
}
