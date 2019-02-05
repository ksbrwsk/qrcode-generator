package de.ksbrwsk.qrcode.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * BEGIN:VCARD
 * VERSION:3.0
 * N:Gump;Forrest;;Mr.;
 * FN:Forrest Gump
 * ORG:Bubba Gump Shrimp Co.
 * TITLE:Shrimp Man
 * PHOTO;MEDIATYPE=image/gif:http://www.example.com/dir_photos/my_photo.gif
 * TEL;TYPE=work,voice;VALUE=uri:tel:+1-111-555-1212
 * TEL;TYPE=home,voice;VALUE=uri:tel:+1-404-555-1212
 * ADR;TYPE=WORK;PREF=1;LABEL="100 Waters Edge\nBaytown\, LA 30314\nUnited States of America":;;100 Waters Edge;Baytown;LA;30314;United States of America
 * ADR;TYPE=HOME;LABEL="42 Plantation St.\nBaytown\, LA 30314\nUnited States of America":;;42 Plantation St.;Baytown;LA;30314;United States of America
 * EMAIL:forrestgump@example.com
 * REV:20080424T195243Z
 * x-qq:21588891
 * END:VCARD
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
