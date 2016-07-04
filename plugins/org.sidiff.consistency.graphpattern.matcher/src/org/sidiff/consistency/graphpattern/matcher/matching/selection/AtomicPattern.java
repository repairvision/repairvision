package org.sidiff.consistency.graphpattern.matcher.matching.selection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.consistency.graphpattern.NodePattern;

public class AtomicPattern {

	protected List<NodePattern> nodes;
	
	protected List<NodePattern> borderNodes;
	
	protected List<Move> evaluation;
	
	public List<NodePattern> getNodes() {
		return nodes;
	}

	public void setNodes(List<NodePattern> nodes) {
		this.nodes = nodes;
	}

	public List<NodePattern> getBorderNodes() {
		return borderNodes;
	}

	public void setBorderNodes(List<NodePattern> borderNodes) {
		this.borderNodes = borderNodes;
	}

	public List<Move> getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(List<Move> evaluation) {
		this.evaluation = evaluation;
	}

	public Collection<EObject> getNodeMatch(NodePattern node, Collection<EObject[]> atomicMatches) {
		int nodeIndex = nodes.indexOf(node);
		Collection<EObject> nodeMatch = new ArrayList<>(atomicMatches.size());
		
		for (EObject[] atomicMatch : atomicMatches) {
			nodeMatch.add(atomicMatch[nodeIndex]);
		}
		
		return nodeMatch;
	}

	public Collection<EObject[]> getAtomicMatch(
			PathSelector pathSelector, NodePattern initialNode, Collection<EObject> matches) {
		
		// [New Match]: Initialize matching:
		List<EObject[]> atomicMatches = getAllAtomicMatches(pathSelector, initialNode, matches);
		
		// [Historic Match]: Get already matched nodes of the corresponding path:
		List<Collection<EObject>> nodeMatches = new ArrayList<>(nodes.size());
		
		for (int i = 0; i < nodes.size(); i++) {
			NodePattern nodePattern = nodes.get(i);
			Collection<EObject> nodeMatch = pathSelector.getPath().getMatch(nodePattern);
			nodeMatches.add(nodeMatch);
		}

		// [Appendable Atomic Matches] Filter matches by already matched nodes:
		ArrayList<EObject[]> filteredAtomicMatches = new ArrayList<>(atomicMatches.size());
		
		for (EObject[] atomicMatch : atomicMatches) {
			boolean valid = true;
			
			for (int i = 0; i < atomicMatch.length; i++) {
				Collection<EObject> nodeMatch = nodeMatches.get(i);
				
				if (!nodeMatch.isEmpty() && !nodeMatch.contains(atomicMatch[i])) {
					valid = false;
					break;
				}
			}
			
			if (valid) {
				filteredAtomicMatches.add(atomicMatch);
			}
		}
		
		return filteredAtomicMatches;
	}
	
//	// TODO: Atomic-Pattern cache: Object + Node!?
//	Map<EObject, List<EObject[]>> cache = new HashMap<>();
//	
//	private List<EObject[]> getAllAtomicMatches(
//			PathSelector pathSelector, NodePattern initialNode, Collection<EObject> matches) {
//		
//		ArrayList<EObject[]> atomicMatches = new ArrayList<>(matches.size());
//		
//		for (EObject match : matches) {
//			List<EObject[]> cachedAtomicMatches = cache.get(match);
//			
//			if (cachedAtomicMatches != null) {
//				atomicMatches.addAll(cachedAtomicMatches);
//			} else {
//				List<EObject[]> newAtomicMatches = calculateAllAtomicMatches(
//						pathSelector, initialNode, Collections.singleton(match));
//				atomicMatches.addAll(newAtomicMatches);
//				cache.put(match, newAtomicMatches);
//			}
//		}
//		
//		return atomicMatches;
//	}
	
	private List<EObject[]> getAllAtomicMatches(
			PathSelector pathSelector, NodePattern initialNode, Collection<EObject> matches) {
		
		// [New Match]: Initialize matching:
		ArrayList<EObject[]> atomicMatches = new ArrayList<>(matches.size());
		int initialNodeIndex = getNodes().indexOf(initialNode);
		
		for (EObject match : matches) {
			EObject[] initialMatch = new EObject[getNodes().size()];
			atomicMatches.add(initialMatch);
			initialMatch[initialNodeIndex] = match;
		}
		
		// [Atomic Match] Complete the matches: (All atomic matches which could be appended to the given path.)
		for(Move evaluationStep : evaluation) {
			int sourceIndex = getNodes().indexOf(evaluationStep.source);
			int targetIndex = getNodes().indexOf(evaluationStep.target);
			int actualAtomicMatchesSize = atomicMatches.size();
			
			for (int i = 0; i < actualAtomicMatchesSize; i++) {
				EObject[] atomicMatch = atomicMatches.get(i);

				EObject sourceMatch = atomicMatch[sourceIndex];
				assert (sourceMatch != null) : "Incomplete atomic match!";
					
				// Get adjacent matching:
				List<EObject> targetMatches = pathSelector.getAdjacentMatches(sourceMatch,
						evaluationStep.source, evaluationStep.edge, evaluationStep.target);

				// New match(es)?
				if (targetMatches.isEmpty()) {
					// Incomplete match:
					atomicMatches.remove(atomicMatch);
					
					// Loop update:
					--actualAtomicMatchesSize;
					--i;
				} else {
					// Extend match:
					atomicMatch[targetIndex] = targetMatches.get(0);

					// Fork new matches:
					atomicMatches.ensureCapacity(atomicMatches.size() + targetMatches.size() - 1);
					
					for (int j = 1; j < targetMatches.size(); j++) {
						EObject[] forkedAtomicMatch = Arrays.copyOf(atomicMatch, atomicMatch.length);
						forkedAtomicMatch[targetIndex] = targetMatches.get(j);

						// (Ignored in this loop iteration.)
						atomicMatches.add(forkedAtomicMatch);
					}
				}
			}
		}
		
		return atomicMatches;
	}
}
