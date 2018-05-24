#Spring boot build steps

#Pre-requisites  

Java 1.8   to see run java --version

Maven 3.5.x  to see version run mvn -v

cd /go/to/project/root/directory

mvn clean install

mvn clean install  -DskipTests -Dpmd.skip=true

java -jar ./target/user-service-0.0.1-SNAPSHOT.jar  --spring.config.location=./src/main/resources/application.properties

#To see existing JAVA processes running  

ps aux | grep java
