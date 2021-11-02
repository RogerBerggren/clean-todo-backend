module robe.todo.spring {
	requires robe.todo.config;
	requires robe.todo.usecase;
	requires robe.todo.controller;
	requires spring.beans;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.web;
	requires spring.webmvc;
    requires com.fasterxml.jackson.databind;
	requires jackson.annotations;
    requires spring.hateoas;

    exports com.robe.todo.spring;
	exports com.robe.todo.spring.config;
	opens com.robe.todo.spring.config to spring.core;
}
