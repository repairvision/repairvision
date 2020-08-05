package org.sidiff.revision.editrules.complement.matching.finder.henshin;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil;

/**
 * Sorts a set of Henshin rules by its structure. This will optimize the
 * performance of the Henshin match finder.
 * 
 * @author Manuel Ohrndorf
 */
public class HenshinRuleStructureSorting {
	
	/**
	 * Sorts a recognition rules by its structure.
	 * 
	 * @param henshinRule The Henshin rule rule to sort.
	 * @param preMatch    A partial pre match for the rule.
	 */
	public static void sort(Rule henshinRule, Match preMatch) {
		
		// Sort kernel rule:
		EList<Node> nodes = henshinRule.getLhs().getNodes();
		SortingConstraint.structuredSorting(getStartNode(henshinRule, preMatch), nodes);
		
		// Sort application conditions:
		for (NestedCondition ac : henshinRule.getLhs().getNestedConditions()) {
			SortingConstraint.structuredSorting(getACStartNode(ac), ac.getConclusion().getNodes());
		}
		
		// Sort all multi-rules:
		for (Rule multiRule : henshinRule.getAllMultiRules()) {
			EList<Node>  multiNodes = multiRule.getLhs().getNodes();
			SortingConstraint.structuredSorting(HenshinRuleStructureSorting.getMultiStartNode(multiRule), multiNodes);
			
			// Sort application conditions:
			for (NestedCondition ac : multiRule.getLhs().getNestedConditions()) {
				SortingConstraint.structuredSorting(getACStartNode(ac), ac.getConclusion().getNodes());
			}
		}
	}
	
	private static int getStartNode(Rule rule, Match preMatch) {
		EList<Node> nodes = rule.getLhs().getNodes();
		int offset = 0;
		
		// Use already matched nodes as starting points:
		for (int i = 0; i < nodes.size(); ++i) {
			Node node =  nodes.get(i);
			
			if (preMatch.getNodeTarget(node) != null) {
				nodes.move(0, i);
				++offset;
			}
		}
		
		return offset;
	}
	
	private static int getACStartNode(NestedCondition ac) {
		EList<Node> nodes = ac.getConclusion().getNodes();
		int offset = 0;
		
		// Use already matched nodes as starting points:
		for (int i = 0; i < nodes.size(); ++i) {
			Node node =  nodes.get(i);
			
			if (ac.getMappings().getOrigin(node) != null) {
				nodes.move(0, i);
				++offset;
			}
		}
		
		return offset;
	}
	
	private static int getMultiStartNode(Rule multiRule) {
		int embeddedOffset = 0;
		int boundaryOffset = 0;
		EList<Node> nodes = multiRule.getLhs().getNodes();
		
		// Filter embedded nodes:
		for (int i = 0; i < nodes.size(); ++i) {
			Node node = nodes.get(i);
			
			if (HenshinRuleAnalysisUtil.getRemoteNode(multiRule.getMultiMappings(), node) != null) {
				nodes.move(0, i);
				++embeddedOffset;
			}
		}
		
		// Get all boundary nodes as start nodes:
		for (int i = embeddedOffset; i < nodes.size(); ++i) {
			Node node = nodes.get(i);

			if (HenshinRuleAnalysisUtil.isBoundaryNode(multiRule.getMultiMappings(), node)) {
				nodes.move(embeddedOffset + boundaryOffset, i);
				++boundaryOffset;
			}
		}
		
		return embeddedOffset + boundaryOffset;
	}
}
