package org.sidiff.consistency.complement.construction;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Action;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.complement.construction.match.ComplementMatch;
import org.sidiff.consistency.complement.construction.match.EditRuleEdgeMatch;
import org.sidiff.consistency.complement.construction.match.EditRuleMatch;
import org.sidiff.consistency.complement.construction.match.EditRuleNodeMatch;
import org.sidiff.consistency.complement.util.ComplementUtil;

/**
 * Constructs the complement-rule = source-rule (-) partial-edit-rule-match
 * 
 * @author Manuel Ohrndorf
 */
public abstract class ComplementConstructor {

	protected Rule sourceRule;
	
	public ComplementConstructor(Rule sourceRule) {
		this.sourceRule = sourceRule;
	}
	
	/**
	 * @param sourceRuleMatching
	 *            A partial (edit-rule) matching of the partially executed source-rule.
	 * @return The rule which complements the partial partially executed source-rule.
	 */
	public ComplementRule createComplementRule(Collection<EditRuleMatch> sourceRuleMatching) {
		
		// Derive complement rule:
		ComplementRule complement = deriveComplementRule(sourceRuleMatching); 
		
		// Create the complements pre-match: 
		List<ComplementMatch> preMatches = initializeComplementPrematch(complement, sourceRuleMatching);
		
		// Get unfulfilled application conditions:
		for (ComplementMatch preMatch : preMatches) {
			initializeApplicationConditions(complement, preMatch);
		}
		
		return complement;
	}
	
	private ComplementRule deriveComplementRule(Collection<EditRuleMatch> sourceRuleMatching) {

		// Create copy of the source rule:
		 Map<EObject, EObject> copyTrace = ComplementUtil.deepCopy(sourceRule);
		 Rule complementRule = (Rule) copyTrace.get(sourceRule);
		
		// Initialize complement rule:
		ComplementRule complement = new ComplementRule(sourceRule, complementRule);
		
		// Substitute already executed edges:
		for (EditRuleMatch sourceRuleMatch : sourceRuleMatching) {
			if (sourceRuleMatch instanceof EditRuleEdgeMatch) {
				Edge sourceEdge = ((EditRuleEdgeMatch) sourceRuleMatch).getEdge();
				Edge complementEdge = (Edge) copyTrace.get(sourceEdge);
				
				// Delete-Edge:
				if (sourceRuleMatch.getAction().equals(Type.DELETE)) {
					// Remove edge from source-rule:
					EcoreUtil.remove(complementEdge);
				}
				
				// Create-Edge:
				else if (sourceRuleMatch.getAction().equals(Type.CREATE)) {
					// Transform create-edge to preserve-edge:
					complementEdge.setAction(new Action(Type.PRESERVE));
				}
			}
		}
		
		// Substitute already executed nodes:
		for (EditRuleMatch sourceRuleMatch : sourceRuleMatching) {
			if (sourceRuleMatch instanceof EditRuleNodeMatch) {
				Node sourceNode = ((EditRuleNodeMatch) sourceRuleMatch).getNode();
				Node complementNode = (Node) copyTrace.get(sourceNode);
				
				// Delete-Node:
				if (sourceRuleMatch.getAction().equals(Type.DELETE)) {
					// Remove dangling remove edges:
					for (Edge incoming : complementNode.getIncoming()) {
						EcoreUtil.remove(incoming);
					}
					for (Edge outgoing : complementNode.getOutgoing()) {
						EcoreUtil.remove(outgoing);
					}
					
					// Remove node from source-rule:
					EcoreUtil.remove(complementNode);
				}
				
				// Create-Node:
				else  if (sourceRuleMatch.getAction().equals(Type.CREATE)) {
					// Transform create-node to preserve-node:
					complementNode.setAction(new Action(Type.PRESERVE));
					complement.addTrace(sourceNode, complementNode);
				} else {
					// Unchanged node: (save trace)
					complement.addTrace(sourceNode, complementNode);
				}
			}
		}

		return complement;
	}

	protected abstract List<ComplementMatch> initializeComplementPrematch(
			ComplementRule complement, Collection<EditRuleMatch> sourceRuleMatching);
		
	private void initializeApplicationConditions(ComplementRule complement, ComplementMatch preMatch) {
		Set<NestedCondition> unfulfilledACs = new HashSet<>(sourceRule.getLhs().getNestedConditions());
		preMatch.setUnfulfilledACs(unfulfilledACs);
		complement.recheckAllApplicationConditions(preMatch);
	}
}
