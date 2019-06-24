package org.sidiff.completion.ui.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.HenshinPackage;
import org.eclipse.swt.graphics.Image;
import org.sidiff.completion.ui.list.ICompletionPreview;
import org.sidiff.completion.ui.list.ICompletionProposal;
import org.sidiff.graphpattern.edit.util.ItemProviderUtil;
import org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil;
import org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension;
import org.sidiff.graphpattern.profile.henshin_extension.RuleExtension;
import org.sidiff.graphpattern.profile.henshin_extension.SubGraph;
import org.sidiff.repair.complement.construction.ComplementRule;

public class ModelCompletionProposal implements ICompletionProposal {

	private static Image icon = (Image) ItemProviderUtil.getImageByType(HenshinPackage.eINSTANCE.getRule());
	
	private ComplementRule complement;
	
	private List<Match> proposalMatches;
	
	public ModelCompletionProposal(ComplementRule complement, List<Match> proposalMatches) {
		this.complement = complement;
		this.proposalMatches = proposalMatches;
	}

	@Override
	public String getText() {
		
		// TODO: Calculate template
		// - Find same sub graphs  -> by name
		// - Find similar sub graphs -> by name
		// -> check dependencies
		
		// Calculate name based on decomposition
		if ((complement.getComplementRule() instanceof RuleExtension) && (complement.getRecognizedRule() instanceof RuleExtension)) {
			RuleExtension complementRule = (RuleExtension) complement.getComplementRule();
			List<SubGraph> complementDecomposition = getDecomposition(complementRule.getSubgraphs(), complement.getComplementingChanges());
			String complementDecompositionName = generateDecompositionName(complementDecomposition);
			
			RuleExtension recognizedRule = (RuleExtension) complement.getRecognizedRule();
			List<SubGraph> recognizedDecomposition = getDecomposition(recognizedRule.getSubgraphs(), complement.getRecognizedChanges());
			String recognizedDecompositionName = generateDecompositionName(recognizedDecomposition);
			
			return recognizedDecompositionName + " |-> " + complementDecompositionName;
		}
		
		return complement.getComplementRule().getName();
	}
	
	private String generateDecompositionName(List<SubGraph> decomposition) {
		StringBuilder name = new StringBuilder();
		
		for (SubGraph subEditRule : decomposition) {
			name.append(subEditRule.getName());
			
			if (subEditRule != decomposition.get(decomposition.size() - 1)) {
				name.append(" -> ");
			}
		}
		
		return name.toString();
	}
	
	private List<SubGraph> getDecomposition(List<SubGraph> allSubGraphs, List<GraphElement> changes) {
		
		// Calculate all sub graphs that contain elements of the given change set:
		Set<SubGraph> decomposition = new HashSet<>();
		
		for (GraphElement change : changes) {
			if (change instanceof GraphElementExtension) {
				for (SubGraph containedInSubGraph : ((GraphElementExtension) change).getSubgraphs()) {
					if (HenshinProfileUtil.isChange(containedInSubGraph)) {
						EObject subEditRuleGraph = containedInSubGraph.eContainer();
						
						if (subEditRuleGraph instanceof SubGraph) {
							decomposition.add((SubGraph) subEditRuleGraph);
						}
					}
				}
			}
		}
		
		/*
		 * NOTE: We expect that the sub edit rules of the decomposition are ordered by
		 * their dependencies. We can also assume that the historic edit operations is
		 * not depending on the complementing edit operation. Therefore, if we split the
		 * list of sub edit rules into a list for historic and a list for complementing
		 * sub edit rules the relative dependency ordering of the sub edit rules is
		 * still correct.
		 */
		List<SubGraph> decompositionWithDependency = new ArrayList<>(allSubGraphs);
		decompositionWithDependency.retainAll(decomposition);
		
		return decompositionWithDependency;
	}

	@Override
	public Image getImage() {
		return icon;
	}

	@Override
	public String getInformation() {
		return "Partial execution of edit operation '" + complement.getComplementRule().getName() + "' recognized.";
	}

	@Override
	public ICompletionPreview preview() {
		// TODO: Apply/undo on editing domain
		System.out.println("Preview: " + complement.getComplementRule().getName());
		return null;
	}

	@Override
	public boolean apply() {
		// TODO open template in Codebricks editor
		System.out.println("Apply: " + complement.getComplementRule().getName());
		return false;
	}

}
