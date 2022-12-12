package com.example.todoserver.mapper;

import com.example.todoserver.dto.ToDoPatchDto;
import com.example.todoserver.dto.ToDoPostDto;
import com.example.todoserver.dto.ToDoResponseDto;
import com.example.todoserver.entity.ToDo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ToDoMapper {
    default ToDo toDoPostDtoToToDos(ToDoPostDto toDoPostDto) {
            if (toDoPostDto == null) {
                return null;
            } else {
                ToDo toDo = new ToDo();
                toDo.setTitle(toDoPostDto.getTitle());
                toDo.setTodo_order((toDoPostDto.getOrder()));
                toDo.setCompleted(toDoPostDto.getCompleted());
                return toDo;
            }
    }

    default public ToDo toDoPatchDtoToToDos(ToDoPatchDto toDoPatchDto) {
        if (toDoPatchDto == null) {
            return null;
        } else {
            ToDo toDo = new ToDo();
            toDo.setToDoId(toDoPatchDto.getToDoId());
            toDo.setTitle(toDoPatchDto.getTitle());
            toDo.setTodo_order(toDoPatchDto.getTodo_order());
            toDo.setCompleted(toDoPatchDto.getCompleted());
            return toDo;
        }
    }

    ToDoResponseDto toDosToToDoResponseDto(ToDo toDo);
}
