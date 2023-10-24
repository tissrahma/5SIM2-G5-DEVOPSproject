# Use the OpenJDK 11 image from Docker Hub
FROM openjdk:11

# Expose the port on which your Spring Boot application is listening (make sure to use the correct port)
EXPOSE 8082

# Copy the JAR file from the project's target directory to the Docker image
ADD target/DevOps_Project-2.1.jar DevOps_Project-2.1.jar

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "DevOps_Project-2.1.jar"]
