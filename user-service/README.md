## Set Up Steps
### Pre-requisites and build steps
```
Java 1.8 to see run java --version
Maven 3.5.x to see version run mvn -v
cd /go/to/project/root/directory
mvn clean install
mvn clean install -DskipTests -Dpmd.skip=true  (optional)
java -jar ./target/user-service-0.0.1-SNAPSHOT.jar --spring.config.location=./src/main/resources/application.properties

ps aux | grep java (optional)
```

## APIs

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

### Retrieve a user
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

RESPONSE: HTTP 200
Location: http://localhost:8080/users/1
```