package de.ksbrwsk.qrcode.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class QrCodeSms {

    @NotEmpty
    private String phone = "";

    private String messageToBeEncoded = "";

    public QrCodeSms() {
    }

    public QrCodeSms(@NotEmpty String phone) {
        this.phone = phone;
    }

    public QrCodeSms(String phone, String messageToBeEncoded) {
        this.phone = phone;
        this.messageToBeEncoded = messageToBeEncoded;
    }
}
