FROM openjdk:8-jre-alpine
VOLUME C:/Users/felip/git/frezze/frezze/target /tmp
COPY frezze-0.0.1-SNAPSHOT.jar api-frezze.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/api-frezze.jar"]