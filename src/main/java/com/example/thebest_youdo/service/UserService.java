package com.example.thebest_youdo.service;

import java.util.UUID;

public interface UserService {
    void giveUserRate(UUID userId, int rate);
}
