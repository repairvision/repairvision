package org.sidiff.consistency.graphpattern.design.service;

import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.design.consistency.ConsistencyChecks;

public class ConditionService {

	public boolean isNavigable(EdgePattern edgePattern) {
		
		if (edgePattern.getOpposite() != null) {
			if (
					// Check opposite consistency
					(ConsistencyChecks.checkOpposite(edgePattern))
					
					// Filter cross-references
					&& (!edgePattern.getOpposite().isCrossReference())) {
				return true;
			}
		}
		
		return false;
	}
}
