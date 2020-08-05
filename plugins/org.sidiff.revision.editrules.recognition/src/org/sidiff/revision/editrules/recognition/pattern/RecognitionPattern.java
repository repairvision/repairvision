package org.sidiff.revision.editrules.recognition.pattern;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.henshin.model.Action;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil;
import org.sidiff.revision.editrules.recognition.configuration.RecognitionLogger;
import org.sidiff.revision.editrules.recognition.dependencies.ChangeDependencies;
import org.sidiff.revision.editrules.recognition.pattern.graph.ActionAttributeConstraint;
import org.sidiff.revision.editrules.recognition.pattern.graph.ActionAttributeConstraintConstant;
import org.sidiff.revision.editrules.recognition.pattern.graph.ActionEdge;
import org.sidiff.revision.editrules.recognition.pattern.graph.ActionGraph;
import org.sidiff.revision.editrules.recognition.pattern.graph.ActionNode;
import org.sidiff.revision.editrules.recognition.pattern.graph.ChangePattern;
import org.sidiff.revision.editrules.recognition.revision.RevisionGraph;

public class RecognitionPattern {
	
	protected Rule editRule;
	
	protected ActionGraph actionGraph;
	
	protected Map<Node, ActionNode> nodeTrace = new LinkedHashMap<>();
	
	protected Map<Edge, ActionEdge> edgeTrace = new LinkedHashMap<>();

	protected GraphPattern recognitionPattern;
	
	protected List<NodePattern> changeNodePatterns = new ArrayList<>();
	
	protected List<NodePattern> graphNodePatterns = new ArrayList<>();
	
	protected Map<NodePattern, ChangePattern> changePatterns = new LinkedHashMap<>();
	
	protected RecognitionLogger logger;
	
	/**
	 * @param editRule
	 *            The edit rule.
	 * @param recognitionPattern
	 *            Empty graph pattern.
	 */
	public RecognitionPattern(Rule editRule, GraphPattern recognitionPattern, RecognitionLogger logger) {
		this.editRule = editRule;
		this.recognitionPattern = recognitionPattern; 
		this.logger = logger;

		// Generate recognition pattern:
		generateRecognitionPattern();
		
		// Create dependency graph:
		// TODO: Support for additional EOpposites per meta-model!
		new ChangeDependencies(editRule, this).calculateDependencyGraph();
	}
	
	/**
	 * Initializes the matching.
	 * 
	 * @param matchingHelper
	 * @param changeIndex
	 * @param changeDomainMap
	 */
	public void initialize(RevisionGraph matchingHelper) {
		actionGraph.initialize(matchingHelper);
		RecognitionPatternInitializer.initializeRecognitionPattern(this, matchingHelper);
	}
	
