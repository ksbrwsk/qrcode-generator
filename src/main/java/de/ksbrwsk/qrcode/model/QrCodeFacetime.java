package de.ksbrwsk.qrcode.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * Model for a FaceTime QR code.
 * <p>
 * Encoded payload format: {@code facetime://+12125551212}
 */
@Getter
@Setter
@Validated
public class QrCodeFacetime {

    @NotEmpty
    private String facetime;

    public QrCodeFacetime() {
    }

    /**
     * Creates a new instance with the given FaceTime address or phone number.
     *
     * @param facetime the FaceTime address or phone number to encode
     */
    public QrCodeFacetime(String facetime) {
        this.facetime = facetime;
    }
}
