package org.sidiff.editrule.recognition.pattern.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.editrule.recognition.util.MatchingHelper;
import org.sidiff.graphpattern.Matching;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.impl.MatchingImpl;

public class Domain extends MatchingImpl {
	
	protected EClass type;
	
	protected List<AttributeConstant> attributes;
	
	protected boolean collecting = true;
	
	protected LinkedHashMap<EObject, SelectionType> domain;
	
	protected Stack<Restriction> restrictions;
	
	// FIXME: size calculation!
//	protected int size;
	
	// FIXME: Use modCount of Hash-Map!?
//	protected boolean modified;
	
	protected MatchingHelper matchingHelper;
	
	public enum SelectionType {
		
		RESTRICTED,	// A restricted object of this domain
					// NOTE: All restricted objects are stored on the restriction stack (restriction history)
		ACCEPTED,	// A currently available object of this domain
		MARKED,		// A searched object (out of the accepted) of a previous path search
		SEARCHED; 	// A searched object (out of the accepted) on a visited node in the current path search
		
		// NOTE: Collection of accepted objects:
		// 1.   Search a path starting with a seeding object
		//      - Use all ACCEPTED/MARKED objects -> isSelected()
		//		- Set all objects on the path to SEARCHED
		// 2.   Remember the searched path
		//      - Set all SEARCHED objects to MARKED
		// N.   Search the next path (1. + 2.)
		// N+1. Finally set all MARKED to ACCEPTED and all ACCEPTED (unmarked) to RESTRICTED
		
		public static boolean isSelected(SelectionType type) {
			return ((type != null) && !type.equals(RESTRICTED));
		}
	}
	
	public void initialize() {
		this.type = getNode().getType();
		this.domain = new LinkedHashMap<EObject, SelectionType>();
		this.restrictions = new Stack<Restriction>();
//		this.size = 0;
	}
	
	public void initialize(MatchingHelper matchingHelper) {
		initialize();
		this.matchingHelper = matchingHelper;
	}
	
	public Map<EObject, SelectionType> getDomain() {
		return domain;
	}
	
	public EClass getType() {
		return type;
	}
	
	public List<AttributeConstant> getAttributes() {
		if (attributes == null) {
			attributes = new ArrayList<>(5);
		}
		
		return attributes;
	}

	public boolean isCollecting() {
		return collecting;
	}

	public void setCollecting(boolean collecting) {
		this.collecting = collecting;
	}
	
	@Override
	public Iterator<EObject> iterator() {
//		return new LockedSelectionIterator(this);
		return new IteratorSelection(this);
	}
	
	public Iterator<EObject> getSearchedMatchIterator() {
//		return new LockedSelectionIterator(this);
		return new IteratorSearched(this);
	}

	/**
	 * @return A modifiable (unreflected) copy of the selected matches. 
	 */
	public List<EObject> getDomainCopy() {
		ArrayList<EObject> selected = new ArrayList<>();
		
		for(EObject selectedMatch : domain.keySet()) {
			if (SelectionType.isSelected(domain.get(selectedMatch))) {
				selected.add(selectedMatch);
			}
		}
		
		selected.trimToSize();
		return selected;
	}

	@Override
	public void add(EObject localMatch) {
		assert (localMatch != null) : "Null match!";
		
		if (ConstraintTester.check(this, localMatch)) {
			SelectionType selection = domain.get(localMatch);
			
			if ((selection == null) || !selection.equals(SelectionType.ACCEPTED)) {
				domain.put(localMatch, SelectionType.ACCEPTED);
//				modified = true;
//				++size;
				// TODO: return true;
			}
		}
		
		// TODO: return false;
	}
	
