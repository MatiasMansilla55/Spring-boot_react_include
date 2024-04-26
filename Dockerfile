FROM eclipse-temurin:21-jdk-alpine
        WORKDIR /app
        COPY target/libros-0.0.1-SNAPSHOT.jar libros-0.0.1-SNAPSHOT.jar
        EXPOSE 8080
        CMD ["java", "-jar","libros-0.0.1-SNAPSHOT.jar"]