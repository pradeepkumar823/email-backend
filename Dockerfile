FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/Email-App-0.0.1-SNAPSHOT.jar app.jar
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT}"]
