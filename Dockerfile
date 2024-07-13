FROM eclipse-temurin:21-alpine
MAINTAINER kai.saborowski@googlemail.com

EXPOSE 8080
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD target/qrcode-generator-1.5.0.jar /app/app.jar
ENTRYPOINT ["java","-Xms768M", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]