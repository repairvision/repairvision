package org.sidiff.graphpattern.tools.editrules.csp;

import java.util.HashMap;
import java.util.Map;

import org.sidiff.csp.solver.ISolution;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.tools.editrules.generator.GEDEditRuleGenerator;

public class GraphConstraintMatch implements ISolution<NodePattern, NodePattern> {

	protected GraphPattern preConstraint;
	
	protected GraphPattern postConstraint;
	
	protected Map<NodePattern, NodePattern> preToPostMatch;
	
	public GraphConstraintMatch(GraphPattern preConstraint, GraphPattern postConstraint, int size) {
		this.preConstraint = preConstraint;
		this.postConstraint = postConstraint;
		this.preToPostMatch = new HashMap<NodePattern, NodePattern>((int) ((float) size / 0.75f + 1.0f));
	}
	
	public GraphPattern getPreConstraint() {
		return preConstraint;
	}
	
	public GraphPattern getPostConstraint() {
		return postConstraint;
	}
	
	@Override
	public void store(NodePattern subject, NodePattern value) {
		preToPostMatch.put(subject, value);
	}
	
	public int getGraphEditDistance() {
		GEDEditRuleGenerator editRuleGenerator = new GEDEditRuleGenerator(preConstraint, postConstraint, preToPostMatch);
		editRuleGenerator.generate(preConstraint.getNodes(), postConstraint.getNodes());
		return editRuleGenerator.getGraphEditDistance();
		
//		// nodes:
//		int deletedNodes = Math.abs(preConstraint.getNodes().size() - size());
//		int createdNodes = Math.abs(postConstraint.getNodes().size() - size());
//		
//		// edges:
//		int deletedEdges = 0;
//		int createdEdges = 0;
//		
//		for (Entry<NodePattern, NodePattern> lhsToRhsMatched : preToPostMatch.entrySet()) {
//			NodePattern lhsNode = lhsToRhsMatched.getKey();
//			NodePattern rhsNode = lhsToRhsMatched.getValue();
//			
//			List<EdgePattern> rhsMatchedEdges = new ArrayList<>();
//			
//			for (EdgePattern lhsEdge : lhsNode.getOutgoings()) {
//				EdgePattern rhsEdge = EditRuleGeneratorUtil.getEdgeMatch(preToPostMatch, lhsEdge);
//				
//				if (rhsEdge != null) {
//					rhsMatchedEdges.add(rhsEdge);
//				} else {
//					++deletedEdges;
//				}
//			}
//			
//			for (EdgePattern rhsEdge : rhsNode.getOutgoings()) {
//				if (!rhsMatchedEdges.contains(rhsEdge)) {
//					++createdEdges;
//				}
//			}
//		}
//		
//		// attributes:
//		int attributeValueChanges = 0;
//		
//		for (Entry<NodePattern, NodePattern> lhsToRhsMatched : preToPostMatch.entrySet()) {
//			NodePattern lhsNode = lhsToRhsMatched.getKey();
//		
//			for (AttributePattern lhsAttribute : lhsNode.getAttributes()) {
//				AttributePattern rhsAttribute = EditRuleGeneratorUtil.getAttributeMatch(preToPostMatch, lhsAttribute);
//				
//				if (rhsAttribute != null) {
//					if (!lhsAttribute.getValue().equals(rhsAttribute.getValue())) {
//						++attributeValueChanges;
//					}
//				}
//			}
//		}
//		
//		int editDistance = deletedNodes + createdNodes + deletedEdges + createdEdges + attributeValueChanges;
//		return editDistance;
	}
	
	public Map<NodePattern, NodePattern> getMatch() {
		return preToPostMatch;
	}

	public int size() {
		return preToPostMatch.size();
	}
}
