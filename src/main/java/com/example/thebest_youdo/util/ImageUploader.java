package com.example.thebest_youdo.util;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageUploader {

    // Configure


    public static String upload(MultipartFile file) {
        Map config = new HashMap<String, String>();
        config.put("cloud_name", "ddkxweaw0");
        config.put("api_key", "132132136374712");
        config.put("api_secret", "TxqRFXqAllArZqLS6bWaQ1TO2tc");
        Cloudinary cloudinary = new Cloudinary(config);

// Upload
        try {
            cloudinary.uploader().upload(file, ObjectUtils.asMap("public_id", "olympic_flag"));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        // Transform
        String url = cloudinary.url().transformation(new Transformation().width(100).height(150).crop("fill")).generate("olympic_flag");
        System.out.println(url);

        return url;
    }
}
