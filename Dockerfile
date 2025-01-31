FROM eclipse-temurin:17.0.13_11-jre-jammy
WORKDIR /app
COPY /build/libs/weather-service-0.0.1-SNAPSHOT.jar /app/weather-api.jar

WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "weather-api.jar"]