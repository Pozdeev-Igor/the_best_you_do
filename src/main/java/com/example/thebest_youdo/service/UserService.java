package com.example.thebest_youdo.service;

import com.example.thebest_youdo.model.dto.request.UsersDataRequestDto;
import com.example.thebest_youdo.model.dto.responce.UserResponseDto;

import java.util.UUID;

public interface UserService {
    void giveUserRate(UUID userId, int rate);

    UserResponseDto findById(UUID userId);

    UserResponseDto editUsersData(UUID userId, UsersDataRequestDto usersDataRequest);
}
