FROM openjdk:8-jre-alpine
VOLUME C:/Users/felip/git/frezze/frezze/target /tmp
COPY demo-0.0.1-SNAPSHOT.jar frezze-app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/frezze-app.jar"]