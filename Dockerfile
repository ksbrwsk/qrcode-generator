FROM eclipse-temurin:21-alpine
MAINTAINER kai.saborowski@googlemail.com

EXPOSE 8080
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD target/qrcode-generator-2.0.0-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-Xms768M", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=ssl",  "-jar", "/app/app.jar"]