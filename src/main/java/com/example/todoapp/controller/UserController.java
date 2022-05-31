package com.example.todoapp.controller;

import java.util.NoSuchElementException;

import com.example.todoapp.entity.Todo;
import com.example.todoapp.entity.User;
import com.example.todoapp.repository.TodoRepository;
import com.example.todoapp.repository.UserRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	private UserRepository userRepository;
	private TodoRepository todoRepository;

	public UserController(UserRepository userRepository, TodoRepository todoRepository) {
		this.userRepository = userRepository;
		this.todoRepository = todoRepository;
	}
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable Long userId){
		return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
	}
	 @PostMapping
	public User addUser(@RequestBody User user){
		return userRepository.save(user);
	 }
	 @PostMapping("/{userId}/todos")
	public void addTodo(@PathVariable Long userId, @RequestBody Todo todo){
		User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
		user.getTodoList().add(todo);
	 }
	 @PostMapping("/todos/{todoId}")
	public void toggleTodoCompleted(@PathVariable Long todoId){
		Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
		todo.setCompleted(!todo.getCompleted());
		todoRepository.save(todo);
	 }
	 @DeleteMapping("todos/{todoId}")
	public void deleteTodo(@PathVariable Long todoId){
		Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
		todoRepository.delete(todo);
	 }
	 @DeleteMapping("/{userId}")
	 public void deleteUser(@PathVariable Long userId){
		User user= userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
		userRepository.delete(user);
	 }
}
