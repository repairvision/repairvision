package org.sidiff.consistency.repair.api;

import java.util.List;

import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.repair.api.matching.EditOperationMatching;
import org.sidiff.consistency.repair.api.matching.EOMatch;

/**
 * Represents a single repair operation.
 * 
 * @author Manuel Ohrndorf
 */
public interface IRepair {

	/**
	 * @return The corresponding partially executed edit-rule.
	 */
	Rule getEditRule();

	/**
	 * @return All already applied changes of the corresponding edit-rule.
	 */
	List<GraphElement> getHistoricChanges();

	/**
	 * @return All missing changes of the corresponding edit-rule.
	 */
	List<GraphElement> getComplementingChanges();

	/**
	 * @param editRuleGraphElement
	 *            A node/edge of the edit rule.
	 * @return The corresponding node/edge of the complement rule.
	 */
	<G extends GraphElement> G getTrace(G editRuleGraphElement);

	/**
	 * @param graphElement
	 *            A << delete / create >> edge or a node of the source rule.
	 * @return The corresponding edit-rule match or <code>null</code> if the
	 *         given node/edge is a change that need to be complemented.
	 */
	EOMatch getSourceMatch(GraphElement graphElement);

	/**
	 * @return The pre-match of the complementing repair-rule.
	 */
	EditOperationMatching getRepairPreMatch();

	/**
	 * @return The successfully applied repair application or <code>null</code>.
	 */
	RuleApplication apply();
}