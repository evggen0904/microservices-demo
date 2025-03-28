package com.microservices.demo.elastic.model.index.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microservices.demo.elastic.model.index.IndexModel;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Data
@Builder
//@Document(indexName = "#{elasticConfigData.indexName}")
@Document(indexName = "twitter-index")
public class TwitterIndexModel implements IndexModel {

    @JsonProperty
    private String id;
    @JsonProperty
    private Long userId;
    @JsonProperty
    private String text;

//    @Field(type = FieldType.Date, format = {}, pattern = "uuuu-MM-dd'T'HH:mm:ssVV")
//    @Field(type = FieldType.Date, format = DateFormat.strict_date_time_no_millis)
    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second)
//    @Field(type = FieldType.Date, pattern = "uuuu-MM-dd'T'HH:mm:ssZZ")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "uuuu-MM-dd'T'HH:mm:ss")
    @JsonProperty
    private LocalDateTime createdAt;
}
