package com.robe.todo.domain.entity;

import java.util.Objects;

public class Todo {
    private final Long id;
    private final String title;
    private final boolean completed;
    private final Integer order;

    public Todo(Long id, String title, boolean completed, Integer order) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.order = order;
    }

	public Long getId() {
		return id;
	}

    public String getTitle() {
        return this.title;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public Integer getOrder() {
        return order;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Todo todo = (Todo) o;
		return completed == todo.completed &&
			Objects.equals(id, todo.id) &&
			Objects.equals(title, todo.title) &&
			Objects.equals(order, todo.order);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, completed, order);
	}
}
