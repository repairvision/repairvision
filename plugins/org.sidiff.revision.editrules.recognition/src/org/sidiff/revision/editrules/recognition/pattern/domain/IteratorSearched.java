package org.sidiff.revision.editrules.recognition.pattern.domain;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain.SelectionType;

public class IteratorSearched implements Iterator<EObject> {
	
	private Iterator<Entry<EObject, SelectionType>> matchIterator;
	
	private Entry<EObject, SelectionType> next;
	
	public IteratorSearched(Domain matchSelection) {
		matchIterator = matchSelection.domain.entrySet().iterator();
		findNext();
	}
	
	@Override
	public EObject next() {
		
		if (next == null)  {
			throw new NoSuchElementException();
		}
		
		// NOTE: We need to cache the next value because future restrictions
		// would change the value of hasNext(). next() may only be called again
		// if the restriction is in the same state as the iterator was created.
		Entry<EObject, SelectionType> tmp_next = next;
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
		while (matchIterator.hasNext()) {
			Entry<EObject, SelectionType> tmp_next = matchIterator.next();

			if (tmp_next.getValue().equals(SelectionType.SEARCHED)) {
				next = tmp_next;
				break;
			}
		}
	}
}
