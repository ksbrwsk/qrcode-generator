package de.ksbrwsk.qrcode.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Validated
public class QrCodeSms {

    @NotEmpty
    private String phoneToBeEncoded = "";

    private String messageToBeEncoded = "";

    public QrCodeSms() {
    }

    public QrCodeSms(@NotEmpty String phoneToBeEncoded) {
        this.phoneToBeEncoded = phoneToBeEncoded;
    }

    public QrCodeSms(String phoneToBeEncoded, String messageToBeEncoded) {
        this.phoneToBeEncoded = phoneToBeEncoded;
        this.messageToBeEncoded = messageToBeEncoded;
    }
}
