package de.ksbrwsk.qrcode.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * # Address
 * mailto:someone@yoursite.com
 *
 * # Address, subject
 * mailto:someone@yoursite.com?subject=Mail%20from%20Our%20Site
 */
@Getter
@Setter
@Validated
public class QrCodeEmail {

    @NotEmpty
    private String emailToBeEncoded = "";

    private String subjectToBeEncoded = "";

    public QrCodeEmail() {
    }

    public QrCodeEmail(@NotEmpty String emailToBeEncoded) {
        this.emailToBeEncoded = emailToBeEncoded;
    }

    public QrCodeEmail(String emailToBeEncoded, String subjectToBeEncoded) {
        this.emailToBeEncoded = emailToBeEncoded;
        this.subjectToBeEncoded = subjectToBeEncoded;
    }

}
