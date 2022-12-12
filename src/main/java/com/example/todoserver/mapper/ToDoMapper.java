package com.example.todoserver.mapper;

import com.example.todoserver.dto.ToDoDto;
import com.example.todoserver.entity.ToDo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ToDoMapper {
    default ToDo postDtoToToDo(ToDoDto.Post post) {
        if (post == null) {
            return null;
        } else {
            ToDo toDo = new ToDo();
            toDo.setTitle(post.getTitle());
            toDo.setTodo_order(post.getOrder());
            toDo.setCompleted(post.getCompleted());
            return toDo;
        }
    }

    default ToDo patchDtoToToDo(ToDoDto.Patch patch) {
        if (patch == null) {
            return null;
        } else {
            ToDo toDo = new ToDo();
            toDo.setToDoId(patch.getToDoId());
            toDo.setTitle(patch.getTitle());
            toDo.setTodo_order(patch.getOrder());
            toDo.setCompleted(patch.getCompleted());
            return toDo;
        }
    }

    ToDoDto.Response toDoToResponseDto(ToDo toDo);

    List<ToDoDto.Response> toDosToResponses(List<ToDo> toDos);
}
