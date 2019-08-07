FROM openjdk:11.0.3-jdk-stretch
ADD ./target/episodic-media-service-0.0.1-SNAPSHOT.jar /app/user/episodic-media-service-0.0.1-SNAPSHOT.jar
ADD  ./src/main/resources/episodic.csv /app/user/src/main/resources/episodic.csv
WORKDIR /app/user
ENTRYPOINT ["java","-jar","episodic-media-service-0.0.1-SNAPSHOT.jar"]