package org.sidiff.common.util.internal;

import org.sidiff.common.util.ObjectConverter;

public class StringConverter implements ObjectConverter {

	@Override
	public Class<?> getType() {
		return String.class;
	}

	@Override
	public String marshal(Object object) {
		assert(object instanceof String) : "Used StringConverter with no String!";
		return (String) object;
	}

	@Override
	public Object unmarshal(String string) {
		return string;
	}

}
