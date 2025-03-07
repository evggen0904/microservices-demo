1) Название конфигурационного файла должно быть таким же, что указано в настройке у клиента
   ```yml
      spring:
        application:
          name: twitter-to-kafka-service
    ```
   Т.е в нашем случае ```twitter-to-kafka-service.yml```
2) Файл с настройками должен создаваться согласно маске ```{serviceID}{profile{.yml}}``` Если профиль не указан, то будет использован ```default```
3) Для того, что посмотреть что файлы конфигурации подтянулись на сервер
    ```shell
        curl http://localhost:8888/config-client.yml
        curl http://localhost:8888/twitter-to-kafka-service.yml
    ```
4) Посмотреть конфигурацию на сервере
   ```shell
      curl http://localhost:8888/twitter-to-kafka-service/default
    ```
5) Для того чтобы клиент смог использовать настройки с сервера необходимо задать имя и путь до сервера
    ```yaml
    spring:
        application:
            name: twitter-to-kafka-service
        config:
            import: optional:configserver:http://localhost:8888
    ```