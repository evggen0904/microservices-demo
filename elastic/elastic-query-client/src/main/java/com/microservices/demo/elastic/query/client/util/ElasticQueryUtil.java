package com.microservices.demo.elastic.query.client.util;

import co.elastic.clients.elasticsearch._types.query_dsl.IdsQuery;
import com.microservices.demo.elastic.model.index.IndexModel;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.IdsQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ElasticQueryUtil<T extends IndexModel> {

    public Query getSearchQueryById(String id) {
        return NativeQuery.builder()
                .withQuery(q -> q
                        .match(m -> m
                                .field("id")
                                .query(id)
                        )
                )
                .build();
//        return new NativeSearchQueryBuilder()
//                .withIds(Collections.singleton(id))
//                .build();
    }

    public Query getSearchQueryByFieldText(String field, String text) {
//        return new NativeSearchQueryBuilder()
//                .withQuery(new BoolQueryBuilder()
//                        .must(QueryBuilders.matchQuery(field, text)))
//                .build();
        return NativeQuery.builder()
                .withQuery(q -> q
                        .match(m -> m
                                .field(field)
                                .query(text)
                        )
                )
                .build();
    }

    public Query getSearchQueryForAll() {
          return null;

//        return new NativeSearchQueryBuilder()
//                .withQuery(new BoolQueryBuilder()
//                        .must(QueryBuilders.matchAllQuery()))
//                .build();
    }
}
