package de.ksbrwsk.qrcode.web;

import de.ksbrwsk.qrcode.config.ApplicationProperties;
import de.ksbrwsk.qrcode.model.*;
import de.ksbrwsk.qrcode.service.QrCodeEncoder;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class QrCodeController {

    private final static String PAGE_INDEX = "index";
    private final static String PAGE_RESULT = "result";
    private final static String PAGE_QR_CODE_URL = "qr-code-url";
    private final static String PAGE_QR_CODE_PHONE = "qr-code-phone";
    private final static String PAGE_QR_CODE_VCARD = "qr-code-vcard";
    private final static String PAGE_QR_CODE_EMAIL = "qr-code-email";
    private final static String QR_CODE = "image";
    private final static String TEXT_TO_BE_ENCODED = "text";
    private final static String SUCCESS_MESSAGE = "successMessage";
    private final static String ERROR_MESSAGE = "errorMessage";

    private final ApplicationProperties applicationProperties;
    private final QrCodeEncoder qrCodeEncoder;

    public QrCodeController(ApplicationProperties applicationProperties, QrCodeEncoder qrCodeEncoder) {
        this.applicationProperties = applicationProperties;
        this.qrCodeEncoder = qrCodeEncoder;
    }

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        addCommonModelAttributes(model);
        return PAGE_INDEX;
    }

    @GetMapping("/qr-code-url")
    public String qrCodeUrl(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodeUrl", new QrCodeUrl());
        return PAGE_QR_CODE_URL;
    }

    @PostMapping("/process/url")
    public String processUrl(Model model,
                             @Valid @ModelAttribute("qrCodeUrl") QrCodeUrl qrCodeUrl,
                             BindingResult bindingResult) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodeUrl", qrCodeUrl);
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for Url {}", qrCodeUrl.getUrlToBeEncoded());
            QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeUrl(qrCodeUrl);
            this.addResultModelAttributes(model, result);
            return PAGE_RESULT;
        }
        return PAGE_QR_CODE_URL;
    }

    @GetMapping("/qr-code-phone")
    public String qrCodePhone(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodePhone", new QrCodePhone());
        return PAGE_QR_CODE_PHONE;
    }

    @PostMapping("/process/phone")
    public String processPhone(Model model,
                               @Valid @ModelAttribute("qrCodePhone") QrCodePhone qrCodePhone,
                               BindingResult bindingResult) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodePhone", qrCodePhone);
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for Phone number {}", qrCodePhone.getPhoneToBeEncoded());
            QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodePhone(qrCodePhone);
            this.addResultModelAttributes(model, result);
            return PAGE_RESULT;
        }
        return PAGE_QR_CODE_PHONE;
    }

    @GetMapping("/qr-code-email")
    public String qrCodeEmail(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodeEmail", new QrCodeEmail());
        return PAGE_QR_CODE_EMAIL;
    }

    @PostMapping("/process/email")
    public String processEmail(Model model,
                               @Valid @ModelAttribute("qrCodeEmail") QrCodeEmail qrCodeEmail,
                               BindingResult bindingResult) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodeEmail", qrCodeEmail);
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for Email {}", qrCodeEmail.getEmailToBeEncoded());
            QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeEmail(qrCodeEmail);
            this.addResultModelAttributes(model, result);
            return PAGE_RESULT;
        }
        return PAGE_QR_CODE_EMAIL;
    }

    @GetMapping("/qr-code-vcard")
    public String qrCodeVCard(Model model) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodeVCard", new QrCodeVCard());
        return PAGE_QR_CODE_VCARD;
    }

    @PostMapping("/process/vcard")
    public String processVCard(Model model,
                               @Valid @ModelAttribute("qrCodeVCard") QrCodeVCard qrCodeVCard,
                               BindingResult bindingResult) {
        addCommonModelAttributes(model);
        model.addAttribute("qrCodeVCard", qrCodeVCard);
        if (!bindingResult.hasErrors()) {
            log.info("generate QR Code for VCard {}", qrCodeVCard.getName());
            QrCodeProcessingResult result = this.qrCodeEncoder.generateQrCodeVCard(qrCodeVCard);
            this.addResultModelAttributes(model, result);
            return PAGE_RESULT;
        }
        return PAGE_QR_CODE_VCARD;
    }

    private void addCommonModelAttributes(@NotNull Model model) {
        model.addAttribute("titleMessage", this.applicationProperties.getTitle());
        model.addAttribute("appInfo", this.applicationProperties.getAppInfo());
    }

    private void addResultModelAttributes(@NotNull Model model, @NotNull QrCodeProcessingResult result) {
        model.addAttribute(QR_CODE, result.getImage());
        model.addAttribute(TEXT_TO_BE_ENCODED, result.getEncodedText());
        if (result.isSuccessfull()) {
            model.addAttribute(SUCCESS_MESSAGE, result.getSuccessMessage());
        } else {
            model.addAttribute(ERROR_MESSAGE, result.getErrorMessage());
        }
    }
}