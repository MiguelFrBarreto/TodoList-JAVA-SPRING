package com.example.todo.test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.todo.category.Category;
import com.example.todo.category.CategoryService;
import com.example.todo.task.Task;
import com.example.todo.task.TaskService;
import com.example.todo.toDoList.ToDoList;
import com.example.todo.toDoList.ToDoListService;
import com.example.todo.user.User;
import com.example.todo.user.UserService;

@Component
public class Test implements CommandLineRunner{
    private final UserService us;
    private final ToDoListService tdService;
    private final TaskService ts;
    private final CategoryService cs;

    public Test(UserService us, ToDoListService tdService, TaskService ts, CategoryService cs) {
        this.us = us;
        this.tdService = tdService;
        this.ts = ts;
        this.cs = cs;
    }

    @Override
    public void run(String... args) {
        User user1 = new User("joao", "joao123", "joao@gmail.com");
        User user2 = new User("maria", "maria123", "maria@gmail.com");
        User user3 = new User("jose", "jose123", "jose@gmail.com");

        us.saveAll(Arrays.asList(user1, user2, user3));

        ToDoList list1 = new ToDoList("lista 1");
        ToDoList list2 = new ToDoList("lista 2");
        ToDoList list3 = new ToDoList("lista 3");
        ToDoList list4 = new ToDoList("lista 4");
        ToDoList list5 = new ToDoList("lista 5");

        tdService.saveAll(Arrays.asList(list1, list2, list3, list4, list5));

        Task task1 = new Task("task1", "task legal 1", Instant.now().plus(1, ChronoUnit.DAYS));
        Task task2 = new Task("task2", "task legal 2", Instant.now().plus(1, ChronoUnit.DAYS));
        Task task3 = new Task("task3", "task legal 3", Instant.now().plus(1, ChronoUnit.DAYS));
        Task task4 = new Task("task4", "task legal 4", Instant.now().plus(1, ChronoUnit.DAYS));
        Task task5 = new Task("task5", "task legal 5", Instant.now().plus(1, ChronoUnit.DAYS));
        Task task6 = new Task("task6", "task legal 6", Instant.now().plus(1, ChronoUnit.DAYS));
        Task task7 = new Task("task7", "task legal 7", Instant.now().plus(1, ChronoUnit.DAYS));
        Task task8 = new Task("task8", "task legal 8", Instant.now().plus(1, ChronoUnit.DAYS));
        Task task9 = new Task("task9", "task legal 9", Instant.now().plus(1, ChronoUnit.DAYS));
        Task task10 = new Task("task10", "task legal 10", Instant.now().plus(1, ChronoUnit.DAYS));

        ts.saveAll(Arrays.asList(task1, task2, task3, task4, task5, task6, task7, task8, task9, task10));

        Category category1 = new Category("category1");
        Category category2 = new Category("category2");
        Category category3 = new Category("category3");

        cs.saveAll(Arrays.asList(category1, category2, category3));

        task1.setToDoList(list1);
        task2.setToDoList(list1);
        task3.setToDoList(list2);
        task4.setToDoList(list3);
        task5.setToDoList(list2);
        task6.setToDoList(list3);
        task7.setToDoList(list4);
        task8.setToDoList(list4);
        task9.setToDoList(list5);
        task10.setToDoList(list5);

        list1.setTasks(Arrays.asList(task1, task2));
        list2.setTasks(Arrays.asList(task3, task5));
        list3.setTasks(Arrays.asList(task6, task4));
        list4.setTasks(Arrays.asList(task7, task8));
        list5.setTasks(Arrays.asList(task9, task10));

        list1.setCategory(category1);
        list2.setCategory(category2);
        list3.setCategory(category1);
        list4.setCategory(category3);
        list5.setCategory(category2);

        list1.setUser(user1);
        list2.setUser(user1);
        list3.setUser(user3);
        list4.setUser(user3);
        list5.setUser(user2);

        user1.setToDoLists(Arrays.asList(list1, list2));
        user2.setToDoLists(Arrays.asList(list5));
        user3.setToDoLists(Arrays.asList(list3, list4));

        us.saveAll(Arrays.asList(user1, user2, user3));
        tdService.saveAll(Arrays.asList(list1, list2, list3, list4, list5));
        ts.saveAll(Arrays.asList(task1, task2, task3, task4, task5, task6, task7, task8, task9, task10));
        cs.saveAll(Arrays.asList(category1, category2, category3));
    }
}
