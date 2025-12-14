package com.example.todo;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.todo.ToDoList.ToDoList;
import com.example.todo.category.Category;
import com.example.todo.task.Task;
import com.example.todo.user.User;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		User user1 = new User("joao", "joao123", "joao@gmail.com");
		User user2 = new User("maria", "maria123", "maria@gmail.com");
		User user3 = new User("jose", "jose123", "jose@gmail.com");

		ToDoList list1 = new ToDoList("lista 1");
		ToDoList list2 = new ToDoList("lista 2");
		ToDoList list3 = new ToDoList("lista 3");
		ToDoList list4 = new ToDoList("lista 4");
		ToDoList list5 = new ToDoList("lista 5");

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

		Category category1 = new Category("category1");
		Category category2 = new Category("category1");
		Category category3 = new Category("category1");

		list1.setTasks(Arrays.asList(task1, task2, task4));
		list1.setTasks(Arrays.asList(task3, task5));
		list1.setTasks(Arrays.asList(task6, task2, task4));
		list1.setTasks(Arrays.asList(task7, task8));
		list1.setTasks(Arrays.asList(task9, task10));

		list1.setCategory(category1);
		list2.setCategory(category2);
		list3.setCategory(category1);
		list4.setCategory(category3);
		list5.setCategory(category2);

		user1.setLists(Arrays.asList(list1, list2));
		user1.setLists(Arrays.asList(list5));
		user1.setLists(Arrays.asList(list3, list4));

		SpringApplication.run(TodoApplication.class, args);
	}
}
