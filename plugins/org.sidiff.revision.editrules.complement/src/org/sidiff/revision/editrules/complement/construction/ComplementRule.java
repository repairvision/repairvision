package org.sidiff.revision.editrules.complement.construction;

import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.getLHS;
import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.getRHS;
import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.isRHSEdge;
import static org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil.isRHSNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.GraphElement;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.sidiff.revision.common.henshin.HenshinChangesUtil;
import org.sidiff.revision.common.henshin.HenshinRuleAnalysisUtil;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.editrules.recognition.match.RecognitionActionMatch;
import org.sidiff.revision.editrules.recognition.match.RecognitionMatching;

/**
 * Stores the trace of a complement rule for a given partially executed edit rule.
 * 
 * @author Manuel Ohrndorf
 */
public class ComplementRule {

	/**
	 * The recognized partially executed edit rule.
	 */
	protected Rule recognizedRule;
	
	/**
	 * All already executed changes of the source rule.
	 */
	private List<GraphElement> recognizedChanges;
	
	/**
	 * The (partial) match of the recognition rule.
	 */
	private RecognitionMatching recognitionMatch;
	
	/**
	 * The complement rule for the partially executed edit rule.
	 */
	protected Rule complementRule;
	
	/**
	 * All changes that will be executed by the complementing rule.
	 */
	private List<GraphElement> complementingChanges;
	
	/**
	 * LHS-Source -> LHS-Complement (forbid, require)
	 */
	private Map<Node, Node> lhsTrace = new HashMap<>();
	
	/**
	 * RHS-Source -> RHS-Complement
	 */
	private Map<Node, Node> rhsTrace = new HashMap<>();
	
	public ComplementRule(Rule recognizedRule, RecognitionMatching recognitionMatch, Rule complementRule) {
		this.recognizedRule = recognizedRule;
		this.recognitionMatch = recognitionMatch;
		this.complementRule = complementRule;
	}
	
	public Rule getRecognizedRule() {
		return recognizedRule;
	}
	
	public List<GraphElement> getRecognizedChanges() {
		
		if (recognizedChanges == null) {
			recognizedChanges = recognitionMatch.stream()
					.filter(sm -> sm instanceof RecognitionActionMatch)
					.map(sm -> (RecognitionActionMatch) sm)
					.map(RecognitionActionMatch::getGraphElement)
					.collect(Collectors.toList());
			
			// NOTE: Allow the overwriting of already initially set attributes:
			//       (for complete recognized edit rules)
			List<Attribute> settingAttributes = HenshinChangesUtil.getSettingAttributes(recognizedRule);
			
			if ((getComplementingChanges().size() - settingAttributes.size()) == 0) {
				recognizedChanges.addAll(settingAttributes);
			}
		}
		
		return recognizedChanges;
	}
	
	public RecognitionMatching getRecognitionMatching() {
		return recognitionMatch;
	}
	
	public List<Change> getRecognizedChangeSet() {
		return recognitionMatch.getChangeSet();
	}
	
	public Rule getComplementRule() {
		return complementRule;
	}
	
	public List<GraphElement> getComplementingChanges() {
		
		if (complementingChanges == null) {
			complementingChanges = HenshinChangesUtil.getPotentialChanges(complementRule);
		}
		
		return complementingChanges;
	}
	
	/**
	 * @return The boundary changes that are incident to the LHS.
	 */
	public List<GraphElement> getComplementingBoundaryChanges() {
		List<GraphElement> boundaryComplementingChanges = new ArrayList<>();
		
		for (GraphElement graphElement : getComplementingChanges()) {
			if (graphElement instanceof Edge) {
				Node source = HenshinRuleAnalysisUtil.getLHS(((Edge) graphElement).getSource());
				
				if (source != null) {
					boundaryComplementingChanges.add(graphElement);
				}
			} else if (graphElement instanceof Attribute) {
				Node container = HenshinRuleAnalysisUtil.getLHS(((Attribute) graphElement).getNode());
				
				if (container != null) {
					boundaryComplementingChanges.add(graphElement);
				}
			} else if (graphElement instanceof Node) {
				Node node = HenshinRuleAnalysisUtil.getLHS((Node) graphElement);
				
				if (node != null) {
					boundaryComplementingChanges.add(node);
				}
			}
		}
		
		return boundaryComplementingChanges;
	}
	
	/**
	 * Saves the complement-rule in the same path as the source-rule + '_complement'.
	 */
	public void saveComplementRule() {
		String sourceRuleURI = EcoreUtil.getURI(recognizedRule).trimFragment().trimFileExtension().toString();
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
		complementModule.setName(recognizedRule.getModule().getName());
		complementModule.getUnits().add(complementRule);
		complementResource.getContents().add(complementModule);
		
		try {
			complementResource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//// Trace ////
	
	public void addTrace(Node sourceNode, Node complementNode) {
		assert (sourceNode.getGraph().getRule() == recognizedRule);
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
		assert (sourceNode.getGraph().getRule() == recognizedRule);
		
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
		assert ((sourceNode == null) ||(sourceNode.getGraph().getRule() == recognizedRule));
		Node lhsNodeTrace = lhsTrace.get(sourceNode);
		
		if (lhsNodeTrace == null) {
			return rhsTrace.get(sourceNode);
		} else {
			return lhsNodeTrace; 
		}
	}
	
	public Attribute getTrace(Attribute sourceAttribute) {
		assert ((sourceAttribute == null) ||(sourceAttribute.getGraph().getRule() == recognizedRule));
		Node complementNode = getTrace(sourceAttribute.getNode());
		
		if (complementNode != null) {
			return complementNode.getAttribute(sourceAttribute.getType());
		}
		
		return null;
	}
	
	public Edge getTrace(Edge sourceEdge) {
		assert ((sourceEdge == null) ||(sourceEdge.getGraph().getRule() == recognizedRule));
		
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
	
	public Parameter getTrace(Parameter sourceParameter) {
		return complementRule.getParameter(sourceParameter.getName());
	}
	
	@Override
	public String toString() {
		StringBuilder complementRule = new StringBuilder();
		
		complementRule.append(recognizedRule.getName());
		complementRule.append("\n");
		complementRule.append("\n");
		complementRule.append("Sub-Rule:");
		complementRule.append("\n");

		for (GraphElement graphElement : getRecognizedChanges()) {
			complementRule.append(" ");
			complementRule.append(graphElement);
			complementRule.append("\n");
		}
		
		complementRule.append("\n");
		complementRule.append("Complement-Rule:");
		complementRule.append("\n");
		
		for (GraphElement graphElement : getComplementingChanges()) {
			complementRule.append(" ");
			complementRule.append(graphElement);
			complementRule.append("\n");
		}
		
		return complementRule.toString();
	}
}
