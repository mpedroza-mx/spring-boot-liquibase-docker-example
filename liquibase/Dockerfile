FROM alpine:latest

RUN mkdir -p /usr/local/src/liquibaseBinary
COPY liquibaseBinary /usr/local/src/liquibaseBinary
WORKDIR /usr/local/src/liquibaseBinary/

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
#ENTRYPOINT ["sh","-c","java -cp \".:/usr/local/src/liquibaseBinary/liquibase.jar:/usr/local/src/liquibaseBinary/lib/commons-cli-1.4.jar:/usr/local/src/liquibaseBinary/lib/h2-1.4.200.jar:/usr/local/src/liquibaseBinary/lib/jaxb-api-2.3.0.jar:/usr/local/src/liquibaseBinary/lib/jaxb-core-2.3.0.jar:/usr/local/src/liquibaseBinary/lib/jaxb-impl-2.3.0.jar:/usr/local/src/liquibaseBinary/lib/logback-classic-1.2.3.jar:/usr/local/src/liquibaseBinary/lib/logback-core-1.2.3.jar:/usr/local/src/liquibaseBinary/lib/mysql-connector-java-8.0.19.jar:/usr/local/src/liquibaseBinary/lib/slf4j-api-1.7.28.jar:/usr/local/src/liquibaseBinary/lib/snakeyaml-1.24.jar:/usr/local/src/liquibaseBinary/lib\" liquibase.integration.commandline.Main --verbose=true --driver=com.mysql.cj.jdbc.Driver --changeLogFile=medical-consultory/liquibase-outputChangeLog.xml --url=${DB_URL} --username=${DB_USER} --password=${DB_PASSWORD} --logLevel=debug update"]

