package com.example.todoserver.controller;

import com.example.todoserver.dto.ToDoPatchDto;
import com.example.todoserver.dto.ToDoPostDto;
import com.example.todoserver.dto.ToDoResponseDto;
import com.example.todoserver.entity.ToDo;
import com.example.todoserver.mapper.ToDoMapper;
import com.example.todoserver.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "https://todobackend.com")
@RestController
@RequestMapping
@Validated
public class ToDoController {
    private final ToDoService toDoService;
    private final ToDoMapper toDoMapper;

    public ToDoController(ToDoService toDoService, ToDoMapper toDoMapper) {
        this.toDoService = toDoService;
        this.toDoMapper = toDoMapper;
    }

    @PostMapping
    public ResponseEntity postToDo(@Valid @RequestBody ToDoPostDto toDoPostDto) {
        ToDo toDo = toDoService.createToDo(toDoMapper.toDoPostDtoToToDos(toDoPostDto));
        return new ResponseEntity<>(toDoMapper.toDosToToDoResponseDto(toDo), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getToDos() {
        List<ToDo> toDos = toDoService.findToDos();
        List<ToDoResponseDto> response = toDos.stream()
                .map(toDoMapper::toDosToToDoResponseDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{todo-id}")
    public ResponseEntity getToDo(@PathVariable("todo-id") @Positive long toDoId) {
        ToDo toDo = toDoService.findToDo(toDoId);
        return new ResponseEntity<>(toDoMapper.toDosToToDoResponseDto(toDo), HttpStatus.OK);
    }

    @PatchMapping("/{todo-id}")
    public ResponseEntity updateToDo(@PathVariable("todo-id") @Positive long toDoId,
                                     @Valid @RequestBody ToDoPatchDto toDoPatchDto) {
        toDoPatchDto.setToDoId(toDoId);
        ToDo toDo = toDoService.updateToDo(toDoMapper.toDoPatchDtoToToDos(toDoPatchDto));
        return new ResponseEntity<>(toDoMapper.toDosToToDoResponseDto(toDo), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteToDos() {
        toDoService.deleteToDos();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{todo-id}")
    public ResponseEntity deleteToDo(@PathVariable("todo-id") @Positive long toDoId) {
        toDoService.deleteToDo(toDoId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
