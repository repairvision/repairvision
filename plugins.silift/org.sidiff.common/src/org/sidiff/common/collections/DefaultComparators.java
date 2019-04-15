package org.sidiff.common.collections;

import java.util.*;

/**
 * This class can be used to create some default comparators.
 */
@SuppressWarnings("unchecked")
public class DefaultComparators {

	private DefaultComparators() {
	};

	/**
	 * Creates a comparator that compares objects based on their hash value
	 * 
	 * @return Comparator
	 */
	public static <T> Comparator<T> getHashComparator(Class<T> type) {
		return ((Comparator<T>) new Comparator() {

			Map<Object, Long> identities = null;
			long nextID = 1;

			private Long getIdentity(Object o) {
			
				Long identity = identities.get(o);

				if (identity == null) {
					identity = nextID++;
					identities.put(o, identity);
				}

				return identity;
			}

			@Override
			public int compare(Object o1, Object o2) {
				int i = o1.hashCode() - o2.hashCode();
				if (i == 0 && o1 != o2) {
					
					if (identities == null) identities = new HashMap<Object, Long>();
					
					Long identityO1 = getIdentity(o1);
					Long identityO2 = getIdentity(o2);
					
					return identityO1.compareTo(identityO2);
					
				}
				return i;
			}
		});
	}
}
