package org.sidiff.common.util;

import java.util.HashMap;
import java.util.Map;

public class ObjectUtil {
	
	protected static final String TYPE_SEPERATOR = ":";
	
	private static Map<Class<?>, ObjectConverter> converter = new HashMap<Class<?>, ObjectConverter>(); 
	
	public static void registerConverter(ObjectConverter converter){
		
		ObjectUtil.converter.put(converter.getType(), converter);
	}

	public static String marshal(Object object){
		
		ObjectConverter converter = findConverter(object.getClass());

		if (converter!=null){
			StringBuffer result = new StringBuffer();
			
			result.append(converter.getType().getName());
			result.append(TYPE_SEPERATOR);
			result.append(converter.marshal(object));
			return result.toString();
		} else {
			throw new IllegalArgumentException("Cannot convert "+object.getClass().getName()+" (Missing Converter)");
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T unmarshal(Class<T> type, String string) {

		String[] type_data = string.split(TYPE_SEPERATOR, 2);
		if (type_data.length == 2) {
			try {
				ObjectConverter converter = findConverter(ReflectionUtil.loadClass(type_data[0]));
				if (converter != null) {
					return (T) converter.unmarshal(type_data[1]);
				} else {
					throw new IllegalArgumentException("Cannot convert " + type_data[0] + " (Missing Converter)");
				}
			} catch (Exception e) {
				throw new IllegalArgumentException("Cannot convert " + type_data[0] + " (cannot access class)");
			}
		} else {
			throw new IllegalArgumentException("Corrupt data \n'" + string + "'");
		}

	}
	
	private static ObjectConverter findConverter(Class<?> type){

		if (type != null) {
			if (converter.containsKey(type)) {
				return converter.get(type);
			} else {
				for(Class<?> clazz : ReflectionUtil.computePolymorism(type)){
					if(converter.containsKey(clazz)){
						return converter.get(clazz);
					}
				}
			}
			return null;
		} else {
			throw new IllegalThreadStateException("missing type! (null)");
		}
	}
}
