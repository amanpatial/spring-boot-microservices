#Spring boot build steps

cd /go/to/project/root/directory

mvn clean install

mvn clean install  -DskipTests -Dpmd.skip=true

java -jar ./target/user-service-0.0.1-SNAPSHOT.jar  --spring.config.location=./src/main/resources/application.properties

#To see existing JAVA processes running  

ps aux | grep java
