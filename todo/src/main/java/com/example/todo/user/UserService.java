package com.example.todo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> getById(Long id){
        return userRepository.findById(id);
    }

    public User create(CreateUserDTO dto){
        User user = new User(dto.name(), dto.password(), dto.email());
        return userRepository.save(user);
    }

    public List<User> saveAll(List<User> users){
        return userRepository.saveAll(users);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
