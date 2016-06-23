package org.sidiff.consistency.graphpattern.matcher.lifting.matching;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.matching.BasicMatchValidation;
import org.sidiff.consistency.graphpattern.matcher.matching.NodeMatching;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricPackage;

// TODO: Check atomic matches here...
public class LiftingMatchValidation extends BasicMatchValidation {
	
	@Override
	public boolean isPotentialMatch(NodeMatching newNodeMatching, Map<NodePattern, NodeMatching> matching) {
		return super.isPotentialMatch(newNodeMatching, matching);
	}
	
	@Override
	public boolean isMatch(Map<NodePattern, NodeMatching> matching) {
		return super.isMatch(matching);
	}
	
	private boolean isMandatoryOutgoingEdge(EdgePattern edge) {
		EReference type = edge.getType();
		
		if (type == SymmetricPackage.eINSTANCE.getAddObject_Obj()) {
			return true;
		}
		
		else if (type == SymmetricPackage.eINSTANCE.getRemoveObject_Obj()) {
			return true;
		}
		
		else if (type == SymmetricPackage.eINSTANCE.getRemoveReference_Src()) {
			return true;
		}
		
		else if (type == SymmetricPackage.eINSTANCE.getRemoveReference_Tgt()) {
			return true;
		}
		
		else if (type == SymmetricPackage.eINSTANCE.getRemoveReference_Type()) {
			return true;
		}
		
		else if (type == SymmetricPackage.eINSTANCE.getAddReference_Src()) {
			return true;
		}
		
		else if (type == SymmetricPackage.eINSTANCE.getAddReference_Tgt()) {
			return true;
		}
		
		else if (type == SymmetricPackage.eINSTANCE.getAddReference_Type()) {
			return true;
		}
		
		else if (type == SymmetricPackage.eINSTANCE.getAttributeValueChange_ObjA()) {
			return true;
		}
		
		else if (type == SymmetricPackage.eINSTANCE.getAttributeValueChange_ObjB()) {
			return true;
		}
		
		else if (type == SymmetricPackage.eINSTANCE.getAttributeValueChange_Type()) {
			return true;
		}
		
		return false;
	}
	
	private boolean onlyAtomicChangeMatches(Map<NodePattern, NodeMatching> matching) {
		
		for (Entry<NodePattern, NodeMatching> match : matching.entrySet()) {
			
			// Add-Object:
			if (match.getKey().getType() == SymmetricPackage.eINSTANCE.getAddObject()) {
				
				if (!isAtomic(matching, match.getValue(), SymmetricPackage.eINSTANCE.getAddObject_Obj())) {
					return false;
				}
			}
			
			// Remove-Object:
			if (match.getKey().getType() == SymmetricPackage.eINSTANCE.getRemoveObject()) {
				
				if (!isAtomic(matching, match.getValue(), SymmetricPackage.eINSTANCE.getRemoveObject_Obj())) {
					return false;
				}
			}
			
			// Remove-Reference:
			if (match.getKey().getType() == SymmetricPackage.eINSTANCE.getRemoveReference()) {
				
				if (!isAtomic(matching, match.getValue(), SymmetricPackage.eINSTANCE.getRemoveReference_Src())) {
					return false;
				}
				
				if (!isAtomic(matching, match.getValue(), SymmetricPackage.eINSTANCE.getRemoveReference_Type())) {
					return false;
				}

				// Check target for non abstract Remove-Reference:
				EObject tgt = ((EObject) ((RemoveReference) match.getValue().getMatch())
						.eGet(SymmetricPackage.eINSTANCE.getRemoveReference_Tgt()));

				if (tgt != null) {
					if (!isAtomic(matching, match.getValue(), SymmetricPackage.eINSTANCE.getRemoveReference_Tgt())) {
						return false;
					}
				}
			}
			
			// Add-Reference:
			if (match.getKey().getType() == SymmetricPackage.eINSTANCE.getAddReference()) {
				
				if (!isAtomic(matching, match.getValue(), SymmetricPackage.eINSTANCE.getAddReference_Src())) {
					return false;
				}
				
				if (!isAtomic(matching, match.getValue(), SymmetricPackage.eINSTANCE.getAddReference_Type())) {
					return false;
				}

				EObject tgt = ((EObject) ((AddReference) match.getValue().getMatch())
						.eGet(SymmetricPackage.eINSTANCE.getAddReference_Tgt()));

				if (tgt != null) {
					if (!isAtomic(matching, match.getValue(), SymmetricPackage.eINSTANCE.getAddReference_Tgt())) {
						return false;
					}
				}
			}
			
			// Attribute-Value-Change:
			if (match.getKey().getType() == SymmetricPackage.eINSTANCE.getAttributeValueChange()) {
				
				if (!isAtomic(matching, match.getValue(), SymmetricPackage.eINSTANCE.getAttributeValueChange_ObjA())) {
					return false;
				}
				
				if (!isAtomic(matching, match.getValue(), SymmetricPackage.eINSTANCE.getAttributeValueChange_ObjB())) {
					return false;
				}
				
				if (!isAtomic(matching, match.getValue(), SymmetricPackage.eINSTANCE.getAttributeValueChange_Type())) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private boolean isAtomic(Map<NodePattern, NodeMatching> matching, NodeMatching srcMatch, EReference outgoingType) {
		List<EdgePattern> outgoings = srcMatch.getNode().getEdges(outgoingType);
		
		for (EdgePattern outgoing : outgoings) {
			NodePattern targetNode = outgoing.getTarget();
			
			if (matching.get(targetNode).getMatch() == null) {
				return false;
			}
		}
		
		return true;
	}
}
