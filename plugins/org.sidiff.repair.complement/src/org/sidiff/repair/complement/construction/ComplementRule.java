package org.sidiff.repair.complement.construction;

import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getLHS;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.getRHS;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isRHSEdge;
import static org.sidiff.common.henshin.HenshinRuleAnalysisUtilEx.isRHSNode;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.RuleApplication;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.RuleApplicationImpl;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.consistency.common.henshin.ChangePatternUtil;
import org.sidiff.repair.api.matching.EOAttributeMatch;
import org.sidiff.repair.api.matching.EOEdgeMatch;
import org.sidiff.repair.api.matching.EOMatch;
import org.sidiff.repair.api.matching.EONodeMatch;
import org.sidiff.repair.api.matching.EditOperationMatching;

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
	private List<EOMatch> sourceMatch;
	
	/**
	 * All possible (full) pre-matches for the complement rule.
	 */
	private List<EditOperationMatching> complementMatches;
	
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
			historicChanges = ChangePatternUtil.getPotentialChanges(sourceRule);
			
			for (Iterator<GraphElement> iterator = historicChanges.iterator(); iterator.hasNext();) {
				GraphElement potentialHistoricChanges = iterator.next();
				
				if (getComplementingChanges().contains(getTrace(potentialHistoricChanges))) {
					iterator.remove();
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
			complementingChanges = ChangePatternUtil.getChanges(complementRule);
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
	public RuleApplication apply(EditOperationMatching complementPreMatch) {
		
		if ((engine == null) || (graph == null)) {
			throw new RuntimeException("Initialize graph transformation engine!");
		}
		
		// Apply complement rule:
		RuleApplication application = new RuleApplicationImpl(engine);
		application.setRule(complementRule);
		application.setEGraph(graph);
		application.setCompleteMatch(complementPreMatch.getMatch());

		if (application.execute(null)) {
			return application;
		} else {
			return null;
		}
	}
	
	//// Getter / Setter /////
	
	public Rule getSourceRule() {
		return sourceRule;
	}

	public void setSourceRule(Rule sourceRule) {
		this.sourceRule = sourceRule;
	}
	
	public EOMatch getSourceMatch(GraphElement graphElement) {
		
		if (graphElement instanceof Node) {
			for (EOMatch editRuleMatch : sourceMatch) {
				if (editRuleMatch instanceof EONodeMatch) {
					if (((EONodeMatch) editRuleMatch).getNode() == graphElement) {
						return editRuleMatch;
					}
				}
			}
		}
		
		else if (graphElement instanceof Edge) {
			for (EOMatch editRuleMatch : sourceMatch) {
				if (editRuleMatch instanceof EOEdgeMatch) {
					if (((EOEdgeMatch) editRuleMatch).getEdge() == graphElement) {
						return editRuleMatch;
					}
				}
			}
		}
		
		else if (graphElement instanceof Attribute) {
			for (EOMatch editRuleMatch : sourceMatch) {
				if (editRuleMatch instanceof EOAttributeMatch) {
					if (((EOAttributeMatch) editRuleMatch).getAttribute() == graphElement) {
						return editRuleMatch;
					}
				}
			}
		}
		
		return null;
	}

	protected void setSourceMatch(List<EOMatch> sourceMatch) {
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
	protected abstract List<EditOperationMatching> createComplementMatches(List<EOMatch> partialSourceMatch);

	/**
	 * @return all possible complement match (called lazy), i.e. the parameter
	 *         values for the complementing changes.
	 */
	public List<EditOperationMatching> getComplementMatches() {

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
	
	public void addTrace(Node sourceNode, Node complementNode) {
		assert (sourceNode.getGraph().getRule() == sourceRule);
		assert (complementNode.getGraph().getRule() == complementRule);
		
		if (isRHSNode(sourceNode)) {
			// RHS-Node
			rhsTrace.put(sourceNode, complementNode);
			
			// Lookup LHS-Node:
			Node lhsNode = getLHS(sourceNode);
			
			if (lhsNode == null) {
				lhsTrace.put(sourceNode, complementNode);
			}
		} else {
			// LHS/Forbid/Require-Node
			lhsTrace.put(sourceNode, complementNode);
			
			// Lookup RHS-Node:
			Node rhsNode = getRHS(sourceNode);
			
			if (rhsNode == null) {
				rhsTrace.put(sourceNode, complementNode);
			}
		}
	}
	
	public void removeTrace(Node sourceNode) {
		assert (sourceNode.getGraph().getRule() == sourceRule);
		
		if (isRHSNode(sourceNode)) {
			rhsTrace.remove(sourceNode);
		} else {
			lhsTrace.remove(sourceNode);
		}
	}
	
	public GraphElement getTrace(GraphElement sourceGraphElement) {
		if (sourceGraphElement instanceof Node) {
			return getTrace((Node) sourceGraphElement);
		} else if (sourceGraphElement instanceof Edge) {
			return getTrace((Edge) sourceGraphElement);
		} else if (sourceGraphElement instanceof Attribute) {
			return getTrace((Attribute) sourceGraphElement);
		}
		return null;
	}
	
	public Node getTrace(Node sourceNode) {
		assert ((sourceNode == null) ||(sourceNode.getGraph().getRule() == sourceRule));
		Node lhsNodeTrace = lhsTrace.get(sourceNode);
		
		if (lhsNodeTrace == null) {
			return rhsTrace.get(sourceNode);
		} else {
			return lhsNodeTrace; 
		}
	}
	
	public Attribute getTrace(Attribute sourceAttribute) {
		assert ((sourceAttribute == null) ||(sourceAttribute.getGraph().getRule() == sourceRule));
		Node complementNode = getTrace(sourceAttribute.getNode());
		
		if (complementNode != null) {
			return complementNode.getAttribute(sourceAttribute.getType());
		}
		
		return null;
	}
	
	public Edge getTrace(Edge sourceEdge) {
		assert ((sourceEdge == null) ||(sourceEdge.getGraph().getRule() == sourceRule));
		
		Node srcNodeTrace = null;
		Node tgtNodeTrace = null;
		
		if (isRHSEdge(sourceEdge)) {
			srcNodeTrace = rhsTrace.get(sourceEdge.getSource());
			tgtNodeTrace = rhsTrace.get(sourceEdge.getTarget());
		} else {
			srcNodeTrace = lhsTrace.get(sourceEdge.getSource());
			tgtNodeTrace = lhsTrace.get(sourceEdge.getTarget());
		}
		
		if ((srcNodeTrace != null) && (tgtNodeTrace != null)) {
			return srcNodeTrace.getOutgoing(sourceEdge.getType(), tgtNodeTrace);
		}
		
		return null;
	}
}
