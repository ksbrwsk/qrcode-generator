# A simple Spring Boot application generating QR Codes.

Features
--------

A simple [Spring Boot](http://projects.spring.io/spring-boot/) standalone application generating QR Codes based on
[ZXing ("Zebra Crossing")](https://github.com/zxing/zxing/) barcode scanning library.

Build & run 
-----------

**Prerequisites:**

* Java 14
* Apache Maven (https://maven.apache.org/)

Application properties can be configured in

```bash
qr-code-generator/src/main/resources
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


