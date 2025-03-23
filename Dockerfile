FROM openjdk:21
ARG JAR_FILE=target/*.jar
COPY e-commerce/target/e-commerce-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]