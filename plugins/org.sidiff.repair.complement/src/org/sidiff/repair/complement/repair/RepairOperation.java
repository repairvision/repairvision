package org.sidiff.repair.complement.repair;

import java.util.List;

import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.repair.api.IRepairPlan;
import org.sidiff.repair.api.matching.EOMatch;
import org.sidiff.repair.api.matching.EditOperationMatching;
import org.sidiff.repair.complement.construction.ComplementRule;

/**
 * Represents a single repair operation.
 * 
 * @author Manuel Ohrndorf
 */
public class RepairOperation implements IRepairPlan {

	/**
	 * The rule that contains the repair changes.
	 */
	private ComplementRule complementRule;
	
	/**
	 * A concrete pre-match for the repair operation.
	 */
	private EditOperationMatching complementPreMatch;
	
	/**
	 * @param complementRule
	 *            The container of the complement rule.
	 * @param complementPreMatch
	 *            The pre-match of the complement rule.
	 */
	public RepairOperation(ComplementRule complementRule, EditOperationMatching complementPreMatch) {
		super();
		this.complementRule = complementRule;
		this.complementPreMatch = complementPreMatch;
	}

	@Override
	public Rule getEditRule() {
		return complementRule.getSourceRule();
	}
	
	@Override
	public List<GraphElement> getHistoricChanges() {
		return complementRule.getHistoricChanges();
	}
	
	@Override
	public List<GraphElement> getComplementingChanges() {
		return complementRule.getComplementingChanges();
	}
	
	@Override
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
	
	@Override
	public EOMatch getSourceMatch(GraphElement graphElement) {
		assert (graphElement.getGraph().getRule() == complementRule.getSourceRule());
		return complementRule.getSourceMatch(graphElement);
	}
	
	@Override
	public EditOperationMatching getRepairPreMatch() {
		return complementPreMatch;
	}
	
	@Override
	public RuleApplication apply() {
		return complementRule.apply(complementPreMatch);
	}
}
