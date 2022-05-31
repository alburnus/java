package com.github.alburnus.javastuff.model;

import lombok.Data;

/**
 * Person class
 */
@Data
public class Person {

    private String firstName;
    private String lastName;
    private Address homeAddress;
    private ContactDetail contactDetail;
}
