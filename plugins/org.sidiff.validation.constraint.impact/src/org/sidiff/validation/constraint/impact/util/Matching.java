package org.sidiff.validation.constraint.impact.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Node;

public interface Matching {

	EObject getMatch(Node node);
	
}
