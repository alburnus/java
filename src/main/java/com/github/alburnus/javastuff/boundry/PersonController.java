package com.github.alburnus.javastuff.boundry;

import com.github.alburnus.javastuff.model.Person;
import com.github.alburnus.javastuff.validation.AddressValidation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final AddressValidation addressValidation;

    public PersonController(AddressValidation addressValidation) {
        this.addressValidation = addressValidation;
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        DataBinder dataBinder = new DataBinder(person.getHomeAddress());
        dataBinder.addValidators(addressValidation);
        dataBinder.validate();
        if (dataBinder.getBindingResult().hasErrors()) {
            dataBinder.getBindingResult().getAllErrors().forEach(System.out::println);
        }
        return ResponseEntity.ok(person);
    }
}
