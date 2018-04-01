package org.sidiff.graphpattern.design.service;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.design.consistency.ConsistencyChecks;

public class ConditionService {

	public boolean isNavigable(EdgePattern edgePattern) {
		return ConsistencyChecks.checkOpposite(edgePattern);
	}
	
	public boolean isNodePatter(EObject obj) {
		return obj instanceof NodePattern;
	}
}
