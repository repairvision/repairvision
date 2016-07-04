package org.sidiff.consistency.graphpattern.matcher.data.selection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.NodePattern;

public class MatchSelection {

	// Selection -> Restricted-Selection
	protected LinkedHashMap<EObject, SelectionType> selectedMatches = new LinkedHashMap<EObject, SelectionType>();
	
	protected Stack<Restriction> restrictionHistory = new Stack<Restriction>();
	
	protected enum SelectionType {
		
		RESTRICTED,
		ACCEPTED,
		MARKED;
		
		public static boolean isAccepted(SelectionType type) {
			return ((type != null) && (type.equals(ACCEPTED) || type.equals(MARKED)));
		}
	}
	
	/**
	 * @return A modifiable (unreflected) copy of the selected matches. 
	 */
	public List<EObject> getMatch() {
		ArrayList<EObject> selected = new ArrayList<>();
		
		for(EObject selectedMatch : selectedMatches.keySet()) {
			if (SelectionType.isAccepted(selectedMatches.get(selectedMatch))) {
				selected.add(selectedMatch);
			}
		}
		
		selected.trimToSize();
		return selected;
	}
	
	public void selectMatches(Collection<EObject> selections) {
		for (EObject selection : selections) {
			assert (selection != null) : "Null selection!";
			selectedMatches.put(selection, SelectionType.ACCEPTED);
		}
	}
	
	public void selectMatch(EObject selection) {
		assert (selection != null) : "Null selection!";
		selectedMatches.put(selection, SelectionType.ACCEPTED);
	}
	
	public boolean isSelectedMatch(EObject match) {
		return (SelectionType.isAccepted(selectedMatches.get(match))) ;
	}
	
	public Iterator<EObject> getSelectedMatches() {
//		return new LockedSelectionIterator(this);
		return new SelectionIterator(this);
	}
	
	public void clearSelection() {
		selectedMatches.clear();
	}
	
	public void markSelection(Collection<EObject> marks) {
		for (EObject mark : marks) {
			selectedMatches.put(mark, SelectionType.MARKED);
		}
	}
	
	public void markSelection(EObject mark) {
		selectedMatches.put(mark, SelectionType.MARKED);
	}
	
	public void restrictSelection(NodePattern restrictionSource) {
		Collection<EObject> restriction = new ArrayList<>(); 
		
		// Set marked selection as restricted:
		for (Entry<EObject, SelectionType> selection : selectedMatches.entrySet()) {
			if (selection.getValue().equals(SelectionType.MARKED)) {
				selection.setValue(SelectionType.ACCEPTED);
			} else {
				selection.setValue(SelectionType.RESTRICTED);
				restriction.add(selection.getKey());
			}
		}
		
		// Save restriction history:
		// TODO: Handle empty restrictions...!?
		restrictionHistory.push(new Restriction(restrictionSource, restriction));
	}
	
	public void restrictSelection(NodePattern restrictionSource, EObject selection) {
		SelectionType selectionType = selectedMatches.get(selection);

		// Further restriction necessary?
		if ((selectionType != null) && SelectionType.isAccepted(selectionType)) {
			selectedMatches.put(selection, SelectionType.RESTRICTED);
			
			// Save restriction history:
			// TODO: Single object restrictions...
			restrictionHistory.push(new Restriction(restrictionSource, Collections.singletonList(selection)));
		}
	}
	
	public void undoRestrictSelection(NodePattern restrictionSource) {
		
		// Revert the selection:
		while (!restrictionHistory.isEmpty() && (restrictionHistory.lastElement().getSource() == restrictionSource)) {
			selectMatches(restrictionHistory.lastElement().getRestrictions());
			restrictionHistory.pop();
		}
	}
}
