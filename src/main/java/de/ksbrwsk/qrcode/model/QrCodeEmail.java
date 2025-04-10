package de.ksbrwsk.qrcode.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * # Address
 * mailto:someone@yoursite.com
 * <p>
 * # Address, subject
 * mailto:someone@yoursite.com?subject=Mail%20from%20Our%20Site
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

    public QrCodeEmail(@NotEmpty String emailToBeEncoded) {
        this.email = emailToBeEncoded;
    }

    public QrCodeEmail(String emailToBeEncoded, String subjectToBeEncoded) {
        this.email = emailToBeEncoded;
        this.subject = subjectToBeEncoded;
    }

}
