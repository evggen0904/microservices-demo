# check elastic cluster
curl -v http://localhost:9200

#create index
curl -X PUT "localhost:9200/twitter-index" -H 'Content-Type: application/json' -d'
{
  "mappings": {
    "properties": {
      "userId": {
        "type": "long"
      },
      "id": {
        "type": "text",
        "fields": {
          "keyword": {
            "type": "keyword",
            "ignore_above": 256
          }
        }
      },
      "createdAt": {
        "type": "date",
        "format": "yyyy-MM-dd'\''T'\''HH:mm:ss"
      },
      "text": {
        "type": "text",
        "fields": {
          "keyword": {
            "type": "keyword",
            "ignore_above": 256
          }
        }
      }
    }
  }
}
'

#create document in index
curl -X POST "localhost:9200/twitter-index/_doc/1" -H 'Content-Type: application/json' -d'
{
  "userId": "1",
  "id": "1",
  "createdAt": "2025-03-17T09:01:00",
  "text": "test multi word"
}
'

#search document
curl -v "localhost:9200/twitter-index/_search?q=id:1"

curl -X DELETE "localhost:9200/twitter-index"