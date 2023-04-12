package com.example.thebest_youdo.mapper;

import com.example.thebest_youdo.model.dto.request.CommentRequestDto;
import com.example.thebest_youdo.model.dto.responce.CommentResponseDto;
import com.example.thebest_youdo.model.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentsMapper {

    @Mapping(target = "serviceId", source = "service.id")
    @Mapping(target = "usersName", source = "createdBy.name")
    CommentResponseDto commentToCommentDto(Comment comment);

    List<CommentResponseDto> commentsToCommentsResponseDto(List<Comment> comments);

}
