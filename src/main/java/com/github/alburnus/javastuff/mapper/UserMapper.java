package com.github.alburnus.javastuff.mapper;

import com.github.alburnus.javastuff.external.RoleExt;
import com.github.alburnus.javastuff.external.UserExt;
import com.github.alburnus.javastuff.model.Role;
import com.github.alburnus.javastuff.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    User mapToUser(UserExt userExt);

    @Mapping(source = "roleName", target = "role")
    Role mapToROle(RoleExt roleExt);

}
