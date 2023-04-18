package com.example.thebest_youdo.controller;

import com.example.thebest_youdo.model.dto.request.UsersDataRequestDto;
import com.example.thebest_youdo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/auth/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PatchMapping("/{userId}/rate")
    public ResponseEntity<?> rateUser(@PathVariable UUID userId, @RequestBody int rate) {

        userService.giveUserRate(userId, rate);
        return ResponseEntity.ok("thanks for rate!");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> showCurrentUserData(@PathVariable UUID userId) {

        return ResponseEntity.ok(userService.findById(userId));
    }

    @PatchMapping("/{userId}/edit")
    public ResponseEntity<?> editUsersData(@PathVariable UUID userId, @RequestBody UsersDataRequestDto usersDataRequest) {

        return ResponseEntity.ok(userService.editUsersData(userId, usersDataRequest));
    }
}
