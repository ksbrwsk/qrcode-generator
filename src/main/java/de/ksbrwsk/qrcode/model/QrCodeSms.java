package de.ksbrwsk.qrcode.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * Model for an SMS QR code.
 * <p>
 * Encoded payload formats:
 * <ul>
 *   <li>{@code sms:+12125551212}</li>
 *   <li>{@code sms:+12125551212?sms_body=Hello%20World}</li>
 * </ul>
 */
@Getter
@Setter
@Validated
public class QrCodeSms {

    @NotEmpty
    private String phone = "";

    private String messageToBeEncoded = "";

    public QrCodeSms() {
    }

    /**
     * Creates a new instance with the given phone number.
     *
     * @param phone the recipient phone number to encode
     */
    public QrCodeSms(@NotEmpty String phone) {
        this.phone = phone;
    }

    /**
     * Creates a new instance with a phone number and message body.
     *
     * @param phone               the recipient phone number to encode
     * @param messageToBeEncoded  the SMS message body to encode
     */
    public QrCodeSms(String phone, String messageToBeEncoded) {
        this.phone = phone;
        this.messageToBeEncoded = messageToBeEncoded;
    }
}
