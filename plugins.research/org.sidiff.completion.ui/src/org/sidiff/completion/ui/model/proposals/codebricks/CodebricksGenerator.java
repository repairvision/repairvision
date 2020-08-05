package org.sidiff.completion.ui.model.proposals.codebricks;

import static org.sidiff.completion.ui.model.proposals.util.ModelCompletionProposalUtil.TEMPLATE_EDIT_RULE_SEPARATOR;
import static org.sidiff.completion.ui.model.proposals.util.ModelCompletionProposalUtil.TEMPLATE_MANDATORY_PLACEHOLDER;
import static org.sidiff.completion.ui.model.proposals.util.ModelCompletionProposalUtil.TEMPLATE_OPTIONAL_PLACEHOLDER;
import static org.sidiff.completion.ui.model.proposals.util.ModelCompletionProposalUtil.TEMPLATE_PARAMETER_LIST_POSTFIX;
import static org.sidiff.completion.ui.model.proposals.util.ModelCompletionProposalUtil.TEMPLATE_PARAMETER_LIST_PREFIX;
import static org.sidiff.completion.ui.model.proposals.util.ModelCompletionProposalUtil.TEMPLATE_PARAMETER_NAME_VALUE_SEPARATOR;
import static org.sidiff.completion.ui.model.proposals.util.ModelCompletionProposalUtil.TEMPLATE_PARAMETER_SEPARATOR;
import static org.sidiff.completion.ui.model.proposals.util.ModelCompletionProposalUtil.TEMPLATE_PRESENCE_SEPARATOR_TRIM;
import static org.sidiff.completion.ui.model.proposals.util.ModelCompletionProposalUtil.getPlainTemplate;
import static org.sidiff.completion.ui.model.proposals.util.ModelCompletionProposalUtil.getSubGraphChanges;
import static org.sidiff.completion.ui.model.proposals.util.ModelCompletionProposalUtil.getSubGraphContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.completion.ui.codebricks.Brick;
import org.sidiff.completion.ui.codebricks.Codebrick;
import org.sidiff.completion.ui.codebricks.Codebricks;
import org.sidiff.completion.ui.codebricks.CodebricksFactory;
import org.sidiff.completion.ui.codebricks.CollapsibleBrick;
import org.sidiff.completion.ui.codebricks.ComposedBrick;
import org.sidiff.completion.ui.codebricks.LineBreakBrick;
import org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick;
import org.sidiff.completion.ui.codebricks.POJOCodebrickView;
import org.sidiff.completion.ui.codebricks.ResetTemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.TextBrick;
import org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.ViewableBrick;
import org.sidiff.completion.ui.model.proposals.ModelCompletionProposal;
import org.sidiff.completion.ui.model.proposals.ModelCompletionProposalCluster;
import org.sidiff.completion.ui.model.proposals.util.DecompositionTemplates;
import org.sidiff.graphpattern.attributes.JavaSciptParser;
import org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension;
import org.sidiff.graphpattern.profile.henshin_extension.SubGraph;
import org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil;
import org.sidiff.revision.editrules.generation.decompose.DecomposingEditRulesUtil;

public class CodebricksGenerator {
	
	private static final int[] COLOR_RULE_NAME = {127, 0, 85};
	
