package de.ksbrwsk.qrcode.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.springframework.validation.annotation.Validated;

/**
 * Model for a URL QR code.
 * <p>
 * The URL is validated as non-empty and must be a well-formed HTTP/HTTPS URL.
 * Encoded payload format: {@code http://example.com}
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

    /**
     * Creates a new instance with the given URL.
     *
     * @param urlToBeEncoded the URL to encode
     */
    public QrCodeUrl(String urlToBeEncoded) {
        this.url = urlToBeEncoded;
    }
}
