FROM openjdk:8u201-jdk-alpine3.9
ADD target/crm-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD java -XX:+UseSerialGC -Xss512k -XX:MaxRAM=72m -jar crm-0.0.1-SNAPSHOT.jar --server.port=$PORT