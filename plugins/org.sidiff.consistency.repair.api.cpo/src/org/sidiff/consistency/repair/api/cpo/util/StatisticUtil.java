package org.sidiff.consistency.repair.api.cpo.util;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.util.DifferenceAnalysis;
import org.sidiff.difference.symmetric.util.DifferenceAnalysisUtil;

public class StatisticUtil {

	public static void analyzeSetup(
			Collection<Rule> subEditRules, Collection<Rule> cpEditRules,
			SymmetricDifference difference) {
		
		System.out.println("---------------- Difference after CPO changes were removed ---------------- ");
		analyzeDifference(difference);
		
		System.out.println("---------------- Rules ---------------- ");
		System.out.println("Count of preserve, delete and create nodes/edges (integrated).");
		
		System.out.println("---------------- CPO ---------------- ");
		int fullNodeCount_cpo = 0;
		int fullEdgeCount_cpo = 0;
		
		for (Rule cpo : cpEditRules) {
			int nodes = getNodeCount(cpo);
			int edges = getEdgeCount(cpo);
			
			fullNodeCount_cpo += nodes;
			fullEdgeCount_cpo += edges;
			
			System.out.println(cpo.getName());
			System.out.println("  - Nodes: " + nodes);
			System.out.println("  - Edges: " + edges);
		}
		
		System.out.println("################## SUM ##################");
		System.out.println("Rules: " + cpEditRules.size());
		System.out.println("All Nodes: " + fullNodeCount_cpo);
		System.out.println("avg. Nodes: " + ((double) fullNodeCount_cpo / (double) cpEditRules.size()));
		System.out.println("All Edges: " + fullEdgeCount_cpo);
		System.out.println("avg. Edges: " + ((double) fullEdgeCount_cpo / (double) cpEditRules.size()));
		
		System.out.println("---------------- Sub-EO ---------------- ");
		int fullNodeCount_sub = 0;
		int fullEdgeCount_sub = 0;
		
		for (Rule sub : subEditRules) {
			int nodes = getNodeCount(sub);
			int edges = getEdgeCount(sub);
			
			fullNodeCount_sub += nodes;
			fullEdgeCount_sub += edges;
			
			System.out.println(sub.getName());
			System.out.println("  - Nodes: " + nodes);
			System.out.println("  - Edges: " + edges);
		}
		
		System.out.println("################## SUM ##################");
		System.out.println("Rules: " + subEditRules.size());
		System.out.println("All Nodes: " + fullNodeCount_sub);
		System.out.println("avg. Nodes: " + ((double) fullNodeCount_sub / (double) subEditRules.size()));
		System.out.println("All Edges: " + fullEdgeCount_sub);
		System.out.println("avg. Edges: " + ((double) fullEdgeCount_sub / (double) subEditRules.size()));
	}
	
	public static int getNodeCount(Rule rule) {
		return HenshinRuleAnalysisUtilEx.getLHSIntersectRHSNodes(rule).size()
				+ HenshinRuleAnalysisUtilEx.getLHSMinusRHSNodes(rule).size()
				+ HenshinRuleAnalysisUtilEx.getRHSMinusLHSNodes(rule).size();
	}
	
	public static int getEdgeCount(Rule rule) {
		return HenshinRuleAnalysisUtilEx.getLHSIntersectRHSEdges(rule).size()
				+ HenshinRuleAnalysisUtilEx.getLHSMinusRHSEdges(rule).size()
				+ HenshinRuleAnalysisUtilEx.getRHSMinusLHSEdges(rule).size();
	}
	
	/**
	 * Analyze the difference.
	 * 
	 * @param difference
	 *            The Symmetric-Difference.
	 */
	public static void analyzeDifference(SymmetricDifference difference) {
		
		// Analyze models:
		System.out.println("---------------- Models ---------------- ");
		
		System.out.println("Model A: " + difference.getModelA().getURI().lastSegment());
		System.out.println("Model B: " + difference.getModelB().getURI().lastSegment());
		
		System.out.println("Objects Model A: " + getModelObjectCount(difference.getModelA().getAllContents()));
		System.out.println("References Model A: " + getModelReferenceCount(difference.getModelA().getAllContents()));
		
		System.out.println("Objects Model B: " + getModelObjectCount(difference.getModelB().getAllContents()));
		System.out.println("References Model B: " + getModelReferenceCount(difference.getModelB().getAllContents()));
		
		// Analyze difference:
		DifferenceAnalysis analysis = new DifferenceAnalysis(difference);
		
		System.out.println("---------------- Technical Difference ---------------- ");
		System.out.println("Add Objects: " + analysis.getAddObjectCount());
		System.out.println("Remove Objects: " + analysis.getRemoveObjectCount());
		System.out.println("Add References: " + analysis.getAddReferenceCount());
		System.out.println("Remove References: " + analysis.getRemoveReferenceCount());
		System.out.println("Attribute Value Changes: " + analysis.getAttributeValueChangeCount());
		System.out.println("Correspondences: " + analysis.getCorrespondenceCount());
		System.out.println("Change Sets: " + difference.getChangeSets().size());
		
		int allChanges = difference.getChanges().size();
		int uncoveredChanges = DifferenceAnalysisUtil.getRemainingChanges(difference).size();
		int coveredChanges = allChanges - uncoveredChanges;
		
		System.out.println("All Changes: " + allChanges);
		System.out.println("Changes in Change Sets: " + coveredChanges);
		System.out.println("Changes without Change Sets: " + uncoveredChanges);
	}
	
	/**
	 * Counts all object of a model.
	 * 
	 * @param it
	 *            An iterator to iterate over all elements of the model.
	 * @return The counted object of the model.
	 */
	public static int getModelObjectCount(Iterator<EObject> it) {
		int counter = 0;
		
		while (it.hasNext()) {
			it.next();
			counter++;
		}
		return counter;
	}
	
	/**
	 * Counts all references of a model.
	 * 
	 * @param it
	 *            An iterator to iterate over all elements of the model.
	 * @return The counted references of the model.
	 */
	public static int getModelReferenceCount(Iterator<EObject> it) {
		int counter = 0;
		
		while(it.hasNext()) {
			EObject obj = it.next();
			
			for (EReference ref : obj.eClass().getEAllReferences()) {
				if (obj.eGet(ref) != null) {
					if (ref.isMany()) {
						Collection<?> multiRef = (Collection<?>) obj.eGet(ref);
						counter += multiRef.size();
					} else {
						counter++;
					}	
				}
			}
		}
		return counter;
	}
}
