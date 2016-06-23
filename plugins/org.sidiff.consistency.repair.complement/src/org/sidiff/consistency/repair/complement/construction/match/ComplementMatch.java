package org.sidiff.consistency.repair.complement.construction.match;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;

/**
 * A pre-match for a complement rule.
 */
public class ComplementMatch {

	private Map<Node, EObject> nodeMatches;
	
	private Set<NestedCondition> unfulfilledACs = new HashSet<>();
	
	private Set<NestedCondition> ignoredACs = new HashSet<>();

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

	public Set<NestedCondition> getUnfulfilledACs() {
		return unfulfilledACs;
	}

	public void setUnfulfilledACs(Set<NestedCondition> unfulfilledACs) {
		this.unfulfilledACs = unfulfilledACs;
	}

	public Set<NestedCondition> getIgnoredACs() {
		return ignoredACs;
	}

	public void setIgnoredACs(Set<NestedCondition> ignoredACs) {
		this.ignoredACs = ignoredACs;
	}
}
