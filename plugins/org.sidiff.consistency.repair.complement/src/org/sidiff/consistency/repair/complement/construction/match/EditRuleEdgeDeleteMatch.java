package org.sidiff.consistency.repair.complement.construction.match;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Edge;

public class EditRuleEdgeDeleteMatch extends EditRuleEdgeMatch {

	public EditRuleEdgeDeleteMatch(Edge edge, EObject srcModelElement, EObject tgtModelElement) {
		super(edge, Type.DELETE, srcModelElement, tgtModelElement);
	}
}
