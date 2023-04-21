package com.example.thebest_youdo.mapper;

import com.example.thebest_youdo.model.dto.responce.UserResponseDto;
import com.example.thebest_youdo.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "authorities", expression = "java(getRoles(user))")
    UserResponseDto userToUserResponseDto (User user);

    default List<String> getRoles(User user) {
        return user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
    }
}
