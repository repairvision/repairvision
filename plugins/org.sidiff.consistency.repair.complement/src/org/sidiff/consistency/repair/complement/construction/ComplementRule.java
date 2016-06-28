package org.sidiff.consistency.repair.complement.construction;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.copyPreserveNodes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHS;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHS;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isRHSEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isRHSNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.NestedCondition;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.common.henshin.HenshinConditionAnalysis;
import org.sidiff.common.henshin.view.NodePair;
import org.sidiff.consistency.repair.complement.construction.match.ComplementMatch;
import org.sidiff.consistency.repair.complement.util.ComplementUtil;

/**
 * Wraps a complement rule for a given partially executed source rule.
 * 
 * @author Manuel Ohrndorf
 */
public class ComplementRule {

	/**
	 * The origin of the complement-rule.
	 */
	private Rule sourceRule;
	
	/**
	 * The complement rule for the partially executed source rule.
	 */
	private Rule complementRule;
	
	/**
	 * LHS-Source -> LHS-Complement (forbid, require)
	 */
	private Map<Node, Node> lhsTrace = new HashMap<>();
	
	/**
	 * RHS-Source -> RHS-Complement
	 */
	private Map<Node, Node> rhsTrace = new HashMap<>();
	
	//// Evaluation ////
	
	/**
	 * All possible (full) pre-matches for the complement rule.
	 */
	private List<ComplementMatch> complementPreMatches;
	
	/**
	 * Rules which check a single application condition of the complement rule.
	 */
	private Map<NestedCondition, Rule> applicationConditions = new HashMap<>();
	
	/**
	 * The (Henshin) engine which applies the rules.
	 */
	private Engine engine;
	
	/**
	 * The working graph, i.e. the actual version of the model.
	 */
	private EGraph graph;
	
	public ComplementRule(Rule sourceRule, Rule complementRule) {
		super();
		this.sourceRule = sourceRule;
		this.complementRule = complementRule;
	}
	
	/**
	 * @param complementPreMatch
	 *            The concrete complement pre-match.
	 * 
	 * @return <code>true</code> if the rule was successfully applied;
	 *         <code>false</code> otherwise.
	 */
	public boolean apply(ComplementMatch complementPreMatch) {
		
		if (complementPreMatch.getUnfulfilledACs().isEmpty()) {
			Match preMatch = new MatchImpl(complementRule);
			
			for (Entry<Node, EObject> match : complementPreMatch.getNodeMatches().entrySet()) {
				preMatch.setNodeTarget(match.getKey(), match.getValue());
			}
			
			RuleApplication application = new RuleApplicationImpl(engine);
			application.setRule(complementRule);
			application.setEGraph(graph);
			application.setCompleteMatch(preMatch);
			
			return application.execute(null);
		}
		
		return false;
	}
	
	//// Getter / Setter /////
	
	public Rule getSourceRule() {
		return sourceRule;
	}

	public void setSourceRule(Rule sourceRule) {
		this.sourceRule = sourceRule;
	}

	public Rule getComplementRule() {
		return complementRule;
	}

	public void setComplementRule(Rule complementRule) {
		this.complementRule = complementRule;
	}
	
	public List<ComplementMatch> getComplementPreMatches() {
		return complementPreMatches;
	}

	public void setComplementPreMatches(List<ComplementMatch> complementPreMatches) {
		this.complementPreMatches = complementPreMatches;
	}
	
	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public EGraph getGraph() {
		return graph;
	}

	public void setGraph(EGraph graph) {
		this.graph = graph;
	}
	
	//// Trace ////
	
	public void addTrace(Node sourceRule, Node complementRule) {
		
		if (isRHSNode(sourceRule)) {
			// RHS-Node
			rhsTrace.put(sourceRule, complementRule);
			
			// Lookup LHS-Node:
			Node lhsNode = getLHS(sourceRule);
			
			if (lhsNode == null) {
				lhsTrace.put(sourceRule, complementRule);
			}
		} else {
			// LHS/Forbid/Require-Node
			lhsTrace.put(sourceRule, complementRule);
			
			// Lookup RHS-Node:
			Node rhsNode = getRHS(sourceRule);
			
			if (rhsNode == null) {
				rhsTrace.put(sourceRule, complementRule);
			}
		}
	}
	
	public void removeTrace(Node sourceNode) {
		
		if (isRHSNode(sourceNode)) {
			rhsTrace.remove(sourceNode);
		} else {
			lhsTrace.remove(sourceNode);
		}
	}
	
	public Node getTrace(Node sourceRule) {
		Node lhsNodeTrace = lhsTrace.get(sourceRule);
		
		if (lhsNodeTrace == null) {
			return rhsTrace.get(sourceRule);
		} else {
			return lhsNodeTrace; 
		}
	}
	
