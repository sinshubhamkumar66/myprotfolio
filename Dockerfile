# ✅ Java 21 (LTS)
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy Maven wrapper and config
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (cached layer)
RUN ./mvnw dependency:go-offline

# Copy source and build
COPY src src
RUN ./mvnw clean package -DskipTests

# Expose port used by Render
EXPOSE 8080

# Run Spring Boot app
CMD ["java", "-jar", "target/*.jar"]
