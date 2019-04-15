package org.sidiff.common.util;

public interface ObjectConverter {

	public Class<?> getType();
	
	public String marshal(Object object);
	
	public Object unmarshal(String string);
}