	public Codebricks createCodebrick(ModelCompletionProposalCluster cluster) {
		Codebricks codebricks = CodebricksFactory.eINSTANCE.createCodebricks();
		
		// Create template:
		POJOCodebrickView template = CodebricksFactory.eINSTANCE.createDelegateToAlternativePOJOCodebrickView();
		codebricks.setTemplate(template);
		
		// Historic:
		LinkedHashMap<ComposedBrick, String> historicEditRules = createEditRuleSequenceCodebrick(
				template, 
				cluster.getIntersectionHistoricTemplates(), 
				cluster.getSupersetProposal().getHistoricTemplates(), 
				cluster.getSupersetProposal()::getHistoricByTemplate);
		
		// Presence:
		LineBreakBrick lineBreakBeforeHistoricalSeparator = CodebricksFactory.eINSTANCE.createLineBreakBrick();
		template.getBricks().add(lineBreakBeforeHistoricalSeparator);
		
		TextBrick historicalComplementSeparatorBrick = CodebricksFactory.eINSTANCE.createTextBrick();
		historicalComplementSeparatorBrick.setText(TEMPLATE_PRESENCE_SEPARATOR_TRIM + " ");
		template.getBricks().add(historicalComplementSeparatorBrick);
		
		// Complement:
		LinkedHashMap<ComposedBrick, String> complementEditRules = createEditRuleSequenceCodebrick(
				template, 
				cluster.getIntersectionComplementTemplates(), 
				cluster.getSupersetProposal().getComplementFirstLevel(), 
				cluster.getSupersetProposal()::getComplementByFirstLevel);
		
		// Generate alternatives:
		createAlternatives(cluster.getProposalCluster(), codebricks, historicEditRules, complementEditRules);
		
		return codebricks;
	}
	
	private void createAlternatives(
			List<ModelCompletionProposal> proposalCluster, Codebricks codebricks,
			LinkedHashMap<ComposedBrick, String> historicTemplate,
			LinkedHashMap<ComposedBrick, String> complementTemplate) {
		
		for (ModelCompletionProposal proposal : proposalCluster) {
			DecompositionTemplates decomposition = proposal.getDecomposition();
			
			// Create alternative:
			POJOCodebrickView template = CodebricksFactory.eINSTANCE.createPOJOCodebrickView();
			template.setModel(proposal);
			codebricks.getAlternatives().add(template);
			
			// Historic:
			LinkedHashMap<ComposedBrick, String> historicAlternative = createEditRuleSequenceCodebrick(
					template, null, decomposition.getHistoricTemplates(), 
					decomposition::getHistoricByTemplate);
			
			// Presence:
			LineBreakBrick lineBreakBeforeHistoricalSeparator = CodebricksFactory.eINSTANCE.createLineBreakBrick();
			template.getBricks().add(lineBreakBeforeHistoricalSeparator);
			
			TextBrick historicalComplementSeparatorBrick = CodebricksFactory.eINSTANCE.createTextBrick();
			historicalComplementSeparatorBrick.setText(TEMPLATE_PRESENCE_SEPARATOR_TRIM + " ");
			template.getBricks().add(historicalComplementSeparatorBrick);
			
			// Complement:
			LinkedHashMap<ComposedBrick, String> complementAlternative = createEditRuleSequenceCodebrick(
					template, null, decomposition.getComplementTemplates(), 
					decomposition::getComplementByTemplate);
			
			// Map alternatives to template, i.e, calculate choices:
			// NOTE: There should be no choices for the historic template if it is common to all alternatives.
			matchAlternativeToTemplates(historicAlternative, historicTemplate); 
			matchAlternativeToTemplates(complementAlternative, complementTemplate);
		}
	}
	
