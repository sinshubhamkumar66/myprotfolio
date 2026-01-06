# Java 21
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy Maven wrapper and configs
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (cache layer)
RUN ./mvnw dependency:go-offline

# Copy source and build
COPY src src
RUN ./mvnw clean package -DskipTests

# Expose Render port
EXPOSE 8080

# ✅ IMPORTANT: Use EXACT jar name
CMD ["java", "-jar", "target/myprotofolio-0.0.1-SNAPSHOT.jar"]
