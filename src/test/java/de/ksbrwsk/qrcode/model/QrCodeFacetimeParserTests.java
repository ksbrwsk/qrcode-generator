package de.ksbrwsk.qrcode.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for {@link QrCodeFacetimeParser}.
 */
public class QrCodeFacetimeParserTests {

    @Test
    public void thatParseFacetimePasses() {
        String expected = "facetime://+49555123456";
        QrCodeFacetime qrCodeFacetime = new QrCodeFacetime("+49555123456");
        assertEquals(expected, new QrCodeFacetimeParser(qrCodeFacetime).parse());
    }
}