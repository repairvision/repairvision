package org.sidiff.completion.ui.model;

import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.TEMPLATE_EDIT_RULE_SEPARATOR;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.TEMPLATE_MANDATORY_PLACEHOLDER;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.TEMPLATE_OPTIONAL_PLACEHOLDER;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.TEMPLATE_PARAMETER_NAME_VALUE_SEPARATOR;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.TEMPLATE_PARAMETER_SEPARATOR;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.TEMPLATE_PRESENCE_SEPARATOR;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.TEMPLATE_PRESENCE_SEPARATOR_TRIM;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.generateDecompositionSequenceFromHierarchicals;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.getPlainTemplate;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.getSubGraphChanges;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.getSubGraphContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.HenshinPackage;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.swt.graphics.Image;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;
import org.sidiff.completion.ui.codebricks.Brick;
import org.sidiff.completion.ui.codebricks.Codebrick;
import org.sidiff.completion.ui.codebricks.Codebricks;
import org.sidiff.completion.ui.codebricks.CodebricksFactory;
import org.sidiff.completion.ui.codebricks.ComposedBrick;
import org.sidiff.completion.ui.codebricks.LineBreakBrick;
import org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick;
import org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.TextBrick;
import org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.ViewableBrick;
import org.sidiff.completion.ui.codebricks.editor.CodebricksEditor;
import org.sidiff.completion.ui.list.ICompletionPreview;
import org.sidiff.completion.ui.list.ICompletionProposal;
import org.sidiff.graphpattern.attributes.JavaSciptParser;
import org.sidiff.graphpattern.edit.util.ItemProviderUtil;
import org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension;
import org.sidiff.graphpattern.profile.henshin_extension.SubGraph;
import org.sidiff.graphpattern.tools.editrules.DecomposingEditRulesUtil;

public class ModelCompletionProposalCluster implements ICompletionProposal {
	
	private static Image ICON = (Image) ItemProviderUtil.getImageByType(HenshinPackage.eINSTANCE.getRule());

	private List<ModelCompletionProposal> proposalCluster;
	
	private DecompositionTemplates supersetProposal;
	
	private List<String> intersectionHistoricTemplates;
	
	private List<String> intersectionComplementTemplates;
	
	public ModelCompletionProposalCluster(
			ModelCompletionProposal initialProposal, 
			DecompositionTemplates initialTemplate) {
		
		this.proposalCluster = new ArrayList<>();
		this.proposalCluster.add(initialProposal);
		this.supersetProposal = initialTemplate;
		
		// Initialize template intersection:
		// NOTE: Allows only sub set clustering!
		intersectionHistoricTemplates = new ArrayList<>(initialTemplate.getHistoricFirstLevel());
		intersectionComplementTemplates = new ArrayList<>(initialTemplate.getComplementFirstLevel());
	}

	/**
	 * @return This cluster if the given candidate was added. A fork of this cluster
	 *         if the candidate matches this cluster but not its current
	 *         intersection of all other members of this cluster. <code>null</code> if
	 *         the candidate does not match into this cluster.
	 */
	public ModelCompletionProposalCluster add(
			ModelCompletionProposal proposalCandidate, 
			DecompositionTemplates candidateProposal) {
		
		// Match historic exact:
		if (supersetProposal.getHistoricFirstLevel().size() == candidateProposal.getHistoricFirstLevel().size()) {
			List<String> superSetComplementTemplate = supersetProposal.getComplementFirstLevel();
			List<String> subSetComplementTemplate = candidateProposal.getComplementFirstLevel();
			
			// Is candidate larger? -> Switch:
			if (subSetComplementTemplate.size() > superSetComplementTemplate.size()) {
				superSetComplementTemplate = candidateProposal.getComplementFirstLevel();
				subSetComplementTemplate = supersetProposal.getComplementFirstLevel();
			}
			
			// Match historic/current candidate template in this historic/current template:
			if (matchTemplates(candidateProposal.getHistoricFirstLevel(), supersetProposal.getHistoricFirstLevel())) {
				if (matchTemplates(subSetComplementTemplate, superSetComplementTemplate)) {
					
					// Is candidate larger and contains currently largest main template? 
					// -> Make the candidate the new largest main template:
					if (subSetComplementTemplate == supersetProposal.getComplementFirstLevel()) {
						this.supersetProposal = candidateProposal;
						proposalCluster.add(0, proposalCandidate);
						
						// NOTE: If the candidate fully contains the largest template,
						//       this implies that it also fully contains the common intersection.
						
						return this;
					} else {
						
						// Matches common intersection? -> add to cluster:
						if (matchTemplates(candidateProposal.getHistoricFirstLevel(), intersectionHistoricTemplates)) {
							if (matchTemplates(candidateProposal.getComplementFirstLevel(), intersectionComplementTemplates)) {
								proposalCluster.add(proposalCandidate);
								
								// Update/Shrink intersections:
								// TODO: Check this...!?
								intersectionHistoricTemplates.retainAll(candidateProposal.getHistoricFirstLevel());
								intersectionComplementTemplates.retainAll(candidateProposal.getComplementFirstLevel());
								
								return this;
							}
						}
					}
					
					// Matches the main template but not the common intersection -> fork this cluster:
					ModelCompletionProposalCluster fork = new ModelCompletionProposalCluster(supersetProposal.getProposal(), supersetProposal);
					fork.proposalCluster.add(proposalCandidate);
				}
			}
		}
		
		// No match:
		return null;
	}

