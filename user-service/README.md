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

## GET

## Content-Type application/json

http://localhost:8080/users


## GET

## Content-Type application/json
http://localhost:8080/users/1




## PUT

## Content-Type application/json

http://localhost:8080/users/1
{
  "id":"1",
  "name": "aman patial",
  "email": "aman.patial@gmail.com"
}

## DELETE

## Content-Type application/json

http://localhost:8080/users/1
