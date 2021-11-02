package com.robe.todo.controller;

import com.robe.todo.usecase.*;
import com.robe.todo.domain.entity.Todo;
import com.robe.todo.controller.model.TodoWeb;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class TodoController {
	private final CreateTodo createTodo;
	private final GetTodo getTodo;
	private final EditTodo editTodo;
	private final DeleteTodo deleteTodo;

	public TodoController(CreateTodo createTodo, GetTodo getTodo, EditTodo editTodo, DeleteTodo deleteTodo) {
		this.createTodo = createTodo;
		this.getTodo = getTodo;
		this.editTodo = editTodo;
		this.deleteTodo = deleteTodo;
	}

	public TodoWeb create(TodoWeb request) {
		Todo todo = request.toTodo();
		return TodoWeb.from(createTodo.create(todo));
	}

	public TodoWeb getOne(Long id) throws NoSuchElementException {
		Optional<Todo> todo = getTodo.get(id);
		return TodoWeb.from(todo.orElseThrow());
	}

	public List<TodoWeb> getAll() {
		List<Todo> ls = getTodo.getAll();
		return ls.stream().map(TodoWeb::from).collect(Collectors.toList());
	}

	public TodoWeb edit(Long id, Map<String, String> updates) throws NoSuchElementException {
		Optional<Todo> todo = editTodo.edit(id, updates);
		return TodoWeb.from(todo.orElseThrow());
	}

	public void deleteById(Long id) {
		deleteTodo.delete(id);
	}

	public void deleteAll() {
		deleteTodo.deleteAll();
	}
}
