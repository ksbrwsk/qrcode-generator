package de.ksbrwsk.qrcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for {@link QrCodeEmailParser}.
 */
public class QrCodeEmailParserTests {

    @Test
    public void thatParseEmailPasses() {
        String expected = "mailto:email@email.com";
        QrCodeEmail qrCodeEmail = new QrCodeEmail();
        qrCodeEmail.setEmail("email@email.com");
        assertEquals(expected, new QrCodeEmailParser(qrCodeEmail).parse());
    }

    @Test
    public void thatParseEmailAndSubjectPasses() {
        String expected = "mailto:email@email.com?subject=Subject";
        QrCodeEmail qrCodeEmail = new QrCodeEmail();
        qrCodeEmail.setEmail("email@email.com");
        qrCodeEmail.setSubject("Subject");
        assertEquals(expected, new QrCodeEmailParser(qrCodeEmail).parse());
    }

    @Test
    public void thatParseEmailAndSubjectWithBlanksPasses() {
        String expected = "mailto:email@email.com?subject=My%20Subject";
        QrCodeEmail qrCodeEmail = new QrCodeEmail();
        qrCodeEmail.setEmail("email@email.com");
        qrCodeEmail.setSubject("My Subject");
        assertEquals(expected, new QrCodeEmailParser(qrCodeEmail).parse());
    }
}