# openapi
curl -v http://localhost:8183/elastic-query-service/api-docs

# swagger documentation
http://localhost:8183/elastic-query-service/swagger-ui/index.html#/

#get all documents
curl -v http://localhost:8183/elastic-query-service/documents/

#get document by id
curl -v http://localhost:8183/elastic-query-service/documents/1

#get document by id v2 (versioning by HATEOAS - hypermedia as the engine of application state)
curl -H 'Accept: application/vnd.api.v2+json' -v http://localhost:8183/elastic-query-service/documents/1

#get document by text
curl -v -X POST http://localhost:8183/elastic-query-service/documents/get-document-by-text -H 'Content-Type: application/json' -d'
{
  "text": "test"
}
'
