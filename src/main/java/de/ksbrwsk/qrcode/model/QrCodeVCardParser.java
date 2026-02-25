package de.ksbrwsk.qrcode.model;

import org.apache.commons.lang3.StringUtils;

/**
 * Parser that formats a {@link QrCodeVCard} into a vCard 4.0 payload string for ZXing.
 * <p>
 * Only non-empty optional fields are included in the output.
 */
public class QrCodeVCardParser extends AbstractQrCodeParser {

    private final QrCodeVCard qrCodeVCard;

    /**
     * Creates a new parser for the given vCard model.
     *
     * @param qrCodeVCard the vCard model to parse
     */
    public QrCodeVCardParser(QrCodeVCard qrCodeVCard) {
        this.qrCodeVCard = qrCodeVCard;
    }

    /**
     * Formats the vCard data into a vCard 4.0 payload string.
     *
     * @return the formatted vCard payload string
     */
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

        if (StringUtils.isNotEmpty(this.qrCodeVCard.getTitle())) {
            builder.append("TITLE:");
            builder.append(this.qrCodeVCard.getTitle());
            builder.append("\n");
        }
        if (StringUtils.isNotEmpty(this.qrCodeVCard.getOrganisation())) {
            builder.append("ORG:");
            builder.append(this.qrCodeVCard.getOrganisation());
            builder.append("\n");
        }
        if (StringUtils.isNotEmpty(this.qrCodeVCard.getEmail1())) {
            builder.append("EMAIL:")
                    .append(this.qrCodeVCard.getEmail1())
                    .append("\n");
        }
        if (StringUtils.isNotEmpty(this.qrCodeVCard.getEmail2())) {
            builder.append("EMAIL:")
                    .append(this.qrCodeVCard.getEmail2())
                    .append("\n");
        }
        if (StringUtils.isNotEmpty(this.qrCodeVCard.getPhone1())) {
            builder.append("TEL;TYPE=")
                    .append(this.qrCodeVCard.getPhone1Type())
                    .append(":")
                    .append(this.qrCodeVCard.getPhone1())
                    .append("\n");
        }
        if (StringUtils.isNotEmpty(this.qrCodeVCard.getAdress1Street())) {
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
