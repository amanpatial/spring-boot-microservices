## 'Microservices' spring boot project
Micro services architecture with Spring Boot 2.0 application - API Gateway, User services, Eureka registration and Discover, Spring OAuth 2.0 as Auth Server, Multiple Resource (Web Services) Servers, and Hystrix for circuit breaker

### Pre-requisites and build steps
```
Make sure that your operating system had JDK 1.8 and Maven 3.x installed
java -version
mvn -v
chmod +x ./install.sh ( only for linux instances, in case java and maven are not installed) 
clone the code repository
cd /go/to/project/code/root/directory
mvn clean install
mvn clean install -DskipTests -Dpmd.skip=true  (optional to avoid the test package building)
java -jar ./target/user-service-0.0.1-SNAPSHOT.jar --spring.config.location=./src/main/resources/application.properties
```
