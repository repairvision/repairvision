package org.sidiff.graphpattern.tools.editrules.generator;

import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;

import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Parameter;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil;

public class GraphPatternGeneratorUtil {

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
