package org.sidiff.consistency.repair.lifting.api;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHSMinusRHSEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHSMinusRHSNodes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHSMinusLHSEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHSMinusLHSNodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.construction.match.ComplementMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleMatch;

/**
 * Represents a single repair operation.
 * 
 * @author Manuel Ohrndorf
 */
public class Repair {

	private ComplementRule complementRule;
	
	private ComplementMatch complementPreMatch;
	
	// TODO: Move this to ComplementRule!
	private List<GraphElement> historicChanges;
	
	// TODO: Move this to ComplementRule!
	private List<GraphElement> complementingChanges;
	
	/**
	 * @param complementRule
	 *            The container of the complement rule.
	 * @param complementPreMatch
	 *            The pre-match of the complement rule.
	 */
	public Repair(ComplementRule complementRule, ComplementMatch complementPreMatch) {
		super();
		this.complementRule = complementRule;
		this.complementPreMatch = complementPreMatch;
	}

	/**
	 * @return The corresponding partially executed edit-rule.
	 */
	public Rule getEditRule() {
		return complementRule.getSourceRule();
	}
	
	/**
	 * @param editRuleGraphElement
	 *            A node/edge of the edit rule.
	 * @return The corresponding node/edge of the complement rule.
	 */
	@SuppressWarnings("unchecked")
	public <G extends GraphElement> G getTrace(G editRuleGraphElement) {
		
		if (editRuleGraphElement instanceof Edge) {
			return (G) complementRule.getTrace((Edge) editRuleGraphElement);
		}
		
		else  if (editRuleGraphElement instanceof Node) {
			return (G) complementRule.getTrace((Node) editRuleGraphElement);
		}
		
		return null;
	}
	
	/**
	 * @return All already applied changes of the corresponding edit-rule.
	 */
	public List<GraphElement> getHistoricChanges() {
		
		if (historicChanges == null) {
			historicChanges = new ArrayList<>();
			
			for (Node deleteNode : getLHSMinusRHSNodes(getEditRule())) {
				if (!getComplementingChanges().contains(complementRule.getTrace(deleteNode))) {
					historicChanges.add(deleteNode);
				}
			}
			
			for (Edge deleteEdge : getLHSMinusRHSEdges(getEditRule())) {
				if (!getComplementingChanges().contains(complementRule.getTrace(deleteEdge))) {
					historicChanges.add(deleteEdge);
				}
			}
			
			for (Node createNode : getRHSMinusLHSNodes(getEditRule())) {
				if (!getComplementingChanges().contains(complementRule.getTrace(createNode))) {
					historicChanges.add(createNode);
				}
			}
			
			for (Edge createEdge : getRHSMinusLHSEdges(getEditRule())) {
				if (!getComplementingChanges().contains(complementRule.getTrace(createEdge))) {
					historicChanges.add(createEdge);
				}
			}
		}
		
		return historicChanges;
	}
	
	/**
	 * @return All missing changes of the corresponding edit-rule.
	 */
	public List<GraphElement> getComplementingChanges() {
		
		if (complementingChanges == null) {
			complementingChanges = new ArrayList<>();
			
			for (Node deleteNode : getLHSMinusRHSNodes(complementRule.getComplementRule())) {
				complementingChanges.add(deleteNode);
			}
			
			for (Edge deleteEdge : getLHSMinusRHSEdges(complementRule.getComplementRule())) {
				complementingChanges.add(deleteEdge);
			}
			
			for (Node createNode : getRHSMinusLHSNodes(complementRule.getComplementRule())) {
				complementingChanges.add(createNode);
			}
			
			for (Edge createEdge : getRHSMinusLHSEdges(complementRule.getComplementRule())) {
				complementingChanges.add(createEdge);
			}
		}
		
		return complementingChanges;
	}
	
	/**
	 * @param graphElement
	 *            A << delete / create >> edge or a node of the source rule.
	 * @return The corresponding edit-rule match or <code>null</code> if the
	 *         given node/edge is a change that need to be complemented.
	 */
	public EditRuleMatch getSourceMatch(GraphElement graphElement) {
		assert (graphElement.getGraph().getRule() == complementRule.getSourceRule());
		return complementRule.getSourceMatch(graphElement);
	}
	
	/**
	 * @return The pre-match of the complementing repair-rule.
	 */
	public Map<Node, EObject> getRepairPreMatch() {
		return complementPreMatch.getNodeMatches();
	}
	
	/**
	 * @return <code>true</code> if the repair was successfully applied;
	 *         <code>false</code> otherwise.
	 */
	public boolean apply() {
		return complementRule.apply(complementPreMatch);
	}
}
