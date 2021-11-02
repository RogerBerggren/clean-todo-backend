package com.robe.todo.spring.controller;

import com.robe.todo.controller.TodoController;
import com.robe.todo.controller.model.TodoWeb;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.PATCH;

@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "/todos")
public class SpringTodoController {
	private final TodoController controller;

	public SpringTodoController(final TodoController controller) {
		this.controller = controller;
	}

	@RequestMapping(method = POST)
	public TodoWeb create(@RequestBody final TodoWeb todo) {
		return setUrl(controller.create(todo));
	}

	@RequestMapping(value = "/{id}", method = GET)
	public TodoWeb getOne(@PathVariable("id") Long id) {
		return setUrl(controller.getOne(id));
	}

	@RequestMapping(method = GET)
	public List<TodoWeb> getAll() {
		return controller.getAll().stream().map(this::setUrl).collect(Collectors.toList());
	}

	@RequestMapping(value = "/{id}", method = PATCH)
	public TodoWeb edit(@RequestBody Map<String, String> updates, @PathVariable("id") Long id) {
		return setUrl(controller.edit(id, updates));
	}

	@RequestMapping(value = "/{id}", method = DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void deleteById(@PathVariable("id") Long id) {
		controller.deleteById(id);
	}

	@RequestMapping(method = DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete() {
		controller.deleteAll();
	}

	private TodoWeb setUrl(TodoWeb todoWeb) {
		todoWeb.setUrl(linkTo(SpringTodoController.class).slash(todoWeb.getId()).withSelfRel().getHref());
		return todoWeb;
	}
}
