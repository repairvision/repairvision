package org.sidiff.difference.symmetric.graphviewer.content;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.graphviewer.content.symmetric.AddObjectNode;
import org.sidiff.difference.symmetric.graphviewer.content.symmetric.AddReferenceEdge;
import org.sidiff.difference.symmetric.graphviewer.content.symmetric.CorrespondenceNode;
import org.sidiff.difference.symmetric.graphviewer.content.symmetric.RemoveObjectNode;
import org.sidiff.difference.symmetric.graphviewer.content.symmetric.RemoveReferenceEdge;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.MatchingModelFactory;

public class SymmetricDifferenceImporter implements MatchingGraphImporter {

	protected SymmetricDifference difference;
	
	protected Map<EObject, MatchingNode> nodes = new HashMap<>();
	
	protected Map<EObject, MatchingEdge> edges = new HashMap<>();
	
	public SymmetricDifferenceImporter(SymmetricDifference difference, Set<Change> changeFilter) {
		this.difference = difference;
		
		// Create nodes:
		for (Change change : difference.getChanges()) {
			if (!changeFilter.contains(change)) {
				if (change instanceof AddObject) {
					AddObjectNode node = new AddObjectNode((AddObject) change);
					nodes.put(((AddObject) change).getObj(), node);
				} else if (change instanceof RemoveObject) {
					RemoveObjectNode node = new RemoveObjectNode((RemoveObject) change);
					nodes.put(((RemoveObject) change).getObj(), node);
				}
			}
		}
		
		for (Correspondence correspondence : difference.getMatching().getCorrespondences()) {
			CorrespondenceNode node = new CorrespondenceNode(correspondence);
			nodes.put(correspondence.getMatchedA(), node);
			nodes.put(correspondence.getMatchedB(), node);
		}
		
		// Create edges:
		for (Change change : difference.getChanges()) {
			if (!changeFilter.contains(change)) {
				if (change instanceof AddReference) {
					AddReferenceEdge edge = new AddReferenceEdge((AddReference) change, 
							getNode(((AddReference) change).getSrc()), 
							getNode(((AddReference) change).getTgt()));
					edges.put(change, edge);
				} else if (change instanceof RemoveReference) {
					RemoveReferenceEdge edge = new RemoveReferenceEdge((RemoveReference) change, 
							getNode(((RemoveReference) change).getSrc()), 
							getNode(((RemoveReference) change).getTgt()));
					edges.put(change, edge);
				}
			}
		}
	}
	
	private MatchingNode getNode(EObject obj) {
		MatchingNode node = nodes.get(obj);
		
		// Merge Imports:
		if (node == null) {
			Correspondence correspondence = MatchingModelFactory.eINSTANCE.createCorrespondence();
			correspondence.setMatchedA(obj);
			correspondence.setMatchedB(obj);
			difference.addCorrespondence(correspondence);
			
			node = new CorrespondenceNode(correspondence);
			nodes.put(correspondence.getMatchedA(), node);
			nodes.put(correspondence.getMatchedB(), node);
		}
		
		return node;
	}
	
	@Override
	public Iterator<MatchingNode> getNodes() {
		return new HashSet<>(nodes.values()).iterator();
	}

	@Override
	public Iterator<MatchingEdge> getEdges() {
		return new HashSet<>(edges.values()).iterator();
	}
}
