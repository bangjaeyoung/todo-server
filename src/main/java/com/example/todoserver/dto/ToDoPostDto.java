package com.example.todoserver.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
public class ToDoPostDto {
    @NotBlank(message = "제목은 공백이 아니어야 합니다.")
    String title;

    @Positive
    Long order;

    Boolean completed;
}
