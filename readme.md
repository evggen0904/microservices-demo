1) Для поднятия контейнера kafka + zookeeper необходимо стартануть докер образы 
    ```shell
       docker-compose -f common.yml -f kafka_cluster.yml up
    ```
2) Запустить ConfigServer для загрузки настроек приложений кластера

3) Запустить приложение twitter-to-kafka-service