package org.sidiff.graphpattern.tools.editrules.generator.main;

import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.not;
import static org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil.completeConditions;
import static org.sidiff.graphpattern.tools.editrules.generator.util.GraphPatternGeneratorUtil.completeContext;
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
import org.sidiff.graphpattern.tools.editrules.generator.GraphPatternEditRuleGenerator;
import org.sidiff.graphpattern.tools.editrules.generator.util.EditRuleCollector;
import org.sidiff.graphpattern.util.GraphPatternUtil;

public class TransformationEditRuleGenerator {

	public static void generateStructuralTransformationRules(Pattern pattern, EditRuleCollector editRules) {
		List<GraphPattern> allConstraints = pattern.getAllGraphPatterns();
		
		// Generate edit rules:
		// Consider cross-product of all graph patterns:
		for (GraphPattern fromConstraint : allConstraints) {
			List<Pattern> transformationRules = new ArrayList<>();
			
//			if (fromConstraint.getName().contains("Multiplicity-One Containment-Container Reference")) {
//				System.out.println(fromConstraint.getName());
//			} else {
//				continue;
//			}
			
			for (GraphPattern toConstraint : allConstraints) {
//				if (toConstraint.getName().contains("Multiplicity-Many Bidirectional Reference")) {
//					System.out.println(toConstraint.getName());
//				} else {
//					continue;
//				}
				
				if ((fromConstraint != toConstraint) && (parentConstraint(fromConstraint) == parentConstraint(toConstraint))) {
					int preSize = GraphPatternUtil.getPatternSize(fromConstraint.getNodes());
					int postSize = GraphPatternUtil.getPatternSize(toConstraint.getNodes());

					IConstraintSatisfactionProblem<NodePattern, NodePattern> problem = new ConstraintSatisfactionProblem<>(fromConstraint.getNodes().size());
					problem.setMinimumSolutionSize(Math.min(preSize, postSize)); // NOTE: At least one of both patterns need to be matched completely.
					problem.setMaximumSolutionSize(Math.max(preSize, postSize));
					problem.setSearchMaximumSolutions(true);
					problem.setSearchInjectiveSolutions(true);

					for (NodePattern fromNode : fromConstraint.getNodes()) {
						if (!fromNode.getStereotypes().contains(not)) {
							IDomain<NodePattern> domain = AbstractGraphPatternMatchings.getDomain(fromNode, 
									toConstraint.getNodes(), 
									n -> !n.getStereotypes().contains(not));
							IVariable<NodePattern, NodePattern> variable = new Variable<>(fromNode, domain, true);
							problem.addVariable(variable);
						}
					}

					MinGraphEditDistanceMatchings matchings = new MinGraphEditDistanceMatchings(fromConstraint, toConstraint);
					ICSPSolver<NodePattern, NodePattern> solver = new CSPSolver<>(problem, matchings);
					solver.run();

					String name = "Transform: "
							+ fromConstraint.getName() + " - To - "
							+ toConstraint.getName();

//					System.out.println("[" + matchings.getMatches().size() + "]: " + name);

					// Generate edit rules:
					int counter = 0;
					int count = matchings.getMatches().size();

					for (MinGraphEditDistanceMatch match : matchings.getMatches()) {
						GraphPatternEditRuleGenerator editRuleGenerator = new GraphPatternEditRuleGenerator(
								matchings.getSubjectGraph(), 
								matchings.getValueGraph(),
								match.getMatch());
						editRuleGenerator.generate(
								matchings.getSubjectGraph().getNodes(), 
								matchings.getValueGraph().getNodes());

						if (count > 1) {
							editRuleGenerator.setName(name + " (" + ++counter + ")");
						} else {
							editRuleGenerator.setName(name);
						}

						Pattern editOperation = editRuleGenerator.getEditOperation();
						completeContext(editOperation);
						completeConditions(editOperation);
						transformationRules.add(editOperation);
					}
				}
			}
			
			// Add new edit rule for graph pattern:
			editRules.add(fromConstraint, transformationRules);
		}
	}
}
