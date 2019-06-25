package org.sidiff.completion.ui.model;

import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.TEMPLATE_EDIT_RULE_SEPARATOR;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.TEMPLATE_OPTIONAL_PLACEHOLDER;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.TEMPLATE_PRESENCE_SEPARATOR;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.TEMPLATE_PRESENCE_SEPARATOR_TRIM;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.generateDecompositionNameFromHierarchical;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.generateDecompositionNameFromHierarchicals;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.generateDecompositionNameFromSubGraphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.eclipse.emf.henshin.model.HenshinPackage;
import org.eclipse.swt.graphics.Image;
import org.sidiff.completion.ui.codebricks.Codebrick;
import org.sidiff.completion.ui.codebricks.Codebricks;
import org.sidiff.completion.ui.codebricks.CodebricksFactory;
import org.sidiff.completion.ui.codebricks.LineBreakBrick;
import org.sidiff.completion.ui.codebricks.TemplatePlaceholderBrick;
import org.sidiff.completion.ui.codebricks.TextBrick;
import org.sidiff.completion.ui.codebricks.editor.CodebricksEditor;
import org.sidiff.completion.ui.list.ICompletionPreview;
import org.sidiff.completion.ui.list.ICompletionProposal;
import org.sidiff.graphpattern.edit.util.ItemProviderUtil;
import org.sidiff.graphpattern.profile.henshin_extension.RuleExtension;
import org.sidiff.graphpattern.profile.henshin_extension.SubGraph;
import org.sidiff.graphpattern.tools.editrules.DecomposingEditRulesUtil;

public class ModelCompletionProposalCluster implements ICompletionProposal {
	
	private static Image ICON = (Image) ItemProviderUtil.getImageByType(HenshinPackage.eINSTANCE.getRule());

	private List<ModelCompletionProposal> similarProposals;
	
	private List<String> historicTemplates;
	
	private List<String> intersectionHistoricTemplates;
	
	private List<String> complementTemplates;
	
	private List<String> intersectionComplementTemplates;
	
	public ModelCompletionProposalCluster(ModelCompletionProposal initialProposal) {
		this.similarProposals = new ArrayList<>();
		this.similarProposals.add(initialProposal);
		
		this.historicTemplates = initialProposal.getHistoricDecompositionTemplates();
		this.complementTemplates = initialProposal.getCurrentDecompositionFirstLevelTemplates();
		
		// Initialize template intersection:
		// NOTE: Allows only sub set clustering!
		intersectionHistoricTemplates = new ArrayList<>(historicTemplates);
		intersectionComplementTemplates = new ArrayList<>(complementTemplates);
	}

