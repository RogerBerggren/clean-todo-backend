package com.robe.todo.usecase;

import com.robe.todo.domain.entity.Todo;
import com.robe.todo.usecase.port.TodoRepository;

import java.util.Map;
import java.util.Optional;

public final class EditTodo {
	private final TodoRepository repository;

	public EditTodo(final TodoRepository repository) {
		this.repository = repository;
	}

	public Optional<Todo> edit(Long id, Map<String, String> updates) {
		Optional<Todo> optionalTodo = repository.findById(id);

		if (optionalTodo.isPresent()) {
			Todo existing = optionalTodo.get();

			Optional<String> title = Optional.ofNullable(updates.get("title"));
			Optional<String> completedString = Optional.ofNullable(updates.get("completed"));
			Optional<String> order = Optional.ofNullable(updates.get("order"));

			Todo updatedTodo = new Todo(existing.getId(),
				title.orElse(existing.getTitle()),
				completedString.map(Boolean::valueOf).orElseGet(existing::isCompleted),
				order.map(Integer::valueOf).orElse(null));

			optionalTodo = repository.update(updatedTodo);
		}


		return optionalTodo;
	}
}
