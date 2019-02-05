package de.ksbrwsk.qrcode.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
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