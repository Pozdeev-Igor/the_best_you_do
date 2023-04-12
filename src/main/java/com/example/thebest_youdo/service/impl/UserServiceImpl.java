package com.example.thebest_youdo.service.impl;

import com.example.thebest_youdo.exception.ResourceNotFoundException;
import com.example.thebest_youdo.model.entity.User;
import com.example.thebest_youdo.repository.UserRepository;
import com.example.thebest_youdo.service.UserService;
import com.example.thebest_youdo.util.RateCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public void giveUserRate(UUID userId, int rate) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("there is no user by provided id"));
        Long count = user.getCount();
        user.setRate(RateCalculator.calc(rate, user.getRate(), count));
        user.setCount(++count);
        userRepository.save(user);
    }
}
