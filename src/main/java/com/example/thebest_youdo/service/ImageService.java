package com.example.thebest_youdo.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface ImageService {
    String addAvatar(UUID userId, MultipartFile file);
}
