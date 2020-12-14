package de.ksbrwsk.qrcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QrCodeUrlParserTests {

    @Test
    public void thatParseUrlPasses() {
        String expected = "http://www.google.de";
        QrCodeUrl qrCodeUrl = new QrCodeUrl("http://www.google.de");
        assertEquals(expected, new QrCodeUrlParser(qrCodeUrl).parse());
    }

    @Test
    public void thatParseUrlWithBlanksPasses() {
        String expected = "http://www.google.de?value=My%20Site";
        QrCodeUrl qrCodeUrl = new QrCodeUrl("http://www.google.de?value=My%20Site");
        assertEquals(expected, new QrCodeUrlParser(qrCodeUrl).parse());
    }
}