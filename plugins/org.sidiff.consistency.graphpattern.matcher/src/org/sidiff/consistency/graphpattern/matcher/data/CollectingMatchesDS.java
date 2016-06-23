package org.sidiff.consistency.graphpattern.matcher.data;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.impl.DataStoreImpl;;

public class CollectingMatchesDS extends DataStoreImpl {

	private Set<EObject> matches = new HashSet<>();

	@Override
	public Iterator<EObject> getMatchIterator() {
		return matches.iterator(); // TODO: Unmodifiable
	}
	
	@Override
	public int getMatchSize() {
		return matches.size();
	}
	
	@Override
	public boolean isEmptyMatch() {
		return matches.isEmpty();
	}
	
	@Override
	public void addMatch(EObject localMatch) {
		if (!matches.contains(localMatch)) {
			matches.add(localMatch);
		}
	}
	
	@Override
	public boolean removeMatch(EObject localMatch) {
		return matches.remove(localMatch);
	}
	
	@Override
	public boolean containsMatch(EObject localMatch) {
		return matches.contains(localMatch);
	}
	
	@Override
	public void clearMatches() {
		matches.clear();
	}
}
