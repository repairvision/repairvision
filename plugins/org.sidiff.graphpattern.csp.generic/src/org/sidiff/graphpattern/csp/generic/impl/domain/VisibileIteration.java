package org.sidiff.graphpattern.csp.generic.impl.domain;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

public class VisibileIteration<D> implements Iterator<D> {
	
	private Iterator<Entry<D, ValueColor>> domainIterator;
	
	private Entry<D, ValueColor> next;
	
	public VisibileIteration(Domain<D> domain) {
		domainIterator = domain.values.entrySet().iterator();
		findNext();
	}
	
	@Override
	public D next() {
		
		if (next == null)  {
			throw new NoSuchElementException();
		}
		
		// NOTE: We need to cache the next value because future restrictions
		// would change the value of hasNext(). next() may only be called again
		// if the restriction is in the same state as the iterator was created.
		Entry<D, ValueColor> tmp_next = next;
		findNext();

		return tmp_next.getKey();
	}
	
	@Override
	public boolean hasNext() {
		return (next != null);
	}
	
	private void findNext() {
		next = null;
		
		// Find next not restricted match:
		while (domainIterator.hasNext()) {
			Entry<D, ValueColor> tmp_next = domainIterator.next();

			if (tmp_next.getValue().isVisible()) {
				next = tmp_next;
				break;
			}
		}
	}
}