	public Edge getTrace(Edge sourceRule) {
		Node srcNodeTrace = null;
		Node tgtNodeTrace = null;
		
		if (isRHSEdge(sourceRule)) {
			srcNodeTrace = rhsTrace.get(sourceRule.getSource());
			tgtNodeTrace = rhsTrace.get(sourceRule.getTarget());
		} else {
			srcNodeTrace = lhsTrace.get(sourceRule.getSource());
			tgtNodeTrace = lhsTrace.get(sourceRule.getTarget());
		}
		
		if ((srcNodeTrace != null) && (tgtNodeTrace != null)) {
			return srcNodeTrace.getOutgoing(sourceRule.getType(), tgtNodeTrace);
		}
		
		return null;
	}
	
	//// Handle application conditions ////
	
	public boolean recheckApplicationCondition(
			NestedCondition applicationCondition, ComplementMatch complementPreMatch) {
		
		Rule minimumConclusion = getMinimumConclusion(applicationCondition);
		Match minimumPreMatch = getPreMatch(minimumConclusion, complementPreMatch);
		
		// Ignored AC -> Activate?
		if (complementPreMatch.getIgnoredACs().contains(applicationCondition)) {
			complementPreMatch.getIgnoredACs().remove(applicationCondition);
			complementPreMatch.getUnfulfilledACs().add(applicationCondition);
		}
		
		// Recheck AC:
		if (minimumPreMatch != null) {
			Iterator<Match> matchFinder = engine.findMatches(minimumConclusion, graph, minimumPreMatch).iterator();
			
			if (matchFinder.hasNext()) {
				complementPreMatch.getUnfulfilledACs().remove(applicationCondition);
				return true;
			}
		}
		
		return false;
	}
		
	private Rule getMinimumConclusion(NestedCondition applicationCondition) {
		Rule minConclusion = applicationConditions.get(applicationCondition);
		
		// Create minimum conclusion:
		if (minConclusion == null) {
			minConclusion = createMinimumConclusion(applicationCondition);
		}
		
		return minConclusion;
	}
	
	private Rule createMinimumConclusion(NestedCondition applicationCondition) {
		Rule minConclusion = HenshinFactory.eINSTANCE.createRule();
		
		Map<EObject, EObject> acCopy = ComplementUtil.deepCopy(applicationCondition);
		NestedCondition minConclusionAC = (NestedCondition) acCopy.get(applicationCondition);
		minConclusion.getLhs().getNestedConditions().add(minConclusionAC);
		
		for (Mapping acMapping : applicationCondition.getMappings()) {
			Node acContextNode = acMapping.getImage();
			
			if (HenshinConditionAnalysis.isACBoundaryNode(acContextNode)) {
				Node lhsBoundaryNode = acMapping.getOrigin();
				Node rhsBoundaryNode = getRHS(lhsBoundaryNode);
				NodePair preserveNode = new NodePair(lhsBoundaryNode, rhsBoundaryNode);
				
				// Copy minimal boundary:
				NodePair minConclusionPreserveNode = copyPreserveNodes(minConclusion, preserveNode, false);
				
				// Copy AC mapping:
				Mapping minConclusionACMapping = HenshinFactory.eINSTANCE.createMapping();
				minConclusionACMapping.setOrigin(minConclusionPreserveNode.getLhsNode());
				minConclusionACMapping.setImage((Node) acCopy.get(acContextNode));
				minConclusionAC.getMappings().add(minConclusionACMapping);
			}
		}
		
		return minConclusion;
	}
	
	private Match getPreMatch(Rule rule, ComplementMatch complementPreMatch) {
		Match preMatch = new MatchImpl(rule);
		
		for (Node lhsNode : rule.getLhs().getNodes()) {
			EObject nodePreMatch = complementPreMatch.getNodeMatches().get(lhsNode);
			assert (nodePreMatch != null) : "Missing context: " + lhsNode;
			preMatch.setNodeTarget(lhsNode, nodePreMatch);
		}
		
		return preMatch;
	}
	
	// FIXME: Maybe we should check all ACs of the rule here and not only the latest unfulfilled!?
	public void recheckAllApplicationConditions(ComplementMatch contextMatch) {
		for (NestedCondition pac : contextMatch.getUnfulfilledACs()) {
			recheckApplicationCondition(pac, contextMatch);
		}
	}
	
	public void ignoreApplicationCondition(NestedCondition applicationCondition, ComplementMatch contextMatch) {
		contextMatch.getIgnoredACs().add(applicationCondition);
		contextMatch.getUnfulfilledACs().remove(applicationCondition);
		
		// Remove AC from complement-rule:
		applicationCondition.getConclusion().getNestedConditions().remove(applicationCondition);
	}
}
