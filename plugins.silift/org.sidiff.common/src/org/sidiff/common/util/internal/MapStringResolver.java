package org.sidiff.common.util.internal;

import java.util.*;

import org.sidiff.common.util.StringResolver;
import org.sidiff.common.util.StringUtil;

/**
 * StringResolver to compute the string representation of a map.
 * The computation of the string representation of the contained keys and objects is again
 * delegated to the StringUtil. 
 */
public class MapStringResolver implements StringResolver {

	@Override
	public Class<?> dedicatedClass() {
		return Map.class;
	}

	@Override
	public String resolve(Object obj) {
		if (!(obj instanceof Map<?,?>))
			return null;
		Map<?, ?> map = (Map<?, ?>)obj;
		StringBuffer result = new StringBuffer();
		Iterator<?> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			Object key = iter.next();
			result.append(StringUtil.resolve(key));
			result.append("(");
			result.append(StringUtil.resolve(map.get(key)));
			result.append(")");
			if (iter.hasNext()) {
				result.append(",");
			}
		}
		return result.toString();
	}
}