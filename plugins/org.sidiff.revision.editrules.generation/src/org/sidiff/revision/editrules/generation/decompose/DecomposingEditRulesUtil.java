package org.sidiff.revision.editrules.generation.decompose;


import java.util.Collections;
import java.util.List;

import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.SubGraph;
import org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil;

public class DecomposingEditRulesUtil {

	// TODO: Migration from Henshin to Graph-Pattern: org.sidiff.completion.ui.model.ModelCompletionProposalUtil
	// - getDecomposition
	// - generateDecompositionName
	
	public static final String HIERARCHICAL_NAME_PLACEHOLDER_PREFIX = "[";

	public static final String HIERARCHICAL_NAME_PLACEHOLDER_POSTFIX = "]";

	public static final String HIERARCHICAL_NAME_PLACEHOLDER_SYMBOL = "+";

	public static final String HIERARCHICAL_NAME_PLACEHOLDER = 
			HIERARCHICAL_NAME_PLACEHOLDER_PREFIX + HIERARCHICAL_NAME_PLACEHOLDER_SYMBOL + HIERARCHICAL_NAME_PLACEHOLDER_POSTFIX;
	
	public static final String MATCH_INNER_BRACES = 
			java.util.regex.Pattern.quote(HIERARCHICAL_NAME_PLACEHOLDER_PREFIX) + "[^"
			+ java.util.regex.Pattern.quote(HIERARCHICAL_NAME_PLACEHOLDER_PREFIX) + "^"
			+ java.util.regex.Pattern.quote(HIERARCHICAL_NAME_PLACEHOLDER_POSTFIX) + "]*?"
			+ java.util.regex.Pattern.quote(HIERARCHICAL_NAME_PLACEHOLDER_POSTFIX);
	
	public static final String MATCH_PREFIX_NOT_PLACEHOLDER = 
			"((" + java.util.regex.Pattern.quote(HIERARCHICAL_NAME_PLACEHOLDER_PREFIX) + ")" +
			"(?!" + java.util.regex.Pattern.quote(HIERARCHICAL_NAME_PLACEHOLDER_SYMBOL + HIERARCHICAL_NAME_PLACEHOLDER_POSTFIX) + "))";
	
	public static final  String MATCH_POSTFIX_NOT_PLACEHOLDER = 
			"((?<!" + java.util.regex.Pattern.quote(HIERARCHICAL_NAME_PLACEHOLDER_PREFIX + HIERARCHICAL_NAME_PLACEHOLDER_SYMBOL) + ")" + 
			"(" + java.util.regex.Pattern.quote(HIERARCHICAL_NAME_PLACEHOLDER_POSTFIX) + "))";
	
	public static final  String MATCH_PREFIX_OR_POSTFIX_NOT_PLACEHOLDER = 
			MATCH_PREFIX_NOT_PLACEHOLDER + "|" + MATCH_POSTFIX_NOT_PLACEHOLDER;

	public static String generateHierarchicalName(GraphPattern graphPattern) {
		Pattern rulePattern = graphPattern.getPattern(); // TODO: Generalize this...!?
		Pattern containerPattern = (Pattern) rulePattern.eContainer();
		
		String rulePrefix = rulePattern.getName().replace(containerPattern.getName(), "").trim(); // TODO: Generalize this...!?
		String hierarchicalName = "";
		
		while (containerPattern != null) {
			String containerName = containerPattern.getName();
			
			if (containerName.contains(HIERARCHICAL_NAME_PLACEHOLDER)) {
				// Replace placeholder of parent with child name:
				hierarchicalName = containerName.replace(HIERARCHICAL_NAME_PLACEHOLDER,
						HIERARCHICAL_NAME_PLACEHOLDER_PREFIX + hierarchicalName + HIERARCHICAL_NAME_PLACEHOLDER_POSTFIX);
			} else {
				hierarchicalName += containerName;
			}
			
			if (containerPattern.eContainer() instanceof Pattern) {
				containerPattern = (Pattern) containerPattern.eContainer();
			} else {
				containerPattern = null;
			}
		}
		
		return rulePrefix + hierarchicalName;
	}
	
	public static String getFirstLevelTemplate(String hierarchicalName) {
		// replace inner [.*?] with [+]
		return hierarchicalName.replaceAll(MATCH_INNER_BRACES, HIERARCHICAL_NAME_PLACEHOLDER);
	}
	
	public static String getPlainTemplate(String hierarchicalName) {
		// Match opening [ and closing ] braces that are not placeholders [+]
		return hierarchicalName.replaceAll(MATCH_PREFIX_OR_POSTFIX_NOT_PLACEHOLDER, "");
	}
	
	public static Boolean containsPlaceholder(String template) {
		return template.contains(HIERARCHICAL_NAME_PLACEHOLDER);
	}
	
	public static List<GraphElement> getSubGraphContext(SubGraph subGraph) {
		for (SubGraph annotatedSubGraph : subGraph.getSubgraphs()) {
			if (HenshinProfileUtil.isPreserve(annotatedSubGraph)) {
				return annotatedSubGraph.getElements();
			}
		}
		return Collections.emptyList();
	}
	
	public static List<GraphElement> getSubGraphChanges(SubGraph subGraph) {
		for (SubGraph annotatedSubGraph : subGraph.getSubgraphs()) {
			if (HenshinProfileUtil.isChange(annotatedSubGraph)) {
				return annotatedSubGraph.getElements();
			}
		}
		return Collections.emptyList();
	}
	
	public static void clearSubGraphElements(SubGraph subGraph) {
		
		for (SubGraph subSubGraph : subGraph.getSubgraphs()) {
			clearSubGraphElements(subSubGraph);
		}
		
		subGraph.getElements().clear();
	}
}
