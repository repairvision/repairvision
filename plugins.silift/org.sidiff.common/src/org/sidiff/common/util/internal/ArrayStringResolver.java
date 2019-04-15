package org.sidiff.common.util.internal;

import org.sidiff.common.util.StringResolver;
import org.sidiff.common.util.StringUtil;

/**
 * StringResolver to compute the string representation of an array.
 * The computation of the string representation of the values is again
 * delegated to the StringUtil. 
 */
public class ArrayStringResolver implements StringResolver {

	@Override
	public Class<?> dedicatedClass() {
		return Object[].class;
	}

	@Override
	public String resolve(Object obj) {
		if (!(obj instanceof Object[]))
			return null;
		Object[] array = (Object[])obj;
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			result.append(StringUtil.resolve(array[i]));
			if ((i + 1) < array.length) {
				result.append(",");
			}
		}
		return result.toString();
	}
}