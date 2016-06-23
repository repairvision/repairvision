package org.sidiff.consistency.repair.lifting.api;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.*;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.construction.match.ComplementMatch;

/**
 * Represents a single repair operation.
 * 
 * @author Manuel Ohrndorf
 */
public class Repair {

	private ComplementRule complementRule;
	
	private ComplementMatch complementPreMatch;
	
	private List<GraphElement> historicChanges;
	
	private List<GraphElement> complementingChanges;
	
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
		
		if (historicChanges != null) {
			historicChanges = new ArrayList<>();
			
			for (Node deleteNode : getLHSMinusRHSNodes(getEditRule())) {
				historicChanges.add(deleteNode);
			}
			
			for (Edge deleteEdge : getLHSMinusRHSEdges(getEditRule())) {
				historicChanges.add(deleteEdge);
			}
			
			for (Node createNode : getRHSMinusLHSNodes(getEditRule())) {
				historicChanges.add(createNode);
			}
			
			for (Edge createEdge : getRHSMinusLHSEdges(getEditRule())) {
				historicChanges.add(createEdge);
			}
			
			historicChanges.removeAll(getComplementingChanges());
		}
		
		return historicChanges;
	}
	
	/**
	 * @return All missing changes of the corresponding edit-rule.
	 */
	public List<GraphElement> getComplementingChanges() {
		
		if (complementingChanges != null) {
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
	 * @return <code>true</code> if the repair was successfully applied;
	 *         <code>false</code> otherwise.
	 */
	public boolean apply() {
		return complementRule.apply(complementPreMatch);
	}
}
