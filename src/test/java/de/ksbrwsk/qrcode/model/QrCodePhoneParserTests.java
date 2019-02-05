package de.ksbrwsk.qrcode.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class QrCodePhoneParserTests {

    @Test
    public void thatParsePhonePasses() {
        String expected = "tel:+495551234567";
        QrCodePhone qrCodePhone = new QrCodePhone("+495551234567");
        assertEquals(expected, new QrCodePhoneParser(qrCodePhone).parse());
    }
}