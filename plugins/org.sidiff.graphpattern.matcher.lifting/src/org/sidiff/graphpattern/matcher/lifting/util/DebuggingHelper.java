package org.sidiff.graphpattern.matcher.lifting.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.NodePattern;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SemanticChangeSet;
import org.sidiff.difference.symmetric.SymmetricFactory;
import org.sidiff.difference.symmetric.SymmetricPackage;
import org.sidiff.graphpattern.matching.algorithms.NodeMatching;
import org.sidiff.graphpattern.wgraph.selection.MatchSelection;
import org.sidiff.graphpattern.wgraph.util.WGraph;

public class DebuggingHelper {

	public List<SemanticChangeSet> filterDuplicates(List<SemanticChangeSet> repairChangeSets) {
		List<SemanticChangeSet> min_repairChangeSets = new ArrayList<>();

		for (SemanticChangeSet repairChangeSet : repairChangeSets) {
			boolean containsEqual = false;

			for (SemanticChangeSet min_repairChangeSet : min_repairChangeSets) {
				boolean isEqual = true;

				// Compare changes:
				for (Change change : repairChangeSet.getChanges()) {
					for (Change min_change : min_repairChangeSet.getChanges()) {
						if (change != min_change) {
							isEqual = false;
							break;
						}
					}

					if (!isEqual) {
						break;
					}
				}

				if (isEqual) {
					containsEqual = true;
					break;
				}
			}

			if (!containsEqual) {
				min_repairChangeSets.add(repairChangeSet);
			}

		}

		return min_repairChangeSets;
	}

	public SemanticChangeSet createChangeSet(Map<NodePattern, NodeMatching> matching)  {
		SemanticChangeSet repairChangeSet = SymmetricFactory.eINSTANCE.createSemanticChangeSet();

		for (Entry<NodePattern, NodeMatching> match : matching.entrySet()) {
			if (match.getValue().getMatch() != null) {
				repairChangeSet.getChanges().add((Change) match.getValue().getMatch());
			}
		}

		return repairChangeSet;
	}
	
	public static boolean test_selection_atomicPatterns(Collection<NodePattern> graphPattern) {
		return test_selection_removeReferencePattern(graphPattern) && test_selection_addReferencePattern(graphPattern);
	}
	
