package de.ksbrwsk.qrcode.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.support.BindingAwareModelMap;

public class TestUtils {

    private TestUtils() {
    }

    private static LocalValidatorFactoryBean LOCAL_VALIDATOR_FACTORY_BEAN = createLocalValidatorFactoryBean();

    private static LocalValidatorFactoryBean createLocalValidatorFactoryBean() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.afterPropertiesSet();
        return localValidatorFactoryBean;
    }

    public static BindingResult createBindingResult(Object qrCodeModel) {
        DataBinder dataBinder = new DataBinder(qrCodeModel);
        dataBinder.setValidator(LOCAL_VALIDATOR_FACTORY_BEAN);
        dataBinder.validate();
        return dataBinder.getBindingResult();
    }

    public static BindingAwareModelMap createModel() {
        return new BindingAwareModelMap();
    }
}
