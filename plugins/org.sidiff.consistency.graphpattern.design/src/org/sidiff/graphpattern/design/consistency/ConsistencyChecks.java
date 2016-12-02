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
				
				// Check type inconsistent opposite definition: Non-cross-reference:
				|| (!isEdgeWithCrossReference(edgePattern)
						
						&& ((edgePattern.getType().getEOpposite() != edgePattern.getOpposite().getType())
								|| (edgePattern.getType().getEOpposite() == null))
						
						// NOTE: An opposite might be defined only in one direction due to inheritance.
						&& !((edgePattern.getType().getEOpposite() == null) 
								&& checkOpposite(edgePattern.getOpposite())))
				
				// Check type inconsistent opposite definition: Cross-reference:
				|| ((isEdgeWithCrossReference(edgePattern))
					&& ((edgePattern.getType() != edgePattern.getOpposite().getType())
				
					// Only one edge should be marked as cross-reference:
					|| ((edgePattern.isCrossReference() == edgePattern.getOpposite().isCrossReference()))))) {	
			
			return false;
		}
		
		return true;
	}
	
	public static boolean isEdgeWithCrossReference(EdgePattern edgePattern) {
		return ((edgePattern.isCrossReference() 
				|| ((edgePattern.getOpposite() != null) 
						&& (edgePattern.getOpposite().isCrossReference()))));
	}
}
