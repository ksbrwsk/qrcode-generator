package de.ksbrwsk.qrcode.web;

import de.ksbrwsk.qrcode.config.ApplicationProperties;
import de.ksbrwsk.qrcode.model.*;
import de.ksbrwsk.qrcode.service.QrCodeEncoder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Spring MVC controller that handles all QR code generation requests.
 * <p>
 * Provides GET handlers to display input forms and POST handlers to process the submitted
 * models, delegating encoding to {@link QrCodeEncoder}. On validation errors the form is
 * re-rendered with field error messages; on success the {@code result} view is returned.
 */
@Controller
@Slf4j
public class QrCodeController {

    private final static String PAGE_INDEX = "index";

    private final static String PAGE_RESULT = "result";

    private final static String PAGE_QR_CODE_URL = "qr-code-url";
    private final static String PAGE_QR_CODE_PHONE = "qr-code-phone";
    private final static String PAGE_QR_CODE_FACETIME = "qr-code-facetime";
    private final static String PAGE_QR_CODE_VCARD = "qr-code-vcard";
    private final static String PAGE_QR_CODE_EMAIL = "qr-code-email";
    private final static String PAGE_QR_CODE_SMS = "qr-code-sms";
    private final static String PAGE_QR_CODE_EVENT = "qr-code-event";

    private final static String QR_CODE = "image";
    private final static String TEXT_TO_BE_ENCODED = "text";
    private final static String SUCCESS_MESSAGE = "successMessage";
    private final static String ERROR_MESSAGE = "errorMessage";

    private final ApplicationProperties applicationProperties;
    private final QrCodeEncoder qrCodeEncoder;

    /**
     * Creates a new {@code QrCodeController}.
     *
     * @param applicationProperties application-level configuration properties
     * @param qrCodeEncoder         service used to encode data into QR code images
     */
    public QrCodeController(ApplicationProperties applicationProperties, QrCodeEncoder qrCodeEncoder) {
        this.applicationProperties = applicationProperties;
        this.qrCodeEncoder = qrCodeEncoder;
    }

