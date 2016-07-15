package org.sidiff.consistency.repair.complement.construction.match;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Node;

/**
 * A pre-match for a complement rule.
 */
// TODO: Make this extends the Henshin MatchImpl!?
public class ComplementMatch {

	private Map<Node, EObject> nodeMatches;
	
//	private Set<NestedCondition> unfulfilledACs = new HashSet<>();
//	
//	private Set<NestedCondition> ignoredACs = new HashSet<>();

	public ComplementMatch() {
	}
	
	public ComplementMatch(Map<Node, EObject> nodeMatches) {
		this.nodeMatches = nodeMatches;
	}

	public Map<Node, EObject> getNodeMatches() {
		return nodeMatches;
	}

	public void setNodeMatches(Map<Node, EObject> nodeMatches) {
		this.nodeMatches = nodeMatches;
	}

// TODO: ACs
//	public Set<NestedCondition> getUnfulfilledACs() {
//		return unfulfilledACs;
//	}
//
//	public void setUnfulfilledACs(Set<NestedCondition> unfulfilledACs) {
//		this.unfulfilledACs = unfulfilledACs;
//	}
//
//	public Set<NestedCondition> getIgnoredACs() {
//		return ignoredACs;
//	}
//
//	public void setIgnoredACs(Set<NestedCondition> ignoredACs) {
//		this.ignoredACs = ignoredACs;
//	}
}
