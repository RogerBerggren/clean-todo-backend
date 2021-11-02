package com.robe.todo.usecase;

import com.robe.todo.domain.entity.Todo;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.testng.Assert.*;

public class GetTodoTest extends TodoTest {

	@Test
	public void testGet() {
		GetTodo getTodo = new GetTodo(repository);
		List<Todo> ls = createTodoItems(1, true);
		Optional<Todo> todo = getTodo.get(ls.get(0).getId());

		assertTrue(todo.isPresent());
	}

	@Test
	public void testGetAll() {
		GetTodo getTodo = new GetTodo(repository);
		List<Todo> ls = createTodoItems(5, true);
		List<Todo> all = getTodo.getAll();

		assertTrue(all.size() >= ls.size());
	}
}
