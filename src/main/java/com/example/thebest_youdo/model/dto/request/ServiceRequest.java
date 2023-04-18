package com.example.thebest_youdo.model.dto.request;


import com.example.thebest_youdo.model.entity.Category;
import com.example.thebest_youdo.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequest {


    private String title;
    private String description;
    private UUID categoryId;
    private String price;
    private MultipartFile file;
}
