package com.example.todoapp.controller;

import java.util.NoSuchElementException;

import com.example.todoapp.entity.User;
import com.example.todoapp.repository.TodoRepository;
import com.example.todoapp.repository.UserRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
