package com.example.todo.task;

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
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getAll() {
        return taskService.getAll();
    }
    
    @GetMapping("/tasks/{id}")
    public Optional<Task> getById(@PathVariable Long id) {
        return taskService.getById(id);
    }

    @PostMapping("/lists/{listId}/tasks")
    public Task create(@RequestBody CreateTaskDTO dto, @PathVariable Long listId) {
        return taskService.create(dto, listId);
    }
    
    @DeleteMapping("/tasks/{id}")
    public void deleteById(@PathVariable Long id){
        taskService.deleteById(id);
    }
}