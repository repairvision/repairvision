package org.sidiff.completion.ui.model;

import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.generateDecompositionNameFromHierarchicals;
import static org.sidiff.completion.ui.model.ModelCompletionProposalUtil.generateDecompositionNameFromSubGraphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.henshin.model.HenshinPackage;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.sidiff.completion.ui.codebricks.Codebricks;
import org.sidiff.completion.ui.codebricks.editor.CodebricksEditor;
import org.sidiff.completion.ui.list.ICompletionPreview;
import org.sidiff.completion.ui.list.ICompletionProposal;
import org.sidiff.graphpattern.edit.util.ItemProviderUtil;

public class ModelCompletionProposalCluster implements ICompletionProposal {
	
	private static Image ICON = (Image) ItemProviderUtil.getImageByType(HenshinPackage.eINSTANCE.getRule());

	private List<ModelCompletionProposal> similarProposals;
	
	private List<String> historicTemplates;
	
	private List<String> intersectionHistoricTemplates;
	
	private List<String> currentTemplates;
	
	private List<String> intersectionCurrentTemplates;
	
	public ModelCompletionProposalCluster(ModelCompletionProposal initialProposal) {
		this.similarProposals = new ArrayList<>();
		this.similarProposals.add(initialProposal);
		
		this.historicTemplates = initialProposal.getHistoricDecompositionTemplates();
		this.currentTemplates = initialProposal.getCurrentDecompositionFirstLevelTemplates();
		
		// Initialize template intersection:
		// NOTE: Allows only sub set clustering!
		intersectionHistoricTemplates = new ArrayList<>(historicTemplates);
		intersectionCurrentTemplates = new ArrayList<>(currentTemplates);
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
			List<String> superCurrentTemplate = currentTemplates;
			List<String> subCurrentTemplate = candidateCurrentTemplates;
			
			// Is candidate larger? -> Switch:
			if (subCurrentTemplate.size() > superCurrentTemplate.size()) {
				superCurrentTemplate = candidateCurrentTemplates;
				subCurrentTemplate = currentTemplates;
			}
			
			// Match historic/current candidate template in this historic/current template:
			if (matchTemplates(candidateHistoricTemplates, historicTemplates)) {
				if (matchTemplates(subCurrentTemplate, superCurrentTemplate)) {
					
					// Is candidate larger and contains currently largest main template? 
					// -> Make the candidate the new largest main template:
					if (subCurrentTemplate == currentTemplates) {
						this.historicTemplates = candidateHistoricTemplates;
						this.currentTemplates = candidateCurrentTemplates;
						
						similarProposals.add(0, proposalCandidate);
						
						// NOTE: If the candidate fully contains the largest template,
						//       this implies that it also fully contains the common intersection.
						
						return this;
					} else {
						
						// Matches common intersection? -> add to cluster:
						if (matchTemplates(candidateHistoricTemplates, intersectionHistoricTemplates)) {
							if (matchTemplates(candidateCurrentTemplates, intersectionCurrentTemplates)) {
								similarProposals.add(proposalCandidate);
								
								// Update/Shrink intersections:
								intersectionHistoricTemplates.retainAll(candidateHistoricTemplates);
								intersectionCurrentTemplates.retainAll(candidateCurrentTemplates);
								
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
		return generateDecompositionNameFromHierarchicals(intersectionHistoricTemplates) + " |-> " + generateDecompositionNameFromHierarchicals(intersectionCurrentTemplates);
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
					+ " |-> " + generateDecompositionNameFromSubGraphs(proposal.getCurrentDecomposition()));
			info.append("</p>");
			info.append("<br>");
			info.append("\n");
		}
		
		return info.toString();
	}

	@Override
	public ICompletionPreview preview() {
		// TODO: Apply/undo on editing domain
		System.out.println("Preview: " + similarProposals.get(0).getComplement().getComplementRule().getName());
		return null;
	}

	@Override
	public boolean apply() {
		// TODO open template in Codebricks editor
		System.out.println("Apply: " + similarProposals.get(0).getComplement().getComplementRule().getName());
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createPlatformPluginURI("org.sidiff.completion.ui" + "/model/TESTDATA1.xmi", true), true);
		Codebricks codebricks = (Codebricks) resource.getContents().get(0);
		
		Display display = PlatformUI.createDisplay();
		
		CodebricksEditor editor = new CodebricksEditor(display);
		editor.setContent(codebricks);
		editor.setContent(codebricks);
		editor.showPopupOnCursor();
		
		return false;
	}
}
