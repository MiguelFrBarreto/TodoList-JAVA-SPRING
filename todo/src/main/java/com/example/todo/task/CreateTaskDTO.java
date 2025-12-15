package com.example.todo.task;

import java.time.Instant;

public record CreateTaskDTO(
        String title,
        String description,
        Instant expirationDate) {
}
