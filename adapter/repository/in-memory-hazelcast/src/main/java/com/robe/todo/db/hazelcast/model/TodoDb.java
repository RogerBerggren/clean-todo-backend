package com.robe.todo.db.hazelcast.model;

import com.robe.todo.domain.entity.Todo;
import java.io.Serializable;

public class TodoDb implements Serializable {
    private Long id;
    private String title;
    private boolean completed;
    private Integer order;

    public TodoDb() {
    }

	TodoDb(Todo todo) {
		this.id = todo.getId();
		this.title = todo.getTitle();
		this.completed = todo.isCompleted();
		this.order = todo.getOrder();
	}

    public static TodoDb from(Todo todo) {
        return new TodoDb(todo);
    }

	public Todo toTodo() {
		return new Todo(id, title, completed, order);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
}
