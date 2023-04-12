package com.example.thebest_youdo.service;

import com.example.thebest_youdo.model.dto.request.CommentRequestDto;
import com.example.thebest_youdo.model.dto.responce.CommentResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    CommentResponseDto makeNewComment(UUID serviceId, CommentRequestDto commentRequestDto);

    CommentResponseDto editComment(CommentRequestDto commentRequestDto);

    List<CommentResponseDto> showAllComments(UUID serviceId);
}
