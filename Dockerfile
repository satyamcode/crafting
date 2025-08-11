# Stage 1: The Build Stage
# We use a Maven image to build the application and create the JAR file.
FROM maven:3.8.5-openjdk-17 AS builder

# Set the working directory
WORKDIR /app

# Copy the Maven wrapper and pom.xml to leverage Docker layer caching.
# This ensures that dependencies are only re-downloaded if pom.xml changes.
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Download all the project dependencies
RUN ./mvnw dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Build the application, skipping the tests for a faster build
RUN ./mvnw clean package -DskipTests


# Stage 2: The Final Image Stage
# We use a lightweight OpenJDK image to run the application.
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the 'builder' stage into the final image.
COPY --from=builder /app/target/*.jar app.jar

# Expose port 8080. Render will connect to this port.
EXPOSE 8080

# The command to run when the container starts.
ENTRYPOINT ["java","-jar","app.jar"]
