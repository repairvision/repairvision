package org.sidiff.consistency.graphpattern.matcher.lifting.atomics;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EReference;
import org.sidiff.consistency.graphpattern.DataStore;
import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.AtomicPattern;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.Move;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.Path;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.PathSelector;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.matching.model.MatchingModelPackage;

public class AtomicAddReferencePattern extends AtomicPattern {

	private static MatchingModelPackage MATCHING_MODEL = MatchingModelPackage.eINSTANCE;
	private static final SymmetricPackage DIFFERENCE_MODEL = SymmetricPackage.eINSTANCE;
	
	public AtomicAddReferencePattern(NodePattern addReferenceNode, PathSelector pathSelector) {
		Path path = pathSelector.getPath();
		
		// Pattern definition:
		nodes = new ArrayList<>();
		nodes.add(addReferenceNode);
		
		evaluation = new ArrayList<>();
		borderNodes = new ArrayList<>(4);
		
		NodePattern modelSrcNodeB = null;
		NodePattern modelTgtNodeB = null;
		NodePattern typeNode = null;
		
		NodePattern correspondenceSrcNode = null;
		NodePattern modelSrcNodeA = null;
		
		NodePattern correspondenceTgtNode = null;
		NodePattern modelTgtNodeA = null;
		
		// Find nodes:
		EReference type = null;
		
		for (EdgePattern outgoing : addReferenceNode.getOutgoings()) {
			if (outgoing.getType() == DIFFERENCE_MODEL.getAddReference_Src()) {
				modelSrcNodeB = outgoing.getTarget();
				
				nodes.add(modelSrcNodeB);
				evaluation.add(new Move(addReferenceNode, outgoing, modelSrcNodeB));
				
				if (!path.contains(modelSrcNodeB)) borderNodes.add(modelSrcNodeB);
			}
			
			else if (outgoing.getType() == DIFFERENCE_MODEL.getAddReference_Tgt()) {
				modelTgtNodeB = outgoing.getTarget();
				
				nodes.add(modelTgtNodeB);
				evaluation.add(new Move(addReferenceNode, outgoing , modelTgtNodeB));
				
				if (!path.contains(modelTgtNodeB)) borderNodes.add(modelTgtNodeB);
			}
			
			else if (outgoing.getType() == DIFFERENCE_MODEL.getAddReference_Type()) {
				typeNode = outgoing.getTarget();
				
				nodes.add(typeNode);
				evaluation.add(new Move(addReferenceNode, outgoing , typeNode));
				
				// Get type:
				DataStore typeDS = typeNode.getEvaluation().getStore();
				
				if (typeDS.getMatchSize() == 1) {
					type = (EReference) typeDS.getMatchIterator().next();
				}
			}
		}
		
		// Find opposite:
		// TODO: Add EOpposite to SymmetricModel!
		if ((type != null) && (type.getEOpposite() != null)) {
			for (EdgePattern oppositeTgtEdge : modelSrcNodeB.getIncomings(DIFFERENCE_MODEL.getAddReference_Tgt())) {
				NodePattern oppositeChangeNode = oppositeTgtEdge.getSource();
				EdgePattern oppositeTypeEdge = oppositeChangeNode.getOutgoing(DIFFERENCE_MODEL.getAddReference_Type());
				NodePattern oppositeTypeNode = oppositeTypeEdge.getTarget();
				
				// Get type:
				DataStore oppositeTypeDS = oppositeTypeNode.getEvaluation().getStore();
				
				if (oppositeTypeDS.getMatchSize() == 1) {
					EReference oppositeType = (EReference) oppositeTypeDS.getMatchIterator().next();
					
					if (oppositeType == type.getEOpposite()) {
						NodePattern oppositeSrcNode = oppositeChangeNode.getOutgoing(
								DIFFERENCE_MODEL.getAddReference_Src()).getTarget();
						
						if (oppositeSrcNode == modelTgtNodeB) {
							
							// Opposite found:
							nodes.add(oppositeChangeNode);
							evaluation.add(new Move(modelSrcNodeB, oppositeTgtEdge, oppositeChangeNode));
							
							// Add type node:
							nodes.add(oppositeTypeNode);
							evaluation.add(new Move(oppositeChangeNode, oppositeTypeEdge, oppositeTypeNode));
							
							break;
						}
					}
				}
			}
		}
		
		// -src-> ModelB <-matchedB- Correspondence -matchedA-> ModelA 
		for (EdgePattern incoming : modelSrcNodeB.getIncomings()) {
			if (incoming.getType() == MATCHING_MODEL.getCorrespondence_MatchedB()) {
				correspondenceSrcNode = incoming.getSource();
				EdgePattern matchedA = correspondenceSrcNode.getOutgoing(MATCHING_MODEL.getCorrespondence_MatchedA());
				modelSrcNodeA = matchedA.getTarget();
				
				nodes.add(correspondenceSrcNode);
				nodes.add(modelSrcNodeA);
				
				evaluation.add(new Move(modelSrcNodeB, incoming, correspondenceSrcNode));
				evaluation.add(new Move(correspondenceSrcNode, matchedA, modelSrcNodeA));
				
				if (!path.contains(modelSrcNodeA)) borderNodes.add(modelSrcNodeA);
			}
		}
		
		// -tgt-> ModelB <-matchedB- Correspondence -matchedA-> ModelA 
		for (EdgePattern incoming : modelTgtNodeB.getIncomings()) {
			if (incoming.getType() == MATCHING_MODEL.getCorrespondence_MatchedB()) {
				correspondenceTgtNode = incoming.getSource();
				EdgePattern matchedA = correspondenceTgtNode.getOutgoing(MATCHING_MODEL.getCorrespondence_MatchedA());
				modelTgtNodeA = matchedA.getTarget();
				
				nodes.add(correspondenceTgtNode);
				nodes.add(modelTgtNodeA);
				
				evaluation.add(new Move(modelTgtNodeB, incoming, correspondenceTgtNode));
				evaluation.add(new Move(correspondenceTgtNode, matchedA , modelTgtNodeA));
				
				if (!path.contains(modelTgtNodeA)) borderNodes.add(modelTgtNodeA);
			}
		}
	}
}
