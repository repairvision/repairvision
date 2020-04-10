package org.sidiff.revision.editrules.generation.filter;

import java.util.List;

import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.Stereotype;
import org.sidiff.graphpattern.csp.generic.ICSPSolver;
import org.sidiff.graphpattern.csp.generic.IConstraintSatisfactionProblem;
import org.sidiff.graphpattern.csp.generic.impl.CSPSolver;
import org.sidiff.graphpattern.csp.generic.impl.ConstraintSatisfactionProblem;
import org.sidiff.graphpattern.csp.generic.impl.Variable;
import org.sidiff.graphpattern.tools.csp.GraphPatternMatchings;
import org.sidiff.graphpattern.tools.csp.NodePatternDomain;
import org.sidiff.graphpattern.tools.csp.NodePatternDomain.EdgeMatching;
import org.sidiff.graphpattern.tools.csp.NodePatternVariable;

public class EditRuleDuplicationFilter implements IEditRuleFilter {

	@Override
	public boolean filter(Pattern editOperation, GraphPattern editRule, Iterable<GraphPattern> rulebase) {
		
		// Match given rule into rulebase:
		int nodeSize = editRule.getNodes().size();
		
		for (GraphPattern rulebaseEditRule : rulebase) {
			if (matchSize(editRule, rulebaseEditRule)) {
				IConstraintSatisfactionProblem<NodePattern, NodePattern> problem = new ConstraintSatisfactionProblem<>(nodeSize);
				problem.setMinimumSolutionSize(nodeSize);
				problem.setMaximumSolutionSize(nodeSize);
				problem.setSearchInjectiveSolutions(true);
				
				for (NodePattern basicEditRuleNode : editRule.getNodes()) {
					NodePatternDomain domain = new NodePatternDomain(
							basicEditRuleNode, rulebaseEditRule.getNodes(), 
							EdgeMatching.TOTAL_INJECTIVE, EdgeMatching.TOTAL_INJECTIVE) {

						@Override
						protected boolean checkStereotypes(NodePattern subject, NodePattern value) {

							// Nodes:
							return subject.getStereotypes().equals(value.getStereotypes());
						}

						@Override
						protected boolean checkAttributes(NodePattern subject, NodePattern value) {
							
							// One-to-one match:
							if (subject.getAttributes().size() == value.getAttributes().size()) {
								AttributePattern[] domain = value.getAttributes().toArray(new AttributePattern[0]);
								
								for (AttributePattern subjectAttribute : subject.getAttributes()) {
									int match = matchAttribute(subjectAttribute, domain);
									
									if (match >= 0) {
										domain[match] = null; 	// "value assigned" (injective)
									} else {
										return false;			// no match found
									}
								}
								
								return true;
							}
							
							return false;
						}
						
						private int matchAttribute(AttributePattern variable, AttributePattern[] domain) {
							
							for (int i = 0; i < domain.length; i++) {
								AttributePattern value = domain[i];

								if (value != null) {
									if (value.getType() == variable.getType()) {
										if (value.getStereotypes().equals(variable.getStereotypes())) {
											if (value.getValue().equals(variable.getValue())) {
												return i;
											}
										}
									}
								}
							}
							
							return -1;
						}
					};
					
					// NOTE: Optimization:
					if (domain.isEmpty()) {
						break;
					}
					
					Variable<NodePattern, NodePattern> variable = new NodePatternVariable(basicEditRuleNode, domain, false, true, true) {
						
						@Override
						protected boolean checkStereotypes(List<Stereotype> subject, List<Stereotype> assignment) {
							
							// Edges:
							return subject.equals(assignment);
						}
					};
					problem.addVariable(variable);
				}
				
				GraphPatternMatchings matchings = new GraphPatternMatchings(editRule, rulebaseEditRule);
				ICSPSolver<NodePattern, NodePattern> solver = new CSPSolver<>(problem, matchings);
				solver.run();
				
				// TODO[Optimize]: Find only first match:
				if (!matchings.getMatches().isEmpty()) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean matchSize(GraphPattern editRuleA, GraphPattern editRuleB) {
		if (editRuleA.getNodes().size() == editRuleB.getNodes().size()) {
			int edgesA = 0;
			int attributesA = 0;
			
			int edgesB = 0;
			int attributesB = 0;
			
			for (NodePattern nodeA : editRuleA.getNodes()) {
				edgesA += nodeA.getOutgoings().size();
				attributesA += nodeA.getAttributes().size();
			}
			
			for (NodePattern nodeB : editRuleB.getNodes()) {
				edgesB += nodeB.getOutgoings().size();
				attributesB += nodeB.getAttributes().size();

				if (edgesB > edgesA) {
					return false;
				}

				if (attributesB > attributesA) {
					return false;
				}
			}
			
			if (edgesB == edgesA) {
				return true;
			}
			
			if (attributesB == attributesA) {
				return true;
			}
		}
		
		return false;
	}

}
