FROM maven:3.6.3-openjdk-14-slim AS build
COPY backend /app
RUN mvn -f /app/pom.xml clean package -DskipTests

FROM openjdk:11-jre-slim
MAINTAINER Alex Bondor
WORKDIR /backend/api
COPY --from=build  /app/api/target/seaplol.jar /backend/api/
ENTRYPOINT ["java", "-jar", "seaplol.jar"]
