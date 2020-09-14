FROM openjdk:11-jre-slim

MAINTAINER Alex Bondor

WORKDIR /app

COPY app/target/seaplol.jar /app/

ENTRYPOINT ["java", "-jar", "seaplol.jar"]