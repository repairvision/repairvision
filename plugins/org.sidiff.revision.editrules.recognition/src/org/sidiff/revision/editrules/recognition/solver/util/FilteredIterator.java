package org.sidiff.revision.editrules.recognition.solver.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

public class FilteredIterator implements Iterator<EObject> {

	private Iterator<EObject> matchIterator;

	private Set<EObject> filter;
	
	private EObject next = null;
	
	public FilteredIterator(Iterator<EObject> matchIterator, Set<EObject> filter) {
		this.matchIterator = matchIterator;
		this.filter = filter;
	}

	@Override
	public boolean hasNext() {

		if (next != null) {
			return true;
		} else {
			while (matchIterator.hasNext()) {
				next = matchIterator.next();

				if (!filter.contains(next)) {
					return true;
				}
			}
			next = null;
		}
		return false;
	}


	@Override
	public EObject next() {

		if (hasNext()) {
			EObject tmp_next = next;
			next = null;
			return tmp_next;
		} else {
			throw new NoSuchElementException();
		}
	}
}
