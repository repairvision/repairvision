package org.sidiff.editrule.partialmatcher.complement;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.partialmatcher.pattern.RecognitionPattern;
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

		// EO-Changes:
		for (NodePattern changeNodePattern : recognitionPattern.getChangeNodePatterns()) {
			ChangePattern changePattern = recognitionPattern.getChangePattern(changeNodePattern);
			
			// EO-Create-Nodes:
			if (changePattern instanceof ChangePatternAddObject) {
				AddObject change = (AddObject) matching.getFirstMatch(changePattern.getChangeNodePattern());

				if (change != null) {
					Node eoHenshinNode = ((ChangePatternAddObject) changePattern).getNode().getEditRuleNode();
					EONodeSingleMatch createMatch = new EONodeSingleMatch(Type.CREATE, eoHenshinNode);
					createMatch.setModelBElement(change.getObj());
					editRuleMatch.add(createMatch);
				}
			}
			
			// EO-Delete-Nodes:
			else if (changePattern instanceof ChangePatternRemoveObject) {
				RemoveObject change = (RemoveObject) matching.getFirstMatch(changePattern.getChangeNodePattern());

				if (change != null) {
					Node eoHenshinNode = ((ChangePatternRemoveObject) changePattern).getNode().getEditRuleNode();
					EONodeSingleMatch deleteMatch = new EONodeSingleMatch(Type.DELETE, eoHenshinNode);
					deleteMatch.setModelBElement(change.getObj());
					editRuleMatch.add(deleteMatch);
				}
			}
			
			// EO-Create-Edges:
			else if (changePattern instanceof ChangePatternAddReference) {
				Edge eoHenshinEdge = ((ChangePatternAddReference) changePattern).getEdge().getEditRuleEdge();
				AddReference change = (AddReference) matching.getFirstMatch(changePattern.getChangeNodePattern());
				
				if (change != null) {
					EOEdgeMatch createMatch = new EOEdgeMatch(Type.CREATE, eoHenshinEdge);
					createMatch.setSrcModelBElement(change.getSrc());
					createMatch.setTgtModelBElement(change.getTgt());
					editRuleMatch.add(createMatch);
					
					// Transfer context to model A if possible:
					// NOTE: The context might have been first created in model B!
					createMatch.setSrcModelAElement(difference.getCorrespondingObjectInA(change.getSrc()));
					createMatch.setTgtModelAElement(difference.getCorrespondingObjectInA(change.getTgt()));
				}
			}
			
			// EO-Delete-Edges:
			else if (changePattern instanceof ChangePatternRemoveReference) {
				Edge eoHenshinEdge = ((ChangePatternRemoveReference) changePattern).getEdge().getEditRuleEdge();
				RemoveReference change = (RemoveReference) matching.getFirstMatch(changePattern.getChangeNodePattern());

				if (change != null) {
					EOEdgeMatch deleteMatch = new EOEdgeMatch(Type.DELETE, eoHenshinEdge);
					deleteMatch.setSrcModelAElement(change.getSrc());
					deleteMatch.setTgtModelAElement(change.getTgt());
					editRuleMatch.add(deleteMatch);
					
					// Transfer context to model B if possible:
					// NOTE: The context might have been deleted in model B!
					deleteMatch.setSrcModelBElement(difference.getCorrespondingObjectInB(change.getSrc()));
					deleteMatch.setTgtModelBElement(difference.getCorrespondingObjectInB(change.getTgt()));
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
}
