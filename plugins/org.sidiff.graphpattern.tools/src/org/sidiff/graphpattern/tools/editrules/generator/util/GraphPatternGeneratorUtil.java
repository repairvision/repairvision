package org.sidiff.graphpattern.tools.editrules.generator.util;

import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.*;
import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.exists;
import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.not;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.*;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.post;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.pre;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphElement;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Parameter;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.attributes.JavaSciptParser;

public class GraphPatternGeneratorUtil {

	public static boolean isContext(NodePattern node) {
		return !node.getIncomings().stream().anyMatch(e -> e.getType().isContainment());
	}
	
	public static boolean hasContent(NodePattern node) {
		return node.getOutgoings().stream().map(EdgePattern::getType).anyMatch(EReference::isContainment);
	}
	
	public static boolean isEditCondition(GraphElement graphElement) {
		return isForbid(graphElement)|| isRequire(graphElement);
	}
	
	public static boolean isRequire(GraphElement graphElement) {
		return graphElement.getStereotypes().contains(require);
	}

	public static boolean isForbid(GraphElement graphElement) {
		return graphElement.getStereotypes().contains(forbid);
	}
	
	public static boolean isPre(GraphElement graphElement) {
		return graphElement.getStereotypes().contains(pre);
	}
	
	public static boolean isPost(GraphElement graphElement) {
		return graphElement.getStereotypes().contains(post);
	}

	public static boolean isCondition(GraphElement graphElement) {
		return isNot(graphElement)|| isExists(graphElement) || isForAll(graphElement);
	}
	
	public static boolean isNot(GraphElement graphElement) {
		return graphElement.getStereotypes().contains(not);
	}
	
	public static boolean isExists(GraphElement graphElement) {
		return graphElement.getStereotypes().contains(exists);
	}
	
	public static boolean isForAll(GraphElement graphElement) {
		return graphElement.getStereotypes().contains(forall);
	}
	
	public static boolean isUnmodifiable(EdgePattern edge) {
		return !edge.getType().isContainer() && (!edge.getType().isChangeable() || edge.getType().isDerived() || edge.getType().isTransient());
	}
	
	public static boolean isUnmodifiable(AttributePattern attribute) {
		return !attribute.getType().isChangeable() || attribute.getType().isDerived() || attribute.getType().isTransient();
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
	
	public static void generateINParameters(Pattern pattern) {
		
		for (GraphPattern editRule : pattern.getGraphs()) {
			for (NodePattern eoNode : editRule.getNodes()) {
				
				// Filter OUT parameters:
				if (!eoNode.getStereotypes().contains(create)) {
					generateParameter(pattern, eoNode.getName());
				}
				
				for (AttributePattern attribute : eoNode.getAttributes()) {
					for (String variable : JavaSciptParser.getVariables(attribute.getValue())) {
						generateParameter(pattern, variable);
					}
				}
			}
		}
	}
	
	public static boolean generateParameter(Pattern pattern, String name) {
		Parameter parameter = GraphpatternFactory.eINSTANCE.createParameter();
		parameter.setName(name);
		
		if (!pattern.getParameters().stream().anyMatch(p -> (p.getName() != null) && p.getName().equals(name))) {
			pattern.getParameters().add(parameter);
			return true;
		}
		
		return false;
	}
	
	public static void saveBundle(URI patternURI, Bundle bundle) {
		Resource patternResource = new ResourceSetImpl().createResource(patternURI);
		patternResource.getContents().add(bundle);
		
		try {
			patternResource.save(Collections.emptyMap());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
