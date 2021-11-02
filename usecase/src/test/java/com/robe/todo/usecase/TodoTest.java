package com.robe.todo.usecase;

import com.robe.todo.domain.entity.Todo;
import com.robe.todo.usecase.port.IdGenerator;
import com.robe.todo.usecase.port.TodoRepository;

import java.util.*;

public class TodoTest {
	protected final static TodoRepository repository;
	protected final static IdGenerator idGenerator;

	static {
		repository = new TodoRepository() {
			private final Map<Long, Todo> db = new HashMap<>();

			@Override
			public Todo create(Todo todo) {
				db.put(todo.getId(), todo);
				return todo;
			}

			@Override
			public Optional<Todo> update(Todo todo) {
				db.put(todo.getId(), todo);
				return Optional.of(todo);
			}

			@Override
			public Optional<Todo> findById(Long id) {
				return Optional.ofNullable(db.get(id));
			}

			@Override
			public List<Todo> findAll() {
				return new ArrayList<>(db.values());
			}

			@Override
			public void delete(Long id) {
				db.remove(id);
			}

			@Override
			public void deleteAll() {
				db.clear();
			}
		};

		idGenerator = new IdGenerator() {
			private Long start = 100L;

			@Override
			public Long generateLong() {
				start++;
				return start;
			}
		};
	}

	protected List<Todo> createTodoItems(int nofTodos, boolean createId) {
		List<Todo> ls = new ArrayList<>(nofTodos);

		for (int i = 0; i < nofTodos; i++) {
			Long id = createId ? idGenerator.generateLong() : null;
			Todo todo = new Todo(id, "Title " + i, false, i);
			ls.add(todo);

			if (id != null) {
				repository.create(todo);
			}
		}

		return ls;
	}
}
