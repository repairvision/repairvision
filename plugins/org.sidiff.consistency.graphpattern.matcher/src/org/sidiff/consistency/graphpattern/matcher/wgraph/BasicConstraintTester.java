package org.sidiff.consistency.graphpattern.matcher.wgraph;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.AttributePattern;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.tools.MatchingHelper;
import org.sidiff.difference.symmetric.SymmetricPackage;

//TODO: Lifting customization...
public class BasicConstraintTester implements IConstraintTester {

	private MatchingHelper matchingHelper;
	
	private static final SymmetricPackage SYMMETRIC_PACKAGE = SymmetricPackage.eINSTANCE;
	
	public BasicConstraintTester(MatchingHelper matchingHelper) {
		this.matchingHelper = matchingHelper;
	}
	
	private static boolean isChangeNode(NodePattern node) {
		
		if (node.getType() == SYMMETRIC_PACKAGE.getAddObject()
				|| (node.getType() == SYMMETRIC_PACKAGE.getRemoveObject())
				|| (node.getType() == SYMMETRIC_PACKAGE.getAddReference())
				|| (node.getType() == SYMMETRIC_PACKAGE.getRemoveReference())
				|| (node.getType() == SYMMETRIC_PACKAGE.getAttributeValueChange())) {
			return true;
		}
		
		return false;
	}
	
	public boolean check(NodePattern node, EObject object) {
		
		// Check types!
		if (!((object.eClass() == node.getType())
				|| matchingHelper.getSubTypes(object.eClass()).contains(node.getType()))) {
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
		
		// TODO[TEST]: Atomic patterns:
		
		if (isChangeNode(node)) {
			
			// AddReference
			EdgePattern typeEdge = node.getOutgoing(SymmetricPackage.eINSTANCE.getAddReference_Type());
			
			// RemoveReference
			if (typeEdge == null) {
				typeEdge = node.getOutgoing(SymmetricPackage.eINSTANCE.getRemoveReference_Type());
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
			if (node.getType() == SymmetricPackage.eINSTANCE.getAddObject()) {
				EdgePattern modelEdge = node.getOutgoing(SymmetricPackage.eINSTANCE.getAddObject_Obj());
				NodePattern modelNode = MatchingHelper.getAdjacent(node, modelEdge);
				EObject modelMatch = matchingHelper.getTargets(object, node, modelEdge).next();
				
				if (!((modelMatch.eClass() == modelNode.getType())
						|| matchingHelper.getSubTypes(modelMatch.eClass()).contains(modelNode.getType()))) {
					return false;
				}
			}
			
			// RemoveObject
			if (node.getType() == SymmetricPackage.eINSTANCE.getRemoveObject()) {
				EdgePattern modelEdge = node.getOutgoing(SymmetricPackage.eINSTANCE.getRemoveObject_Obj());
				NodePattern modelNode = MatchingHelper.getAdjacent(node, modelEdge);
				EObject modelMatch = matchingHelper.getTargets(object, node, modelEdge).next();
				
				if (!((modelMatch.eClass() == modelNode.getType())
						|| matchingHelper.getSubTypes(modelMatch.eClass()).contains(modelNode.getType()))) {
					return false;
				}
			}
		}
		
		//-----------------------------
		
		return true;
	}
}
