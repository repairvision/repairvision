package org.sidiff.consistency.repair.lifting.matching.atomic;

import org.sidiff.consistency.graphpattern.EdgePattern;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.AtomicPattern;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.IAtomicPatternFactory;
import org.sidiff.consistency.graphpattern.matcher.matching.selection.PathSelector;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.matching.model.MatchingModelPackage;

// TODO: AtomicPattern: Add/RemoveObject with containment references!?
// TODO: AtomicPattern: Add/RemoveReference and EOpposites

public class AtomicLiftingPatternFactory implements IAtomicPatternFactory {

	private static MatchingModelPackage MATCHING_MODEL = MatchingModelPackage.eINSTANCE;
	private static SymmetricPackage DIFFERENCE_MODEL = SymmetricPackage.eINSTANCE;
	
	@Override
	public AtomicPattern getAtomicPattern(PathSelector path, NodePattern node) {
		
		if (node.getType() == DIFFERENCE_MODEL.getAddReference()) {
			return new AtomicAddReferencePattern(node, path);
		}
		
		else if (node.getType() == DIFFERENCE_MODEL.getRemoveReference()) {
			return new AtomicRemoveReferencePattern(node, path);
		}
		
		else if (node.getType() == DIFFERENCE_MODEL.getAttributeValueChange()) {
			return new AtomicAttributeValueChangePattern(node, path);
		}
		
		else {
			// Check for adjacent correspondence:
			for (EdgePattern incoming : node.getIncomings()) {
				if ((incoming.getType() == MATCHING_MODEL.getCorrespondence_MatchedA())
						|| (incoming.getType() == MATCHING_MODEL.getCorrespondence_MatchedB())) {
					return new AtomicCorrespondencePattern(node, incoming);
				}
			}
		}
		
		return null;
	}
}
