package de.ksbrwsk.qrcode.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * Model for a vCard contact QR code (vCard 4.0).
 * <p>
 * Only {@code name} and {@code lastname} are required; all other fields are optional.
 * Encoded payload example:
 * <pre>
 * BEGIN:VCARD
 * VERSION:3.0
 * N:Gump;Forrest;;Mr.;
 * FN:Forrest Gump
 * ORG:Bubba Gump Shrimp Co.
 * TITLE:Shrimp Man
 * TEL;TYPE=work,voice;VALUE=uri:tel:+1-111-555-1212
 * ADR;TYPE=WORK;PREF=1;LABEL="...":;;100 Waters Edge;Baytown;LA;30314;United States of America
 * EMAIL:forrestgump@example.com
 * END:VCARD
 * </pre>
 */
@Getter
@Setter
@Validated
public class QrCodeVCard {

    @NotEmpty
    private String name;

    @NotEmpty
    private String lastname;
    private String organisation;
    private String title;
    private String phone1;
    private QrCodeEnumType phone1Type = QrCodeEnumType.WORK;

    private String adress1Street;
    private String adress1Locality;
    private String adress1Region;
    private String adress1PostalCode;
    private String adress1Country;
    private QrCodeEnumType adress1Type = QrCodeEnumType.WORK;

    private String email1;
    private String email2;
}
