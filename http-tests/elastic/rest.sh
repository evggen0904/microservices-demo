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

#delete index
curl -X DELETE "localhost:9200/twitter-index"

#get all data(max 10000)
curl -v "localhost:9200/twitter-index/_search"

#specify query size
curl -v "localhost:9200/twitter-index/_search?size=2"

#get data with text=test
curl -v "localhost:9200/twitter-index/_search?q=text:test"

curl -X POST "localhost:9200/twitter-index/_search" -H 'Content-Type: application/json' -d'
  {
    "query": {
      "term": {
         "text": "test multi word"
        }
     }
  }
'

#result search for "test" and "word" match
curl -X POST "localhost:9200/twitter-index/_search" -H 'Content-Type: application/json' -d'
{
  "from": 0,
  "size": 10,
  "query": {
    "bool": {
      "must": [
        {
          "match": {
            "text": "test"
          }
        },
        {
          "match": {
            "text": "word"
          }
        }
      ]
    }
  }
}
'
#union result search "test" or "word"
curl -X POST "localhost:9200/twitter-index/_search" -H 'Content-Type: application/json' -d'
{
  "from": 0,
  "size": 10,
  "query": {
    "bool": {
      "should": [
        {
          "match": {
            "text": "test"
          }
        },
        {
          "match": {
            "text": "word"
          }
        }
      ]
    }
  }
}
'