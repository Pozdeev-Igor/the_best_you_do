package com.example.thebest_youdo.service.impl;

import com.example.thebest_youdo.exception.ResourceNotFoundException;
import com.example.thebest_youdo.model.entity.User;
import com.example.thebest_youdo.repository.ImageRepository;
import com.example.thebest_youdo.repository.UserRepository;
import com.example.thebest_youdo.service.ImageService;
import com.example.thebest_youdo.util.ImageUploader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final UserRepository userRepository;
    @Override
    public String addAvatar(UUID userId, MultipartFile file) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("there is no user with provided id"));
        String url = ImageUploader.upload(file);
        user.setAvatar(url);
        userRepository.save(user);
        return url;
    }
}
