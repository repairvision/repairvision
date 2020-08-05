package org.sidiff.completion.ui.model.proposals;

import static org.sidiff.completion.ui.model.proposals.util.ModelCompletionProposalUtil.TEMPLATE_EDIT_RULE_SEPARATOR;
import static org.sidiff.completion.ui.model.proposals.util.ModelCompletionProposalUtil.TEMPLATE_PRESENCE_SEPARATOR;
import static org.sidiff.completion.ui.model.proposals.util.ModelCompletionProposalUtil.generateDecompositionSequenceFromHierarchicals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.henshin.model.HenshinPackage;
import org.eclipse.swt.graphics.Image;
import org.sidiff.completion.ui.codebricks.Codebricks;
import org.sidiff.completion.ui.codebricks.editor.CodebricksEditor;
import org.sidiff.completion.ui.model.proposals.codebricks.CodebricksGenerator;
import org.sidiff.completion.ui.model.proposals.util.DecompositionTemplates;
import org.sidiff.completion.ui.proposals.ICompletionPreview;
import org.sidiff.completion.ui.proposals.ICompletionProposal;
import org.sidiff.revision.common.emf.ItemProviderUtil;

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
		intersectionHistoricTemplates = new ArrayList<>(initialTemplate.getHistoricTemplates());
		intersectionComplementTemplates = new ArrayList<>(initialTemplate.getComplementFirstLevel());
	}
	
	public List<ModelCompletionProposal> getProposalCluster() {
		return proposalCluster;
	}

	public DecompositionTemplates getSupersetProposal() {
		return supersetProposal;
	}

	public List<String> getIntersectionHistoricTemplates() {
		return intersectionHistoricTemplates;
	}

	public List<String> getIntersectionComplementTemplates() {
		return intersectionComplementTemplates;
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
		if (supersetProposal.getHistoricTemplates().size() == candidateProposal.getHistoricTemplates().size()) {
			List<String> superSetComplementTemplate = supersetProposal.getComplementFirstLevel();
			List<String> subSetComplementTemplate = candidateProposal.getComplementFirstLevel();
			
			// Is candidate larger? -> Switch:
			if (subSetComplementTemplate.size() > superSetComplementTemplate.size()) {
				superSetComplementTemplate = candidateProposal.getComplementFirstLevel();
				subSetComplementTemplate = supersetProposal.getComplementFirstLevel();
			}
			
			// Match historic/current candidate template in this historic/current template:
			if (matchTemplates(candidateProposal.getHistoricTemplates(), supersetProposal.getHistoricTemplates())) {
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
						if (intersectingTemplates(intersectionHistoricTemplates, candidateProposal.getHistoricTemplates())) {
							if (intersectingTemplates(intersectionComplementTemplates, candidateProposal.getComplementFirstLevel())) {
								proposalCluster.add(proposalCandidate);
								
								// Update/Shrink intersections:
								// TODO: Check this...!?
								intersectionHistoricTemplates.retainAll(candidateProposal.getHistoricTemplates());
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
		
		// SEE: org.sidiff.completion.ui.model.CodebricksGenerator.matchAlternativeToTemplates()
		
		// TODO: NOTE*1: We currently do not check if the common sub sequence of rules is also a common sub graph!
		//               This doesn't matter if we not show the parameters in the template for the unselected sub rules.
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
	
	/**
	 * @param templatesA The first list of templates.
	 * @param templatesB The second list of templates.
	 * @return <code>true</code> if there is an intersection; <code>false</code> otherwise.
	 */
	private boolean intersectingTemplates(List<String> templatesA, List<String> templatesB) {

		for (String templateA : templatesA) {
			if (templatesB.contains(templateA)) {
				return true;
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
		Codebricks codebricks = new CodebricksGenerator().createCodebrick(this);
		
		CodebricksEditor editor = new CodebricksEditor();
		editor.setContent(codebricks);

		editor.showPopupOnCursor();
		
		return false;
	}
	
	@Override
	public String toString() {
			StringBuilder info = new StringBuilder();
			
			for (String intersectionHistoricTemplate : intersectionHistoricTemplates) {
				info.append(intersectionHistoricTemplate);	
				
				if (intersectionHistoricTemplates.get(intersectionHistoricTemplates.size() - 1) != intersectionHistoricTemplate) {
					info.append(TEMPLATE_EDIT_RULE_SEPARATOR);
				}
			}
			
			info.append(TEMPLATE_PRESENCE_SEPARATOR);
			
			for (String intersectionComplementTemplate : intersectionComplementTemplates) {
				info.append(intersectionComplementTemplate);
				
				if (intersectionComplementTemplates.get(intersectionComplementTemplates.size() - 1) != intersectionComplementTemplate) {
					info.append(TEMPLATE_EDIT_RULE_SEPARATOR);
				}
			}
			
			info.append("\n");
			
			for (ModelCompletionProposal proposal : proposalCluster) {
				info.append("     ");
				DecompositionTemplates decomposition = proposal.getDecomposition();
				info.append(proposal.getComplement().getComplementRule().getName());
				info.append(" = ");
				info.append(generateDecompositionSequenceFromHierarchicals(decomposition.getHistoricTemplates()));
				info.append(TEMPLATE_PRESENCE_SEPARATOR);
				info.append(generateDecompositionSequenceFromHierarchicals(decomposition.getComplementTemplates()));
				info.append("\n");
			}
			
			return info.toString();
	}
}
