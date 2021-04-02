package com.github.alburnus.javastuff.mapper;

import com.github.alburnus.javastuff.external.RoleExt;
import com.github.alburnus.javastuff.external.UserExt;
import com.github.alburnus.javastuff.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserMapperTest {

    private final UserMapper userMapper = new UserMapperImpl();

    @Test
    void shouldMap() {
        // Given
        String firstName = "Adam";
        String lastName = "Nowak";
        String roleName = "ADMIN";

        UserExt user = UserExt
                .builder()
                .firstName(firstName)
                .lastName(lastName)
                .roles(List.of(RoleExt.builder().roleName(roleName).build()))
                .build();

        // When
        User result = userMapper.mapToUser(user);

        // Then
        assertThat(result.getFirstName()).isEqualTo(firstName);
        assertThat(result.getLastName()).isEqualTo(lastName);
        assertThat(result.getRoles().get(0).getRole()).isEqualTo(roleName);
    }

}