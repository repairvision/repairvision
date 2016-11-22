package org.sidiff.consistency.graphpattern.matcher.data.selection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.matching.IMatching;
import org.sidiff.consistency.graphpattern.matcher.tools.MatchingHelper;

/**
 * A view that shows the selection of the data store as a match.
 * 
 * @author Manuel Ohrndorf
 */
public abstract class SelectionMatching implements IMatching {

	protected boolean selectionModified = false;
	
	@Override
	public Iterator<EObject> getMatch(NodePattern node) {
		if (!selectionModified) {
			return MatchingHelper.getDataStore(node).getMatchSelection().getSelectedMatches();
		} else {
			throw new ConcurrentModificationException();
		}
	}
	
	@Override
	public EObject getFirstMatch(NodePattern node) {
		if (!selectionModified) {
			Iterator<EObject> matchIt = getMatch(node);
			
			if (matchIt.hasNext()) {
				return matchIt.next();
			} else {
				return null;
			}
		} else {
			throw new ConcurrentModificationException();
		}
	}

	public boolean isSelectionModified() {
		return selectionModified;
	}

	public void setSelectionModified(boolean selectionModified) {
		this.selectionModified = selectionModified;
	}
}
