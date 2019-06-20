package org.sidiff.graphpattern.tools.editrules.generator.util;

import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.constraint;
import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.not;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.create;
import static org.sidiff.graphpattern.profile.henshin.HenshinStereotypes.delete;
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
import org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil;

public class GraphPatternGeneratorUtil {

	public static boolean isContext(NodePattern node) {
		return !node.getIncomings().stream().anyMatch(e -> e.getType().isContainment());
	}
	
	public static boolean hasContent(NodePattern node) {
		return node.getOutgoings().stream().map(EdgePattern::getType).anyMatch(EReference::isContainment);
	}
	
	public static boolean isCondition(EdgePattern edge) {
		EReference type = edge.getType();
		
		boolean isContainmentMove = type.isContainment() && edge.getTarget().getIncomings().stream().anyMatch(e -> (e != edge) && (e.getType() == type));
		boolean isContainerMove = type.isContainer() && edge.getSource().getOutgoings().stream().anyMatch(e -> (e != edge) && (e.getType() == type));
		
		boolean edgeBetweenContextNodes = edge.getSource().getStereotypes().contains(preserve) && edge.getTarget().getStereotypes().contains(preserve);
		
		boolean unmodifiable = !type.isContainer() && (!type.isChangeable() || type.isDerived() || type.isTransient());
		
		return unmodifiable || (edgeBetweenContextNodes && (!isContainmentMove || !isContainerMove));
	}
	
	public static boolean isCondition(AttributePattern attribute) {
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
	
	public static void completeContext(Pattern editOperation) {
		for (GraphPattern graphPattern : editOperation.getAllGraphPatterns()) {
			for (NodePattern node : graphPattern.getNodes()) {
				if (!node.getStereotypes().contains(not)) {
					if (!node.getStereotypes().contains(preserve) && isContext(node)) {
						
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
	
	public static void completeConditions(Pattern editOperation) {
		for (GraphPattern graphPattern : editOperation.getAllGraphPatterns()) {
			for (NodePattern node : graphPattern.getNodes()) {
				
				// edges:
				for (EdgePattern edge : node.getOutgoings()) {
					if (!edge.getStereotypes().contains(not)) {
						if (!edge.getStereotypes().contains(preserve) && isCondition(edge)) {
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
					if (!attribute.getStereotypes().contains(not)) {
						if (!attribute.getStereotypes().contains(preserve) && isCondition(attribute)) {
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
	
	public static void generateParameters(Pattern pattern) {
		
		for (GraphPattern editRule : pattern.getGraphs()) {
			for (NodePattern eoNode : editRule.getNodes()) {
				if (eoNode.getStereotypes().contains(delete) || HenshinProfileUtil.hasEdgeChanges(eoNode)) {
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
