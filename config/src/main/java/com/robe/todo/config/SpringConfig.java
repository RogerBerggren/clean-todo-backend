package com.robe.todo.config;

import com.robe.todo.usecase.*;
import com.robe.todo.db.hazelcast.HazelcastTodoRepository;
import com.robe.todo.usecase.port.TodoRepository;
import com.robe.todo.uuid.UuidGenerator;

public class SpringConfig {
	private final TodoRepository todoRepository = new HazelcastTodoRepository();

	public CreateTodo createTodo() {
		return new CreateTodo(todoRepository, new UuidGenerator());
	}

	public GetTodo getTodo() {
		return new GetTodo(todoRepository);
	}

	public EditTodo editTodo() {
		return new EditTodo(todoRepository);
	}

	public DeleteTodo deleteTodo() {
		return new DeleteTodo(todoRepository);
	}
}
