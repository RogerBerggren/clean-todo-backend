package com.robe.todo.usecase;

import com.robe.todo.domain.entity.Todo;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.testng.Assert.*;

public class DeleteTodoTest extends TodoTest {

	@Test
	public void testDeleteAll() {
		DeleteTodo deleteTodo = new DeleteTodo(repository);
		List<Todo> ls = createTodoItems(5, true);
		deleteTodo.deleteAll();

		List<Todo> todoList = repository.findAll();

		assertTrue(todoList.isEmpty());
	}

	@Test
	public void testDelete() {
		DeleteTodo deleteTodo = new DeleteTodo(repository);
		List<Todo> ls = createTodoItems(1, true);
		Long id = ls.get(0).getId();
		deleteTodo.delete(id);

		Optional<Todo> todo = repository.findById(id);

		assertFalse(todo.isPresent());
	}
}
