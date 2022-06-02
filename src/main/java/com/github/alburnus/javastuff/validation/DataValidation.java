package com.github.alburnus.javastuff.validation;

import com.github.alburnus.javastuff.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.List;

/**
 * Class to validate data.
 */
@Component
public class DataValidation {

    private final List<AbstractValidation> validations;

    @Autowired
    public DataValidation(List<AbstractValidation> validations) {
        this.validations = validations;
    }

    public void validate(Person person) {
        BeanPropertyBindingResult errors = new BeanPropertyBindingResult(person, "person");
        validations.forEach(v -> v.validate(person, errors));
    }
}
