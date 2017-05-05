package org.sidiff.editrule.partialmatcher.selection;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.editrule.partialmatcher.pattern.RecognitionPattern;
import org.sidiff.editrule.partialmatcher.pattern.domain.Domain;
import org.sidiff.graphpattern.NodePattern;

public class MatchSelector implements IMatchSelector {
	
	private RecognitionPattern recognitionPattern;
	
	public MatchSelector(RecognitionPattern recognitionPattern) {
		this.recognitionPattern = recognitionPattern;
	}
	
	@Override
	public void initialSelection(NodePattern selectedNode, EObject selectedMatch) {
		
		// Clear old domains:
		
		// Action-Graph:
		for (NodePattern node : recognitionPattern.getGraphNodePatterns()) {
			Domain domain = Domain.get(node.getEvaluation());
			domain.clearMatches();
			domain.setCollecting(true);
		}
		
		// Changes:
		for (NodePattern node : recognitionPattern.getChangeNodePatterns()) {
			Domain domain = Domain.get(node.getEvaluation());
			domain.clearSelection();
			domain.setCollecting(true);
		}
		
//		System.out.println("-----------------------------------------------------------");
//		System.out.println("Initial Selection: " + selectedNode);
		
		// Search domains from model:
		recognitionPattern.getChangePattern(selectedNode).searchPaths((Change) selectedMatch);
		
		// Action-Graph:
		for (NodePattern node : recognitionPattern.getGraphNodePatterns()) {
			Domain domain = Domain.get(node.getEvaluation());
			domain.setCollecting(false);
			domain.restrictUnmarked(selectedNode);
		}
		
		// Changes:
		for (NodePattern node : recognitionPattern.getChangeNodePatterns()) {
			Domain domain = Domain.get(node.getEvaluation());
			domain.setCollecting(false);
			domain.restrictUnmarked(selectedNode);
		}
		
//		System.out.println(PrintUtil.printSelections(recognitionPattern.getChangeNodePatterns()));
	}
	
	@Override
	public void selection(NodePattern selectedNode, EObject selectedMatch) {
		System.out.println("Selection: " + selectedNode);
				
		recognitionPattern.getChangePattern(selectedNode).searchPaths((Change) selectedMatch);
		
		// Restriction:
		
		// Action-Graph: 
		for (NodePattern node : recognitionPattern.getGraphNodePatterns()) {
			Domain domain = Domain.get(node.getEvaluation());
			domain.restrictUnmarked(selectedNode);
		}
		
		// Changes:
		for (NodePattern node : recognitionPattern.getChangeNodePatterns()) {
			Domain domain = Domain.get(node.getEvaluation());
			domain.restrictUnmarked(selectedNode);
		}
		
//		System.out.println(PrintUtil.printSelections(recognitionPattern.getChangeNodePatterns()));
	}

	@Override
	public void undoSelection(NodePattern unselectedNode) {
		
		// undo restriction on all nodes (full graph):
		for (NodePattern node : recognitionPattern.getGraphPattern().getNodes()) {
			Domain domain = Domain.get(node.getEvaluation());
			domain.undoRestriction(unselectedNode);	
		}
	}
}
