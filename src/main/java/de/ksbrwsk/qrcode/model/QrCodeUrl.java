package de.ksbrwsk.qrcode.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * Format: http://google.de
 */
@Getter
@Setter
@Validated
public class QrCodeUrl {

    @NotEmpty
    private String urlToBeEncoded;

    public QrCodeUrl() {
    }

    public QrCodeUrl(String urlToBeEncoded) {
        this.urlToBeEncoded = urlToBeEncoded;
    }
}