	private boolean matchAlternativeToTemplates(
			LinkedHashMap<ComposedBrick, String> matchAlternative,
			LinkedHashMap<ComposedBrick, String> inTemplate) {
		
		// SEE: org.sidiff.completion.ui.model.ModelCompletionProposalCluster.matchTemplates()
		
		// TODO: NOTE*1: We currently do not check if the common sub sequence of rules is also a common sub graph!
		//               This doesn't matter if we not show the parameters in the template for the unselected sub rules.
		//               Different sub graphs would just lead to different IN/OUT parameter bindings between the sub rules.
		
		if (!inTemplate.isEmpty() && !matchAlternative.isEmpty() && (matchAlternative.size() <= inTemplate.size())) {
			Iterator<Entry<ComposedBrick, String>> matchAlternativeItr = matchAlternative.entrySet().iterator();
			Iterator<Entry<ComposedBrick, String>> inTemplatesItr = inTemplate.entrySet().iterator();
			
			Entry<ComposedBrick, String> searchedAlternative = matchAlternativeItr.next();
			
			while(inTemplatesItr.hasNext()) {
				Entry<ComposedBrick, String> nextTemplate = inTemplatesItr.next();
				
				// Match by template text:
				String template = DecomposingEditRulesUtil.getFirstLevelTemplate(nextTemplate.getValue());
				String alternativeTemplate = DecomposingEditRulesUtil.getFirstLevelTemplate(searchedAlternative.getValue());
				
				if (template.equals(alternativeTemplate)) {

					// Template has placeholder? 
					if (DecomposingEditRulesUtil.containsPlaceholder(template)) {
						TemplatePlaceholderBrick placeholder = null;
						
						if (nextTemplate.getKey() instanceof TemplatePlaceholderBrick) {
							placeholder = (TemplatePlaceholderBrick) nextTemplate.getKey();
						} else if (nextTemplate.getKey() instanceof ComposedBrick) {
							for (ViewableBrick brick : ((ComposedBrick) nextTemplate.getKey()).getBricks()) {
								if (brick instanceof TemplatePlaceholderBrick) {
									placeholder = (TemplatePlaceholderBrick) brick;
									break;
								}
							}
						}
						
						// Add to choices:
						if (placeholder != null) {
							ComposedBrick choice = searchedAlternative.getKey();
							placeholder.getChoices().add(choice);
							
							// Setup template reset hooks:
							for (Brick choiceBrick : choice.getBricks()) {
								if (choiceBrick instanceof ResetTemplatePlaceholderBrick) {
									((ResetTemplatePlaceholderBrick) choiceBrick).setPlaceholder(placeholder);
								}
							}
						}
					}
					
					
					if (matchAlternativeItr.hasNext()) {
						searchedAlternative = matchAlternativeItr.next();
					} else {
						// All alternatives matched!
						return true;
					}
				}
			}
		}
		
		return false;
	}

	/**
	 * @return Bricks of the sub edit rules. 
	 */
	private LinkedHashMap<ComposedBrick, String> createEditRuleSequenceCodebrick(
			Codebrick codebrick, List<String> intersectionTemplates,
			List<String> templates, Function<String, SubGraph> templateToRule) {
		
		LinkedHashMap<ComposedBrick, String> subEditRules = new LinkedHashMap<>();
		
		for (String template : templates) {
			
			// Common?
			if ((intersectionTemplates == null) || intersectionTemplates.contains(template)) {
				String plainTemplate = getPlainTemplate(template);
				
				// Sub edit rule template?
				if (DecomposingEditRulesUtil.containsPlaceholder(template)) {
					ComposedBrick subEditRule = CodebricksFactory.eINSTANCE.createComposedBrick();
					
					// NOTE: Not show parameters for template:
					// SEE NOTE*1 
					
					TemplatePlaceholderBrick subEditRuleBrick = CodebricksFactory.eINSTANCE.createTemplatePlaceholderBrick();
					subEditRuleBrick.setPlaceholder(plainTemplate + TEMPLATE_PARAMETER_LIST_PREFIX + TEMPLATE_PARAMETER_LIST_POSTFIX);
					subEditRuleBrick.setMandatory(true);
					subEditRuleBrick.setColor(COLOR_RULE_NAME[0], COLOR_RULE_NAME[1], COLOR_RULE_NAME[2]);
					subEditRuleBrick.setHighlight(true);
					subEditRule.getBricks().add(subEditRuleBrick);
					
					// Add sub edit rule to template:
					codebrick.getBricks().add(subEditRule);
					subEditRules.put(subEditRule, template); // NOTE: the rule template string is not necessarily unique.
				} else {
					CollapsibleBrick subEditRule = CodebricksFactory.eINSTANCE.createCollapsibleBrick();
					
					// Text representing the rule name:
					TextBrick subEditRuleBrick = CodebricksFactory.eINSTANCE.createTextBrick();
					subEditRuleBrick.setText(plainTemplate);
					subEditRuleBrick.setColor(COLOR_RULE_NAME[0], COLOR_RULE_NAME[1], COLOR_RULE_NAME[2]);
					subEditRuleBrick.setHighlight(true);
					
					// Text install placeholder reset hook:
					ResetTemplatePlaceholderBrick resetPlaceholderBrick = CodebricksFactory.eINSTANCE.createResetTemplatePlaceholderBrick();
					resetPlaceholderBrick.setAttachedTo(subEditRuleBrick);
					resetPlaceholderBrick.setColor(COLOR_RULE_NAME[0], COLOR_RULE_NAME[1], COLOR_RULE_NAME[2]);
					resetPlaceholderBrick.setHighlight(true);
					subEditRule.getBricks().add(resetPlaceholderBrick);
					
					createTemplateParameters(subEditRule, templateToRule.apply(template));
					
					// Add sub edit rule to template:
					codebrick.getBricks().add(subEditRule);
					subEditRules.put(subEditRule, template); // NOTE: the rule template string is not necessarily unique.
				}
				
			} else {
				ComposedBrick subEditRule = CodebricksFactory.eINSTANCE.createComposedBrick();
				
				// Optional placeholder:
				// NOTE: Actually, not needed since we currently match only proposals with the same historic template.
				TemplatePlaceholderBrick subEditRuleBrick = CodebricksFactory.eINSTANCE.createTemplatePlaceholderBrick();
				subEditRuleBrick.setPlaceholder(TEMPLATE_OPTIONAL_PLACEHOLDER);
				subEditRuleBrick.setMandatory(false);
				
				subEditRule.getBricks().add(subEditRuleBrick);
				
				// Add sub edit rule to template:
				codebrick.getBricks().add(subEditRule);
				subEditRules.put(subEditRule, template); // NOTE: the rule template string is not necessarily unique.
			}
			
			// Not last rule?
			if (template != templates.get(templates.size() -1)) {
				LineBreakBrick lineBreakBeforeRuleSeparator = CodebricksFactory.eINSTANCE.createLineBreakBrick();
				codebrick.getBricks().add(lineBreakBeforeRuleSeparator);
				
				TextBrick ruleSeparatorBrick = CodebricksFactory.eINSTANCE.createTextBrick();
				ruleSeparatorBrick.setText(TEMPLATE_EDIT_RULE_SEPARATOR);
				codebrick.getBricks().add(ruleSeparatorBrick);
			}
		}
		
		return subEditRules;
	}

