package com.robe.todo.db.hazelcast;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.org.codehaus.commons.nullanalysis.NotNull;
import com.hazelcast.query.impl.predicates.TruePredicate;
import com.robe.todo.db.hazelcast.model.TodoDb;
import com.robe.todo.domain.entity.Todo;
import com.robe.todo.usecase.port.TodoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HazelcastTodoRepository implements TodoRepository {
	private static final String MAP_NAME = "todo";
	private static final HazelcastInstance repository = Hazelcast.getInstance();

	@Override
	public Todo create(final Todo todo) {
		var todoDb = TodoDb.from(todo);
		var map = repository.getMap(MAP_NAME);
		map.put(todoDb.getId(), todoDb);
		return todo;
	}

	@Override
	public Optional<Todo> update(Todo todo) {
		var map = repository.<Long, TodoDb>getMap(MAP_NAME);
		boolean exists =  map.containsKey(todo.getId());

		if (exists) {
			map.set(todo.getId(), TodoDb.from(todo));
		}

		return exists ? Optional.of(todo) : Optional.empty();
	}

	@Override
	public Optional<Todo> findById(@NotNull Long id) {
		var map = repository.<Long, TodoDb>getMap(MAP_NAME);
		var todoDb = map.get(id);

		return todoDb != null ? Optional.of(todoDb.toTodo()) : Optional.empty();
	}

	@Override
	public List<Todo> findAll() {
		var map = repository.<Long, TodoDb>getMap(MAP_NAME);
		return map.values().stream().map(TodoDb::toTodo).collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		var map = repository.<Long, TodoDb>getMap(MAP_NAME);
		map.remove(id);
	}

	@Override
	public void deleteAll() {
		var map = repository.<Long, TodoDb>getMap(MAP_NAME);
		map.removeAll(new TruePredicate<>());
	}
}
