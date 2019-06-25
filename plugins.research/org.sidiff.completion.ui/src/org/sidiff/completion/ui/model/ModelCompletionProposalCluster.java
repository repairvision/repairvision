package org.sidiff.completion.ui.model;

import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.TEMPLATE_EDIT_RULE_SEPARATOR;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.TEMPLATE_MANDATORY_PLACEHOLDER;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.TEMPLATE_OPTIONAL_PLACEHOLDER;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.TEMPLATE_PARAMETER_NAME_VALUE_SEPARATOR;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.TEMPLATE_PARAMETER_SEPARATOR;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.TEMPLATE_PRESENCE_SEPARATOR;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.TEMPLATE_PRESENCE_SEPARATOR_TRIM;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.getPlainTemplate;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.generateDecompositionSequenceFromHierarchicals;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.getSubGraphChanges;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.getSubGraphContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

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
import org.sidiff.completion.ui.codebricks.LineBreakBrick;
import org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick;
import org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.TextBrick;
import org.sidiff.completion.ui.codebricks.ValuePlaceholderBrick;
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
				String nextHistoricTemplate = inTemplatesBItr.next();
				
				// Match against largest main template:
				if (searchedTemplateA.equals(nextHistoricTemplate)) {
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
		createEditRuleSequenceCodebrick(
				template, intersectionHistoricTemplates,
				supersetProposal.getHistoricTemplates(), supersetProposal::getHistoricByTemplate);
		
		// Presence:
		LineBreakBrick lineBreakBeforeHistoricalSeparator = CodebricksFactory.eINSTANCE.createLineBreakBrick();
		template.getBricks().add(lineBreakBeforeHistoricalSeparator);
		
		TextBrick historicalComplementSeparatorBrick = CodebricksFactory.eINSTANCE.createTextBrick();
		historicalComplementSeparatorBrick.setText(TEMPLATE_PRESENCE_SEPARATOR_TRIM + " ");
		template.getBricks().add(historicalComplementSeparatorBrick);
		
		// Complement:
		createEditRuleSequenceCodebrick(
				template, intersectionComplementTemplates,
				supersetProposal.getComplementFirstLevel(), supersetProposal::getComplementByFirstLevel);
		
		return codebricks;
	}

	private void createEditRuleSequenceCodebrick(
			Codebrick codebrick, List<String> intersectionTemplates,
			List<String> templates, Function<String, SubGraph> templateToRule) {
		
		for (String template : templates) {
			
			// Common?
			if (intersectionTemplates.contains(DecomposingEditRulesUtil.getFirstLevelTemplate(template))) {
				
				// Sub edit rule template?
				if (DecomposingEditRulesUtil.containsPlaceholder(template)) {
					String plainTemplate = getPlainTemplate(template);
					
					TemplatePlaceholderBrick complementSubEditRuleBrick = CodebricksFactory.eINSTANCE.createTemplatePlaceholderBrick();
					complementSubEditRuleBrick.setPlaceholder(plainTemplate);
					complementSubEditRuleBrick.setMandatory(true);
					codebrick.getBricks().add(complementSubEditRuleBrick);
					
					// Not show parameters for template:
					// SEE NOTE*1 
					TextBrick ruleParameterOpeningBracesBrick = CodebricksFactory.eINSTANCE.createTextBrick();
					ruleParameterOpeningBracesBrick.setText("(");
					codebrick.getBricks().add(ruleParameterOpeningBracesBrick);
					
					TextBrick ruleParameterClosingBracesBrick = CodebricksFactory.eINSTANCE.createTextBrick();
					ruleParameterClosingBracesBrick.setText(")");
					codebrick.getBricks().add(ruleParameterClosingBracesBrick);
					
				} else {
					String plainFirstLevelTemplate = getPlainTemplate(template);
					
					TextBrick complementSubEditRuleBrick = CodebricksFactory.eINSTANCE.createTextBrick();
					complementSubEditRuleBrick.setText(plainFirstLevelTemplate);
					codebrick.getBricks().add(complementSubEditRuleBrick);
					
					createTemplateParameters(codebrick, templateToRule.apply(template));
				}
				
			} else {
				// Optional placeholder:
				// NOTE: Actually, not needed since we currently match only proposals with the same historic template.
				TemplatePlaceholderBrick complementSubEditRuleBrick = CodebricksFactory.eINSTANCE.createTemplatePlaceholderBrick();
				complementSubEditRuleBrick.setPlaceholder(TEMPLATE_OPTIONAL_PLACEHOLDER);
				complementSubEditRuleBrick.setMandatory(false);
				codebrick.getBricks().add(complementSubEditRuleBrick);
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
	}

	private void createTemplateParameters(Codebrick template, SubGraph subEditRule) {
		
		// NOTE: Show (all) IN parameters of subEditRule (hide OUT parameters):
		
		// add '(':
		TextBrick ruleParameterOpeningBracesBrick = CodebricksFactory.eINSTANCE.createTextBrick();
		ruleParameterOpeningBracesBrick.setText("(");
		template.getBricks().add(ruleParameterOpeningBracesBrick);
		
		// Create parameters for sub edit rule:
		Brick contextParameterSeparator = createParametersForSubGraph(template, getSubGraphContext(subEditRule));
		Brick changesParameterSeparator = createParametersForSubGraph(template, getSubGraphChanges(subEditRule));
		
		// Remove last ',':
		if ((changesParameterSeparator == null) && (contextParameterSeparator != null)) {
			template.getBricks().remove(contextParameterSeparator);
		}
		if (changesParameterSeparator != null) {
			template.getBricks().remove(changesParameterSeparator);
		}
		
		// add ')':
		TextBrick ruleParameterClosingBracesBrick = CodebricksFactory.eINSTANCE.createTextBrick();
		ruleParameterClosingBracesBrick.setText(")");
		template.getBricks().add(ruleParameterClosingBracesBrick);
	}

	private Brick createParametersForSubGraph(Codebrick template, List<GraphElementExtension> subGraph) {
		TextBrick parameterSeparator = null;
		
		for (GraphElementExtension graphElement : subGraph) {
			if (graphElement instanceof Node) {
				Node eoNode = (Node) graphElement;
				
				if (HenshinRuleAnalysisUtilEx.isDeletionNode(eoNode) || hasEdgeChanges(eoNode)) {
					generateObjectParameter(template, eoNode.getName());
					
					parameterSeparator = CodebricksFactory.eINSTANCE.createTextBrick();
					parameterSeparator.setText(TEMPLATE_PARAMETER_SEPARATOR);
					template.getBricks().add(parameterSeparator);
				}
				
				for (Attribute attribute : eoNode.getAttributes()) {
					for (String variable : JavaSciptParser.getVariables(attribute.getValue())) {
						generateValueParameter(template, variable);
						
						parameterSeparator = CodebricksFactory.eINSTANCE.createTextBrick();
						parameterSeparator.setText(TEMPLATE_PARAMETER_SEPARATOR);
						template.getBricks().add(parameterSeparator);
					}
				}
			}
		}
		
		return parameterSeparator;
	}
	
	private void generateValueParameter(Codebrick template, String name) {
		TextBrick parameterName = CodebricksFactory.eINSTANCE.createTextBrick();
		parameterName.setText(name + TEMPLATE_PARAMETER_NAME_VALUE_SEPARATOR);
		template.getBricks().add(parameterName);
		
		ValuePlaceholderBrick parameter = CodebricksFactory.eINSTANCE.createValuePlaceholderBrick();
		parameter.setPlaceholder(TEMPLATE_MANDATORY_PLACEHOLDER);
		parameter.setMandatory(true);
		template.getBricks().add(parameter);
	}
	
	private void generateObjectParameter(Codebrick template, String name) {
		TextBrick parameterName = CodebricksFactory.eINSTANCE.createTextBrick();
		parameterName.setText(name + TEMPLATE_PARAMETER_NAME_VALUE_SEPARATOR);
		template.getBricks().add(parameterName);
		
		ObjectPlaceholderBrick parameter = CodebricksFactory.eINSTANCE.createObjectPlaceholderBrick();
		parameter.setPlaceholder(TEMPLATE_MANDATORY_PLACEHOLDER);
		parameter.setMandatory(true);
		template.getBricks().add(parameter);
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
