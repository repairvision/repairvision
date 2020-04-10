package org.sidiff.revision.editrules.generation.constructors;

import static org.sidiff.graphpattern.profile.constraints.util.ConstraintProfileUtil.isNegativeCondition;
import static org.sidiff.revision.editrules.generation.generator.util.GraphPatternGeneratorUtil.parentConstraint;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.csp.generic.ICSPSolver;
import org.sidiff.graphpattern.csp.generic.IConstraintSatisfactionProblem;
import org.sidiff.graphpattern.csp.generic.IDomain;
import org.sidiff.graphpattern.csp.generic.IVariable;
import org.sidiff.graphpattern.csp.generic.impl.CSPSolver;
import org.sidiff.graphpattern.csp.generic.impl.ConstraintSatisfactionProblem;
import org.sidiff.graphpattern.csp.generic.impl.Variable;
import org.sidiff.graphpattern.tools.csp.AbstractGraphPatternMatchings;
import org.sidiff.graphpattern.util.GraphPatternUtil;
import org.sidiff.revision.editrules.generation.constructors.util.EditRuleCollector;
import org.sidiff.revision.editrules.generation.constructors.util.MinGraphEditDistanceMatch;
import org.sidiff.revision.editrules.generation.constructors.util.MinGraphEditDistanceMatchings;
import org.sidiff.revision.editrules.generation.filter.IEditRuleFilter;

public class TransformationEditRuleConstructor implements IEditRuleConstructor {

	@Override
	public void construct(Pattern pattern, List<IEditRuleFilter> filter, EditRuleCollector editRules) {
		List<GraphPattern> allConstraints = pattern.getAllGraphPatterns();
		
		// TODO[PERFORMANCE]: As long as it makes no difference to match A,B or B,A we
		// could also just process all pair instead of the cross-product of all patterns.

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
					int preSize = GraphPatternUtil.count(preConstraint.getNodes(), n -> !isNegativeCondition(n));
					int postSize = GraphPatternUtil.count(postConstraint.getNodes(), n -> !isNegativeCondition(n));

					// NOTE: Find match: 
					//       - Pre in Post or Post in Pre
					//       - equal node types
					//       - keep match with minimal graph edit distance
					//       - do not consider negative condition nodes in matching
					IConstraintSatisfactionProblem<NodePattern, NodePattern> problem = new ConstraintSatisfactionProblem<>(preConstraint.getNodes().size());
//					problem.setMinimumSolutionSize(Math.min(preSize, postSize)); 	// NOTE: At least one of both patterns need to be matched completely.
					problem.setMinimumSolutionSize(1);								// NOTE: MCS matching, with minimum of 1
					problem.setMaximumSolutionSize(Math.max(preSize, postSize));
					problem.setSearchInjectiveSolutions(true);

					for (NodePattern preNode : preConstraint.getNodes()) {
						if (!isNegativeCondition(preNode)) {
							IDomain<NodePattern> domain = AbstractGraphPatternMatchings.getDomain(preNode, 
									postConstraint.getNodes(), 
									n -> !isNegativeCondition(n));
							IVariable<NodePattern, NodePattern> variable = new Variable<>(
									preNode, 
									domain, 
									domain.isEmpty(),	// optimization - search maximum common set - in general true
									true);
							problem.addVariable(variable);
						}
					}

					MinGraphEditDistanceMatchings matchings = new MinGraphEditDistanceMatchings(preConstraint, postConstraint, filter);
					ICSPSolver<NodePattern, NodePattern> solver = new CSPSolver<>(problem, matchings);
					solver.run();

					String name = "Transform: "
							+ preConstraint.getName() + " - To - "
							+ postConstraint.getName();

//					System.out.println("[" + matchings.getMatches().size() + "]: " + name);

					// Filter edit rules (by global rulebase):
					for (Iterator<MinGraphEditDistanceMatch> iterator = matchings.getMatches().iterator(); iterator.hasNext();) {
						MinGraphEditDistanceMatch match = iterator.next();
						
						if (IEditRuleFilter.filter(filter, match.getEditOperation(), match.getEditRule(), editRules.getRulebase())) {
							System.err.println("INFO: Filtered edit rule [" + matchings.getMatches().indexOf(match) + "]: " + name);
							iterator.remove();
						}
					}
					
					// Generate edit rule names:
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
