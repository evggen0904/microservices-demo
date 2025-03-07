### Запуск кафки и сервиса по отдельности:
```shell
    docker-compose -f common.yml -f kafka_cluster.yml up -d
    // wait until kafka starts
    docker-compose -f common.yml -f services.yml up -d
```

### Запуск кафка + сервис вместе

Сервис будет рестартиться, пока не сможет подключиться к кластеру кафка
```shell
    docker-compose up -d
```


Проверить что топики создались и данные пишутся. Для этого можно использовать утилиту kafkacat.
Статус кластера:
```shell
kcat -L -b localhost:19092
```

Посмотреть сообщения в топике:
```shell
kcat -C -b localhost:19092 -t twitter-topic
```