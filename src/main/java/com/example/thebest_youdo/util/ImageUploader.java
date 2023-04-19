package com.example.thebest_youdo.util;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageUploader {
    @Value("${cloudinary.cloud-name}")
    private static String cloudName;
    @Value("${cloudinary.api-key}")
    private static String apiKey;
    @Value("${cloudinary.api-secret}")
    private static String apiSecret;

    public static String upload(MultipartFile file) {
        Map config = new HashMap<String, String>();
        config.put("cloud_name", cloudName);
        config.put("api_key", apiKey);
        config.put("api_secret", apiSecret);
        Cloudinary cloudinary = new Cloudinary(config);

        String publicId = "";
        try {
            Map uploadRsult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            publicId = uploadRsult.get("public_id").toString();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        String url = cloudinary.url().transformation(new Transformation().width(400).height(300).gravity("faces").crop("thumb")).generate(publicId);
        System.out.println(url);

        return url;
    }
}
