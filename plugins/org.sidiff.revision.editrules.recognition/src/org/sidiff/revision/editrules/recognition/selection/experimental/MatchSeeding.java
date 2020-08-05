package org.sidiff.revision.editrules.recognition.selection.experimental;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.Node;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.editrules.impact.graph.GraphActionImpactScope;
import org.sidiff.revision.editrules.recognition.pattern.RecognitionPattern;
import org.sidiff.revision.editrules.recognition.pattern.domain.Domain;
import org.sidiff.revision.editrules.recognition.pattern.graph.ActionNode;
import org.sidiff.revision.editrules.recognition.pattern.graph.path.MatchingPath;
import org.sidiff.revision.editrules.recognition.pattern.graph.path.MatchingPathFactory;
import org.sidiff.revision.editrules.recognition.selection.IMatchSelector;

public class MatchSeeding implements IMatchSelector {
	
	protected RecognitionPattern recognitionPattern;
	
	protected MatchingPathFactory matchingPathFactory = new MatchingPathFactory();
	
	public MatchSeeding(RecognitionPattern recognitionPattern) {
		this.recognitionPattern = recognitionPattern;
	}
	
	@Override
	public void setMatchingPathFactory(MatchingPathFactory matchingPathFactory) {
		this.matchingPathFactory = matchingPathFactory;
	}
	
	public void seed(GraphActionImpactScope... scopes) {
		seedInitialize();
		
		for (GraphActionImpactScope scope : scopes) {
			for (GraphElement scopeGraphElement: scope.getChanges()) {
				Node scopeNode = null;

				if (scopeGraphElement instanceof Node) {
					scopeNode = (Node) scopeGraphElement;
				} else if (scopeGraphElement instanceof Edge) {
					scopeNode = ((Edge) scopeGraphElement).getSource();
				} else if (scopeGraphElement instanceof Attribute) {
					scopeNode = ((Attribute) scopeGraphElement).getNode();
				}
				
				scopeNode = HenshinRuleAnalysisUtil.tryLHS(scopeNode);
				
				for (EObject scopeObj : scope.get(scopeGraphElement)) {
					seed(scopeNode, scopeObj);
				}
			}
		}
		
		seedFinished();
	}
	
	public void seedInitialize() {
		
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
		
	}
	
	public void seed(Node node, EObject seed) {
		
//		System.out.println("-----------------------------------------------------------");
//		System.out.println("Seed: " + node);
		
		// Search domains from model:
		ActionNode actionNode = recognitionPattern.getNodeTrace().get(node);
		actionNode.addMatchContextB(seed);
		
		recognitionPattern.getNodeTrace().get(node).searchPaths(null, new MatchingPath());
		
//		System.out.println(PrintUtil.printSelections(recognitionPattern.getGraphPattern().getNodes()));
		
	}
	
	public void seedFinished() {
		
		// Action-Graph:
		for (NodePattern node : recognitionPattern.getGraphNodePatterns()) {
			Domain domain = Domain.get(node.getMatching());
			domain.setCollecting(false);
			domain.restrictUnmarked(null);
		}
		
		// Changes:
		for (NodePattern node : recognitionPattern.getChangeNodePatterns()) {
			Domain domain = Domain.get(node.getMatching());
			domain.setCollecting(false);
			domain.restrictUnmarked(null);
		}
	}
	
	@Override
	public void initialSelection(NodePattern selectedNode, EObject selectedMatch) {
		
		// Clear old domains:
		
		// Action-Graph:
		for (NodePattern node : recognitionPattern.getGraphNodePatterns()) {
			Domain domain = Domain.get(node.getMatching());
			domain.clearSelection();
		}
		
		// Changes:
		for (NodePattern node : recognitionPattern.getChangeNodePatterns()) {
			Domain domain = Domain.get(node.getMatching());
			domain.clearSelection();
		}
		
		// Restriction:
		selection(selectedNode, selectedMatch);
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
