package org.sidiff.common.util.internal;

import java.util.List;
import java.util.Set;

import org.sidiff.common.util.*;

public class GenericSetConverter implements ObjectConverter {

	private static final String SET_ENTRY_SEPERATOR = ",";
	private static final String INSTANCE_TYPE_SEPERATOR = "%";

	@Override
	public Class<?> getType() {
		return Set.class;
	}

	@Override
	public String marshal(Object object) {
		assert (object instanceof Set<?>) : "Using SetConverter with no Set!";
		
		StringBuffer result = new StringBuffer();
		
		result.append(object.getClass().getName());
		result.append(INSTANCE_TYPE_SEPERATOR);
		
		for(Object element : (Set<?>) object){
			result.append(ObjectUtil.marshal(element));
			result.append(SET_ENTRY_SEPERATOR);
		}
		return result.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object unmarshal(String string) {
		
		String[] type_date = string.split(INSTANCE_TYPE_SEPERATOR,2);
		if(type_date.length==2){
			List result = ReflectionUtil.createInstance(type_date[0], List.class);
			for(String entry_data : type_date[1].split(SET_ENTRY_SEPERATOR)){
				result.add(ObjectUtil.unmarshal(Object.class, entry_data));
			}
			return result;
		} else {
			throw new IllegalArgumentException("Invalid data! '"+string+"'");
		}
	}

}
