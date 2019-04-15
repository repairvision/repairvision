package org.sidiff.common.util.internal;

import org.sidiff.common.util.ObjectConverter;

public class FloatConverter implements ObjectConverter {

	@Override
	public Class<?> getType() {
		return Float.class;
	}

	@Override
	public String marshal(Object object) {
		assert(object instanceof Float) : "Used FloatConverter with no Flaot!";
		return String.valueOf((Float) object);
	}

	@Override
	public Object unmarshal(String string) {
		return Float.parseFloat(string);
	}

}
