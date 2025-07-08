# Stage 1: Build with Maven and Java 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the app in a smaller Java 21 image
FROM eclipse-temurin:21-jdk-jammy
COPY --from=build /target/ChattingApp-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
