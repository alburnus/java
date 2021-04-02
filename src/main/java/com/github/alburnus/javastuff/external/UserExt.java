package com.github.alburnus.javastuff.external;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class UserExt {

    private String firstName;

    private String lastName;

    private List<RoleExt> roles;
}
