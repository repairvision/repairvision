package org.sidiff.consistency.complement.construction.match;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Edge;

public class EditRuleEdgeCreateMatch extends EditRuleEdgeMatch {

	public EditRuleEdgeCreateMatch(Edge edge, EObject srcModelElement, EObject tgtModelElement) {
		super(edge, Type.CREATE, srcModelElement, tgtModelElement);
	}
}