	private void createTemplateParameters(CollapsibleBrick template, SubGraph subEditRule) {
		
		// NOTE: Show (all) IN parameters of subEditRule (hide OUT parameters):
		
		// add '(':
		TextBrick ruleParameterOpeningBracesBrick = CodebricksFactory.eINSTANCE.createTextBrick();
		ruleParameterOpeningBracesBrick.setText(TEMPLATE_PARAMETER_LIST_PREFIX);
		template.getBricks().add(ruleParameterOpeningBracesBrick);
		
		// Create parameters for sub edit rule:
		List<ViewableBrick> parameterList = new ArrayList<>();
		Brick contextParameterSeparator = createParametersForSubGraph(parameterList, getSubGraphContext(subEditRule));
		Brick changesParameterSeparator = createParametersForSubGraph(parameterList, getSubGraphChanges(subEditRule));
		template.getBricks().addAll(parameterList);
		
		// Remove last ',':
		if ((changesParameterSeparator == null) && (contextParameterSeparator != null)) {
			EcoreUtil.remove(contextParameterSeparator);
		}
		if (changesParameterSeparator != null) {
			EcoreUtil.remove(changesParameterSeparator);
		}
		
		// Make parameter list collapsible:
		template.getCollapsible().addAll(parameterList);
		
		// add ')':
		TextBrick ruleParameterClosingBracesBrick = CodebricksFactory.eINSTANCE.createTextBrick();
		ruleParameterClosingBracesBrick.setText(TEMPLATE_PARAMETER_LIST_POSTFIX);
		template.getBricks().add(ruleParameterClosingBracesBrick);
	}

