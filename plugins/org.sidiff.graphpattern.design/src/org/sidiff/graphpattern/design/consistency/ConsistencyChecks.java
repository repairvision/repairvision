package org.sidiff.graphpattern.design.consistency;

import org.sidiff.graphpattern.EdgePattern;

public class ConsistencyChecks {

	/**
	 * @param edgePattern
	 *            The edge to test.
	 * @return <code>true</code> if there is a consistent opposite edge;
	 *         <code>false</code> otherwise.
	 */
	public static boolean checkOpposite(EdgePattern edgePattern) {
		
		if (
				// Check incomplete opposite definition:
				(edgePattern.getOpposite() == null)
				
				// Missing type:
				|| (edgePattern.getType() == null)
				|| (edgePattern.getOpposite().getType() == null)
				
				// Check inconsistent opposite definition
				|| (edgePattern.getOpposite().getOpposite() != edgePattern)
			) {	
			
			return false;
		}
		
		return true;
	}
}
