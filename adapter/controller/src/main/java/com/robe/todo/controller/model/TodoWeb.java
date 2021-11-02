package com.robe.todo.controller.model;

import com.robe.todo.domain.entity.Todo;

@SuppressWarnings("unused")
public class TodoWeb {
    private Long id;
    private String title;
    private boolean completed;
    private Integer order;
    private String url;

    /**
     * Needed for serialization
     */
    public TodoWeb() {
    }

	TodoWeb(Todo todo) {
		this.id = todo.getId();
		this.title = todo.getTitle();
		this.completed = todo.isCompleted();
		this.order = todo.getOrder();
	}

    public static TodoWeb from(Todo todo) {
        return new TodoWeb(todo);
    }

	public Todo toTodo() {
		return new Todo(id, title, completed, order);
	}

    public Integer getOrder() {
        return order;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public boolean isCompleted() {
        return completed;
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
