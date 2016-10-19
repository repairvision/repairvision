package org.sidiff.consistency.repair.lifting.api;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
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
	 * @return All already applied changes of the corresponding edit-rule.
	 */
	public List<GraphElement> getHistoricChanges() {
		return complementRule.getHistoricChanges();
	}
	
	/**
	 * @return All missing changes of the corresponding edit-rule.
	 */
	public List<GraphElement> getComplementingChanges() {
		return complementRule.getComplementingChanges();
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
	 * @return The successfully applied repair application or <code>null</code>.
	 */
	public RuleApplication apply() {
		return complementRule.apply(complementPreMatch);
	}
}
