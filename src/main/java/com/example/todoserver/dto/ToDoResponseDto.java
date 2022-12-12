package com.example.todoserver.dto;

import lombok.Data;

@Data
public class ToDoResponseDto {
    private Long toDoId;
    private String title;
    private Long todo_order;
    private Boolean completed;
}
