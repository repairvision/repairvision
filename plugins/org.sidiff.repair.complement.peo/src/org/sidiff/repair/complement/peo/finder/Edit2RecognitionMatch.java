package org.sidiff.repair.complement.peo.finder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricPackage;
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
	
	public Edit2RecognitionMatch(IRevision revision) {
		this(revision, null);
	}
	
	public List<Change> getChangeSet(RecognitionPattern recognitionPattern, IMatching matching) {
		ArrayList<Change> changeSet = new ArrayList<>();
		
		for (NodePattern changeNodePattern : recognitionPattern.getChangeNodePatterns()) {
			EObject match = matching.getFirstMatch(changeNodePattern);
			
			if (match instanceof Change) { // i.e. no match -> null
				changeSet.add((Change) matching.getFirstMatch(changeNodePattern));
			}
		}
		
		changeSet.trimToSize();
		return changeSet;
	}
	
	public List<RecognitionMatch> createEditRuleMatch(RecognitionPattern recognitionPattern, IMatching matching) {
		Rule editRule = recognitionPattern.getEditRule();
		
		// NOTE: Consider attribute value overwrites only for full structural matchings.
		boolean considerAttributeValueOverwrites = isFullStructuralMatching(matching);
		
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
					
					// <<Set> Attributes in << Create >>:
					for (Attribute settingAttribute : eoHenshinNode.getAttributes()) {
						Object value = addedObj.eGet(settingAttribute.getType());
						
						if (!considerAttributeValueOverwrites || isRecognizedAttributeValueSet(settingAttribute, addedObj, value)) {
							RecognitionAttributeMatch setAttributeMatch = new RecognitionAttributeMatch(
									settingAttribute, addedObj, value);
							editRuleMatch.add(setAttributeMatch);
						} else {
							// NOTE: Filter the parameters that should be overwritten with user defined values:
							Parameter parameter = editRule.getParameter(settingAttribute.getValue());
							
							if (parameter != null) {
								// NOTE: Already assigned values are not assigned again by findParameters()
								parameters.put(parameter, null);
							}
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
		
		parameters.values().stream().filter(Objects::nonNull).forEach(editRuleMatch::add);
		return editRuleMatch;
	}
	
	private boolean isFullStructuralMatching(IMatching matching) {
		if (!matching.isPartialMatching()) {
			return true;
		} else {
			for (NodePattern changeNode : matching.getNodes()) {
				if (!(changeNode.getType() == SymmetricPackage.eINSTANCE.getAttributeValueChange())) {
					if (matching.getFirstMatch(changeNode) == null) {
						return false;
					}
				}
			}
			return true;
		}
	}
	
	private boolean isRecognizedAttributeValueSet(Attribute settingAttribute, EObject addedObj, Object value) {
		Object constantValue = JavaSciptParser.getConstant(settingAttribute.getType().getEAttributeType(), settingAttribute.getValue());
		
		if (constantValue != null) {
			// Constant value:
			return constantValue.equals(value);
		} else {
			// Variable value:
			if (impact != null) {
				return !impact.getCurrentImpactAnalysis().onModify(addedObj, settingAttribute.getType());
			} else {
				return true;
			}
		}
	}

	private void findParameters(Map<Parameter, RecognitionParameterMatch> parameters, Rule editRule, Node node, EObject match) {
		// NOTE: Parameter can be assigned with 'null' to signal a user defined value.
		
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
