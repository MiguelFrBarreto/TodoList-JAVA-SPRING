package com.example.todo.task;

import java.time.Instant;

import com.example.todo.enums.Status;
import com.example.todo.toDoList.ToDoList;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private Instant creationDate = Instant.now();
    private Instant expirationDate;
    private Instant completionDate;
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="toDoList_id")
    private ToDoList toDoList;

    public Task(String title, String description, Instant expirationDate) {
        this.title = title;
        this.description = description;
        this.expirationDate = expirationDate;
    }
}
