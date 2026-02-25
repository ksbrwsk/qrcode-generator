package de.ksbrwsk.qrcode.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.support.BindingAwareModelMap;

/**
 * Shared test utilities for setting up bean validation and Thymeleaf model objects.
 */
public class TestUtils {

    private static final LocalValidatorFactoryBean LOCAL_VALIDATOR_FACTORY_BEAN = createLocalValidatorFactoryBean();

    private TestUtils() {
    }

    private static LocalValidatorFactoryBean createLocalValidatorFactoryBean() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.afterPropertiesSet();
        return localValidatorFactoryBean;
    }

    /**
     * Runs bean validation against the given model object and returns the binding result.
     *
     * @param qrCodeModel the model object to validate
     * @return the {@link BindingResult} after validation
     */
    public static BindingResult createBindingResult(Object qrCodeModel) {
        DataBinder dataBinder = new DataBinder(qrCodeModel);
        dataBinder.setValidator(LOCAL_VALIDATOR_FACTORY_BEAN);
        dataBinder.validate();
        return dataBinder.getBindingResult();
    }

    /**
     * Creates an empty {@link BindingAwareModelMap} for use as a Spring MVC model in tests.
     *
     * @return a new empty model map
     */
    public static BindingAwareModelMap createModel() {
        return new BindingAwareModelMap();
    }
}
