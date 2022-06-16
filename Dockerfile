FROM openjdk:8-jdk-alpine
MAINTAINER Balamurugan
COPY target/telgatechcrud-0.0.1-SNAPSHOT.jar telgatechcrud-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/telgatechcrud-0.0.1-SNAPSHOT.jar"]