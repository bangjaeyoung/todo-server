package com.example.todoserver.service;

import com.example.todoserver.entity.ToDo;
import com.example.todoserver.repository.ToDoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDo createToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public ToDo findToDo(long toDoId) {
        return toDoRepository.findById(toDoId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<ToDo> findToDos() {
        return toDoRepository.findAll();
    }

    public ToDo updateToDo(ToDo toDo) {
        ToDo findToDo = toDoRepository.findById(toDo.getToDoId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Optional.ofNullable(toDo.getTitle()).ifPresent(findToDo::setTitle);
        Optional.ofNullable(toDo.getTodo_order()).ifPresent(findToDo::setTodo_order);
        Optional.ofNullable(toDo.getCompleted()).ifPresent(findToDo::setCompleted);
        return toDoRepository.save(findToDo);
    }

    public void deleteToDos() {
        toDoRepository.deleteAll();
    }

    public void deleteToDo(long toDoId) {
        toDoRepository.deleteById(toDoId);
    }
}
