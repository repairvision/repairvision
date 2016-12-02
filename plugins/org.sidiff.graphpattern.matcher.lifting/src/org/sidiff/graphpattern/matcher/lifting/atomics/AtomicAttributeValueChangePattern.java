package org.sidiff.graphpattern.matcher.lifting.atomics;

import java.util.ArrayList;

import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.graphpattern.matcher.matching.selection.AtomicPattern;
import org.sidiff.graphpattern.matcher.matching.selection.Move;
import org.sidiff.graphpattern.matcher.matching.selection.Path;
import org.sidiff.graphpattern.matcher.matching.selection.PathSelector;
import org.sidiff.matching.model.MatchingModelPackage;

public class AtomicAttributeValueChangePattern extends AtomicPattern {

	private static MatchingModelPackage MATCHING_MODEL = MatchingModelPackage.eINSTANCE;
	private static final SymmetricPackage DIFFERENCE_MODEL = SymmetricPackage.eINSTANCE;
	
	public AtomicAttributeValueChangePattern(NodePattern attributeValueChangeNode, PathSelector pathSelector) {
		Path path = pathSelector.getPath();
		
		// Pattern definition:
		nodes = new ArrayList<>(5);
		nodes.add(attributeValueChangeNode);
		
		evaluation = new ArrayList<>(5);
		borderNodes = new ArrayList<>(2);
		
		NodePattern modelNodeA = null;
		NodePattern modelNodeB = null;
		NodePattern correspondence = null;
		NodePattern typeNode = null;
		
		// Find nodes:
		for (EdgePattern outgoing : attributeValueChangeNode.getOutgoings()) {
			if (outgoing.getType() == DIFFERENCE_MODEL.getAttributeValueChange_ObjA()) {
				modelNodeA = outgoing.getTarget();
				
				nodes.add(modelNodeA);
				evaluation.add(new Move(attributeValueChangeNode, outgoing, modelNodeA));
				
				if (!path.contains(modelNodeA)) borderNodes.add(modelNodeA);
			}
			
			else if (outgoing.getType() == DIFFERENCE_MODEL.getAttributeValueChange_ObjB()) {
				modelNodeB = outgoing.getTarget();
				
				nodes.add(modelNodeB);
				evaluation.add(new Move(attributeValueChangeNode, outgoing , modelNodeB));
				
				if (!path.contains(modelNodeB)) borderNodes.add(modelNodeB);
			}
			
			else if (outgoing.getType() == DIFFERENCE_MODEL.getAttributeValueChange_Type()) {
				typeNode = outgoing.getTarget();
				
				nodes.add(typeNode);
				evaluation.add(new Move(attributeValueChangeNode, outgoing , typeNode));
			}
		}
		
		// -objA-> ModelA <-matchedA- Correspondence -matchedB-> ModelB <-objB-
		for (EdgePattern incoming : modelNodeA.getIncomings()) {
			if (incoming.getType() == MATCHING_MODEL.getCorrespondence_MatchedA()) {
				correspondence = incoming.getSource();
				EdgePattern matchedB = correspondence.getOutgoing(MATCHING_MODEL.getCorrespondence_MatchedB());
				
				nodes.add(correspondence);
				
				evaluation.add(new Move(modelNodeA, incoming, correspondence));
				evaluation.add(new Move(correspondence, matchedB, modelNodeB));
			}
		}
	}
}
