package com.robe.todo.jug;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.NoArgGenerator;
import com.robe.todo.usecase.port.IdGenerator;

public class JugIdGenerator implements IdGenerator {

	private static NoArgGenerator generator() {
		return Generators.timeBasedGenerator(EthernetAddress.fromInterface());
	}

	@Override
	public Long generateLong() {
		return generator().generate().getMostSignificantBits() & Long.MAX_VALUE;
	}
}
