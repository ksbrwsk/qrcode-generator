package de.ksbrwsk.qrcode.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
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