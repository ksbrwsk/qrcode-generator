FROM adoptopenjdk:15-jre-hotspot
MAINTAINER kai.saborowski@googlemail.com

EXPOSE 8080
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD target/qrcode-generator-1.0.8-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]