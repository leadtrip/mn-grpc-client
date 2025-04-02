FROM openjdk:21-slim

COPY build/libs/*-all.jar /app/mn-grpc-client.jar

CMD ["java", "-jar", "/app/mn-grpc-client.jar"]