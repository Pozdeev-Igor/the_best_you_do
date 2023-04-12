package com.example.thebest_youdo.service.impl;

import com.example.thebest_youdo.exception.ResourceNotFoundException;
import com.example.thebest_youdo.mapper.CommentsMapper;
import com.example.thebest_youdo.model.dto.request.CommentRequestDto;
import com.example.thebest_youdo.model.dto.responce.CommentResponseDto;
import com.example.thebest_youdo.model.entity.Comment;
import com.example.thebest_youdo.model.entity.ServiceProduct;
import com.example.thebest_youdo.model.entity.User;
import com.example.thebest_youdo.repository.CommentRepository;
import com.example.thebest_youdo.repository.ServiceRepository;
import com.example.thebest_youdo.repository.UserRepository;
import com.example.thebest_youdo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ServiceRepository serviceRepository;
    private final UserRepository userRepository;
    private final CommentsMapper commentsMapper;
    @Override
    public CommentResponseDto makeNewComment(UUID serviceId, CommentRequestDto commentRequestDto) {
        ServiceProduct serviceProduct =
                serviceRepository.findById(serviceId)
                        .orElseThrow(() -> new ResourceNotFoundException("provided service ore product id is invalid"));

        User user =
                userRepository.findById(commentRequestDto.getUserId())
                        .orElseThrow(() -> new ResourceNotFoundException("there is no user with provided id"));

        Comment comment = Comment.builder()
                .service(serviceProduct)
                .text(commentRequestDto.getText())
                .createdDate(ZonedDateTime.now())
                .createdBy(user)
                .build();
        commentRepository.save(comment);

        return commentsMapper.commentToCommentDto(comment);
    }

    @Override
    public CommentResponseDto editComment(CommentRequestDto commentRequestDto) {
        Comment comment =
                commentRepository.findById(commentRequestDto.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("comment not found by provided id"));
        comment.setText(commentRequestDto.getText());
        commentRepository.save(comment);
        return commentsMapper.commentToCommentDto(comment);
    }

    @Override
    public List<CommentResponseDto> showAllComments(UUID serviceId) {

        return commentsMapper.commentsToCommentsResponseDto(commentRepository.findAllByServiceId(serviceId));
    }
}
