package org.sidiff.completion.ui.model.proposals.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.GraphElement;
import org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil;
import org.sidiff.graphpattern.profile.henshin_extension.GraphElementExtension;
import org.sidiff.graphpattern.profile.henshin_extension.SubGraph;
import  org.sidiff.revision.editrules.generation.decompose.DecomposingEditRulesUtil;

public class ModelCompletionProposalUtil {
	
	public static String TEMPLATE_EDIT_RULE_SEPARATOR_TRIM = "->";
	
	public static String TEMPLATE_EDIT_RULE_SEPARATOR = " " + TEMPLATE_EDIT_RULE_SEPARATOR_TRIM + " ";
	
	public static String TEMPLATE_PRESENCE_SEPARATOR_TRIM = "|" + TEMPLATE_EDIT_RULE_SEPARATOR_TRIM;
	
	public static String TEMPLATE_PRESENCE_SEPARATOR = " " + TEMPLATE_PRESENCE_SEPARATOR_TRIM + " ";
	
	public static String TEMPLATE_PARAMETER_NAME_VALUE_SEPARATOR = " = ";
	
	public static String TEMPLATE_PARAMETER_SEPARATOR = ", ";
	
	public static String TEMPLATE_PARAMETER_LIST_PREFIX = "(";
	
	public static String TEMPLATE_PARAMETER_LIST_POSTFIX = ")";
	
	public static String TEMPLATE_NAME_PLACEHOLDER_PREFIX = 
			DecomposingEditRulesUtil.HIERARCHICAL_NAME_PLACEHOLDER_PREFIX;
	
	public static String TEMPLATE_NAME_PLACEHOLDER_POSTFIX = 
			DecomposingEditRulesUtil.HIERARCHICAL_NAME_PLACEHOLDER_POSTFIX;
	
	public static String TEMPLATE_OPTIONAL_PLACEHOLDER_SYMBOL = "?";
	
	public static String TEMPLATE_MANDATORY_PLACEHOLDER_SYMBOL = 
			DecomposingEditRulesUtil.HIERARCHICAL_NAME_PLACEHOLDER_SYMBOL;
	
	public static String TEMPLATE_MANDATORY_PLACEHOLDER = 
			TEMPLATE_NAME_PLACEHOLDER_PREFIX +
			TEMPLATE_MANDATORY_PLACEHOLDER_SYMBOL +
			TEMPLATE_NAME_PLACEHOLDER_POSTFIX;
	
	
	public static String TEMPLATE_OPTIONAL_PLACEHOLDER = 
			TEMPLATE_NAME_PLACEHOLDER_PREFIX +
			TEMPLATE_OPTIONAL_PLACEHOLDER_SYMBOL +
			TEMPLATE_NAME_PLACEHOLDER_POSTFIX;

	public static String generateDecompositionSequenceFromSubGraphs(List<SubGraph> decomposition) {
		StringBuilder name = new StringBuilder();
		
		for (SubGraph subEditRule : decomposition) {
			name.append(subEditRule.getName());
			
			if (subEditRule != decomposition.get(decomposition.size() - 1)) {
				name.append(TEMPLATE_EDIT_RULE_SEPARATOR);
			}
		}
		
		return name.toString();
	}
	
	public static String generateDecompositionSequenceFromHierarchicals(List<String> decomposition) {
		StringBuilder name = new StringBuilder();
		
		for (String subEditRule : decomposition) {
			name.append(getPlainTemplate(subEditRule));
			
			if (subEditRule != decomposition.get(decomposition.size() - 1)) {
				name.append(TEMPLATE_EDIT_RULE_SEPARATOR);
			}
		}
		
		return name.toString();
	}
	
	public static String getPlainTemplate(String subEditRule) {
		return DecomposingEditRulesUtil.getPlainTemplate(subEditRule);
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

	public static List<GraphElementExtension> getSubGraphContext(SubGraph subGraph) {
		for (SubGraph annotatedSubGraph : subGraph.getSubgraphs()) {
			if (HenshinProfileUtil.isPreserve(annotatedSubGraph)) {
				return annotatedSubGraph.getElements();
			}
		}
		return Collections.emptyList();
	}
	
	public static List<GraphElementExtension> getSubGraphChanges(SubGraph subGraph) {
		for (SubGraph annotatedSubGraph : subGraph.getSubgraphs()) {
			if (HenshinProfileUtil.isChange(annotatedSubGraph)) {
				return annotatedSubGraph.getElements();
			}
		}
		return Collections.emptyList();
	}
}
