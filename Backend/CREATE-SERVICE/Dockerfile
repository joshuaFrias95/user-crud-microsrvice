FROM maven:3.9-eclipse-temurin-17-alpine as build

WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app
COPY --from=build /app/target/create-service.jar .

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app/create-service.jar"]