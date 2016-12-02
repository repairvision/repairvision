package org.sidiff.graphpattern.wgraph.store;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.impl.NavigableDataStoreImpl;
import org.sidiff.graphpattern.wgraph.selection.MatchSelection;

public class NavigableMatchesDS extends NavigableDataStoreImpl {
	
	/**
	 * Edge -> Matched Object -> Target Matched Objects
	 */	
	private Map<EObject, Object[]> matches = new HashMap<>();
	
	private Map<EdgePattern, Integer> edgeIndex = new HashMap<>();
	
	private MatchSelection matchSelection = new MatchSelection();
	
	public MatchSelection getMatchSelection() {
		return matchSelection;
	}
	
	@Override
	public void initialize() {
		
		// Create edge index:
		for (EdgePattern outgoingEdge : getEvaluation().getNode().getOutgoings()) {
			edgeIndex.put(outgoingEdge, edgeIndex.size());
		}
		
		// Incoming edges with no opposite:
		for (EdgePattern incomingEdge : getEvaluation().getNode().getIncomings()) {
			if (incomingEdge.getOpposite() == null) {
				edgeIndex.put(incomingEdge, edgeIndex.size());
			}
		}
	}
	
	@Override
	public Iterator<EObject> getMatchIterator() {
		return matches.keySet().iterator(); // TODO: Unmodifiable
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
		if (!matches.containsKey(localMatch)) {
			matches.put(localMatch, null);
		}
	}
	
	@Override
	public boolean removeMatch(EObject localMatch) {
		boolean contained = matches.containsKey(localMatch);
		
		if (contained) {
			matches.remove(localMatch);
		}
		
		return contained;
	}
	
	@Override
	public boolean containsMatch(EObject localMatch) {
		return matches.containsKey(localMatch);
	}
	
	@Override
	public void clearMatches() {
		matches.clear();
	}
	
	@Override
	public Iterator<EObject> getRemoteMatchIterator(EObject localMatch, EdgePattern edge) {
		return getEdgeMatches(localMatch, edge).iterator(); // TODO: Unmodifiable
	}
	
	
	@Override
	public int getRemoteMatchSize(EObject localMatch, EdgePattern edge) {
		return getEdgeMatchSize(localMatch, edge);
	}
	
	@Override
	public boolean isEmptyRemoteMatch(EObject localMatch, EdgePattern edge) {
		return getEdgeMatchSize(localMatch, edge) == 0;
	}
	
	@Override
	public void addRemoteMatch(EObject localMatch, EObject remoteMatch, EdgePattern edge) {
		Integer edgeFieldIndex = getEdgeIndex(edge);
		Object[] edgeFields = matches.get(localMatch);
		
		// Is known local match?
		if (edgeFields == null) {
			edgeFields = initializeEdgeMatch(localMatch);
		}
		
//		// TODO: [TEST-CODE]: Print graph:
//		if (!getEvaluation().getNode().getType().equals(EcorePackage.eINSTANCE.getEReference())) {
//			System.out.println("graph.addDirectedEdge(\""+ Integer.toHexString(localMatch.hashCode()) +"\", \""+ Integer.toHexString(remoteMatch.hashCode()) +"\");");
//		}
		
		addEdgeMatch(edgeFields, edgeFieldIndex, remoteMatch);
	}
	
	@Override
	public boolean removeRemoteMatch(EObject localMatch, EObject remoteMatch, EdgePattern edge) {
		return removeEdgeMatch(localMatch, remoteMatch, edge);
	}
	
	@Override
	public boolean containsRemoteMatch(EObject localMatch, EObject remoteMatch, EdgePattern edge) {
		return containsEdgeMatch(localMatch, remoteMatch, edge);
	}
	
	@Override
	public void clearRemoteMatches(EObject localMatch, EdgePattern edge) {
		clearEdgeMatches(localMatch, edge);
	}
	
	private Integer getEdgeIndex(EdgePattern edge) {
		Integer edgeFieldIndex = edgeIndex.get(edge);
		
		// Incoming edge with opposite?
		if (edgeFieldIndex == null) {
			edgeFieldIndex = edgeIndex.get(edge.getOpposite());
		}
		
		return edgeFieldIndex;
	}
	
	private Object[] initializeEdgeMatch(EObject localMatch) {
		Object[] edgeFields = new Object[edgeIndex.size()];
		matches.put(localMatch, edgeFields);
		return edgeFields;
	}
	
