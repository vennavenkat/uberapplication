# Use a base image with Java
FROM openjdk:21-jre-slim

# Set the working directory
WORKDIR /app

# Copy the Maven-built JAR file into the container
COPY target/uberApp-1.jar app.jar

# Expose the port your application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]