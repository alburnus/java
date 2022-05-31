package com.github.alburnus.javastuff.validation;

import com.github.alburnus.javastuff.model.Address;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Class to validate address data {@link com.github.alburnus.javastuff.model.Address}
 */
@Component
public class AddressValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Address.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "streetName", "error.streetName", "Street name is required.");
    }
}
