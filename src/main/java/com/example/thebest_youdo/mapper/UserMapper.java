package com.example.thebest_youdo.mapper;

import com.example.thebest_youdo.model.dto.responce.UserResponseDto;
import com.example.thebest_youdo.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto userToUserResponseDto (User user);
}
