package com.robe.todo.usecase.port;

import com.robe.todo.domain.entity.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
	Todo create(Todo todo);
	Optional<Todo> update(Todo todo);

	Optional<Todo> findById(Long id);
	List<Todo> findAll();

	void delete(Long id);
	void deleteAll();
}