	/**
	 * @param element
	 *            An new element of the domain to mark as searched.
	 * @return <code>true</code> if the domain was changed; <code>false</code>
	 *         otherwise.
	 */
	public boolean addSearchedMatch(EObject localMatch) {
		assert (localMatch != null) : "Null match!";
		
		if (ConstraintTester.check(this, localMatch)) {
			SelectionType selection = domain.get(localMatch);
			
			if ((selection == null) || !selection.equals(SelectionType.SEARCHED)) {
				domain.put(localMatch, SelectionType.SEARCHED);
//				modified = true;
//				++size;
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean remove(EObject localMatch) {
		
		if (domain.remove(localMatch) != null) {
//			modified = true;
//			--size;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(EObject localMatch) {
		return SelectionType.isSelected(domain.get(localMatch));
	}
	
	public boolean contains(EObject localMatch, SelectionType selection) {
		return (domain.get(localMatch) == selection);
	}
	
	public boolean containsAnySearched() {
		return domain.containsValue(SelectionType.SEARCHED);
	}
	
	@Override
	public int size() {
		int i = 0;
		
		for (Iterator<?> iterator = iterator(); iterator.hasNext();) {
			iterator.next();
			++i;
		}
		
		return i;
//		return size;// FIXME
	}

	@Override
	public boolean isEmpty() {
		return !domain.containsValue(SelectionType.ACCEPTED);
//		return (size == 0); // FIXME
	}
	
	public boolean isSelected(EObject match) {
		return (SelectionType.isSelected(domain.get(match))) ;
	}
	
	public void mark(EObject element) {
		// mark existing (non restricted) match:
		SelectionType selection = domain.get(element);
		
		if ((selection != null) && selection.equals(SelectionType.ACCEPTED)) {
			domain.put(element, SelectionType.MARKED);
//			modified = true;
		}
	}
	
	/**
	 * @param element
	 *            An element of the domain to mark as searched.
	 * @return <code>true</code> if the domain was changed; <code>false</code>
	 *         otherwise.
	 */
	public boolean searched(EObject element) {
		// mark existing (non restricted) match:
		SelectionType selection = domain.get(element);
		
		if (selection != null) {
			if (!selection.equals(SelectionType.SEARCHED) && SelectionType.isSelected(selection)) {
				domain.put(element, SelectionType.SEARCHED);
//				modified = true;
				return true;
			}
		}
		
		return false;
	}
	
	public void markSearched() {
		for (Entry<EObject, SelectionType> element : domain.entrySet()) {
			if (element.getValue().equals(SelectionType.SEARCHED)) {
				element.setValue(SelectionType.MARKED);
//				modified = true;
			}
		}
	}
	
	public void restrictUnmarked(NodePattern restrictionSource) {
		Collection<EObject> restriction = new ArrayList<>(); 
		
		// Set marked selection as restricted:
		for (Entry<EObject, SelectionType> element : domain.entrySet()) {
			if (element.getValue().equals(SelectionType.MARKED)) {
				element.setValue(SelectionType.ACCEPTED);
//				modified = true;
			} else {
				if (!element.getValue().equals(SelectionType.RESTRICTED)) {
					element.setValue(SelectionType.RESTRICTED);
					restriction.add(element.getKey());
//					modified = true;
//					--size;
				}
			}
		}
		
		// Save restriction history:
		if (!restriction.isEmpty()) {
			restrictions.push(new Restriction(restrictionSource, restriction));
		}
	}
	
	public void restriction(NodePattern restrictionSource, EObject selection) {
		SelectionType selectionType = domain.get(selection);

		// Further restriction necessary?
		if ((selectionType != null) && SelectionType.isSelected(selectionType)) {
			if (!selectionType.equals(SelectionType.RESTRICTED)) {
				domain.put(selection, SelectionType.RESTRICTED);
//				modified = true;
//				--size;
				
				// Save restriction history:
				restrictions.push(new Restriction(restrictionSource, Collections.singletonList(selection)));
			}
		}
	}
	
	public void undoRestriction(NodePattern restrictionSource) {
		
		// Revert the selection:
		while (!restrictions.isEmpty() && (restrictions.lastElement().getSource() == restrictionSource)) {
			for (EObject restricted : restrictions.lastElement().getRestrictions()) {
				add(restricted);
			}
			restrictions.pop();
		}
	}
	
	public void clearSelection() {
		
		for (Entry<EObject, SelectionType> element : domain.entrySet()) {
			if (!element.getValue().equals(SelectionType.ACCEPTED)) {
				element.setValue(SelectionType.ACCEPTED);
//				modified = true;
//				++size;
			}
		}
		
		restrictions.clear();
	}
	
	public void clearMatches() {
		domain.clear();
		restrictions.clear();
//		size = 0;
	}
	
	/**
	 * @param evaluation
	 *            An node evaluation adapter.
	 * @return The underlying navigable data store.
	 */
	public static Domain get(Matching matching) {
		if (matching instanceof Domain) {
			return (Domain) matching;
		} else {
			throw new RuntimeException("Missing Domain!");
		}
	}

	/**
	 * @param node
	 *            An node pattern.
	 * @return The underlying navigable data store.
	 */
	public static Domain get(NodePattern node) {
		Matching ds = (node.getMatching() != null) ? node.getMatching() : null;
		
		if (ds instanceof Domain) {
			return (Domain) ds;
		} else {
			throw new RuntimeException("Missing Domain!");
		}
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("Domain: " + getNode() + "\n");
		
		for (Entry<EObject, SelectionType> domainEntry : domain.entrySet()) {
			string.append("  <" + domainEntry.getValue() + "> " + domainEntry.getKey() + "\n");
		}
		
		return string.toString();
	}
}
