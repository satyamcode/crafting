# Use an official OpenJDK 17 runtime as a parent image.
# This ensures a lightweight and secure base for our application.
FROM openjdk:17-jdk-slim

# Set the working directory inside the container to /app.
# All subsequent commands will be run from this directory.
WORKDIR /app

# Copy the executable JAR file from the 'target' directory on your machine
# into the container's /app directory and rename it to app.jar.
# The JAR file is created by the 'mvn clean package' command.
COPY target/*.jar app.jar

# Expose port 8080. This tells Docker that the container will listen on
# this port at runtime. Spring Boot uses port 8080 by default.
EXPOSE 8080

# The command to run when the container starts.
# This executes the Spring Boot application.
ENTRYPOINT ["java","-jar","app.jar"]
