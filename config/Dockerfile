FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD


MAINTAINER Marco Pedroza

COPY pom.xml /build/
COPY src /build/src/


WORKDIR /build/
RUN mvn  clean package -DskipTests

FROM alpine:latest
# Add dockerize tool -------------------
RUN apk add --no-cache openssl
ENV DOCKERIZE_VERSION v0.6.1
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz

RUN apk update
RUN apk fetch openjdk8
RUN apk add openjdk8
ENV JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk
ENV PATH="$JAVA_HOME/bin:${PATH}"


WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/config-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8081 8081
#ENTRYPOINT ["java", "-jar", "config-0.0.1-SNAPSHOT.jar"]




