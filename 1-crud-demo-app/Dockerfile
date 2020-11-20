FROM openjdk:8-jdk-alpine

LABEL maintainer="sinookala"

COPY target/crud-demo-app-1.0-SNAPSHOT.jar app/app.jar

RUN addgroup -S spring && adduser -S spring -G spring

USER spring:spring

WORKDIR /app

#CMD java $JAVA_OPTS -jar /app/app.jar

ENTRYPOINT ["java","-jar", "app.jar"]