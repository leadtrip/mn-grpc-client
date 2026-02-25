FROM amazoncorretto:25-jdk

COPY build/libs/*-all.jar /app/mn-grpc-client.jar

CMD ["java", "-jar", "/app/mn-grpc-client.jar"]