    /**
     * Displays the application index / landing page.
     *
     * @param model the Spring MVC model
     * @return the logical view name {@code index}
     */
    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        addCommonModelAttributes(model);
        return PAGE_INDEX;
    }

    /**
     * Displays the URL QR code input form.
     *
     * @param model the Spring MVC model
     * @return the logical view name {@code qr-code-url}
     */
    @GetMapping("/qr-code-url")
    public String qrCodeUrl(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodeUrl", new QrCodeUrl());
        return PAGE_QR_CODE_URL;
    }


    /**
     * Processes the URL QR code form submission.
     *
     * @param model         the Spring MVC model
     * @param qrCodeUrl     the submitted URL model, validated via {@code @Valid}
     * @param bindingResult validation result
     * @return {@code result} view on success, or {@code qr-code-url} on validation errors
     */
    @PostMapping("/process/url")
    public String processUrl(Model model,
                             @Valid @ModelAttribute("qrCodeUrl") QrCodeUrl qrCodeUrl,
                             BindingResult bindingResult) {
        addCommonModelAttributes(model);
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for Url {}", qrCodeUrl.getUrl());
            QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeUrl(qrCodeUrl);
            this.addResultModelAttributes(model, result);
            return PAGE_RESULT;
        } else {
            this.addFieldErrors(bindingResult.getFieldErrors(), model);
        }
        return PAGE_QR_CODE_URL;
    }

    /**
     * Displays the phone number QR code input form.
     *
     * @param model the Spring MVC model
     * @return the logical view name {@code qr-code-phone}
     */
    @GetMapping("/qr-code-phone")
    public String qrCodePhone(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodePhone", new QrCodePhone());
        return PAGE_QR_CODE_PHONE;
    }

    /**
     * Displays the FaceTime QR code input form.
     *
     * @param model the Spring MVC model
     * @return the logical view name {@code qr-code-facetime}
     */
    @GetMapping("/qr-code-facetime")
    public String qrCodeFacetime(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodeFacetime", new QrCodeFacetime());
        return PAGE_QR_CODE_FACETIME;
    }

    /**
     * Processes the phone number QR code form submission.
     *
     * @param model         the Spring MVC model
     * @param qrCodePhone   the submitted phone model, validated via {@code @Valid}
     * @param bindingResult validation result
     * @return {@code result} view on success, or {@code qr-code-phone} on validation errors
     */
    @PostMapping("/process/phone")
    public String processPhone(Model model,
                               @Valid @ModelAttribute("qrCodePhone") QrCodePhone qrCodePhone,
                               BindingResult bindingResult) {
        addCommonModelAttributes(model);
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for Phone number {}", qrCodePhone.getPhone());
            QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodePhone(qrCodePhone);
            this.addResultModelAttributes(model, result);
            return PAGE_RESULT;
        }else {
            this.addFieldErrors(bindingResult.getFieldErrors(), model);
        }
        return PAGE_QR_CODE_PHONE;
    }

    /**
     * Processes the FaceTime QR code form submission.
     *
     * @param model           the Spring MVC model
     * @param qrCodeFacetime  the submitted FaceTime model, validated via {@code @Valid}
     * @param bindingResult   validation result
     * @return {@code result} view on success, or {@code qr-code-facetime} on validation errors
     */
    @PostMapping("/process/facetime")
    public String processFacetime(Model model,
                                  @Valid @ModelAttribute("qrCodeFacetime") QrCodeFacetime qrCodeFacetime,
                                  BindingResult bindingResult) {
        addCommonModelAttributes(model);
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for Facetime number {}", qrCodeFacetime.getFacetime());
            QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeFacetime(qrCodeFacetime);
            this.addResultModelAttributes(model, result);
            return PAGE_RESULT;
        }else {
            this.addFieldErrors(bindingResult.getFieldErrors(), model);
        }
        return PAGE_QR_CODE_FACETIME;
    }

    /**
     * Displays the email QR code input form.
     *
     * @param model the Spring MVC model
     * @return the logical view name {@code qr-code-email}
     */
    @GetMapping("/qr-code-email")
    public String qrCodeEmail(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodeEmail", new QrCodeEmail());
        return PAGE_QR_CODE_EMAIL;
    }

    /**
     * Processes the email QR code form submission.
     *
     * @param model         the Spring MVC model
     * @param qrCodeEmail   the submitted email model, validated via {@code @Valid}
     * @param bindingResult validation result
     * @return {@code result} view on success, or {@code qr-code-email} on validation errors
     */
    @PostMapping("/process/email")
    public String processEmail(Model model,
                               @Valid @ModelAttribute("qrCodeEmail") QrCodeEmail qrCodeEmail,
                               BindingResult bindingResult) {
        addCommonModelAttributes(model);
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for Email {}", qrCodeEmail.getEmail());
            QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeEmail(qrCodeEmail);
            this.addResultModelAttributes(model, result);
            return PAGE_RESULT;
        } else {
            this.addFieldErrors(bindingResult.getFieldErrors(), model);
        }
        return PAGE_QR_CODE_EMAIL;
    }

    /**
     * Displays the SMS QR code input form.
     *
     * @param model the Spring MVC model
     * @return the logical view name {@code qr-code-sms}
     */
    @GetMapping("/qr-code-sms")
    public String qrCodeSms(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodeSms", new QrCodeSms());
        return PAGE_QR_CODE_SMS;
    }

    /**
     * Processes the SMS QR code form submission.
     *
     * @param model         the Spring MVC model
     * @param qrCodeSms     the submitted SMS model, validated via {@code @Valid}
     * @param bindingResult validation result
     * @return {@code result} view on success, or {@code qr-code-sms} on validation errors
     */
    @PostMapping("/process/sms")
    public String processSms(Model model,
                             @Valid @ModelAttribute("qrCodeSms") QrCodeSms qrCodeSms,
                             BindingResult bindingResult) {
        addCommonModelAttributes(model);
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for Email {}", qrCodeSms.getPhone());
            QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeSms(qrCodeSms);
            this.addResultModelAttributes(model, result);
            return PAGE_RESULT;
        } else {
            this.addFieldErrors(bindingResult.getFieldErrors(), model);
        }
        return PAGE_QR_CODE_SMS;
    }

    /**
     * Displays the calendar event QR code input form.
     *
     * @param model the Spring MVC model
     * @return the logical view name {@code qr-code-event}
     */
    @GetMapping("/qr-code-event")
    public String qrCodeEvent(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodeEvent", new QrCodeEvent());
        return PAGE_QR_CODE_EVENT;
    }

    /**
     * Displays the vCard QR code input form.
     *
     * @param model the Spring MVC model
     * @return the logical view name {@code qr-code-vcard}
     */
    @GetMapping("/qr-code-vcard")
    public String qrCodeVCard(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodeVCard", new QrCodeVCard());
        return PAGE_QR_CODE_VCARD;
    }

    /**
     * Processes the vCard QR code form submission.
     *
     * @param model         the Spring MVC model
     * @param qrCodeVCard   the submitted vCard model, validated via {@code @Valid}
     * @param bindingResult validation result
     * @return {@code result} view on success, or {@code qr-code-vcard} on validation errors
     */
    @PostMapping("/process/vcard")
    public String processVCard(Model model,
                               @Valid @ModelAttribute("qrCodeVCard") QrCodeVCard qrCodeVCard,
                               BindingResult bindingResult) {
        addCommonModelAttributes(model);
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for VCard {}", qrCodeVCard.getName());
            QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeVCard(qrCodeVCard);
            this.addResultModelAttributes(model, result);
            return PAGE_RESULT;
        } else {
            this.addFieldErrors(bindingResult.getFieldErrors(), model);
        }
        return PAGE_QR_CODE_VCARD;
    }

    /**
     * Processes the calendar event QR code form submission.
     *
     * @param model         the Spring MVC model
     * @param qrCodeEvent   the submitted event model, validated via {@code @Valid}
     * @param bindingResult validation result
     * @return {@code result} view on success, or {@code qr-code-event} on validation errors
     */
    @PostMapping("/process/event")
    public String processEvent(Model model,
                               @Valid @ModelAttribute("qrCodeEvent") QrCodeEvent qrCodeEvent,
                               BindingResult bindingResult) {
        addCommonModelAttributes(model);
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for Event {}", qrCodeEvent.getSummary());
            QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeEvent(qrCodeEvent);
            this.addResultModelAttributes(model, result);
            return PAGE_RESULT;
        }else {
            this.addFieldErrors(bindingResult.getFieldErrors(), model);
        }
        return PAGE_QR_CODE_EVENT;
    }

    /**
     * Adds common model attributes (title and app info) used by all views.
     *
     * @param model the Spring MVC model
     */
    private void addCommonModelAttributes(@NotNull Model model) {
        model.addAttribute("titleMessage", this.applicationProperties.getTitle());
        model.addAttribute("appInfo", this.applicationProperties.getAppInfo());
    }

    /**
     * Populates the model with the QR code image, encoded text, and success or error message.
     *
     * @param model  the Spring MVC model
     * @param result the processing result returned by {@link QrCodeEncoder}
     */
    private void addResultModelAttributes(@NotNull Model model, @NotNull QrCodeProcessingResult result) {
        model.addAttribute(QR_CODE, result.getImage());
        model.addAttribute(TEXT_TO_BE_ENCODED, result.getEncodedText());
        if (result.isSuccessfull()) {
            model.addAttribute(SUCCESS_MESSAGE, result.getSuccessMessage());
        } else {
            model.addAttribute(ERROR_MESSAGE, result.getErrorMessage());
        }
    }

    /**
     * Collects field validation errors and adds them as an error message list to the model.
     *
     * @param fieldErrors list of field errors from bean validation
     * @param model       the Spring MVC model
     */
    private void addFieldErrors(List<FieldError> fieldErrors, Model model) {
        List<String> errors = fieldErrors.stream()
                .map(fieldError -> fieldError.getField().toUpperCase() + " - " + fieldError.getDefaultMessage())
                .toList();
        model.addAttribute(ERROR_MESSAGE, errors);
    }

}