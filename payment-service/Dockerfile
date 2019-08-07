FROM openjdk:11.0.3-jdk-stretch
ADD ./target/userpackage-0.0.1-SNAPSHOT.jar /app/user/userpackage-0.0.1-SNAPSHOT.jar
WORKDIR /app/user
ENTRYPOINT ["java","-jar","userpackage-0.0.1-SNAPSHOT.jar"]

