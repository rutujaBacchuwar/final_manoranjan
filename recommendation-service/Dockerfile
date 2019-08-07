FROM openjdk:11.0.3-jdk-slim-stretch
ADD ./target/recommendationService-1.0-SNAPSHOT.jar /app/recommendationService-1.0-SNAPSHOT.jar
WORKDIR app/
ENTRYPOINT ["java","-jar","recommendationService-1.0-SNAPSHOT.jar"]