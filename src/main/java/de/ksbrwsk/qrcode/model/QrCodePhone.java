package de.ksbrwsk.qrcode.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * Model for a phone-number QR code.
 * <p>
 * Encoded payload format: {@code tel:+12125551212}
 */
@Getter
@Setter
@Validated
public class QrCodePhone {

    @NotEmpty
    private String phone;

    public QrCodePhone() {
    }

    /**
     * Creates a new instance with the given phone number.
     *
     * @param phoneToBeEncoded the phone number to encode
     */
    public QrCodePhone(String phoneToBeEncoded) {
        this.phone = phoneToBeEncoded;
    }
}
