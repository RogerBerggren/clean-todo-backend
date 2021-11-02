module robe.todo.config {
	exports com.robe.todo.config;

	requires robe.todo.usecase;
	requires robe.todo.domain;
	requires robe.todo.jug;
	requires robe.todo.uuid;
	requires robe.todo.db.simple;
	requires robe.todo.db.hazelcast;
}
