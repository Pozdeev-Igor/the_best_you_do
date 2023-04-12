package com.example.thebest_youdo.model.constant;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum ServiceStatusEnum {

    PUBLISHED("Объявление опубликовано", 1),
    ARCHIVED("Объявление в архиве", 2);

    private final String status;
    private final int orderStep;

    ServiceStatusEnum(String status, int orderStep) {
        this.status = status;
        this.orderStep = orderStep;
    }
}
