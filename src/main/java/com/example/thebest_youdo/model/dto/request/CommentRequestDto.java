package com.example.thebest_youdo.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequestDto {

    private UUID id;
    private String text;
    private UUID serviceId;
    private UUID userId;
}
