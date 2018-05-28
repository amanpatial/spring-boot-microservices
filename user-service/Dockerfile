FROM openjdk:8
ADD target/user-service-0.0.1-SNAPSHOT.jar user-service.jar
EXPOSE 8080
ENTRYPOINT ["java -jar ./target/user-service-0.0.1-SNAPSHOT.jar --spring.config.location=./src/main/resources/application.properties" ]
