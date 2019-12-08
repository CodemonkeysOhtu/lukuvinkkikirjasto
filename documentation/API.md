# API


### Fetching entitites:

| Method | url | response |
| --- | --- | --- |
| GET | / | Object containing array of each entity type named accordingly - for example: <br>`{` <br> `"articles": [],` <br> `"books": [{`<br>`"isbn":"978-1133187790",`<br>` "year":0,`<br>` "edition":"",`<br>` "tagit":[""],`<br>` "related":[""],`<br>`"id":9,`<br>`"title":"",`<br>`"author":"",`<br>`"type":"book"`<br>`}], ` <br> `"blogposts": [],` <br>`"videos": []` <br>`}`  |
| GET | /books | An array containing all found entities of type `Book` - for example: <br> `[`<br>`{`<br>`"id":9,`<br>`"title":"",`<br>`"author":"",`<br>`"type":"book",`<br>`"isbn":"978-1133187790",`<br>`"year":0,`<br>`"edition":"",`<br>`"tagit":[""],`<br>`"related":[""]`<br>`}`<br>`]`|
| GET | /articles | An array containing all found entitites of type `Article` |
| GET | /videos | An array containing all found entitites of type `Video` |
| GET | /blogposts | An array containing all found entitites of type `Blogpost` |


### Deleting individual entitites:

| Method | url | response |
| --- | --- | --- |
| DELETE | `/books/{id}` <br> `/articles/{id}` <br> `/videos/{id}` <br> `/blogposts/{id}` | On success: statuscode 200, String "Success!" <br> On failure: statuscode 404 |


### Creating new entitites:

| Method | url | response |
| --- | --- | --- |
| POST | `/books` <br> `/articles` <br> `/videos` <br> `/blogposts` | On success: return added object in JSON format |
