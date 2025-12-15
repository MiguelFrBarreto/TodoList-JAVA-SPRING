package com.example.todo.category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Optional<Category> getById(Long id){
        return categoryRepository.findById(id);
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> saveAll(List<Category> categories){
        return categoryRepository.saveAll(categories);
    }

    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }
}
