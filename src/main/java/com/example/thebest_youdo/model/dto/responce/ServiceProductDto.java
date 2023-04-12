package com.example.thebest_youdo.model.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceProductDto {

    private UUID id;
    private String title;
    private String description;
    private String categoryName;
    private String price;
    private String status;
    private String username;
}
