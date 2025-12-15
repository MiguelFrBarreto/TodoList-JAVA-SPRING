package com.example.todo.task;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.toDoList.ToDoList;
import com.example.todo.toDoList.ToDoListService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    ToDoListService listService;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> getById(Long id) {
        return taskRepository.findById(id);
    }

    @Transactional
    public Task create(CreateTaskDTO dto, Long listId) {
        ToDoList list = listService.getById(listId)
                .orElseThrow(() -> new EntityNotFoundException("List not found"));

        Task task = new Task();
        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setExpirationDate(dto.expirationDate());
        task.setToDoList(list);
        return taskRepository.save(task);
    }

    public List<Task> saveAll(List<Task> tasks) {
        return taskRepository.saveAll(tasks);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
