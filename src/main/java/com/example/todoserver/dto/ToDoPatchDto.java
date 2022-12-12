package com.example.todoserver.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class ToDoPatchDto {
    Long toDoId;

    @NotBlank(message = "제목은 공백이 아니어야 합니다.")
    String title;

    @Positive
    Long todo_order;

    Boolean completed;
}
