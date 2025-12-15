package com.example.todo.user;

public record CreateUserDTO(
        String name,
        String password,
        String email) {
}
