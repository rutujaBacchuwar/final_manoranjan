FROM openjdk:11.0.3-jdk-stretch
ADD ./target/standalone-media-service-0.0.1-SNAPSHOT.jar /app/user/standalone-media-service-0.0.1-SNAPSHOT.jar
ADD  ./src/main/resources/standalone.csv /app/user/src/main/resources/standalone.csv
WORKDIR /root
RUN mkdir uploads
WORKDIR /app/user
ENTRYPOINT ["java","-jar"   ,"standalone-media-service-0.0.1-SNAPSHOT.jar"]



