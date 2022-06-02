package com.github.alburnus.javastuff.validation;

import com.github.alburnus.javastuff.model.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public abstract class AbstractValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        validatePerson(person, errors);
    }

    abstract void validatePerson(Person person, Errors errors);
}
