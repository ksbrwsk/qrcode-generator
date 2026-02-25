package de.ksbrwsk.qrcode.config;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Integration tests for {@link ApplicationProperties}.
 * <p>
 * Verifies that the {@code application.title} and {@code application.appInfo}
 * properties are loaded and non-empty.
 */
@SpringBootTest
public class ApplicationPropertiesTest {

    @Autowired
    ApplicationProperties applicationProperties;

    @Test
    public void thatTitleIsValid() {
        String actual = this.applicationProperties.getTitle();
        assertNotNull(actual);
        assertTrue(StringUtils.isNotEmpty(actual));
    }

    @Test
    public void thatAppInfoIsValid() {
        String actual = this.applicationProperties.getAppInfo();
        assertNotNull(actual);
        assertTrue(StringUtils.isNotEmpty(actual));
    }
}