	@SuppressWarnings("unchecked")
	private Set<EObject> getEdgeMatches(EObject localMatch, EdgePattern edge) {
		Integer edgeFieldIndex = getEdgeIndex(edge);
		Object[] edgeFields = matches.get(localMatch);
		
		// Is known local match?
		if (edgeFields == null) {
			return Collections.emptySet();
		}
		
		Object edgeField = edgeFields[edgeFieldIndex];
		
		// Empty entry:
		if (edgeField == null) {
			return Collections.emptySet();
		}
		
		// Multiple entries:
		else if (edgeField instanceof Set) {
			return (Set<EObject>) edgeField;
		} 
		
		// Single entry:
		else if (edgeField instanceof EObject) {
			return Collections.singleton((EObject) edgeField);
		}
		
		else {
			assert false : "Unknown entry type. We should never get here!";
		}
		
		return Collections.emptySet();
	}
	
	@SuppressWarnings("unchecked")
	private int getEdgeMatchSize(EObject localMatch, EdgePattern edge) {
		Integer edgeFieldIndex = getEdgeIndex(edge);
		Object[] edgeFields = matches.get(localMatch);
		
		// Is known local match?
		if (edgeFields == null) {
			return 0;
		}
		
		Object edgeField = edgeFields[edgeFieldIndex];
		
		// Empty entry:
		if (edgeField == null) {
			return 0;
		}
		
		// Multiple entries:
		else if (edgeField instanceof Set) {
			return ((Set<EObject>) edgeField).size();
		} 
		
		// Single entry:
		else if (edgeField instanceof EObject) {
			return 1;
		}
		
		else {
			assert false : "Unknown entry type. We should never get here!";
		}
		
		return -1;
	}
	
	@SuppressWarnings("unchecked")
	private void addEdgeMatch(Object[] edgeFields, Integer edgeFieldIndex, EObject remoteMatch) {
		
		// Add edge:
		Object edgeField = edgeFields[edgeFieldIndex];
		
		// Empty entry:
		if (edgeField == null) {
			edgeFields[edgeFieldIndex] = remoteMatch;
		}
		
		// Multiple entries:
		else if (edgeField instanceof Set) {
			((Set<EObject>) edgeField).add(remoteMatch);
		} 
		
		// Single entry:
		else if (edgeField instanceof EObject) {
			if (edgeFields[edgeFieldIndex] != remoteMatch) {
				Set<EObject> sourceMatches = new HashSet<>();
				sourceMatches.add((EObject) edgeField);
				sourceMatches.add(remoteMatch);
				
				edgeFields[edgeFieldIndex] = sourceMatches;	
			}
		}
		
		else {
			assert false : "Unknown entry type. We should never get here!";
		}
	}
	
	@SuppressWarnings("unchecked")
	private boolean removeEdgeMatch(EObject localMatch, EObject remoteMatch, EdgePattern edge) {
		Integer edgeFieldIndex = getEdgeIndex(edge);
		Object[] edgeFields = matches.get(localMatch);
		
		// Is known local match?
		if (edgeFields == null) {
			return false;
		}
		
		Object edgeField = edgeFields[edgeFieldIndex];
		
		// Empty entry:
		if (edgeField == null) {
			return false;
		}
		
		// Multiple entries:
		else if (edgeField instanceof Set) {
			return ((Set<EObject>) edgeField).remove(remoteMatch);
		} 
		
		// Single entry:
		else if (edgeField instanceof EObject) {
			edgeFields[edgeFieldIndex] = null;
			return true;
		}
		
		else {
			assert false : "Unknown entry type. We should never get here!";
		}
		
		return false;
	}
	
	@SuppressWarnings("unchecked")
	private boolean containsEdgeMatch(EObject localMatch, EObject remoteMatch, EdgePattern edge) {
		Integer edgeFieldIndex = getEdgeIndex(edge);
		Object[] edgeFields = matches.get(localMatch);
		
		// Is known local match?
		if (edgeFields == null) {
			return false;
		}
		
		Object edgeField = edgeFields[edgeFieldIndex];
		
		// Empty entry:
		if (edgeField == null) {
			return false;
		}
		
		// Multiple entries:
		else if (edgeField instanceof Set) {
			return ((Set<EObject>) edgeField).contains(remoteMatch);
		} 
		
		// Single entry:
		else if (edgeField instanceof EObject) {
			return edgeField == remoteMatch;
		}
		
		else {
			assert false : "Unknown entry type. We should never get here!";
		}
		
		return false;
	}
	
	private void clearEdgeMatches(EObject localMatch, EdgePattern edge) {
		Integer edgeFieldIndex = getEdgeIndex(edge);
		Object[] edgeFields = matches.get(localMatch);
		
		// Is known local match?
		if (edgeFields == null) {
			return;
		}
		
		edgeFields[edgeFieldIndex] = null;
	}
}
