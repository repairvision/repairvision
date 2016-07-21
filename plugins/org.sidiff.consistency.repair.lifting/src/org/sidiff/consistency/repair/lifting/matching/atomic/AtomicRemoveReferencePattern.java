package org.sidiff.consistency.repair.lifting.matching.atomic;

import java.util.ArrayList;

import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.AtomicPattern;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.Move;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.Path;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.PathSelector;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.matching.model.MatchingModelPackage;

public class AtomicRemoveReferencePattern extends AtomicPattern {

	private static MatchingModelPackage MATCHING_MODEL = MatchingModelPackage.eINSTANCE;
	private static final SymmetricPackage DIFFERENCE_MODEL = SymmetricPackage.eINSTANCE;
	
	public AtomicRemoveReferencePattern(NodePattern removeReferenceNode, PathSelector pathSelector) {
		Path path = pathSelector.getPath();
		
		// Pattern definition:
		nodes = new ArrayList<>();
		nodes.add(removeReferenceNode);
		
		evaluation = new ArrayList<>();
		borderNodes = new ArrayList<>(4);
		
		NodePattern modelSrcNodeA = null;
		NodePattern modelTgtNodeA = null;
		NodePattern typeNode = null;
		
		NodePattern correspondenceSrcNode = null;
		NodePattern modelSrcNodeB = null;
		
		NodePattern correspondenceTgtNode = null;
		NodePattern modelTgtNodeB = null;
		
		// Find nodes:
//		EReference type = null;
		
		for (EdgePattern outgoing : removeReferenceNode.getOutgoings()) {
			if (outgoing.getType() == DIFFERENCE_MODEL.getRemoveReference_Src()) {
				modelSrcNodeA = outgoing.getTarget();
				
				nodes.add(modelSrcNodeA);
				evaluation.add(new Move(removeReferenceNode, outgoing, modelSrcNodeA));
				
				if (!path.contains(modelSrcNodeA)) borderNodes.add(modelSrcNodeA);
			}
			
			else if (outgoing.getType() == DIFFERENCE_MODEL.getRemoveReference_Tgt()) {
				modelTgtNodeA = outgoing.getTarget();
				
				nodes.add(modelTgtNodeA);
				evaluation.add(new Move(removeReferenceNode, outgoing , modelTgtNodeA));
				
				if (!path.contains(modelTgtNodeA)) borderNodes.add(modelTgtNodeA);
			}
			
			else if (outgoing.getType() == DIFFERENCE_MODEL.getRemoveReference_Type()) {
				typeNode = outgoing.getTarget();
				
				nodes.add(typeNode);
				evaluation.add(new Move(removeReferenceNode, outgoing , typeNode));
				
//				// Get type:
//				DataStore typeDS = typeNode.getEvaluation().getStore();
//				
//				if (typeDS.getMatchSize() == 1) {
//					type = (EReference) typeDS.getMatchIterator().next();
//				}
			}
		}
		
//		// Find opposite:
//		// TODO: Add EOpposite to SymmetricModel!
//		if ((type != null) && (type.getEOpposite() != null)) {
//			for (EdgePattern oppositeTgtEdge : modelSrcNodeA.getIncomings(DIFFERENCE_MODEL.getRemoveReference_Tgt())) {
//				NodePattern oppositeChangeNode = oppositeTgtEdge.getSource();
//				EdgePattern oppositeTypeEdge = oppositeChangeNode.getOutgoing(DIFFERENCE_MODEL.getRemoveReference_Type());
//				NodePattern oppositeTypeNode = oppositeTypeEdge.getTarget();
//				
//				// Get type:
//				DataStore oppositeTypeDS = oppositeTypeNode.getEvaluation().getStore();
//				
//				if (oppositeTypeDS.getMatchSize() == 1) {
//					EReference oppositeType = (EReference) oppositeTypeDS.getMatchIterator().next();
//					
//					if (oppositeType == type.getEOpposite()) {
//						NodePattern oppositeSrcNode = oppositeChangeNode.getOutgoing(
//								DIFFERENCE_MODEL.getRemoveReference_Src()).getTarget();
//						
//						if (oppositeSrcNode == modelTgtNodeA) {
//							
//							// Opposite found:
//							nodes.add(oppositeChangeNode);
//							evaluation.add(new Move(modelSrcNodeA, oppositeTgtEdge, oppositeChangeNode));
//							
//							// Add type node:
//							nodes.add(oppositeTypeNode);
//							evaluation.add(new Move(oppositeChangeNode, oppositeTypeEdge, oppositeTypeNode));
//							
//							break;
//						}
//					}
//				}
//			}
//		}
		
		// -src-> ModelA <-matchedA- Correspondence -matchedB-> ModelB 
		for (EdgePattern incoming : modelSrcNodeA.getIncomings()) {
			if (incoming.getType() == MATCHING_MODEL.getCorrespondence_MatchedA()) {
				correspondenceSrcNode = incoming.getSource();
				EdgePattern matchedB = correspondenceSrcNode.getOutgoing(MATCHING_MODEL.getCorrespondence_MatchedB());
				modelSrcNodeB = matchedB.getTarget();
				
				nodes.add(correspondenceSrcNode);
				nodes.add(modelSrcNodeB);
				
				evaluation.add(new Move(modelSrcNodeA, incoming, correspondenceSrcNode));
				evaluation.add(new Move(correspondenceSrcNode, matchedB, modelSrcNodeB));
				
				if (!path.contains(modelSrcNodeB)) borderNodes.add(modelSrcNodeB);
			}
		}
		
		// -tgt-> ModelA <-matchedA- Correspondence -matchedB-> ModelB 
		for (EdgePattern incoming : modelTgtNodeA.getIncomings()) {
			if (incoming.getType() == MATCHING_MODEL.getCorrespondence_MatchedA()) {
				correspondenceTgtNode = incoming.getSource();
				EdgePattern matchedB = correspondenceTgtNode.getOutgoing(MATCHING_MODEL.getCorrespondence_MatchedB());
				modelTgtNodeB = matchedB.getTarget();
				
				nodes.add(correspondenceTgtNode);
				nodes.add(modelTgtNodeB);
				
				evaluation.add(new Move(modelTgtNodeA, incoming, correspondenceTgtNode));
				evaluation.add(new Move(correspondenceTgtNode, matchedB , modelTgtNodeB));
				
				if (!path.contains(modelTgtNodeB)) borderNodes.add(modelTgtNodeB);
			}
		}
	}
}
