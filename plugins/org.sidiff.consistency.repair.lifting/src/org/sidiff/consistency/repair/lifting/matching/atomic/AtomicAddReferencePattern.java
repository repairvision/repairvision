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

public class AtomicAddReferencePattern extends AtomicPattern {

	private static MatchingModelPackage MATCHING_MODEL = MatchingModelPackage.eINSTANCE;
	private static final SymmetricPackage DIFFERENCE_MODEL = SymmetricPackage.eINSTANCE;
	
	public AtomicAddReferencePattern(NodePattern addReferenceNode, PathSelector pathSelector) {
		Path path = pathSelector.getPath();
		
		// Pattern definition:
		nodes = new ArrayList<>(8);
		nodes.add(addReferenceNode);
		
		evaluation = new ArrayList<>(7);
		borderNodes = new ArrayList<>(4);
		
		NodePattern modelSrcNodeB = null;
		NodePattern modelTgtNodeB = null;
		NodePattern typeNode = null;
		
		NodePattern correspondenceSrcNode = null;
		NodePattern modelSrcNodeA = null;
		
		NodePattern correspondenceTgtNode = null;
		NodePattern modelTgtNodeA = null;
		
		// Find nodes:
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
