package com.example.thebest_youdo.model.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private UUID id;
    private LocalDate dayStart;
    private String email;
    private String name;
    private String phoneNumber;
    private Long count;
    private Float rate;
    private String avatar;
    private List<String> authorities;
}
