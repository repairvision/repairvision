package org.sidiff.common.util.internal;

import java.util.Collection;
import java.util.Iterator;

import org.sidiff.common.util.StringResolver;
import org.sidiff.common.util.StringUtil;

/**
 * StringResolver to compute the string representation of a collection.
 * The computation of the string representation of the contained objects is again
 * delegated to the StringUtil. 
 */
public class CollectionStringResolver implements StringResolver {

	@Override
	public Class<?> dedicatedClass() {
		return Collection.class;
	}

	@Override
	public String resolve(Object obj) {
		if (!(obj instanceof Collection<?>))
			return null;
		Collection<?> collection = (Collection<?>)obj;
		StringBuffer result = new StringBuffer();
		Iterator<?> iter = collection.iterator();
		while (iter.hasNext()) {
			result.append(StringUtil.resolve(iter.next()));
			if (iter.hasNext()) {
				result.append(",");
			}
		}
		return result.toString();
	}
}