module robe.todo.db.hazelcast {
	exports com.robe.todo.db.hazelcast;

	requires robe.todo.domain;
	requires robe.todo.usecase;
	requires hazelcast.all;
}
