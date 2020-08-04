package org.sidiff.revision.editrules.impact.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Node;

public interface GraphMatching {

	EObject getMatch(Node node);
	
}
