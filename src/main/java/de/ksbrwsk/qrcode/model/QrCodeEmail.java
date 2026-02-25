package de.ksbrwsk.qrcode.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * Model for an email QR code.
 * <p>
 * Encoded payload formats:
 * <ul>
 *   <li>{@code mailto:someone@yoursite.com}</li>
 *   <li>{@code mailto:someone@yoursite.com?subject=Mail%20from%20Our%20Site}</li>
 * </ul>
 */
@Getter
@Setter
@Validated
public class QrCodeEmail {

    @NotEmpty
    @Email
    private String email = "";

    private String subject = "";

    public QrCodeEmail() {
    }

    /**
     * Creates a new instance with the given email address.
     *
     * @param emailToBeEncoded the email address to encode
     */
    public QrCodeEmail(@NotEmpty String emailToBeEncoded) {
        this.email = emailToBeEncoded;
    }

    /**
     * Creates a new instance with the given email address and subject.
     *
     * @param emailToBeEncoded   the email address to encode
     * @param subjectToBeEncoded the email subject to encode
     */
    public QrCodeEmail(String emailToBeEncoded, String subjectToBeEncoded) {
        this.email = emailToBeEncoded;
        this.subject = subjectToBeEncoded;
    }

}
