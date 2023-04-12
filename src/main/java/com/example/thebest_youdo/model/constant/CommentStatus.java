package com.example.thebest_youdo.model.constant;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum CommentStatus {

    UNWATCHED("Не просмотрено", 1),
    VIEWED("Просмотрено", 2);

    private final String status;
    private final int orderStep;

    CommentStatus(String status, int orderStep) {
        this.status = status;
        this.orderStep = orderStep;
    }
}
