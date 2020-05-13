package org.sidiff.revision.editrules.recognition.selection;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.editrules.recognition.pattern.RecognitionPattern;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain;
import org.sidiff.revision.editrules.recognition.pattern.graph.path.MatchingPathFactory;

public class MatchSelector implements IMatchSelector {
	
	protected RecognitionPattern recognitionPattern;
	
	protected MatchingPathFactory matchingPathFactory = new MatchingPathFactory();
	
	public MatchSelector(RecognitionPattern recognitionPattern) {
		this.recognitionPattern = recognitionPattern;
	}
	
	@Override
	public void setMatchingPathFactory(MatchingPathFactory matchingPathFactory) {
		this.matchingPathFactory = matchingPathFactory;
	}
	
	@Override
	public void initialSelection(NodePattern selectedNode, EObject selectedMatch) {
		
		// Clear old domains:
		
		// Action-Graph:
		for (NodePattern node : recognitionPattern.getGraphNodePatterns()) {
			Domain domain = Domain.get(node.getMatching());
			domain.clearMatches();
			domain.setCollecting(true);
		}
		
		// Changes:
		for (NodePattern node : recognitionPattern.getChangeNodePatterns()) {
			Domain domain = Domain.get(node.getMatching());
			domain.clearSelection();
			domain.setCollecting(true);
		}
		
//		System.out.println("-----------------------------------------------------------");
//		System.out.println("Initial Selection: " + selectedNode);
		
		// Search domains from model:
		recognitionPattern.getChangePattern(selectedNode).searchPaths(matchingPathFactory.createMatchingPath(), (Change) selectedMatch);
		
		// Action-Graph:
		for (NodePattern node : recognitionPattern.getGraphNodePatterns()) {
			Domain domain = Domain.get(node.getMatching());
			domain.setCollecting(false);
			domain.restrictUnmarked(selectedNode);
		}
		
		// Changes:
		for (NodePattern node : recognitionPattern.getChangeNodePatterns()) {
			Domain domain = Domain.get(node.getMatching());
			domain.setCollecting(false);
			domain.restrictUnmarked(selectedNode);
		}
		
//		System.out.println(PrintUtil.printSelections(recognitionPattern.getChangeNodePatterns()));
	}
	
	@Override
	public void selection(NodePattern selectedNode, EObject selectedMatch) {
//		System.out.println("Selection: " + selectedNode);
				
		recognitionPattern.getChangePattern(selectedNode).searchPaths(matchingPathFactory.createMatchingPath(), (Change) selectedMatch);
		
		// Restriction:
		
		// Action-Graph: 
		for (NodePattern node : recognitionPattern.getGraphNodePatterns()) {
			Domain domain = Domain.get(node.getMatching());
			domain.restrictUnmarked(selectedNode);
		}
		
		// Changes:
		for (NodePattern node : recognitionPattern.getChangeNodePatterns()) {
			Domain domain = Domain.get(node.getMatching());
			domain.restrictUnmarked(selectedNode);
		}
		
//		System.out.println(PrintUtil.printSelections(recognitionPattern.getChangeNodePatterns()));
	}

	@Override
	public void undoSelection(NodePattern unselectedNode) {
		
		// undo restriction on all nodes (full graph):
		for (NodePattern node : recognitionPattern.getGraphPattern().getNodes()) {
			Domain domain = Domain.get(node.getMatching());
			domain.undoRestriction(unselectedNode);	
		}
	}
}
