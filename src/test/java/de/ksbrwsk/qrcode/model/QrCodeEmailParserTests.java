package de.ksbrwsk.qrcode.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class QrCodeEmailParserTests {

    @Test
    public void thatParseEmailPasses() {
        String expected = "mailto:email@email.com";
        QrCodeEmail qrCodeEmail = new QrCodeEmail();
        qrCodeEmail.setEmailToBeEncoded("email@email.com");
        assertEquals(new QrCodeEmailParser(qrCodeEmail).parse(), expected);
    }

    @Test
    public void thatParseEmailAndSubjectPasses() {
        String expected = "mailto:email@email.com?subject=Subject";
        QrCodeEmail qrCodeEmail = new QrCodeEmail();
        qrCodeEmail.setEmailToBeEncoded("email@email.com");
        qrCodeEmail.setSubjectToBeEncoded("Subject");
        assertEquals(new QrCodeEmailParser(qrCodeEmail).parse(), expected);
    }

    @Test
    public void thatParseEmailAndSubjectWithBlanksPasses() {
        String expected = "mailto:email@email.com?subject=My%20Subject";
        QrCodeEmail qrCodeEmail = new QrCodeEmail();
        qrCodeEmail.setEmailToBeEncoded("email@email.com");
        qrCodeEmail.setSubjectToBeEncoded("My Subject");
        assertEquals(new QrCodeEmailParser(qrCodeEmail).parse(), expected);
    }
}