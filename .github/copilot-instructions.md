# Copilot Instructions

## Build, Test & Run

```bash
# Build
./mvnw clean install

# Run all tests
./mvnw test

# Run a single test class
./mvnw test -Dtest=QrCodeControllerTests

# Run a single test method
./mvnw test -Dtest=QrCodeControllerTests#thatProcessQrCodeUrlPasses

# Start the application
./mvnw spring-boot:run
# Available at http://localhost:8080
```

Docker:
```bash
docker build -t qrcode-generator .
docker run -d --name qrcode-generator -p 9080:8080 qrcode-generator
```

## Architecture

Spring Boot 3.4.4 / Java 21 MVC web app that generates QR codes using ZXing. Thymeleaf renders the UI.

**Request flow:**
1. `QrCodeController` receives a form POST with a model object (e.g., `QrCodeUrl`)
2. Bean Validation (`@Valid`) runs; on error, the controller re-renders the form page with field errors
3. On success, the appropriate `QrCodeEncoder` method instantiates the matching `*Parser` and calls `parse()` to format the ZXing payload string
4. `QrCodeEncoder.generateImageAsBase64()` writes a temp PNG, Base64-encodes it, and returns a `QrCodeProcessingResult` with a `data:image/png;base64,...` string
5. Controller adds `image`, `text`, `successMessage`/`errorMessage` to the model and returns the `result` Thymeleaf view

**Adding a new QR code type requires four steps:**
1. Create a model class in `model/` (Lombok `@Getter`/`@Setter`, `@Validated`, JSR-303 constraints)
2. Create a `*Parser` extending `AbstractQrCodeParser` that formats the ZXing payload string
3. Add a `generateQrCode*()` method in `QrCodeEncoder`
4. Add GET + POST handler pair in `QrCodeController` and Thymeleaf templates

## Key Conventions

- **Package root:** `de.ksbrwsk.qrcode`
- **Lombok:** All model/config classes use `@Getter`/`@Setter`; services use `@Slf4j` for logging
- **Config:** `ApplicationProperties` bound via `@ConfigurationProperties(prefix = "application")`. `application.properties` uses Maven resource filtering (`@artifactId@`, `@project.version@`)
- **QR encoding settings:** Fixed at 250×250px, UTF-8, error correction level L, margin 1 (in `QrCodeEncoder.createHintMap()`)
- **Tests:** Use `@SpringBootTest` with direct `@Autowired` controller injection (not MockMvc). `TestUtils` provides `createModel()` and `createBindingResult(object)` helpers that run real Bean Validation
- **Docker:** Activates `ssl` Spring profile; SSL config is in `application-ssl.properties`
- **`QrCodeEnumType`:** `WORK` / `HOME` enum used for VCard phone and address type fields
