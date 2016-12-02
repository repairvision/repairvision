package org.sidiff.graphpattern.matcher.lifting.engine.partial;

import static org.sidiff.graphpattern.wgraph.construction.tools.matching.MatchingHelper.isAssignableTo;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.matcher.lifting.util.RecognitionRuleUtil;
import org.sidiff.graphpattern.wgraph.construction.BasicConstraintTester;
import org.sidiff.graphpattern.wgraph.construction.tools.matching.MatchingHelper;

public class PartialLiftingConstraintTester extends BasicConstraintTester {

	private static final SymmetricPackage DIFFERENCE_MODEL = SymmetricPackage.eINSTANCE;
	
	public PartialLiftingConstraintTester(MatchingHelper matchingHelper) {
		super(matchingHelper);
	}
	
	public boolean check(NodePattern node, EObject object) {
		
		// Default tests:
		if (!super.check(node, object)) {
			return false;
		}
		
		// Atomic lifting patterns:
		if (RecognitionRuleUtil.isChangeNode(node)) {
			
			// AddReference
			EdgePattern typeEdge = node.getOutgoing(DIFFERENCE_MODEL.getAddReference_Type());
			
			// RemoveReference
			if (typeEdge == null) {
				typeEdge = node.getOutgoing(DIFFERENCE_MODEL.getRemoveReference_Type());
			}
			
			// Test AddReference / RemoveReference:
			if (typeEdge != null) {
				NodePattern typeNode = MatchingHelper.getAdjacent(node, typeEdge);
				EObject typeMatch = matchingHelper.getTargets(object, node, typeEdge).next();
					
				// Check type name:
				for (AttributePattern attribute : typeNode.getAttributes()) {
					if (attribute.getValue().startsWith("\"") && attribute.getValue().endsWith("\"")) {
						Object instanceValue = typeMatch.eGet(attribute.getType());
						String attributeValue = attribute.getValue().substring(1, attribute.getValue().length() - 1);

						if (!instanceValue.equals(attributeValue)) {
							return false;
						}
					}
				}
			}
			
			// AddObject
			if (node.getType() == DIFFERENCE_MODEL.getAddObject()) {
				EdgePattern modelEdge = node.getOutgoing(DIFFERENCE_MODEL.getAddObject_Obj());
				NodePattern modelNode = MatchingHelper.getAdjacent(node, modelEdge);
				EObject modelMatch = matchingHelper.getTargets(object, node, modelEdge).next();
				
				if (!isAssignableTo(modelMatch.eClass(), modelNode.getType())) {
					return false;
				}
			}
			
			// RemoveObject
			if (node.getType() == DIFFERENCE_MODEL.getRemoveObject()) {
				EdgePattern modelEdge = node.getOutgoing(DIFFERENCE_MODEL.getRemoveObject_Obj());
				NodePattern modelNode = MatchingHelper.getAdjacent(node, modelEdge);
				EObject modelMatch = matchingHelper.getTargets(object, node, modelEdge).next();
				
				if (!isAssignableTo(modelMatch.eClass(), modelNode.getType())) {
					return false;
				}
			}
		}
		
		return true;
	}
}
