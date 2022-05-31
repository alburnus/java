package com.github.alburnus.javastuff.model;

import lombok.Data;

/**
 * Address model
 */
@Data
public class Address {

    private String streetName;
    private String postCode;
    private String city;
    private String country;
}
