package org.sidiff.editrule.partialmatcher.complement;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.editrule.partialmatcher.pattern.RecognitionPattern;
import org.sidiff.editrule.partialmatcher.pattern.graph.ActionEdge;
import org.sidiff.editrule.partialmatcher.pattern.graph.ChangePattern;
import org.sidiff.editrule.partialmatcher.pattern.graph.ChangePatternAddObject;
import org.sidiff.editrule.partialmatcher.pattern.graph.ChangePatternAddReference;
import org.sidiff.editrule.partialmatcher.pattern.graph.ChangePatternAttributeValueChange;
import org.sidiff.editrule.partialmatcher.pattern.graph.ChangePatternRemoveObject;
import org.sidiff.editrule.partialmatcher.pattern.graph.ChangePatternRemoveReference;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.matcher.IMatching;
import org.sidiff.repair.api.matching.EOAttributeMatch;
import org.sidiff.repair.api.matching.EOEdgeMatch;
import org.sidiff.repair.api.matching.EOMatch;
import org.sidiff.repair.api.matching.EONodeSingleMatch;

public class Edit2RecognitionMatch {

	/**
	 * The difference model types.
	 */
	private static final SymmetricPackage DIFFERENCE_MODEL = SymmetricPackage.eINSTANCE;
	
	/**
	 * The difference between model A and B.
	 */
	private SymmetricDifference difference;
	
	public Edit2RecognitionMatch(SymmetricDifference difference) {
		this.difference = difference;
	}
	
	public List<EOMatch> createEditRuleMatch(RecognitionPattern recognitionPattern, IMatching matching) {
		
		// Create edit-operation match:
		List<EOMatch> editRuleMatch = new ArrayList<>();
		
		// TODO: EO-Preserve-Nodes:

		// EO-Change-Nodes:
		for (NodePattern changeNodePattern : recognitionPattern.getChangeNodePatterns()) {
			ChangePattern changePattern = recognitionPattern.getChangePattern(changeNodePattern);
			
			// EO-Create-Nodes:
			if (changePattern instanceof ChangePatternAddObject) {
				NodePattern rrNodePatternB = ((ChangePatternAddObject) changePattern).getNode().getNodePatternB();
				EObject created = getCreatedObject(rrNodePatternB, matching);

				if (created != null) {
					Node eoHenshinNode = ((ChangePatternAddObject) changePattern).getNode().getEditRuleNode();
					EONodeSingleMatch createMatch = new EONodeSingleMatch(Type.CREATE, eoHenshinNode);
					createMatch.setModelBElement(created);
					editRuleMatch.add(createMatch);
				}
			}
			
			// EO-Delete-Nodes:
			else if (changePattern instanceof ChangePatternRemoveObject) {
				NodePattern rrNodePatternA = ((ChangePatternRemoveObject) changePattern).getNode().getNodePatternA();
				EObject deleted = getDeletedObject(rrNodePatternA, matching);

				if (deleted != null) {
					Node eoHenshinNode = ((ChangePatternRemoveObject) changePattern).getNode().getEditRuleNode();
					EONodeSingleMatch deleteMatch = new EONodeSingleMatch(Type.DELETE, eoHenshinNode);
					deleteMatch.setModelBElement(deleted);
					editRuleMatch.add(deleteMatch);
				}
			}
			
			// EO-Create-Edges:
			else if (changePattern instanceof ChangePatternAddReference) {
				ActionEdge actionEdge = ((ChangePatternAddReference) changePattern).getEdge();
				Edge eoHenshinEdge = ((ChangePatternAddReference) changePattern).getEdge().getEditRuleEdge();
				
				EObject[] created = getCreateReference(eoHenshinEdge.getType(),
						actionEdge.getEdgePatternB().getSource(), actionEdge.getEdgePatternB().getTarget(), matching);
				
				if (created != null) {
					EOEdgeMatch createMatch = new EOEdgeMatch(Type.CREATE, eoHenshinEdge);
					createMatch.setSrcModelBElement(created[0]);
					createMatch.setTgtModelBElement(created[1]);
					editRuleMatch.add(createMatch);
					
					// Transfer context to model A if possible:
					// NOTE: The context might have been first created in model B!
					createMatch.setSrcModelAElement(difference.getCorrespondingObjectInA(created[0]));
					createMatch.setTgtModelAElement(difference.getCorrespondingObjectInA(created[1]));
				}
			}
			
			// EO-Delete-Edges:
			else if (changePattern instanceof ChangePatternRemoveReference) {
				ActionEdge actionEdge = ((ChangePatternRemoveReference) changePattern).getEdge();
				Edge eoHenshinEdge = ((ChangePatternRemoveReference) changePattern).getEdge().getEditRuleEdge();
				
				EObject[] deleted = getRemovedReference(eoHenshinEdge.getType(),
						actionEdge.getEdgePatternA().getSource(), actionEdge.getEdgePatternA().getTarget(), matching);

				if (deleted != null) {
					EOEdgeMatch deleteMatch = new EOEdgeMatch(Type.DELETE, eoHenshinEdge);
					deleteMatch.setSrcModelAElement(deleted[0]);
					deleteMatch.setTgtModelAElement(deleted[1]);
					editRuleMatch.add(deleteMatch);
					
					// Transfer context to model B if possible:
					// NOTE: The context might have been deleted in model B!
					deleteMatch.setSrcModelBElement(difference.getCorrespondingObjectInB(deleted[0]));
					deleteMatch.setTgtModelBElement(difference.getCorrespondingObjectInB(deleted[1]));
				}
			}
			
			else if (changePattern instanceof ChangePatternAttributeValueChange) {
				ChangePatternAttributeValueChange attributeChange = ((ChangePatternAttributeValueChange) changePattern);
				
				AttributeValueChange avc = (AttributeValueChange) matching
						.getFirstMatch(attributeChange.getChangeNodePattern());
				
				if (avc != null) {
					EOAttributeMatch attributeMatch = new EOAttributeMatch(
							attributeChange.getAttribute().getRhsAttribute(), 
							avc.getObjB(), avc.getObjB().eGet(avc.getType()));
					
					editRuleMatch.add(attributeMatch);
				}
			}
		}
		
		return editRuleMatch;
	}

