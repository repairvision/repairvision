package org.sidiff.common.util.internal;

import java.util.List;

import org.sidiff.common.util.*;

public class GenericListConverter implements ObjectConverter {

	private static final String LIST_ENTRY_SEPERATOR = ",";
	private static final String INSTANCE_TYPE_SEPERATOR = "%";

	@Override
	public Class<?> getType() {
		return List.class;
	}

	@Override
	public String marshal(Object object) {
		assert (object instanceof List<?>) : "Using ListConverter with no List!";
		
		StringBuffer result = new StringBuffer();
		
		result.append(object.getClass().getName());
		result.append(INSTANCE_TYPE_SEPERATOR);
		
		for(Object element : (List<?>) object){
			result.append(ObjectUtil.marshal(element));
			result.append(LIST_ENTRY_SEPERATOR);
		}
		return result.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object unmarshal(String string) {
		
		String[] type_date = string.split(INSTANCE_TYPE_SEPERATOR,2);
		if(type_date.length==2){
			List result = ReflectionUtil.createInstance(type_date[0], List.class);
			for(String entry_data : type_date[1].split(LIST_ENTRY_SEPERATOR)){
				result.add(ObjectUtil.unmarshal(Object.class, entry_data));
			}
			return result;
		} else {
			throw new IllegalArgumentException("Invalid data! '"+string+"'");
		}
	}

}