	/**
	 * @return This cluster if the given candidate was added. A fork of this cluster
	 *         if the candidate matches this cluster but not its current
	 *         intersection of all other members of this cluster. <code>null</code> if
	 *         the candidate does not match into this cluster.
	 */
	public ModelCompletionProposalCluster add(
			ModelCompletionProposal proposalCandidate, 
			List<String> candidateHistoricTemplates, 
			List<String> candidateCurrentTemplates) {
		
		// Match historic exact:
		if (historicTemplates.size() == candidateHistoricTemplates.size()) {
			List<String> superCurrentTemplate = complementTemplates;
			List<String> subCurrentTemplate = candidateCurrentTemplates;
			
			// Is candidate larger? -> Switch:
			if (subCurrentTemplate.size() > superCurrentTemplate.size()) {
				superCurrentTemplate = candidateCurrentTemplates;
				subCurrentTemplate = complementTemplates;
			}
			
			// Match historic/current candidate template in this historic/current template:
			if (matchTemplates(candidateHistoricTemplates, historicTemplates)) {
				if (matchTemplates(subCurrentTemplate, superCurrentTemplate)) {
					
					// Is candidate larger and contains currently largest main template? 
					// -> Make the candidate the new largest main template:
					if (subCurrentTemplate == complementTemplates) {
						this.historicTemplates = candidateHistoricTemplates;
						this.complementTemplates = candidateCurrentTemplates;
						
						similarProposals.add(0, proposalCandidate);
						
						// NOTE: If the candidate fully contains the largest template,
						//       this implies that it also fully contains the common intersection.
						
						return this;
					} else {
						
						// Matches common intersection? -> add to cluster:
						if (matchTemplates(candidateHistoricTemplates, intersectionHistoricTemplates)) {
							if (matchTemplates(candidateCurrentTemplates, intersectionComplementTemplates)) {
								similarProposals.add(proposalCandidate);
								
								// Update/Shrink intersections:
								intersectionHistoricTemplates.retainAll(candidateHistoricTemplates);
								intersectionComplementTemplates.retainAll(candidateCurrentTemplates);
								
								return this;
							}
						}
					}
					
					// Matches the main template but not the common intersection -> fork this cluster:
					ModelCompletionProposalCluster fork = new ModelCompletionProposalCluster(similarProposals.get(0));
					fork.similarProposals.add(proposalCandidate);
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
		return generateDecompositionNameFromHierarchicals(intersectionHistoricTemplates) + TEMPLATE_PRESENCE_SEPARATOR + generateDecompositionNameFromHierarchicals(intersectionComplementTemplates);
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
		
		for (ModelCompletionProposal proposal : similarProposals) {
			info.append("<p>");
			info.append(proposal.getComplement().getComplementRule().getName());
			info.append("<br>");
			info.append(" = " + generateDecompositionNameFromSubGraphs(proposal.getHistoricDecomposition()) 
					+ TEMPLATE_PRESENCE_SEPARATOR + generateDecompositionNameFromSubGraphs(proposal.getCurrentDecomposition()));
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
	
	private SubGraph getHistoricSubEditRule(String template) {
		// TODO: Store explicit mapping!?
		int index = historicTemplates.indexOf(template);
		return ((RuleExtension) similarProposals.get(0).getComplement().getRecognizedRule()).getSubgraphs().get(index);
	}
	
	private SubGraph getComplementSubEditRule(String template) {
		// TODO: Store explicit mapping!?
		int index = complementTemplates.indexOf(template);
		return ((RuleExtension) similarProposals.get(0).getComplement().getComplementRule()).getSubgraphs().get(index);
	}

	private Codebricks createCodebrick() {
		Codebricks codebricks = CodebricksFactory.eINSTANCE.createCodebricks();
		
		// Create template:
		Codebrick template = CodebricksFactory.eINSTANCE.createCodebrick();
		codebricks.setTemplate(template);
		
		// Historic:
		createEditRuleSequenceCodebrick(template, 
				historicTemplates, intersectionHistoricTemplates,
				this::getHistoricSubEditRule);
		
		// Presence:
		LineBreakBrick lineBreakBeforeHistoricalSeparator = CodebricksFactory.eINSTANCE.createLineBreakBrick();
		template.getBricks().add(lineBreakBeforeHistoricalSeparator);
		
		TextBrick historicalComplementSeparatorBrick = CodebricksFactory.eINSTANCE.createTextBrick();
		historicalComplementSeparatorBrick.setText(TEMPLATE_PRESENCE_SEPARATOR_TRIM + " ");
		template.getBricks().add(historicalComplementSeparatorBrick);
		
		// Complement:
		createEditRuleSequenceCodebrick(template, 
				complementTemplates, intersectionComplementTemplates,
				this::getComplementSubEditRule);
		
		return codebricks;
	}

	private void createEditRuleSequenceCodebrick(Codebrick template, 
			List<String> templates, List<String> intersectionTemplates,
			Function<String, SubGraph> getSubEditRule) {
		
		for (String complementSubEditRule : templates) {
			
			// Common?
			if (intersectionTemplates.contains(complementSubEditRule)) {
				String plainTemplate = generateDecompositionNameFromHierarchical(complementSubEditRule);
				
				// Sub edit rule template?
				if (DecomposingEditRulesUtil.containsPlaceholder(complementSubEditRule)) {
					TemplatePlaceholderBrick complementSubEditRuleBrick = CodebricksFactory.eINSTANCE.createTemplatePlaceholderBrick();
					complementSubEditRuleBrick.setPlaceholder(plainTemplate);
					complementSubEditRuleBrick.setMandatory(true);
					template.getBricks().add(complementSubEditRuleBrick);
				} else {
					TextBrick complementSubEditRuleBrick = CodebricksFactory.eINSTANCE.createTextBrick();
					complementSubEditRuleBrick.setText(plainTemplate);
					template.getBricks().add(complementSubEditRuleBrick);
				}
				
				createTemplateParameters(template, getSubEditRule.apply(complementSubEditRule));
			} else {
				// Optional placeholder:
				// NOTE: Actually, not needed since we currently match only proposals with the same historic template.
				TemplatePlaceholderBrick complementSubEditRuleBrick = CodebricksFactory.eINSTANCE.createTemplatePlaceholderBrick();
				complementSubEditRuleBrick.setPlaceholder(TEMPLATE_OPTIONAL_PLACEHOLDER);
				complementSubEditRuleBrick.setMandatory(false);
				template.getBricks().add(complementSubEditRuleBrick);
			}
			
			// Not last rule?
			if (complementSubEditRule != templates.get(templates.size() -1)) {
				LineBreakBrick lineBreakBeforeRuleSeparator = CodebricksFactory.eINSTANCE.createLineBreakBrick();
				template.getBricks().add(lineBreakBeforeRuleSeparator);
				
				TextBrick ruleSeparatorBrick = CodebricksFactory.eINSTANCE.createTextBrick();
				ruleSeparatorBrick.setText(TEMPLATE_EDIT_RULE_SEPARATOR);
				template.getBricks().add(ruleSeparatorBrick);
			}
		}
	}

	private void createTemplateParameters(Codebrick template, SubGraph subEditRule) {
		
		// (
		TextBrick ruleParameterOpeningBracesBrick = CodebricksFactory.eINSTANCE.createTextBrick();
		ruleParameterOpeningBracesBrick.setText("(");
		template.getBricks().add(ruleParameterOpeningBracesBrick);
		
		// TODO: Create parameters for sub edit rule:
		
		// )
		TextBrick ruleParameterClosingBracesBrick = CodebricksFactory.eINSTANCE.createTextBrick();
		ruleParameterClosingBracesBrick.setText(")");
		template.getBricks().add(ruleParameterClosingBracesBrick);
	}
}
