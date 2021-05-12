package de.ksbrwsk.qrcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QrCodePhoneParserTests {

    @Test
    public void thatParsePhonePasses() {
        String expected = "tel:+495551234567";
        QrCodePhone qrCodePhone = new QrCodePhone("+495551234567");
        assertEquals(expected, new QrCodePhoneParser(qrCodePhone).parse());
    }
}