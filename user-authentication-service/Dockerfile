FROM openjdk:11.0.3-jdk-stretch
ADD ./target/UserAuthentication-0.0.1-SNAPSHOT.jar /app/userauth/UserAuthentication-0.0.1-SNAPSHOT.jar
WORKDIR /app/userauth
ENTRYPOINT ["java","-jar","UserAuthentication-0.0.1-SNAPSHOT.jar"]