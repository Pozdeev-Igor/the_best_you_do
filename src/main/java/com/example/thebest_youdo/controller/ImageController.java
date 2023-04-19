package com.example.thebest_youdo.controller;

import com.example.thebest_youdo.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth/images")
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/new/{userId}")
    public ResponseEntity<?> addAvatar(@PathVariable UUID userId, @RequestParam MultipartFile file) {

        return ResponseEntity.ok(imageService.addAvatar(userId, file));
    }
}
