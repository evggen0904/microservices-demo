1) Для создания docker images сервисов выполнить команду ```shell mvn clean install```
2) Для создания докер образа config-server выполнить команду в корневой директории проекта 
   ```shell
      docker build -f Dockerfile_ConfigServer -t com.microservices.demo/config-server:1.0 . 
   ```
3) Для создания докер образа kafka-to-elastic выполнить команду в корневой директории проекта
   ```shell
      docker build -f Dockerfile_KafkaToElasticService -t com.microservices.demo/kafka-to-elastic:1.0 .
   ```   
4) Для создания докер образа elastic-query-service выполнить команду в корневой директории проекта
   ```shell
      docker build -f Dockerfile_ElasticQueryService -t com.microservices.demo/elastic-query-service:1.0 .
   ```      
5) Для создания докер образа elastic-query-web-client выполнить команду в корневой директории проекта
   ```shell
      docker build -f Dockerfile_ElasticQueryWebClient -t com.microservices.demo/elastic-query-web-client:1.0 .
   ```       
6) Для поднятия контейнера kafka + zookeeper необходимо стартануть докер образы 
    ```shell
       docker-compose -f common.yml -f kafka_cluster.yml up
    ```
7) Для поднятия контейнера elastic search необходимо стартануть докер образы
    ```shell
       docker compose -f common.yml -f elastic_cluster.yml up
    ```   
8) Запустить в контейнерах все сервисы
    ```shell
       docker-compose -f common.yml -f services.yml up
    ```      
   Либо просто стартануть по отдельности ConfigServer, twitter-to-kafka-service, kafka-to-elastic-service, elastic-query-service

9) 
