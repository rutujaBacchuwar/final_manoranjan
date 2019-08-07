FROM openjdk:11.0.3-jdk-stretch

ADD ./target/zuul-api-0.0.1-SNAPSHOT.jar /usr/src/zuul-api-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "zuul-api-0.0.1-SNAPSHOT.jar"]