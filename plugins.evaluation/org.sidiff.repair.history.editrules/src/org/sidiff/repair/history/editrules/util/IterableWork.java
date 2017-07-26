package org.sidiff.repair.history.editrules.util;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;

public class IterableWork<T> implements Iterable<T> {
	
	public int getWork() {
		return IProgressMonitor.UNKNOWN;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<T> iterator() {
		return (Iterator<T>) Collections.emptyList();
	}
}
