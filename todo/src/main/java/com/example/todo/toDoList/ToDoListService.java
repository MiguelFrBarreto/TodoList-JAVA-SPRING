package com.example.todo.toDoList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.category.Category;
import com.example.todo.category.CategoryService;
import com.example.todo.user.User;
import com.example.todo.user.UserService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ToDoListService {
    @Autowired
    private ToDoListRepository toDoListRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    public List<ToDoList> getAll() {
        return toDoListRepository.findAll();
    }

    public Optional<ToDoList> getById(Long id) {
        return toDoListRepository.findById(id);
    }

    @Transactional
    public ToDoList create(CreateToDoListDTO dto, Long id) {
        User user = userService.getById(id)
            .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Category category = categoryService.getById(dto.categoryId())
            .orElseThrow(() -> new EntityNotFoundException("User not found"));

        ToDoList list = new ToDoList();
        list.setName(dto.name());
        list.setUser(user);
        list.setCategory(category);
        return toDoListRepository.save(list);
    }

    public List<ToDoList> saveAll(List<ToDoList> lists) {
        return toDoListRepository.saveAll(lists);
    }

    public void deleteById(Long id) {
        toDoListRepository.deleteById(id);
    }
}
