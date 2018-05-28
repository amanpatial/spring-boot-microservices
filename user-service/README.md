### Create a user resource
```
POST /users
Accept: application/json
Content-Type: application/json

{
  "id":"1",
  "name": "aman",
  "email": "aman.patial@gmail.com"
}

RESPONSE: HTTP 201 (Created)
Location: http://localhost:8080/users
```

### Retrieve a list of users
```
GET /users

RESPONSE: HTTP 200
Content: list of users in json format
```

### Retrieve a single users
```
GET /users/1

RESPONSE: HTTP 200
http://localhost:8080/users/1
Content: user information in json format
```

### Update a user resource
```
PUT /users/1
Accept: application/json
Content-Type: application/json

{
  "id":"1",
  "name": "aman patial",
  "email": "aman.patial@gmail.com"
}

RESPONSE: HTTP 200
Location: http://localhost:8080/users/1
```

### Delete a user resource
```
DELETE /users/1
Accept: application/json
Content-Type: application/json

http://localhost:8080/users/1
RESPONSE: HTTP 200
Location: http://localhost:8080/users/1
```