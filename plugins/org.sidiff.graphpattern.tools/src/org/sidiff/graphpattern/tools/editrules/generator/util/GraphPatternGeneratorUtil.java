package org.sidiff.graphpattern.tools.editrules.generator.util;

import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.constraint;
import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.not;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.preserve;

import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Parameter;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil;

public class GraphPatternGeneratorUtil {

	public static boolean isContext(NodePattern node) {
		return !node.getIncomings().stream().anyMatch(e -> e.getType().isContainment());
	}

	public static Pattern parentConstraint(GraphPattern fromConstraint) {
		Pattern parentPattern = fromConstraint.getPattern();
		
		while (parentPattern.eContainer() instanceof Pattern) {
			if (parentPattern.getStereotypes().contains(constraint)) {
				return parentPattern;
			} else {
				parentPattern = (Pattern) parentPattern.eContainer();
			}
		}
		
		return null;
	}
	
	public static void completeContext(Pattern editOperation) {
		for (GraphPattern graphPattern : editOperation.getAllGraphPatterns()) {
			for (NodePattern node : graphPattern.getNodes()) {
				if (!node.getStereotypes().contains(not)) {
					if (!node.getStereotypes().contains(preserve) && isContext(node)) {
						node.getStereotypes().clear();
						node.getStereotypes().add(preserve);
					}
				}
			}
		}
	}
	
	public static void generateParameters(Pattern pattern) {
		
		for (GraphPattern editRule : pattern.getGraphs()) {
			for (NodePattern eoNode : editRule.getNodes()) {
				if (eoNode.getStereotypes().contains(delete) || HenshinProfileUtil.hasEdgeChanges(eoNode)) {
					generateParameter(pattern, eoNode.getName());
				}
				
				for (AttributePattern attribute : eoNode.getAttributes()) {
					if (!(attribute.getValue().startsWith("\"") && attribute.getValue().endsWith("\""))) {
						generateParameter(pattern, attribute.getValue());
					}
				}
			}
		}
	}
	
	public static void generateParameter(Pattern pattern, String name) {
		Parameter parameter = GraphpatternFactory.eINSTANCE.createParameter();
		parameter.setName(name);
		
		pattern.getParameters().add(parameter);
	}
}
