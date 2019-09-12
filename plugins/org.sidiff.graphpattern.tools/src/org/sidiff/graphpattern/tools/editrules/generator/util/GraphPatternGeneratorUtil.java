package org.sidiff.graphpattern.tools.editrules.generator.util;

import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.constraint;
import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.not;
import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.require;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.preserve;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Parameter;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.attributes.JavaSciptParser;

public class GraphPatternGeneratorUtil {

	public static boolean isContext(NodePattern node) {
		boolean isContained = node.getIncomings().stream().anyMatch(e -> e.getType().isContainment());
		boolean isRequired = node.getStereotypes().contains(require);
		
		return !isContained || isRequired;
	}
	
	public static boolean hasContent(NodePattern node) {
		return node.getOutgoings().stream().map(EdgePattern::getType).anyMatch(EReference::isContainment);
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
	
	/**
	 * Search container nodes and structural context and mark them as 'preserve'.
	 */
	public static void completeContext(Pattern editOperation) {
		for (GraphPattern graphPattern : editOperation.getAllGraphPatterns()) {
			for (NodePattern node : graphPattern.getNodes()) {
				if (!node.getStereotypes().contains(not) && !node.getStereotypes().contains(preserve)) {
					if (isContext(node)) {
						
						// Context element:
						node.getStereotypes().clear();
						node.getStereotypes().add(preserve);
						
						// Set attribute actions:
						for (AttributePattern attribute : node.getAttributes()) {
							if (!attribute.getStereotypes().contains(not)) {
								attribute.getStereotypes().clear();
								attribute.getStereotypes().add(preserve);
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * Search for unmodifiable structural features and mark them as 'preserve'.
	 */
	public static void completeConditions(Pattern editOperation) {
		for (GraphPattern graphPattern : editOperation.getAllGraphPatterns()) {
			for (NodePattern node : graphPattern.getNodes()) {
				
				// edges:
				for (EdgePattern edge : node.getOutgoings()) {
					if (!edge.getStereotypes().contains(not) && !edge.getStereotypes().contains(preserve)) {
						if (isUnmodifiable(edge)) {
							edge.getStereotypes().clear();
							edge.getStereotypes().add(preserve);
							
							if (edge.getSource().getStereotypes().contains(create)) {
								edge.getSource().getStereotypes().clear();
								edge.getSource().getStereotypes().add(preserve);
							}
							
							if (edge.getTarget().getStereotypes().contains(create)) {
								edge.getTarget().getStereotypes().clear();
								edge.getTarget().getStereotypes().add(preserve);
							}
						}
					}
				}
				
				// attributes:
				for (AttributePattern attribute : node.getAttributes()) {
					if (!attribute.getStereotypes().contains(not) && !attribute.getStereotypes().contains(preserve)) {
						if (isUnmodifiable(attribute)) {
							attribute.getStereotypes().clear();
							attribute.getStereotypes().add(preserve);
							
							if (attribute.getNode().getStereotypes().contains(create)) {
								attribute.getNode().getStereotypes().clear();
								attribute.getNode().getStereotypes().add(preserve);
							}
						}
					}
				}
			}
		}
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
		
		if (!pattern.getParameters().stream().anyMatch(p -> p.getName().equals(name))) {
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
