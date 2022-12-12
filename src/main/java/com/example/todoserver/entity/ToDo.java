package com.example.todoserver.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "todos")
@Data
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long toDoId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Long todo_order;

    @Column(nullable = false)
    private Boolean completed;
}
