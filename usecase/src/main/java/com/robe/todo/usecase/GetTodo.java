package com.robe.todo.usecase;

import com.robe.todo.domain.entity.Todo;
import com.robe.todo.usecase.port.TodoRepository;

import java.util.List;
import java.util.Optional;

public final class GetTodo {
	private final TodoRepository repository;

	public GetTodo(final TodoRepository repository) {
		this.repository = repository;
	}

	public Optional<Todo> get(Long id) {
		return repository.findById(id);
	}

	public List<Todo> getAll() {
		return repository.findAll();
	}
}
