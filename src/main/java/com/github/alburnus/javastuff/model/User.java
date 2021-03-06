package com.github.alburnus.javastuff.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class User {

    private String firstName;

    private String lastName;

    private List<Role> roles;
}