	private EObject[] getCreateReference(EReference type,
			NodePattern src_rrNodePatternA, NodePattern tgt_rrNodePatternA,
			IMatching matching) {

		EObject[] srcAndTgtMatch = null;

		for (NodePattern changeNode : matching.getNodes()) {
			if (changeNode.getType() == DIFFERENCE_MODEL.getAddReference()) {
				AddReference change = (AddReference) matching.getFirstMatch(changeNode);

				if ((change != null) && (change.getType() == type)) {
					srcAndTgtMatch = new EObject[2];
					srcAndTgtMatch[0] = change.getSrc();
					srcAndTgtMatch[1] = change.getTgt();
				}
			}
		}

		return srcAndTgtMatch;
	}

	private EObject[] getRemovedReference(EReference type,
			NodePattern src_rrNodePatternB, NodePattern tgt_rrNodePatternB,
			IMatching matching) {

		EObject[] srcAndTgtMatch = null;

		for (NodePattern changeNode : matching.getNodes()) {
			if (changeNode.getType() == DIFFERENCE_MODEL.getRemoveReference()) {
				RemoveReference change = (RemoveReference) matching.getFirstMatch(changeNode);

				if ((change != null) && (change.getType() == type)) {
					srcAndTgtMatch = new EObject[2];
					srcAndTgtMatch[0] = change.getSrc();
					srcAndTgtMatch[1] = change.getTgt();
				}
			}
		}

		return srcAndTgtMatch;
	}

	private EObject getCreatedObject(NodePattern rrNodePatternA, IMatching matching) {
		NodePattern createObjectNode = rrNodePatternA.getIncoming(DIFFERENCE_MODEL.getAddObject_Obj()).getSource();
		AddObject change = (AddObject) matching.getFirstMatch(createObjectNode);

		if (change != null) {
			return change.getObj();
		} else {
			return null;
		}
	}

	private EObject getDeletedObject(NodePattern rrNodePatternB, IMatching matching) {
		NodePattern removeObjectNode = rrNodePatternB.getIncoming(DIFFERENCE_MODEL.getRemoveObject_Obj()).getSource();
		RemoveObject change = (RemoveObject) matching.getFirstMatch(removeObjectNode);

		if (change != null) {
			return change.getObj();
		} else {
			return null;
		}
	}

//	private EditRuleNodeMatch createEditRuleNodeMatch(Node node, List<EObject> match, Type type) {
//		EditRuleNodeMatch nodeMatch;
//
//		if (match.size() == 1) {
//			nodeMatch = new EditRuleNodeSingleMatch(node, type, match.get(0));
//		} else {
//			nodeMatch = new EditRuleNodeMultiMatch(node, type, match);
//		}
//
//		return nodeMatch;
//	}
}
