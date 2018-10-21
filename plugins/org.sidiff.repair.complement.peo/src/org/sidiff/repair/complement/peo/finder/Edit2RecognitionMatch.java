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
import org.sidiff.editrule.recognition.IMatching;
import org.sidiff.editrule.recognition.pattern.RecognitionPattern;
import org.sidiff.editrule.recognition.pattern.graph.ChangePattern;
import org.sidiff.editrule.recognition.pattern.graph.ChangePatternAddObject;
import org.sidiff.editrule.recognition.pattern.graph.ChangePatternAddReference;
import org.sidiff.editrule.recognition.pattern.graph.ChangePatternAttributeValueChange;
import org.sidiff.editrule.recognition.pattern.graph.ChangePatternRemoveObject;
import org.sidiff.editrule.recognition.pattern.graph.ChangePatternRemoveReference;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.attributes.JavaSciptParser;
import org.sidiff.history.revision.IRevision;
import org.sidiff.repair.complement.matching.RecognitionAttributeMatch;
import org.sidiff.repair.complement.matching.RecognitionEdgeMatch;
import org.sidiff.repair.complement.matching.RecognitionMatch;
import org.sidiff.repair.complement.matching.RecognitionNodeSingleMatch;
import org.sidiff.repair.complement.matching.RecognitionParameterMatch;
import org.sidiff.validation.constraint.impact.ImpactAnalyzes;

public class Edit2RecognitionMatch {

	/**
	 * The revision between model A and B.
	 */
	private IRevision revision;
	
	/**
	 * Used to check the impact of << set >> attributes of << create >> nodes.
	 */
	private ImpactAnalyzes impact;
	
	public Edit2RecognitionMatch(IRevision revision, ImpactAnalyzes impact) {
		this.revision = revision;
		this.impact = impact;
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
					EObject addedObj = change.getObj();  
					
					// Node:
					Node eoHenshinNode = ((ChangePatternAddObject) changePattern).getNode().getEditRuleNode();
					RecognitionNodeSingleMatch createMatch = new RecognitionNodeSingleMatch(Type.CREATE, eoHenshinNode);
					createMatch.setModelBElement(addedObj);
					editRuleMatch.add(createMatch);
					
					// Attributes:
					for (Attribute settingAttribute : eoHenshinNode.getAttributes()) {
						Object value = addedObj.eGet(settingAttribute.getType());
						
						if (matching.isPartialMatching() || isRecognizedValueChange(settingAttribute, addedObj, value)) {
							RecognitionAttributeMatch setAttributeMatch = new RecognitionAttributeMatch(
									settingAttribute, addedObj, value);
							editRuleMatch.add(setAttributeMatch);
						}
					}
					
					// Parameters:
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
					createMatch.setSrcModelAElement(revision.getDifference().getCorrespondingObjectInA(change.getSrc()));
					createMatch.setTgtModelAElement(revision.getDifference().getCorrespondingObjectInA(change.getTgt()));
					
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
					deleteMatch.setSrcModelBElement(revision.getDifference().getCorrespondingObjectInB(change.getSrc()));
					deleteMatch.setTgtModelBElement(revision.getDifference().getCorrespondingObjectInB(change.getTgt()));
					
					findParameters(parameters, editRule, eoHenshinEdge.getSource(), change.getSrc());
					findParameters(parameters, editRule, eoHenshinEdge.getTarget(), change.getTgt());
				}
			}
			
			// EO-Attribute-Value changes:
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
	
	private boolean isRecognizedValueChange(Attribute settingAttribute, EObject addedObj, Object value) {
		Object constantValue = JavaSciptParser.getConstant(settingAttribute.getValue());
		
		if (constantValue != null) {
			// Constant value:
			return constantValue.equals(value);
		} else {
			// Variable value:
			return !impact.getPositiveImpactAnalysis().onModify(addedObj, settingAttribute.getType());
		}
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
