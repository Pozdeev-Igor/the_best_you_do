package com.example.thebest_youdo.repository;

import com.example.thebest_youdo.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findAllByServiceId(UUID serviceId);
}