	public static boolean test_selection_addReferencePattern(Collection<NodePattern> graphPattern) {
		
		for (NodePattern node : graphPattern) {
			if (node.getType() == SymmetricPackage.eINSTANCE.getAddReference()) {
				MatchSelection addObjSelection = WGraph.getDataStore(node.getEvaluation()).getMatchSelection();
				
				for (Iterator<EObject> iterator = addObjSelection.getSelectedMatches(); iterator.hasNext();) {
					EObject addReference = iterator.next();

					// Src-Match:
					{
						NodePattern srcNode = node.getOutgoing(SymmetricPackage.eINSTANCE.getAddReference_Src()).getTarget();
						MatchSelection srcSelection = WGraph.getDataStore(srcNode.getEvaluation()).getMatchSelection();
						
						if (!srcSelection.isSelectedMatch(((AddReference) addReference).getSrc())) {
							return false;
						}
					}
					
					// Src-Match:
					{
						NodePattern tgtNode = node.getOutgoing(SymmetricPackage.eINSTANCE.getAddReference_Tgt()).getTarget();
						MatchSelection tgtSelection = WGraph.getDataStore(tgtNode.getEvaluation()).getMatchSelection();
						
						if (!tgtSelection.isSelectedMatch(((AddReference) addReference).getTgt())) {
							return false;
						}
					}

					// Type-Match:
					{
						NodePattern typeNode = node.getOutgoing(SymmetricPackage.eINSTANCE.getAddReference_Type()).getTarget();
						MatchSelection typeSelection = WGraph.getDataStore(typeNode.getEvaluation()).getMatchSelection();
						
						if (!typeSelection.isSelectedMatch(((AddReference) addReference).getType())) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	public static boolean test_selection_removeReferencePattern(Collection<NodePattern> graphPattern) {
		
		for (NodePattern node : graphPattern) {
			if (node.getType() == SymmetricPackage.eINSTANCE.getRemoveReference()) {
				MatchSelection removeObjSelection = WGraph.getDataStore(node.getEvaluation()).getMatchSelection();
				
				for (Iterator<EObject> iterator = removeObjSelection.getSelectedMatches(); iterator.hasNext();) {
					EObject removeReference = iterator.next();

					// Src-Match:
					{
						NodePattern srcNode = node.getOutgoing(SymmetricPackage.eINSTANCE.getRemoveReference_Src()).getTarget();
						MatchSelection srcSelection = WGraph.getDataStore(srcNode.getEvaluation()).getMatchSelection();
						
						if (!srcSelection.isSelectedMatch(((RemoveReference) removeReference).getSrc())) {
							return false;
						}
					}
					
					// Src-Match:
					{
						NodePattern tgtNode = node.getOutgoing(SymmetricPackage.eINSTANCE.getRemoveReference_Tgt()).getTarget();
						MatchSelection tgtSelection = WGraph.getDataStore(tgtNode.getEvaluation()).getMatchSelection();
						
						if (!tgtSelection.isSelectedMatch(((RemoveReference) removeReference).getTgt())) {
							return false;
						}
					}

					// Type-Match:
					{
						NodePattern typeNode = node.getOutgoing(SymmetricPackage.eINSTANCE.getRemoveReference_Type()).getTarget();
						MatchSelection typeSelection = WGraph.getDataStore(typeNode.getEvaluation()).getMatchSelection();
						
						if (!typeSelection.isSelectedMatch(((RemoveReference) removeReference).getType())) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	public static void printAddReference(NodePattern node, EObject match) {
		
		if (match instanceof AddReference) {
			System.out.println();
			System.out.println(node);
			System.out.println("  " + match);
			System.out.println(node.getOutgoing(SymmetricPackage.eINSTANCE.getAddReference_Src()).getTarget());
			System.out.println("  src: " + ((AddReference) match).getSrc());
			System.out.println(node.getOutgoing(SymmetricPackage.eINSTANCE.getAddReference_Tgt()).getTarget());
			System.out.println("  tgt: " + ((AddReference) match).getTgt());
			System.out.println(node.getOutgoing(SymmetricPackage.eINSTANCE.getAddReference_Type()).getTarget());
			System.out.println("  tgt: " + ((AddReference) match).getType());
			System.out.println();
		}
	}
	
	public static void printRemoveReference(NodePattern node, EObject match) {
		
		if (match instanceof RemoveReference) {
			System.out.println();
			System.out.println(node);
			System.out.println("  " + match);
			System.out.println(node.getOutgoing(SymmetricPackage.eINSTANCE.getRemoveReference_Src()).getTarget());
			System.out.println("  src: " + ((RemoveReference) match).getSrc());
			System.out.println(node.getOutgoing(SymmetricPackage.eINSTANCE.getRemoveReference_Tgt()).getTarget());
			System.out.println("  tgt: " + ((RemoveReference) match).getTgt());
			System.out.println(node.getOutgoing(SymmetricPackage.eINSTANCE.getRemoveReference_Type()).getTarget());
			System.out.println("  tgt: " + ((RemoveReference) match).getType());
			System.out.println();
		}
	}
	
	public static void printAddObject(NodePattern node, EObject match) {
		
		if (match instanceof AddObject) {
			System.out.println();
			System.out.println(node);
			System.out.println("  " + match);
			System.out.println(node.getOutgoing(SymmetricPackage.eINSTANCE.getAddObject_Obj()).getTarget());
			System.out.println("  src: " + ((AddObject) match).getObj());
			System.out.println();
		}
	}
	
	public static void printRemoveObject(NodePattern node, EObject match) {
		
		if (match instanceof RemoveObject) {
			System.out.println();
			System.out.println(node);
			System.out.println("  " + match);
			System.out.println(node.getOutgoing(SymmetricPackage.eINSTANCE.getRemoveObject_Obj()).getTarget());
			System.out.println("  src: " + ((RemoveObject) match).getObj());
			System.out.println();
		}
	}
}
