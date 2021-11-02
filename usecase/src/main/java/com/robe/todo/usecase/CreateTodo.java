package com.robe.todo.usecase;

import com.robe.todo.domain.entity.Todo;
import com.robe.todo.usecase.port.IdGenerator;
import com.robe.todo.usecase.port.TodoRepository;

public final class CreateTodo {
	private final TodoRepository repository;
	private final IdGenerator idGenerator;

	public CreateTodo(final TodoRepository repository, final IdGenerator idGenerator) {
		this.repository = repository;
		this.idGenerator = idGenerator;
	}

	/**
	 * Creates and adds a new Todo note
	 */
	public Todo create(final Todo todo) {
		Long id = idGenerator.generateLong();
		var todoToSave = new Todo(id, todo.getTitle(), todo.isCompleted(), todo.getOrder());
		return repository.create(todoToSave);
	}
}
