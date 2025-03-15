package de.ksbrwsk.qrcode.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.springframework.validation.annotation.Validated;

/**
 * Format: http://google.de
 */
@Getter
@Setter
@Validated
public class QrCodeUrl {

    @NotEmpty
    @URL
    private String url;

    public QrCodeUrl() {
    }

    public QrCodeUrl(String urlToBeEncoded) {
        this.url = urlToBeEncoded;
    }
}
