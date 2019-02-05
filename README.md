# A simple Spring Boot application generating QR Codes.

Features
--------

A simple [Spring Boot](http://projects.spring.io/spring-boot/) standalone application generating QR Codes based on
[ZXing ("Zebra Crossing")](https://github.com/zxing/zxing/) barcode scanning library.

Build & run 
-----------

**Prerequisites:**

* Java 8
* Apache Maven (https://maven.apache.org/)

Application properties can be configured in

```
qr-code-generator/src/main/resources
```

Use

```
mvn clean install
```
to build the application and

```
java -jar target/qrcode-generator-1.0.0-SNAPSHOT.jar
```

or 

```
mvn spring-boot:run
```

to run it on your development machine.

Point your browser to 

```
http://localhost:8080
```


