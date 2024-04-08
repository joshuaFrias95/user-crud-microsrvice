FROM maven:3.9-eclipse-temurin-17-alpine as build

WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app
COPY --from=build /app/target/read-service.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/read-service.jar"]