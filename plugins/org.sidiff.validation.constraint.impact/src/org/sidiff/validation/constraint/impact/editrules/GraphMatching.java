package org.sidiff.validation.constraint.impact.editrules;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Node;

public interface GraphMatching {

	EObject getMatch(Node node);
	
}
