FROM openjdk:11-jre-slim

MAINTAINER Alex Bondor

WORKDIR /backend/api

COPY backend/api/target/seaplol.jar /backend/api/

ENTRYPOINT ["java", "-jar", "seaplol.jar"]