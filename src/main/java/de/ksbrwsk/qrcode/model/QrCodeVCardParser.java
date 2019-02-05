package de.ksbrwsk.qrcode.model;

import org.apache.commons.lang3.StringUtils;

/**
 * BEGIN:VCARD
 * VERSION:4.0
 * N:Gump;Forrest;;Mr.;
 * FN:Forrest Gump
 * ORG:Bubba Gump Shrimp Co.
 * TITLE:Shrimp Man
 * TEL;TYPE=work,voice;VALUE=uri:tel:+1-111-555-1212
 * TEL;TYPE=home,voice;VALUE=uri:tel:+1-404-555-1212
 * ADR;TYPE=WORK;PREF=1;LABEL="100 Waters Edge\nBaytown\, LA 30314\nUnited States of America":;;100 Waters Edge;Baytown;LA;30314;United States of America
 * ADR;TYPE=HOME;LABEL="42 Plantation St.\nBaytown\, LA 30314\nUnited States of America":;;42 Plantation St.;Baytown;LA;30314;United States of America
 * EMAIL:forrestgump@example.com
 * REV:20080424T195243Z
 * x-qq:21588891
 * END:VCARD
 */
public class QrCodeVCardParser extends AbstractQrCodeParser {

    private final QrCodeVCard qrCodeVCard;

    public QrCodeVCardParser(QrCodeVCard qrCodeVCard) {
        this.qrCodeVCard = qrCodeVCard;
    }

    @Override
    public String parse() {
        StringBuilder builder = new StringBuilder("BEGIN:VCARD\n")
                .append("VERSION:4.0\n")
                .append("N:")
                .append(this.qrCodeVCard.getLastname())
                .append(";")
                .append(this.qrCodeVCard.getName())
                .append(";;;\n")
                .append("FN:")
                .append(this.qrCodeVCard.getName())
                .append(" ")
                .append(this.qrCodeVCard.getLastname())
                .append("\n");

                if(StringUtils.isNotEmpty(this.qrCodeVCard.getTitle())) {
                    builder.append("TITLE:");
                    builder.append(this.qrCodeVCard.getTitle());
                    builder.append("\n");
                }
                if(StringUtils.isNotEmpty(this.qrCodeVCard.getOrganisation())) {
                    builder.append("ORG:");
                    builder.append(this.qrCodeVCard.getOrganisation());
                    builder.append("\n");
                }
                if(StringUtils.isNotEmpty(this.qrCodeVCard.getEmail1())) {
                    builder.append("EMAIL:")
                            .append(this.qrCodeVCard.getEmail1())
                            .append("\n");
                }
                if(StringUtils.isNotEmpty(this.qrCodeVCard.getEmail2())) {
                    builder.append("EMAIL:")
                            .append(this.qrCodeVCard.getEmail2())
                            .append("\n");
                }
                if(StringUtils.isNotEmpty(this.qrCodeVCard.getPhone1())) {
                    builder.append("TEL;TYPE=")
                            .append(this.qrCodeVCard.getPhone1Type())
                            .append(":")
                            .append(this.qrCodeVCard.getPhone1())
                            .append("\n");
                }
                if(StringUtils.isNotEmpty(this.qrCodeVCard.getAdress1Street())) {
                    builder.append("ADR;TYPE=")
                        .append(this.qrCodeVCard.getAdress1Type())
                        .append(":;;")
                        .append(this.qrCodeVCard.getAdress1Street())
                        .append(";")
                        .append(this.qrCodeVCard.getAdress1Locality())
                        .append(";")
                        .append(this.qrCodeVCard.getAdress1Region())
                        .append(";")
                        .append(this.qrCodeVCard.getAdress1PostalCode())
                        .append(";")
                        .append(this.qrCodeVCard.getAdress1Country())
                        .append("\n")
                        .append("LABEL;TYPE=")
                        .append(this.qrCodeVCard.getAdress1Type())
                        .append(":")
                        .append(this.qrCodeVCard.getAdress1Street())
                        .append("\n")
                        .append(this.qrCodeVCard.getAdress1Locality())
                        .append(",")
                        .append(this.qrCodeVCard.getAdress1Region())
                        .append(" ")
                        .append(this.qrCodeVCard.getAdress1PostalCode())
                        .append("\n")
                        .append(this.qrCodeVCard.getAdress1Country())
                        .append("\n");
                }
        builder.append("END:VCARD");
        return builder.toString();
    }
}
