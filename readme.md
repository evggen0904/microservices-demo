1) Для создания docker images сервисов выполнить команду ```shell mvn clean install```
2) Для создания докер образа config-server выполнить команду в корневой директории проекта 
   ```shell
      docker build -f Dockerfile_ConfigServer -t com.microservices.demo/config-server:1.0 . 
   ```
3) Для поднятия контейнера kafka + zookeeper необходимо стартануть докер образы 
    ```shell
       docker-compose -f common.yml -f kafka_cluster.yml up
    ```
4) Запустить ConfigServer для загрузки настроек приложений кластера

5) Запустить приложение twitter-to-kafka-service