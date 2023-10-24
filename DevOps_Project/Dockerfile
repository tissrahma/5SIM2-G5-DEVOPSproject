# Utilisez l'image OpenJDK 11 depuis Docker Hub
FROM openjdk:11

# Exposez le port sur lequel votre application Spring Boot écoute (ajoutez le port correct)
EXPOSE 8082

# Copiez le fichier JAR de votre projet dans l'image Docker
ADD target/DevOps_Project-2.1.jar /app/DevOps_Project-2.1.jar

# Commande d'entrée pour exécuter l'application Spring Boot
ENTRYPOINT ["java", "-jar", "/app/DevOps_Project-2.1.jar"]
