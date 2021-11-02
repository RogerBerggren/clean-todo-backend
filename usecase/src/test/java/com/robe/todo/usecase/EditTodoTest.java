package com.robe.todo.usecase;

import com.robe.todo.domain.entity.Todo;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.testng.Assert.*;

public class EditTodoTest extends TodoTest {

	@Test
	public void testEdit() {
		EditTodo editTodo = new EditTodo(repository);
		List<Todo> ls = createTodoItems(1, true);

		Map<String, String> updates = new HashMap<>();
		updates.put("title", "Updated Title");

		Todo t = ls.get(0);
		Optional<Todo> todo = editTodo.edit(t.getId(), updates);

		if (todo.isPresent()) {
			assertEquals(todo.get().getTitle(), "Updated Title");
		} else {
			fail();
		}
	}
}
