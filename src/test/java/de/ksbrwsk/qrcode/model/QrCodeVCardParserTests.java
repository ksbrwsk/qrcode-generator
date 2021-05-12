package de.ksbrwsk.qrcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QrCodeVCardParserTests {

    @Test
    public void thatParseVCardCanPasses() {
        String expected = "BEGIN:VCARD\n" +
                "VERSION:4.0\n" +
                "N:Norris;Chuck;;;\n" +
                "FN:Chuck Norris\n" +
                "TITLE:Mr. Roundhousekick\n" +
                "END:VCARD";
        QrCodeVCard qrCodeVCard = new QrCodeVCard();
        qrCodeVCard.setName("Chuck");
        qrCodeVCard.setLastname("Norris");
        qrCodeVCard.setTitle("Mr. Roundhousekick");
        String actual = new QrCodeVCardParser(qrCodeVCard).parse();
        assertEquals(expected, actual);
    }
}