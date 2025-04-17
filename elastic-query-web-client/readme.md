1) Запустить config-server
2) Запустить кластер elastic 
    ```shell
       docker compose -f common.yml -f elastic_cluster.yml up
    ```  
3) Запустить приложение [elastic-query-service](../elastic-query-service) [ElasticQueryServiceApplication.java](../elastic-query-service/src/main/java/com/microservices/demo/elastic/query/service/ElasticQueryServiceApplication.java)   
4) Запустить приложение [elastic-query-web-client]() [ElasticQueryWebClientApplication.java](src/main/java/com/microservices/demo/elastic/query/web/client/ElasticQueryWebClientApplication.java)
5) Начальная точка входа в приложение. Ввести в адресную строку в браузере:
    ```
        http://localhost:8184/elastic-query-web-client/
    ```