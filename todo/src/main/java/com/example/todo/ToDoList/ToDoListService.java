package com.example.todo.ToDoList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {
    @Autowired
    ToDoListRepository toDoListRepository;

    public List<ToDoList> getAll(){
        return toDoListRepository.findAll();
    }

    public Optional<ToDoList> getById(Long id){
        return toDoListRepository.findById(id);
    }

    public ToDoList save(ToDoList toDoList){
        return toDoListRepository.save(toDoList);
    }

    public List<ToDoList> saveAll(List<ToDoList> lists){
        return toDoListRepository.saveAll(lists);
    }

    public void deleteById(Long id){
        toDoListRepository.deleteById(id);
    }
}
