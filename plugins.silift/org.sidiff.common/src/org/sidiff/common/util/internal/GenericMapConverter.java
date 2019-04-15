package org.sidiff.common.util.internal;

import java.util.Map;
import java.util.Map.Entry;

import org.sidiff.common.util.*;

public class GenericMapConverter implements ObjectConverter {
	

	private static final String MAP_ASSIGN = "->";
	private static final String LIST_ENTRY_SEPERATOR = ",";
	private static final String INSTANCE_TYPE_SEPERATOR = "%";

	@Override
	public Class<?> getType() {
		return Map.class;
	}

	@Override
	public String marshal(Object object) {
		assert (object instanceof Map<?,?>) : "Using MapConverter with no Map!";
		
		StringBuffer result = new StringBuffer();
		
		result.append(object.getClass().getName());
		result.append(INSTANCE_TYPE_SEPERATOR);
		
		for(Entry<?,?> entry : ((Map<?,?>)object).entrySet()){
			
			result.append(ObjectUtil.marshal(entry.getKey()));
			result.append(MAP_ASSIGN);
			result.append(ObjectUtil.marshal(entry.getValue()));
			result.append(LIST_ENTRY_SEPERATOR);
		}
		return result.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object unmarshal(String string) {
		
		String[] type_data = string.split(INSTANCE_TYPE_SEPERATOR,2);
		if(type_data.length==2){
			Map result = ReflectionUtil.createInstance(type_data[0], Map.class);
			for(String entry_data : type_data[1].split(LIST_ENTRY_SEPERATOR)){
				String[] key_data = entry_data.split(MAP_ASSIGN,2);
				result.put(ObjectUtil.unmarshal(Object.class, key_data[0]), ObjectUtil.unmarshal(Object.class, key_data[1]));
			}
			return result;
		} else {
			throw new IllegalArgumentException("Invalid data! '"+string+"'");
		}
	}

}
