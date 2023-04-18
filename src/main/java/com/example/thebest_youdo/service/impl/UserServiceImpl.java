package com.example.thebest_youdo.service.impl;

import com.example.thebest_youdo.exception.ResourceNotFoundException;
import com.example.thebest_youdo.mapper.UserMapper;
import com.example.thebest_youdo.model.dto.request.UsersDataRequestDto;
import com.example.thebest_youdo.model.dto.responce.UserResponseDto;
import com.example.thebest_youdo.model.entity.User;
import com.example.thebest_youdo.repository.UserRepository;
import com.example.thebest_youdo.service.UserService;
import com.example.thebest_youdo.util.ImageUploader;
import com.example.thebest_youdo.util.RateCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public void giveUserRate(UUID userId, int rate) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("there is no user by provided id"));
        Long count = user.getCount();
        user.setRate(RateCalculator.calc(rate, user.getRate(), count));
        user.setCount(++count);
        userRepository.save(user);
    }

    @Override
    public UserResponseDto findById(UUID userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("there is no user by provided id"));
        return userMapper.userToUserResponseDto(user);
    }

    @Override
    public UserResponseDto editUsersData(UUID userId, UsersDataRequestDto usersDataRequest) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("there is no user by provided id"));
        user.setName(usersDataRequest.getName());
        user.setEmail(usersDataRequest.getEmail());
        user.setPhoneNumber(usersDataRequest.getPhoneNumber());
        userRepository.save(user);
        return userMapper.userToUserResponseDto(user);
    }
}
