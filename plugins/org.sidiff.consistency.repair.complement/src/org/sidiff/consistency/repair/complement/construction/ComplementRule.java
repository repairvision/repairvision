package org.sidiff.consistency.repair.complement.construction;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getChanges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHS;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHSMinusRHSEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHSMinusRHSNodes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHS;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHSMinusLHSEdges;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHSMinusLHSNodes;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isRHSEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isRHSNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.MatchImpl;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.repair.complement.construction.match.ComplementMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleEdgeMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleMatch;
import org.sidiff.consistency.repair.complement.construction.match.EditRuleNodeMatch;

/**
 * Wraps a complement rule for a given partially executed source rule.
 * 
 * @author Manuel Ohrndorf
 */
public abstract class ComplementRule {

	/**
	 * The origin of the complement-rule.
	 */
	protected Rule sourceRule;
	
	/**
	 * The complement rule for the partially executed source rule.
	 */
	protected Rule complementRule;
	
	/**
	 * LHS-Source -> LHS-Complement (forbid, require)
	 */
	private Map<Node, Node> lhsTrace = new HashMap<>();
	
	/**
	 * RHS-Source -> RHS-Complement
	 */
	private Map<Node, Node> rhsTrace = new HashMap<>();
	
	/**
	 * All already executed changes of the source rule.
	 */
	private List<GraphElement> historicChanges;
	
	/**
	 * All changes that will be executed by the complementing rule.
	 */
	private List<GraphElement> complementingChanges;
	
	//// Evaluation ////
	
	/**
	 * The (partial) match of the source rule.
	 */
	private List<EditRuleMatch> sourceMatch;
	
	/**
	 * All possible (full) pre-matches for the complement rule.
	 */
	private List<ComplementMatch> complementMatches;
	
//	/**
//	 * Rules which check a single application condition of the complement rule.
//	 */
//	private Map<NestedCondition, Rule> applicationConditions = new HashMap<>();
	
	/**
	 * The (Henshin) engine which applies the rules.
	 */
	private EngineImpl engine;
	
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
	 * Saves the complement-rule in the same path as the source-rule + '_complement'.
	 */
	public void saveComplementRule() {
		String sourceRuleURI = EcoreUtil.getURI(sourceRule).trimFragment().trimFileExtension().toString();
		URI complementURI = URI.createURI(sourceRuleURI + "_complement").appendFileExtension("henshin");
		saveComplementRule(complementURI);
	}
	
