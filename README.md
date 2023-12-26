# A simple Spring Boot application generating QR Codes.

Features
--------

A simple [Spring Boot](http://projects.spring.io/spring-boot/) standalone application generating QR Codes based on
[ZXing ("Zebra Crossing")](https://github.com/zxing/zxing/) barcode scanning library.

see [live demo](https://ksbrwsk.de:9080/) on my website.

Build & run 
-----------

**Prerequisites:**

* Java 21
* Apache Maven (https://maven.apache.org/)

Application properties can be configured in

```bash
qrcode-generator/src/main/resources/application.properties
```

Use

```bash
mvn clean install
```
to build the application and

```bash
java -jar target/qrcode-generator-1.0.0-SNAPSHOT.jar
```

or 

```bash
mvn spring-boot:run
```

to run it on your development machine.

Point your browser to 

```bash
http://localhost:8080
```

docker build -t . qrcode-generator
docker run -d --name qrcode-generator -p 9080:8080 qrcode-generator


