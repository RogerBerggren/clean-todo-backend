package com.robe.todo.usecase;

import com.robe.todo.domain.entity.Todo;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class CreateTodoTest extends TodoTest {
	@Test
	public void testCreate() {
		CreateTodo createTodo = new CreateTodo(repository, idGenerator);
		List<Todo> ls = createTodoItems(5, false);

		for (Todo todo : ls) {
			Todo t = createTodo.create(todo);
			assertTrue(t.getId() != null && t.getTitle().equals(todo.getTitle()));
		}
	}
}