	private Brick createParametersForSubGraph(List<ViewableBrick> parameterBricks, List<GraphElementExtension> subGraph) {
		TextBrick parameterSeparator = null;
		
		for (GraphElementExtension graphElement : subGraph) {
			if (graphElement instanceof Node) {
				Node eoNode = (Node) graphElement;
				
				if (!HenshinRuleAnalysisUtil.isCreationNode(eoNode)) {
					String name = eoNode.getName();
					
					// Check if parameter already exists:
					if (!parameterBricks.stream().anyMatch(b -> b.getText().startsWith(name + TEMPLATE_PARAMETER_NAME_VALUE_SEPARATOR))) {
						ComposedBrick newParameter = generateObjectParameter(name, eoNode.getType());
						
						parameterSeparator = CodebricksFactory.eINSTANCE.createTextBrick();
						parameterSeparator.setText(TEMPLATE_PARAMETER_SEPARATOR);
						newParameter.getBricks().add(parameterSeparator);
						
						parameterBricks.add(newParameter);
					}
				}
				
				for (Attribute attribute : eoNode.getAttributes()) {
					for (String variable : JavaSciptParser.getVariables(attribute.getType().getEAttributeType(), attribute.getValue())) {
						
						// Check if parameter already exists:
						if (!parameterBricks.stream().anyMatch(b -> b.getText().startsWith(variable + TEMPLATE_PARAMETER_NAME_VALUE_SEPARATOR))) {
							ComposedBrick newParameter = generateValueParameter(variable, attribute.getType().getEAttributeType());
							
							parameterSeparator = CodebricksFactory.eINSTANCE.createTextBrick();
							parameterSeparator.setText(TEMPLATE_PARAMETER_SEPARATOR);
							newParameter.getBricks().add(parameterSeparator);
							
							parameterBricks.add(newParameter);
						}
					}
				}
			}
		}
		
		return parameterSeparator;
	}
	
	private ComposedBrick generateValueParameter(String name, EDataType type) {
		ComposedBrick parameterAssignment = CodebricksFactory.eINSTANCE.createComposedBrick();
		
		TextBrick parameterName = CodebricksFactory.eINSTANCE.createTextBrick();
		parameterName.setText(name);
		parameterName.setHighlight(true);
		parameterAssignment.getBricks().add(parameterName);
		
		TextBrick parameterNameValueSeparator = CodebricksFactory.eINSTANCE.createTextBrick();
		parameterNameValueSeparator.setText(TEMPLATE_PARAMETER_NAME_VALUE_SEPARATOR);
		parameterAssignment.getBricks().add(parameterNameValueSeparator);
		
		ValuePlaceholderBrick parameter = CodebricksFactory.eINSTANCE.createValuePlaceholderBrick();
		parameter.setPlaceholder(TEMPLATE_MANDATORY_PLACEHOLDER);
		parameter.setName(name);
		parameter.setType(type);
		parameter.setDomain(CompletionValueDomainPolicy.eINSTANCE);
		parameter.setMandatory(true);
		parameterAssignment.getBricks().add(parameter);
		
		return parameterAssignment;
	}
	
	private ComposedBrick generateObjectParameter(String name, EClass type) {
		ComposedBrick parameterAssignment = CodebricksFactory.eINSTANCE.createComposedBrick();
		
		TextBrick parameterName = CodebricksFactory.eINSTANCE.createTextBrick();
		parameterName.setText(name);
		parameterName.setHighlight(true);
		parameterAssignment.getBricks().add(parameterName);
		
		TextBrick parameterNameValueSeparator = CodebricksFactory.eINSTANCE.createTextBrick();
		parameterNameValueSeparator.setText(TEMPLATE_PARAMETER_NAME_VALUE_SEPARATOR);
		parameterAssignment.getBricks().add(parameterNameValueSeparator);
		
		ObjectPlaceholderBrick parameter = CodebricksFactory.eINSTANCE.createObjectPlaceholderBrick();
		parameter.setPlaceholder(TEMPLATE_MANDATORY_PLACEHOLDER);
		parameter.setName(name);
		parameter.setType(type);
		parameter.setDomain(CompletionObjectDomainPolicy.eINSTANCE);
		parameter.setMandatory(true);
		parameterAssignment.getBricks().add(parameter);
		
		return parameterAssignment;
	}
}