	/**
	 * @param uri
	 *            Saves the complement-rule under the given path.
	 */
	public void saveComplementRule(URI uri) {
		Resource complementResource = new ResourceSetImpl().createResource(uri);
		
		Module complementModule = HenshinFactory.eINSTANCE.createModule();
		complementModule.setName(sourceRule.getModule().getName());
		complementModule.getUnits().add(complementRule);
		complementResource.getContents().add(complementModule);
		
		try {
			complementResource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param engine
	 *            The (Henshin) engine which applies the rules.
	 * @param graph
	 *            The working graph, i.e. the actual version of the model.
	 */
	public void initialize(EngineImpl engine, EGraph graph) {
		this.engine = engine;
		this.graph = graph;
	}
	
	/**
	 * @return All already applied changes of the corresponding edit-rule.
	 */
	public List<GraphElement> getHistoricChanges() {
		
		if (historicChanges == null) {
			historicChanges = new ArrayList<>();
			
			for (Node deleteNode : getLHSMinusRHSNodes(sourceRule)) {
				if (!getComplementingChanges().contains(getTrace(deleteNode))) {
					historicChanges.add(deleteNode);
				}
			}
			
			for (Edge deleteEdge : getLHSMinusRHSEdges(sourceRule)) {
				if (!getComplementingChanges().contains(getTrace(deleteEdge))) {
					historicChanges.add(deleteEdge);
				}
			}
			
			for (Node createNode : getRHSMinusLHSNodes(sourceRule)) {
				if (!getComplementingChanges().contains(getTrace(createNode))) {
					historicChanges.add(createNode);
				}
			}
			
			for (Edge createEdge : getRHSMinusLHSEdges(sourceRule)) {
				if (!getComplementingChanges().contains(getTrace(createEdge))) {
					historicChanges.add(createEdge);
				}
			}
		}
		
		return historicChanges;
	}
	
	/**
	 * @return All missing changes of the corresponding edit-rule.
	 */
	public List<GraphElement> getComplementingChanges() {
		
		if (complementingChanges == null) {
			complementingChanges = getChanges(complementRule);
		}
		
		return complementingChanges;
	}

	/**
	 * @param complementPreMatch
	 *            The concrete complement pre-match.
	 * 
	 * @return <code>true</code> if the rule was successfully applied;
	 *         <code>false</code> otherwise.
	 */
	public boolean apply(ComplementMatch complementPreMatch) {
		
		if ((engine == null) || (graph == null)) {
			throw new RuntimeException("Initialize graph transformation engine!");
		}
		
		// FIXME: Handle Attributes/Parameters:
		List<Attribute> attributes = new ArrayList<>();
		
		for (Iterator<EObject> iterator = complementRule.eAllContents(); iterator.hasNext();) {
			EObject ruleElement = iterator.next();
			
			if (ruleElement instanceof Attribute) {
				attributes.add((Attribute) ruleElement);
			}
		}
		
		for (Attribute attribute : attributes) {
			EcoreUtil.remove(attribute);
		}
		
		// Apply complement rule:
		// TODO: ACs
//		if (complementPreMatch.getUnfulfilledACs().isEmpty()) {
			Match preMatch = new MatchImpl(complementRule);
			
			for (Entry<Node, EObject> match : complementPreMatch.getNodeMatches().entrySet()) {
				preMatch.setNodeTarget(match.getKey(), match.getValue());
			}
			
			RuleApplication application = new RuleApplicationImpl(engine);
			application.setRule(complementRule);
			application.setEGraph(graph);
			application.setCompleteMatch(preMatch);
			
			return application.execute(null);
//		}
//		
//		return false;
	}
	
	//// Getter / Setter /////
	
	public Rule getSourceRule() {
		return sourceRule;
	}

	public void setSourceRule(Rule sourceRule) {
		this.sourceRule = sourceRule;
	}
	
	public EditRuleMatch getSourceMatch(GraphElement graphElement) {
		
		if (graphElement instanceof Node) {
			for (EditRuleMatch editRuleMatch : sourceMatch) {
				if (editRuleMatch instanceof EditRuleNodeMatch) {
					if (((EditRuleNodeMatch) editRuleMatch).getNode() == graphElement) {
						return editRuleMatch;
					}
				}
			}
		}
		
		else if (graphElement instanceof Edge) {
			for (EditRuleMatch editRuleMatch : sourceMatch) {
				if (editRuleMatch instanceof EditRuleEdgeMatch) {
					if (((EditRuleEdgeMatch) editRuleMatch).getEdge() == graphElement) {
						return editRuleMatch;
					}
				}
			}
		}
		
		return null;
	}

	protected void setSourceMatch(List<EditRuleMatch> sourceMatch) {
		this.sourceMatch = sourceMatch;
	}

	public Rule getComplementRule() {
		return complementRule;
	}

	public void setComplementRule(Rule complementRule) {
		this.complementRule = complementRule;
	}

	/**
	 * Calculates all possible complement match (called lazy), i.e. the
	 * parameter values for the complementing changes.
	 */
	protected abstract List<ComplementMatch> createComplementMatches(List<EditRuleMatch> partialSourceMatch);

	/**
	 * @return all possible complement match (called lazy), i.e. the parameter
	 *         values for the complementing changes.
	 */
	public List<ComplementMatch> getComplementMatches() {

		if (complementMatches == null) {
			complementMatches = createComplementMatches(sourceMatch);
		}
		
		return complementMatches;
	}
	
	public EngineImpl getEngine() {
		return engine;
	}

	public void setEngine(EngineImpl engine) {
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

// TODO: ACs
//	//// Handle application conditions ////
//	
//	public boolean recheckApplicationCondition(
//			NestedCondition applicationCondition, ComplementMatch complementPreMatch) {
//		
//		Rule minimumConclusion = getMinimumConclusion(applicationCondition);
//		Match minimumPreMatch = getPreMatch(minimumConclusion, complementPreMatch);
//		
//		// Ignored AC -> Activate?
//		if (complementPreMatch.getIgnoredACs().contains(applicationCondition)) {
//			complementPreMatch.getIgnoredACs().remove(applicationCondition);
//			complementPreMatch.getUnfulfilledACs().add(applicationCondition);
//		}
//		
//		// Recheck AC:
//		if (minimumPreMatch != null) {
//			Iterator<Match> matchFinder = engine.findMatches(minimumConclusion, graph, minimumPreMatch).iterator();
//			
//			if (matchFinder.hasNext()) {
//				complementPreMatch.getUnfulfilledACs().remove(applicationCondition);
//				return true;
//			}
//		}
//		
//		return false;
//	}
//		
//	private Rule getMinimumConclusion(NestedCondition applicationCondition) {
//		Rule minConclusion = applicationConditions.get(applicationCondition);
//		
//		// Create minimum conclusion:
//		if (minConclusion == null) {
//			minConclusion = createMinimumConclusion(applicationCondition);
//		}
//		
//		return minConclusion;
//	}
//	
//	private Rule createMinimumConclusion(NestedCondition applicationCondition) {
//		Rule minConclusion = HenshinFactory.eINSTANCE.createRule();
//		
//		Map<EObject, EObject> acCopy = ComplementUtil.deepCopy(applicationCondition);
//		NestedCondition minConclusionAC = (NestedCondition) acCopy.get(applicationCondition);
//		minConclusion.getLhs().getNestedConditions().add(minConclusionAC);
//		
//		for (Mapping acMapping : applicationCondition.getMappings()) {
//			Node acContextNode = acMapping.getImage();
//			
//			if (HenshinConditionAnalysis.isACBoundaryNode(acContextNode)) {
//				Node lhsBoundaryNode = acMapping.getOrigin();
//				Node rhsBoundaryNode = getRHS(lhsBoundaryNode);
//				NodePair preserveNode = new NodePair(lhsBoundaryNode, rhsBoundaryNode);
//				
//				// Copy minimal boundary:
//				NodePair minConclusionPreserveNode = copyPreserveNodes(minConclusion, preserveNode, false);
//				
//				// Copy AC mapping:
//				Mapping minConclusionACMapping = HenshinFactory.eINSTANCE.createMapping();
//				minConclusionACMapping.setOrigin(minConclusionPreserveNode.getLhsNode());
//				minConclusionACMapping.setImage((Node) acCopy.get(acContextNode));
//				minConclusionAC.getMappings().add(minConclusionACMapping);
//			}
//		}
//		
//		return minConclusion;
//	}
//	
//	// FIXME: Maybe we should check all ACs of the rule here and not only the latest unfulfilled!?
//	public void recheckAllApplicationConditions(ComplementMatch contextMatch) {
//		for (NestedCondition pac : contextMatch.getUnfulfilledACs()) {
//			recheckApplicationCondition(pac, contextMatch);
//		}
//	}
//	
//	public void ignoreApplicationCondition(NestedCondition applicationCondition, ComplementMatch contextMatch) {
//		contextMatch.getIgnoredACs().add(applicationCondition);
//		contextMatch.getUnfulfilledACs().remove(applicationCondition);
//		
//		// Remove AC from complement-rule:
//		applicationCondition.getConclusion().getNestedConditions().remove(applicationCondition);
//	}
//	
//	private Match getPreMatch(Rule rule, ComplementMatch complementPreMatch) {
//		Match preMatch = new MatchImpl(rule);
//		
//		for (Node lhsNode : rule.getLhs().getNodes()) {
//			EObject nodePreMatch = complementPreMatch.getNodeMatches().get(lhsNode);
//			assert (nodePreMatch != null) : "Missing context: " + lhsNode;
//			preMatch.setNodeTarget(lhsNode, nodePreMatch);
//		}
//		
//		return preMatch;
//	}
}
