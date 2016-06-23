package org.sidiff.consistency.repair.lifting.api;

import java.util.List;

import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Rule;
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
			// TODO
		}
		
		return historicChanges;
	}
	
	/**
	 * @return All missing changes of the corresponding edit-rule.
	 */
	public List<GraphElement> getComplementingChanges() {
		
		if (complementingChanges != null) {
			// TODO
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
