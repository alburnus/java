package com.github.alburnus.javastuff.validation;

import com.github.alburnus.javastuff.model.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * Class to validate address data {@link com.github.alburnus.javastuff.model.Address}
 */
@Component
public class AddressValidation extends AbstractValidation {

    @Override
    void validatePerson(Person person, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "streetName", "error.field.required", "Street name is required.");
    }
}
