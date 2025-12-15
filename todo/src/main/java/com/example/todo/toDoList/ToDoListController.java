package com.example.todo.toDoList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/todo")
public class ToDoListController {
    @Autowired
    private ToDoListService toDoListService;

    @GetMapping()
    public List<ToDoList> getAll() {
        return toDoListService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<ToDoList> getById(@PathVariable Long id) {
        return toDoListService.getById(id);
    }

    @PostMapping("/users/{userId}/lists")
    public ToDoList create(@RequestBody CreateToDoListDTO dto , @PathVariable Long userId) {
        return toDoListService.create(dto, userId);
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        toDoListService.deleteById(id);
    }
}