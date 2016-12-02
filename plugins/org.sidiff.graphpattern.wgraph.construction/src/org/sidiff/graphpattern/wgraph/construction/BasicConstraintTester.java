package org.sidiff.graphpattern.wgraph.construction;

import static org.sidiff.graphpattern.wgraph.construction.tools.matching.MatchingHelper.isAssignableTo;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.wgraph.construction.tools.matching.MatchingHelper;

/**
 * Basic implementation of a {@link IConstraintTester}.
 * 
 * @author Manuel Ohrndorf
 */
public class BasicConstraintTester implements IConstraintTester {

	protected MatchingHelper matchingHelper;
	
	public BasicConstraintTester(MatchingHelper matchingHelper) {
		this.matchingHelper = matchingHelper;
	}
	
	@Override
	public boolean check(NodePattern node, EObject object) {
		
		// Check types!
		if (!isAssignableTo(object.eClass(), node.getType())) {
			return false;
		}
		
		// FIXME: Better attribute support...
		for (AttributePattern attribute : node.getAttributes()) {
			
			// Check constant attributes!
			if (attribute.getValue().startsWith("\"") && attribute.getValue().endsWith("\"")) {
				Object instanceValue = object.eGet(attribute.getType());
				String attributeValue = attribute.getValue().substring(1, attribute.getValue().length() - 1);
				
				if (!instanceValue.equals(attributeValue)) {
					return false;
				}
			}
		}

		return true;
	}
}
