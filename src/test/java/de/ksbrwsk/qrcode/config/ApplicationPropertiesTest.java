package de.ksbrwsk.qrcode.config;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
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