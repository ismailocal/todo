package com.example.todoapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Todo {

	@Id
	private Long id;
	private String content; //icerik
	private Boolean completed = Boolean.FALSE; //tamamlandı

	public Todo() {
	}

	public Todo(Long id, String content, Boolean completed) {
		this.id = id;
		this.content = content;
		this.completed = completed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
}
