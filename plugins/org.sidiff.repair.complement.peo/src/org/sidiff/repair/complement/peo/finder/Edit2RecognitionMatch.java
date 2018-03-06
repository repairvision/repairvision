package org.sidiff.repair.complement.peo.finder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Action.Type;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.editrule.recognition.pattern.RecognitionPattern;
import org.sidiff.editrule.recognition.pattern.graph.ChangePattern;
import org.sidiff.editrule.recognition.pattern.graph.ChangePatternAddObject;
import org.sidiff.editrule.recognition.pattern.graph.ChangePatternAddReference;
import org.sidiff.editrule.recognition.pattern.graph.ChangePatternAttributeValueChange;
import org.sidiff.editrule.recognition.pattern.graph.ChangePatternRemoveObject;
import org.sidiff.editrule.recognition.pattern.graph.ChangePatternRemoveReference;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.matcher.IMatching;
import org.sidiff.repair.complement.matching.RecognitionAttributeMatch;
import org.sidiff.repair.complement.matching.RecognitionEdgeMatch;
import org.sidiff.repair.complement.matching.RecognitionMatch;
import org.sidiff.repair.complement.matching.RecognitionNodeSingleMatch;
import org.sidiff.repair.complement.matching.RecognitionParameterMatch;

public class Edit2RecognitionMatch {

	/**
	 * The difference between model A and B.
	 */
	private SymmetricDifference difference;
	
	public Edit2RecognitionMatch(SymmetricDifference difference) {
		this.difference = difference;
	}
	
	public List<RecognitionMatch> createEditRuleMatch(RecognitionPattern recognitionPattern, IMatching matching) {
		Rule editRule = recognitionPattern.getEditRule();
		
		// Create edit-operation match:
		List<RecognitionMatch> editRuleMatch = new ArrayList<>();
		Map<Parameter, RecognitionParameterMatch> parameters = new HashMap<>();
		
		// TODO: EO-Preserve-Nodes:

		// EO-Changes:
		for (NodePattern changeNodePattern : recognitionPattern.getChangeNodePatterns()) {
			ChangePattern changePattern = recognitionPattern.getChangePattern(changeNodePattern);
			
			// EO-Create-Nodes:
			if (changePattern instanceof ChangePatternAddObject) {
				AddObject change = (AddObject) matching.getFirstMatch(changePattern.getChangeNodePattern());

				if (change != null) {
					Node eoHenshinNode = ((ChangePatternAddObject) changePattern).getNode().getEditRuleNode();
					RecognitionNodeSingleMatch createMatch = new RecognitionNodeSingleMatch(Type.CREATE, eoHenshinNode);
					createMatch.setModelBElement(change.getObj());
					editRuleMatch.add(createMatch);
					
					findParameters(parameters, editRule, eoHenshinNode, change.getObj());
				}
			}
			
			// EO-Delete-Nodes:
			else if (changePattern instanceof ChangePatternRemoveObject) {
				RemoveObject change = (RemoveObject) matching.getFirstMatch(changePattern.getChangeNodePattern());

				if (change != null) {
					Node eoHenshinNode = ((ChangePatternRemoveObject) changePattern).getNode().getEditRuleNode();
					RecognitionNodeSingleMatch deleteMatch = new RecognitionNodeSingleMatch(Type.DELETE, eoHenshinNode);
					deleteMatch.setModelBElement(change.getObj());
					editRuleMatch.add(deleteMatch);
					
					findParameters(parameters, editRule, eoHenshinNode, change.getObj());
				}
			}
			
			// EO-Create-Edges:
			else if (changePattern instanceof ChangePatternAddReference) {
				Edge eoHenshinEdge = ((ChangePatternAddReference) changePattern).getEdge().getEditRuleEdge();
				AddReference change = (AddReference) matching.getFirstMatch(changePattern.getChangeNodePattern());
				
				if (change != null) {
					RecognitionEdgeMatch createMatch = new RecognitionEdgeMatch(Type.CREATE, eoHenshinEdge);
					createMatch.setSrcModelBElement(change.getSrc());
					createMatch.setTgtModelBElement(change.getTgt());
					editRuleMatch.add(createMatch);
					
					// Transfer context to model A if possible:
					// NOTE: The context might have been first created in model B!
					createMatch.setSrcModelAElement(difference.getCorrespondingObjectInA(change.getSrc()));
					createMatch.setTgtModelAElement(difference.getCorrespondingObjectInA(change.getTgt()));
					
					findParameters(parameters, editRule, eoHenshinEdge.getSource(), change.getSrc());
					findParameters(parameters, editRule, eoHenshinEdge.getTarget(), change.getTgt());
				}
			}
			
			// EO-Delete-Edges:
			else if (changePattern instanceof ChangePatternRemoveReference) {
				Edge eoHenshinEdge = ((ChangePatternRemoveReference) changePattern).getEdge().getEditRuleEdge();
				RemoveReference change = (RemoveReference) matching.getFirstMatch(changePattern.getChangeNodePattern());

				if (change != null) {
					RecognitionEdgeMatch deleteMatch = new RecognitionEdgeMatch(Type.DELETE, eoHenshinEdge);
					deleteMatch.setSrcModelAElement(change.getSrc());
					deleteMatch.setTgtModelAElement(change.getTgt());
					editRuleMatch.add(deleteMatch);
					
					// Transfer context to model B if possible:
					// NOTE: The context might have been deleted in model B!
					deleteMatch.setSrcModelBElement(difference.getCorrespondingObjectInB(change.getSrc()));
					deleteMatch.setTgtModelBElement(difference.getCorrespondingObjectInB(change.getTgt()));
					
					findParameters(parameters, editRule, eoHenshinEdge.getSource(), change.getSrc());
					findParameters(parameters, editRule, eoHenshinEdge.getTarget(), change.getTgt());
				}
			}
			
			else if (changePattern instanceof ChangePatternAttributeValueChange) {
				ChangePatternAttributeValueChange attributeChange = ((ChangePatternAttributeValueChange) changePattern);
				
				AttributeValueChange avc = (AttributeValueChange) matching
						.getFirstMatch(attributeChange.getChangeNodePattern());
				
				if (avc != null) {
					RecognitionAttributeMatch attributeMatch = new RecognitionAttributeMatch(
							attributeChange.getAttribute().getRhsAttribute(), 
							avc.getObjB(), avc.getObjB().eGet(avc.getType()));
					
					editRuleMatch.add(attributeMatch);
					
					Node eoHenshinNode = attributeMatch.getAttribute().getNode();
					findParameters(parameters, editRule, eoHenshinNode, avc.getObjB());
				}
			}
		}
		
		editRuleMatch.addAll(parameters.values());
		return editRuleMatch;
	}
	
	private void findParameters(Map<Parameter, RecognitionParameterMatch> parameters, Rule editRule, Node node, EObject match) {
		for (Attribute attribute : node.getAttributes()) {
			Parameter parameter = editRule.getParameter(attribute.getValue());
			
			if (parameter != null) {
				Object value = match.eGet(attribute.getType());
				
				// TODO: Check attribute value mappings here?
				if (!parameters.containsKey(parameter)) {
					RecognitionParameterMatch parameterMatch = new RecognitionParameterMatch(parameter, value);
					parameters.put(parameter, parameterMatch);
				}
			}
		}
	}
}