	private void generateRecognitionPattern() {
		
		// create action-graph:
		actionGraph = new ActionGraph(editRule);
		
		// create action-graph nodes:
		
		// Nodes: <<delete>> / <<preserve>>:
		for (Node lhsNode : editRule.getLhs().getNodes()) {
			ActionNode node = new ActionNode(lhsNode.getAction().getType(), actionGraph, lhsNode, nodeTrace, logger);
			addEditRuleNode(node);
			
			for (Attribute attribute : lhsNode.getAttributes()) {
				ActionAttributeConstraint attributeConstraint = generateAttributeConstraint(attribute);
				
				if (attributeConstraint != null) {
					node.getAttributeConstraints().add(attributeConstraint);
				} else {
					System.err.println("Warning: Unknown constraint expression: " + attribute.getValue());
				}
			}
		}
		
		// Nodes: <<create>>:
		for (Node createNode : HenshinRuleAnalysisUtil.getCreationNodes(editRule)) {
			addEditRuleNode(new ActionNode(createNode.getAction().getType(), actionGraph, createNode, nodeTrace, logger));
		}
		
		// Nodes: <<require>>:
		for (NestedCondition pac : editRule.getLhs().getPACs()) {
			for(Node requireNode : pac.getConclusion().getNodes()) {
				if (HenshinRuleAnalysisUtil.getLHS(requireNode) == null) {
					
					// NOTE: Handle <<require>> nodes as <<preserve>> nodes:
					addEditRuleNode(new ActionNode(Action.Type.PRESERVE, actionGraph, requireNode, nodeTrace, logger));
				}
			}
		}
		
		// create action-graph edges:
		
		// Edges: <<delete>> / <<preserve>>:
		for (Edge lhsEdge : editRule.getLhs().getEdges()) {
			addEditRuleEdge(new ActionEdge(lhsEdge.getAction().getType(), actionGraph, lhsEdge, nodeTrace, edgeTrace));
		}
		
		// Edges: <<create>>:
		for (Edge createEdge : HenshinRuleAnalysisUtil.getCreationEdges(editRule)) {
			addEditRuleEdge(new ActionEdge(createEdge.getAction().getType(),actionGraph, createEdge, nodeTrace, edgeTrace));
		}
		
		// Edges: <<require>>:
		for (NestedCondition pac : editRule.getLhs().getPACs()) {
			for(Edge requireEdge : pac.getConclusion().getEdges()) {
				if (HenshinRuleAnalysisUtil.getLHS(requireEdge) == null) {
					
					// NOTE: Handle <<require>> edges as <<preserve>> edges:
					addEditRuleEdge(new ActionEdge(Action.Type.PRESERVE, actionGraph, requireEdge, nodeTrace, edgeTrace));
				}
			}
		}
		
		// connect nodes and edges:
		for (ActionEdge actionEdge : edgeTrace.values()) {
			actionEdge.getSource().addAdjacent(actionEdge.getTarget(), actionEdge);
			actionEdge.getTarget().addAdjacent(actionEdge.getSource(), actionEdge);
		}
	}
	
	private ActionAttributeConstraint generateAttributeConstraint(Attribute attribute) {
		ActionAttributeConstraint attributeConstraint = ActionAttributeConstraintConstant.create(attribute.getType(), attribute.getValue());
		return attributeConstraint;
	}
	
	
	private void addEditRuleNode(ActionNode actionNode) {
		addGraphNodePattern(actionNode.getNodePatternA());
		addGraphNodePattern(actionNode.getNodePatternB());
		addGraphNodePattern(actionNode.getCorrespondence());
		
		if (actionNode.getChange() != null) {
			addChangePattern(actionNode.getChange().getChangeNodePattern(), actionNode.getChange());
		}
		
		if (actionNode.getAttributeChanges() != null) {
			for (ChangePattern attributeChange : actionNode.getAttributeChanges()) {
				addChangePattern(attributeChange.getChangeNodePattern(), attributeChange);
			}
		}
	}
	
	private void addEditRuleEdge(ActionEdge actionEdge) {
		if (actionEdge.getChange() != null) {
			addChangePattern(actionEdge.getChange().getChangeNodePattern(), actionEdge.getChange());
		}
	}
	
	private void addChangePattern(NodePattern changeNodePattern, ChangePattern changePattern) {
		changeNodePatterns.add(changeNodePattern);
		changePatterns.put(changeNodePattern, changePattern);
		recognitionPattern.getNodes().add(changeNodePattern);
	}
	
	private void addGraphNodePattern(NodePattern graphNodePattern) {
		if (graphNodePattern != null) {
			graphNodePatterns.add(graphNodePattern);
			recognitionPattern.getNodes().add(graphNodePattern);
		}
	}
	
	public Rule getEditRule() {
		return editRule;
	}
	
	public Map<Node, ActionNode> getNodeTrace() {
		return nodeTrace;
	}
	
	public Map<Edge, ActionEdge> getEdgeTrace() {
		return edgeTrace;
	}
	
	public Map<NodePattern, ChangePattern> getChangePatternTrace() {
		return changePatterns;
	}
	
	public GraphPattern getGraphPattern() {
		return recognitionPattern;
	}

	public List<NodePattern> getChangeNodePatterns() {
		return changeNodePatterns;
	}

	public List<NodePattern> getGraphNodePatterns() {
		return graphNodePatterns;
	}

	public ChangePattern getChangePattern(NodePattern nodePattern) {
		return changePatterns.get(nodePattern);
	}
}
