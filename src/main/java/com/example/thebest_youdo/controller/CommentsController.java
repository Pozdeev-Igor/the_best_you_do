package com.example.thebest_youdo.controller;

import com.example.thebest_youdo.model.dto.request.CommentRequestDto;
import com.example.thebest_youdo.model.dto.responce.CommentResponseDto;
import com.example.thebest_youdo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/auth/{serviceId}/comments")
@RequiredArgsConstructor
public class CommentsController {

    private final CommentService commentService;

    @PostMapping("/new")
    public ResponseEntity<CommentResponseDto> saveComment(@RequestBody CommentRequestDto commentRequestDto, @PathVariable UUID serviceId) {

        return ResponseEntity.ok(commentService.makeNewComment(serviceId, commentRequestDto));
    }

    @PatchMapping("/commentId")
    public ResponseEntity<CommentResponseDto> editComment(@RequestBody CommentRequestDto commentRequestDto) {

        return ResponseEntity.ok(commentService.editComment(commentRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<CommentResponseDto>> showAllComments(@PathVariable UUID serviceId) {

        return ResponseEntity.ok(commentService.showAllComments(serviceId));
    }
}
