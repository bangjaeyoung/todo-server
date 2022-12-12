package com.example.todoserver.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class ToDoDto {
    @Getter
    public static class Post {
        @NotBlank(message = "제목은 공백이 아니어야 합니다.")
        String title;

        @Positive
        Long order;

        Boolean completed;
    }

    @Getter
    public static class Patch {
        Long toDoId;

        @NotBlank(message = "제목은 공백이 아니어야 합니다.")
        String title;

        @Positive
        Long order;

        Boolean completed;

        public void setToDoId(long toDoId) {
            this.toDoId = toDoId;
        }
    }

    @Getter
    @Setter
    public static class Response {
        private Long toDoId;
        private String title;
        private Long todo_order;
        private Boolean completed;
    }
}
