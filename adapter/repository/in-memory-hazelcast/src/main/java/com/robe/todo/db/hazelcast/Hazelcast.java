package com.robe.todo.db.hazelcast;

import com.hazelcast.core.HazelcastInstance;

class Hazelcast {

	private static final Object LOCK = new Object();
	private static HazelcastInstance instance;

	static HazelcastInstance getInstance() {
		if (instance == null) {
			synchronized (LOCK) {
				if (instance == null) {
					instance = com.hazelcast.core.Hazelcast.newHazelcastInstance();
				}
			}
		}
		return instance;
	}

	private Hazelcast() {
	}
}
