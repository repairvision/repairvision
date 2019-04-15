package org.sidiff.common.util.internal;

import java.util.*;

import org.sidiff.common.util.StringResolver;
import org.sidiff.common.util.StringUtil;

/**
 * StringResolver to compute the string representation of a hash table.
 * The computation of the string representation of the contained keys and objects is again
 * delegated to the StringUtil. 
 */
public class HashTableStringResolver implements StringResolver {

	@Override
	public Class<?> dedicatedClass() {
		return Hashtable.class;
	}

	@Override
	public String resolve(Object obj) {
		if (!(obj instanceof Hashtable<?,?>))
			return null;
		Hashtable<?, ?> hashtable = (Hashtable<?, ?>)obj;
		StringBuffer result = new StringBuffer();
		Iterator<?> keys = hashtable.keySet().iterator();
		while (keys.hasNext()) {
			Object key = keys.next();
			Object value = hashtable.get(key);
			result.append(StringUtil.resolve(key) + ":" + StringUtil.resolve(value) + ((keys.hasNext()) ? "," : ""));
		}
		return result.toString();
	}
}