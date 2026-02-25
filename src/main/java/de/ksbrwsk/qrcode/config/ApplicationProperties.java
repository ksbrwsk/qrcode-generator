package de.ksbrwsk.qrcode.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Configuration properties for the application, bound from the {@code application.*} prefix.
 * <p>
 * Properties are defined in {@code application.properties} and support Maven resource filtering.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
@Component
@Getter
@Setter
public class ApplicationProperties {
    /** The application title displayed in the UI. */
    private String title;
    /** Application info string (e.g. name and version). */
    private String appInfo;
}
