## Spring Boot Project
Spring Boot (version 2.0.0) application with CRUD end points connecting through mysql.

### Pre-requisites and build steps
```
Make sure that your operating system had JDK 1.8 and Maven 3.x installed
java -version
mvn -v
clone the code repository
cd /go/to/project/code/root/directory
mvn clean install
mvn clean install -DskipTests -Dpmd.skip=true  (optional to avoid the test package building)
java -jar ./target/user-service-0.0.1-SNAPSHOT.jar --spring.config.location=./src/main/resources/application.properties
```
###  Docker's pre-requisites and installation steps
```
Make sure that your operating system had JDK 1.8 and Maven 3.x installed
Make sure docker latest verison is installed. use docker -v
Refer: https://docs.docker.com/install/linux/docker-ce/centos/#install-using-the-repository
sudo systemctl start docker

clone the code repository
cd /go/to/project/code/root/directory
mvn clean install
docker build -f Dockerfile -t user-service .
docker images 
docker run -p 8080:8080 user-service
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

{
  "id":"1",
  "name": "aman",
  "email": "aman.patial@gmail.com",
  "addresses": [
            {
                "id": 17,
                "addressText": "Chandigarh"
            },
            {
                "id": 3,
                "addressText": "Bangalore"
            },
            {
                "id": 4,
                "addressText": "Amritsar"
            }
        ]
}
```
### Retrieve a user by name
```
GET /users/filter

RESPONSE: HTTP 200
http://localhost:8080/users/filter?name=aman
Content: user information in json format

{
  "id":"1",
  "name": "aman",
  "email": "aman.patial@gmail.com",
  "addresses": [
            {
                "id": 17,
                "addressText": "Chandigarh"
            },
            {
                "id": 3,
                "addressText": "Bangalore"
            },
            {
                "id": 4,
                "addressText": "Amritsar"
            }
        ]
}
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

### Create a address resource for a user
```
POST /users/{userid}/addresses
Accept: application/json
Content-Type: application/json

/users/1/addresses
{
    "addressText": "Chandigarh"
}
```
## Create a address resource
```
POST /address

{
    "addressText": "Chandigarh"
}

```

## Get a address resource
```
Get /address

{
    "addressText": "Chandigarh"
},

{
    "addressText": "Amritsar"
}

```