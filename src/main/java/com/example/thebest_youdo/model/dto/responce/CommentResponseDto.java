package com.example.thebest_youdo.model.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDto {

    private UUID id;
    private ZonedDateTime createdDate;
    private String text;
    private UUID serviceId;
    private String usersName;
}
