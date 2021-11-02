package com.robe.todo.db;

import com.robe.todo.domain.entity.Todo;
import com.robe.todo.usecase.port.TodoRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryTodoRepository implements TodoRepository {
	private final Map<Long, Todo> inMemoryDb = new HashMap<>();

	@Override
	public Todo create(Todo todo) {
		inMemoryDb.put(todo.getId(), todo);
		return todo;
	}

	@Override
	public Optional<Todo> update(Todo todo) {
		boolean exists =  inMemoryDb.containsKey(todo.getId());

		if (exists) {
			inMemoryDb.put(todo.getId(), todo);
		}

		return exists ? Optional.of(todo) : Optional.empty();
	}

	@Override
	public Optional<Todo> findById(Long id) {
		return Optional.ofNullable(inMemoryDb.get(id));
	}

	@Override
	public List<Todo> findAll() {
		return new ArrayList<>(inMemoryDb.values());
	}

	@Override
	public void delete(Long id) {
		inMemoryDb.remove(id);
	}

	@Override
	public void deleteAll() {
		inMemoryDb.clear();
	}
}
