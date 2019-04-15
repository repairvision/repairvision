//TODO Check whether to keep this code or delete it!
package org.sidiff.common.collections.internal;

import java.util.Iterator;
import java.util.Set;

/**
 * Implements a set class whose content is represented by a passed iterator.
 * 
 *
 * @param <E> The type parameter which indicates the type of elements used in collection(s).
 */
@Deprecated
public class IteratorSetView<T> extends IteratorCollectionView<T> implements Set<T>
{
	
	/**
	 * Constructor.
	 * @param iterator The underlying iterator.
	 */
	public IteratorSetView (Iterator<? extends T> iterator)	{
		super (iterator);
	}
	
}
