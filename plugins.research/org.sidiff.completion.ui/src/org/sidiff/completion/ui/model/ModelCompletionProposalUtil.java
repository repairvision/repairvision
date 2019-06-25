package org.sidiff.completion.ui.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.GraphElement;
import org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil;
import org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension;
import org.sidiff.graphpattern.profile.henshin_extension.SubGraph;
import org.sidiff.graphpattern.tools.editrules.DecomposingEditRulesUtil;

public class ModelCompletionProposalUtil {

	public static String generateDecompositionNameFromSubGraphs(List<SubGraph> decomposition) {
		StringBuilder name = new StringBuilder();
		
		for (SubGraph subEditRule : decomposition) {
			name.append(subEditRule.getName());
			
			if (subEditRule != decomposition.get(decomposition.size() - 1)) {
				name.append(" -> ");
			}
		}
		
		return name.toString();
	}
	
	public static String generateDecompositionNameFromHierarchicals(List<String> decomposition) {
		StringBuilder name = new StringBuilder();
		
		for (String subEditRule : decomposition) {
			name.append(DecomposingEditRulesUtil.getPlainTemplate(subEditRule));
			
			if (subEditRule != decomposition.get(decomposition.size() - 1)) {
				name.append(" -> ");
			}
		}
		
		return name.toString();
	}

	public static List<SubGraph> getDecomposition(List<SubGraph> allSubGraphs, List<GraphElement> changes) {
		
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

}
