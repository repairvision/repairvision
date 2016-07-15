package org.sidiff.consistency.repair.complement.construction.cpo;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.repair.complement.construction.ComplementRule;
import org.sidiff.consistency.repair.complement.construction.match.ComplementMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeSingleMatch;

public class CPOComplementRule extends ComplementRule  {

	public CPOComplementRule(Rule sourceRule, Rule complementRule) {
		super(sourceRule, complementRule);
	}

	@Override
	protected List<ComplementMatch> createComplementPrematches(List<EditRuleMatch> partialSourceMatch) {
		Map<Node, EObject> match = new HashMap<>();
		
		for (EditRuleMatch sourceMatch : partialSourceMatch) {
			
			// NOTE: The matching unambiguously in CPO approach (regarding EditRuleNodeMultiMatch):
			if (sourceMatch instanceof EditRuleNodeSingleMatch) {
				EditRuleNodeSingleMatch nodeMatch = (EditRuleNodeSingleMatch) sourceMatch;
				match.put(nodeMatch.getNode(), nodeMatch.getModelElement());
			}
		}
		
		return Collections.singletonList(new ComplementMatch(match));
	}
}
