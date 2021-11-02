module robe.todo.controller {
	exports com.robe.todo.controller;
	exports com.robe.todo.controller.model;

	requires robe.todo.usecase;
	requires robe.todo.domain;
}
