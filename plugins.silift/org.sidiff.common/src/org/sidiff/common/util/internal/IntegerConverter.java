package org.sidiff.common.util.internal;

import org.sidiff.common.util.ObjectConverter;

public class IntegerConverter implements ObjectConverter {

	@Override
	public Class<?> getType() {
		return Integer.class;
	}

	@Override
	public String marshal(Object object) {
		assert (object instanceof Integer) : "Using IntegerConverter with no Integer!";
		return String.valueOf(object);
	}

	@Override
	public Object unmarshal(String string) {
		return Integer.parseInt(string);
	}

}
