package de.ksbrwsk.qrcode.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * Form:
 * <p>
 * facetime://+12125551212
 */
@Getter
@Setter
@Validated
public class QrCodeFacetime {

    @NotEmpty
    private String facetimeToBeEncoded;

    public QrCodeFacetime() {
    }

    public QrCodeFacetime(String facetimeToBeEncoded) {
        this.facetimeToBeEncoded = facetimeToBeEncoded;
    }
}
