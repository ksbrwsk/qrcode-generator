package de.ksbrwsk.qrcode.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QrCodeProcessingResult {
    private String image;
    private String encodedText;
    private String successMessage;
    private String errorMessage;

    public boolean isSuccessfull() {
        return successMessage != null;
    }
}
