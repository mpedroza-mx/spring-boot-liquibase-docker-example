FROM openjdk:8-jre-alpine

MAINTAINER Marco Pedroza

WORKDIR /app

COPY zipkin-server.jar /app/

ENTRYPOINT ["java", "-jar", "zipkin-server.jar"]