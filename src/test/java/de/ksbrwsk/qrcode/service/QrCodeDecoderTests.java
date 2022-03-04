package de.ksbrwsk.qrcode.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class QrCodeDecoderTests {

    @Autowired
    QrCodeDecoder qrCodeDecoder;

    @Test
    public void thatDecodingQrCodeEmailPasses() throws Exception {
        String expected = "mailto:email@email.com?subject=just%20a%20test";
        ClassPathResource resource = new ClassPathResource("decodeQrCodeEmailAndSubject.png");
        File qrCodeFile = resource.getFile();
        String actual = this.qrCodeDecoder.decodeQrCodeFile(qrCodeFile);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }
    @Test
    public void thatDecodingQrCodeEventPasses() throws Exception {
        String expected = "BEGIN:VCALENDAR\nBEGIN:VEVENT\nSUMMARY:Stammtisch\nDTSTART;TZID=Europe/Berlin;VALUE=DATE-TIME:20220304T123000\nDTEND;TZID=Europe/London;VALUE=DATE-TIME:20220304T163000\nLOCATION:Miro\nEND:VEVENT\nEND:VCALENDAR";
        ClassPathResource resource = new ClassPathResource("decodeQrCodeEvent.png");
        File qrCodeFile = resource.getFile();
        String actual = this.qrCodeDecoder.decodeQrCodeFile(qrCodeFile);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }



    @Test
    public void thatDecodingQrCodePhonePasses() throws Exception {
        String expected = "tel:+15551234567";
        ClassPathResource resource = new ClassPathResource("decodeQrCodePhone.png");
        File qrCodeFile = resource.getFile();
        String actual = this.qrCodeDecoder.decodeQrCodeFile(qrCodeFile);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void thatDecodingQrCodeUrlPasses() throws Exception {
        String expected = "http://www.google.com";
        ClassPathResource resource = new ClassPathResource("decodeQrCodeUrl.png");
        File qrCodeFile = resource.getFile();
        String actual = this.qrCodeDecoder.decodeQrCodeFile(qrCodeFile);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void thatDecodingQrCodeVCardPasses() throws Exception {
        String expected = "BEGIN:VCARD\n" +
                "VERSION:4.0\n" +
                "N:Norris;Chuck;;;\n" +
                "FN:Chuck Norris\n" +
                "TITLE:Mr. Roundhousekick\n" +
                "ORG:My Organisation\n" +
                "END:VCARD";
        ClassPathResource resource = new ClassPathResource("decodeQrCodeVCard.png");
        File qrCodeFile = resource.getFile();
        String actual = this.qrCodeDecoder.decodeQrCodeFile(qrCodeFile);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void thatDecodingQrCodeVCardCompletePasses() throws Exception {
        String expected = "BEGIN:VCARD\n" +
                "VERSION:4.0\n" +
                "N:Norris;Chuck;;;\n" +
                "FN:Chuck Norris\n" +
                "TITLE:Mr. Roundhousekick\n" +
                "ORG:My Organisation\n" +
                "EMAIL:chuck@norris.com\n" +
                "EMAIL:chuck@gmail.com\n" +
                "TEL;TYPE=WORK:+15551234567\n" +
                "ADR;TYPE=HOME:;;42 Plantation St.;Baytown;LA;30314;USA\n" +
                "LABEL;TYPE=HOME:42 Plantation St.\n" +
                "Baytown,LA 30314\n" +
                "USA\n" +
                "END:VCARD";
        ClassPathResource resource = new ClassPathResource("decodeQrCodeVCardComplete.png");
        File qrCodeFile = resource.getFile();
        String actual = this.qrCodeDecoder.decodeQrCodeFile(qrCodeFile);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}
