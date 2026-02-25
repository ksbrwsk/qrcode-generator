package de.ksbrwsk.qrcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot application entry point for the QR Code Generator.
 */
@SpringBootApplication
public class QrCodeApplication {

    /**
     * Starts the Spring Boot application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(QrCodeApplication.class, args);
    }
}
