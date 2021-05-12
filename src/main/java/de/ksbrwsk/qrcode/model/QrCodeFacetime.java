package de.ksbrwsk.qrcode.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

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
