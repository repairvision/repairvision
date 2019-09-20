package org.sidiff.graphpattern.tools.editrules.generator.main;

import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.not;
import static org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil.parentConstraint;

import java.util.ArrayList;
import java.util.List;

import org.sidiff.csp.solver.ICSPSolver;
import org.sidiff.csp.solver.IConstraintSatisfactionProblem;
import org.sidiff.csp.solver.IDomain;
import org.sidiff.csp.solver.IVariable;
import org.sidiff.csp.solver.impl.CSPSolver;
import org.sidiff.csp.solver.impl.ConstraintSatisfactionProblem;
import org.sidiff.csp.solver.impl.Variable;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.tools.csp.AbstractGraphPatternMatchings;
import org.sidiff.graphpattern.tools.editrules.csp.MinGraphEditDistanceMatch;
import org.sidiff.graphpattern.tools.editrules.csp.MinGraphEditDistanceMatchings;
import org.sidiff.graphpattern.tools.editrules.generator.util.EditRuleCollector;
import org.sidiff.graphpattern.util.GraphPatternUtil;

public class TransformationEditRuleGenerator {

	public static void generateStructuralTransformationRules(Pattern pattern, EditRuleCollector editRules) {
		List<GraphPattern> allConstraints = pattern.getAllGraphPatterns();
		
		// Generate edit rules:
		// Consider cross-product of all graph patterns:
		for (GraphPattern preConstraint : allConstraints) {
			List<Pattern> transformationRules = new ArrayList<>();
			
//			if (preConstraint.getName().contains("Enumeration with Literal")) {
//				System.out.println(preConstraint.getName());
//			} else {
//				continue;
//			}
			
			for (GraphPattern postConstraint : allConstraints) {
//				if (postConstraint.getName().contains("Enumeration Attribute")) {
//					System.out.println(postConstraint.getName());
//				} else {
//					continue;
//				}
				
				if ((preConstraint != postConstraint) && (parentConstraint(preConstraint) == parentConstraint(postConstraint))) {
					int preSize = GraphPatternUtil.getPatternSize(preConstraint.getNodes());
					int postSize = GraphPatternUtil.getPatternSize(postConstraint.getNodes());

					IConstraintSatisfactionProblem<NodePattern, NodePattern> problem = new ConstraintSatisfactionProblem<>(preConstraint.getNodes().size());
					problem.setMinimumSolutionSize(Math.min(preSize, postSize)); // NOTE: At least one of both patterns need to be matched completely.
					problem.setMaximumSolutionSize(Math.max(preSize, postSize));
					problem.setSearchMaximumSolutions(true);
					problem.setSearchInjectiveSolutions(true);

					for (NodePattern preNode : preConstraint.getNodes()) {
						if (!preNode.getStereotypes().contains(not)) {
							IDomain<NodePattern> domain = AbstractGraphPatternMatchings.getDomain(preNode, 
									postConstraint.getNodes(), 
									n -> !n.getStereotypes().contains(not));
							IVariable<NodePattern, NodePattern> variable = new Variable<>(preNode, domain, true);
							problem.addVariable(variable);
						}
					}

					MinGraphEditDistanceMatchings matchings = new MinGraphEditDistanceMatchings(preConstraint, postConstraint);
					ICSPSolver<NodePattern, NodePattern> solver = new CSPSolver<>(problem, matchings);
					solver.run();

					String name = "Transform: "
							+ preConstraint.getName() + " - To - "
							+ postConstraint.getName();

//					System.out.println("[" + matchings.getMatches().size() + "]: " + name);

					// Generate edit rules:
					int counter = 0;
					int count = matchings.getMatches().size();

					for (MinGraphEditDistanceMatch match : matchings.getMatches()) {

						if (count > 1) {
							match.setName(name + " (" + ++counter + ")");
						} else {
							match.setName(name);
						}

						Pattern editOperation = match.getEditOperation();
						transformationRules.add(editOperation);
					}
				}
			}
			
			// Add new edit rule for graph pattern:
			editRules.add(preConstraint, transformationRules);
		}
	}
}
