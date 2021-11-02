package com.robe.todo.usecase;

import com.robe.todo.usecase.port.TodoRepository;

public final class DeleteTodo {
	private final TodoRepository repository;

	public DeleteTodo(final TodoRepository repository) {
		this.repository = repository;
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	public void delete(Long id) {
		repository.delete(id);
	}
}
