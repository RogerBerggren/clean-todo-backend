package com.robe.todo.uuid;

import com.robe.todo.usecase.port.IdGenerator;
import java.util.UUID;

public class UuidGenerator implements IdGenerator {

	@Override
	public Long generateLong() {
		return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
	}
}