	/**
	 * @param matchTemplatesA Sequence of templates to be matched.
	 * @param inTemplatesB    Sequence of templates as matching base.
	 * @return <code>true</code> A is a subsequence of B; <code>false</code> otherwise.
	 */
	private boolean matchTemplates(List<String> matchTemplatesA, List<String> inTemplatesB) {
		
		// TODO: NOTE*1: We currently do not check if the common sub sequence are also common sub graphs!
		//               If we not show the parameters in the template for the unselected sub rules, this is still correct.
		//               Different sub graphs would just lead to different IN/OUT parameter bindings between the sub rules.
		
		if (!inTemplatesB.isEmpty() && !matchTemplatesA.isEmpty() && (matchTemplatesA.size() <= inTemplatesB.size())) {
			Iterator<String> matchTemplatesAItr = matchTemplatesA.iterator();
			Iterator<String> inTemplatesBItr = inTemplatesB.iterator();
			
			String searchedTemplateA = matchTemplatesAItr.next();
			
			while(inTemplatesBItr.hasNext()) {
				String nextTemplateB = inTemplatesBItr.next();
				
				// Match against largest main template:
				if (searchedTemplateA.equals(nextTemplateB)) {
					if (matchTemplatesAItr.hasNext()) {
						searchedTemplateA = matchTemplatesAItr.next();
					} else {
						// All candidate templates matched!
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean matchAlternativeToTemplates(
			LinkedHashMap<ComposedBrick, String> matchAlternative,
			LinkedHashMap<ComposedBrick, String> inTemplate) {
		
		// TODO: SEE NOTE*1
		
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
							placeholder.getChoices().add(searchedAlternative.getKey());
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

	@Override
	public String getText() {
		return generateDecompositionSequenceFromHierarchicals(intersectionHistoricTemplates) + TEMPLATE_PRESENCE_SEPARATOR + generateDecompositionSequenceFromHierarchicals(intersectionComplementTemplates);
	}
	
	@Override
	public Image getImage() {
		return ICON;
	}

	@Override
	public String getInformation() {
		// Show all proposals in cluster.
		StringBuilder info = new StringBuilder();
		info.append("<p><strong>Partial execution of edit operations recognized:</strong></p><br>\n");
		
		for (ModelCompletionProposal proposal : proposalCluster) {
			DecompositionTemplates decomposition = proposal.getDecomposition();
			
			info.append("<p>");
			info.append(proposal.getComplement().getComplementRule().getName());
			info.append("<br>");
			info.append(" = " + generateDecompositionSequenceFromHierarchicals(decomposition.getHistoricTemplates())
					+ TEMPLATE_PRESENCE_SEPARATOR + generateDecompositionSequenceFromHierarchicals(decomposition.getComplementTemplates()));
			info.append("</p>");
			info.append("<br>");
			info.append("\n");
		}
		
		return info.toString();
	}

	@Override
	public ICompletionPreview preview() {
		// TODO: Apply/undo on editing domain
//		System.out.println("Preview: " + similarProposals.get(0).getComplement().getComplementRule().getName());
		return null;
	}

	@Override
	public boolean apply() {
		// Open template in Codebricks editor:
		Codebricks codebricks = createCodebrick();
		
		CodebricksEditor editor = new CodebricksEditor();
		editor.setContent(codebricks);
		editor.showPopupOnCursor();
		
		return false;
	}
	
	private Codebricks createCodebrick() {
		Codebricks codebricks = CodebricksFactory.eINSTANCE.createCodebricks();
		
		// Create template:
		Codebrick template = CodebricksFactory.eINSTANCE.createCodebrick();
		codebricks.setTemplate(template);
		
		// Historic:
		LinkedHashMap<ComposedBrick, String> historicEditRules = createEditRuleSequenceCodebrick(
				template, intersectionHistoricTemplates, supersetProposal.getHistoricTemplates(), 
				supersetProposal::getHistoricByTemplate);
		
		// Presence:
		LineBreakBrick lineBreakBeforeHistoricalSeparator = CodebricksFactory.eINSTANCE.createLineBreakBrick();
		template.getBricks().add(lineBreakBeforeHistoricalSeparator);
		
		TextBrick historicalComplementSeparatorBrick = CodebricksFactory.eINSTANCE.createTextBrick();
		historicalComplementSeparatorBrick.setText(TEMPLATE_PRESENCE_SEPARATOR_TRIM + " ");
		template.getBricks().add(historicalComplementSeparatorBrick);
		
		// Complement:
		LinkedHashMap<ComposedBrick, String> complementEditRules = createEditRuleSequenceCodebrick(
				template, intersectionComplementTemplates, supersetProposal.getComplementFirstLevel(), 
				supersetProposal::getComplementByFirstLevel);
		
		// Generate alternatives:
		createAlternatives(codebricks, historicEditRules, complementEditRules);
		
		return codebricks;
	}
	
	private void createAlternatives(Codebricks codebricks,
			LinkedHashMap<ComposedBrick, String> historicTemplate,
			LinkedHashMap<ComposedBrick, String> complementTemplate) {
		
		for (ModelCompletionProposal proposal : proposalCluster) {
			DecompositionTemplates decomposition = proposal.getDecomposition();
			
			// Create alternative:
			Codebrick template = CodebricksFactory.eINSTANCE.createCodebrick();
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

	/**
	 * @return Bricks of the sub edit rules. 
	 */
	private LinkedHashMap<ComposedBrick, String> createEditRuleSequenceCodebrick(
			Codebrick codebrick, List<String> intersectionTemplates,
			List<String> templates, Function<String, SubGraph> templateToRule) {
		
		LinkedHashMap<ComposedBrick, String> subEditRules = new LinkedHashMap<>();
		
		for (String template : templates) {
			ComposedBrick subEditRule = CodebricksFactory.eINSTANCE.createComposedBrick();
			
			// Common?
			if ((intersectionTemplates == null) || intersectionTemplates.contains(DecomposingEditRulesUtil.getFirstLevelTemplate(template))) {
				
				// Sub edit rule template?
				if (DecomposingEditRulesUtil.containsPlaceholder(template)) {
					String plainTemplate = getPlainTemplate(template);
					
					TemplatePlaceholderBrick complementSubEditRuleBrick = CodebricksFactory.eINSTANCE.createTemplatePlaceholderBrick();
					complementSubEditRuleBrick.setPlaceholder(plainTemplate);
					complementSubEditRuleBrick.setMandatory(true);
					subEditRule.getBricks().add(complementSubEditRuleBrick);
					
					// Not show parameters for template:
					// SEE NOTE*1 
					TextBrick ruleParameterOpeningBracesBrick = CodebricksFactory.eINSTANCE.createTextBrick();
					ruleParameterOpeningBracesBrick.setText("(");
					subEditRule.getBricks().add(ruleParameterOpeningBracesBrick);
					
					TextBrick ruleParameterClosingBracesBrick = CodebricksFactory.eINSTANCE.createTextBrick();
					ruleParameterClosingBracesBrick.setText(")");
					subEditRule.getBricks().add(ruleParameterClosingBracesBrick);		
					
				} else {
					String plainFirstLevelTemplate = getPlainTemplate(template);
					
					TextBrick complementSubEditRuleBrick = CodebricksFactory.eINSTANCE.createTextBrick();
					complementSubEditRuleBrick.setText(plainFirstLevelTemplate);
					subEditRule.getBricks().add(complementSubEditRuleBrick);
					
					createTemplateParameters(subEditRule, templateToRule.apply(template));
				}
				
			} else {
				// Optional placeholder:
				// NOTE: Actually, not needed since we currently match only proposals with the same historic template.
				TemplatePlaceholderBrick complementSubEditRuleBrick = CodebricksFactory.eINSTANCE.createTemplatePlaceholderBrick();
				complementSubEditRuleBrick.setPlaceholder(TEMPLATE_OPTIONAL_PLACEHOLDER);
				complementSubEditRuleBrick.setMandatory(false);
				subEditRule.getBricks().add(complementSubEditRuleBrick);
			}
			
			// Add sub edit rule to template:
			codebrick.getBricks().add(subEditRule);
			subEditRules.put(subEditRule, template); // NOTE: the rule template string is not necessarily unique.
			
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

	private void createTemplateParameters(ComposedBrick template, SubGraph subEditRule) {
		
		// NOTE: Show (all) IN parameters of subEditRule (hide OUT parameters):
		
		// add '(':
		TextBrick ruleParameterOpeningBracesBrick = CodebricksFactory.eINSTANCE.createTextBrick();
		ruleParameterOpeningBracesBrick.setText("(");
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
		
		// add ')':
		TextBrick ruleParameterClosingBracesBrick = CodebricksFactory.eINSTANCE.createTextBrick();
		ruleParameterClosingBracesBrick.setText(")");
		template.getBricks().add(ruleParameterClosingBracesBrick);
	}

	private Brick createParametersForSubGraph(List<ViewableBrick> parameterBricks, List<GraphElementExtension> subGraph) {
		TextBrick parameterSeparator = null;
		
		for (GraphElementExtension graphElement : subGraph) {
			if (graphElement instanceof Node) {
				Node eoNode = (Node) graphElement;
				
				if (HenshinRuleAnalysisUtilEx.isDeletionNode(eoNode) || hasEdgeChanges(eoNode)) {
					String name = eoNode.getName();
					
					// Check if parameter already exists:
					if (!parameterBricks.stream().anyMatch(b -> b.getText().startsWith(name + TEMPLATE_PARAMETER_NAME_VALUE_SEPARATOR))) {
						ComposedBrick newParameter = generateObjectParameter(name);
						
						parameterSeparator = CodebricksFactory.eINSTANCE.createTextBrick();
						parameterSeparator.setText(TEMPLATE_PARAMETER_SEPARATOR);
						newParameter.getBricks().add(parameterSeparator);
						
						parameterBricks.add(newParameter);
					}
				}
				
				for (Attribute attribute : eoNode.getAttributes()) {
					for (String variable : JavaSciptParser.getVariables(attribute.getValue())) {
						
						// Check if parameter already exists:
						if (!parameterBricks.stream().anyMatch(b -> b.getText().startsWith(variable + TEMPLATE_PARAMETER_NAME_VALUE_SEPARATOR))) {
							ComposedBrick newParameter = generateValueParameter(variable);
							
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
	
	private ComposedBrick generateValueParameter(String name) {
		TextBrick parameterName = CodebricksFactory.eINSTANCE.createTextBrick();
		parameterName.setText(name + TEMPLATE_PARAMETER_NAME_VALUE_SEPARATOR);
		
		ValuePlaceholderBrick parameter = CodebricksFactory.eINSTANCE.createValuePlaceholderBrick();
		parameter.setPlaceholder(TEMPLATE_MANDATORY_PLACEHOLDER);
		parameter.setMandatory(true);
		
		ComposedBrick parameterAssignment = CodebricksFactory.eINSTANCE.createComposedBrick();
		parameterAssignment.getBricks().add(parameterName);
		parameterAssignment.getBricks().add(parameter);
		
		return parameterAssignment;
	}
	
	private ComposedBrick generateObjectParameter(String name) {
		TextBrick parameterName = CodebricksFactory.eINSTANCE.createTextBrick();
		parameterName.setText(name + TEMPLATE_PARAMETER_NAME_VALUE_SEPARATOR);
		
		ObjectPlaceholderBrick parameter = CodebricksFactory.eINSTANCE.createObjectPlaceholderBrick();
		parameter.setPlaceholder(TEMPLATE_MANDATORY_PLACEHOLDER);
		parameter.setMandatory(true);
		
		ComposedBrick parameterAssignment = CodebricksFactory.eINSTANCE.createComposedBrick();
		parameterAssignment.getBricks().add(parameterName);
		parameterAssignment.getBricks().add(parameter);
		
		return parameterAssignment;
	}
	
	private boolean hasEdgeChanges(Node node) {
		for (Edge incident : node.getOutgoing()) {
			if (HenshinRuleAnalysisUtilEx.isCreationEdge(incident)
					|| HenshinRuleAnalysisUtilEx.isDeletionEdge(incident)) {
				return true;
			}
		}
		return false;
	}
}
