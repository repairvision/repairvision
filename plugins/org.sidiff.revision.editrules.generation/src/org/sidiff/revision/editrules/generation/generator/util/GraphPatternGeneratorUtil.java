package org.sidiff.revision.editrules.generation.generator.util;

import static org.sidiff.graphpattern.profile.constraints.ConstraintStereotypes.constraint;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.graphpattern.AttributePattern;
import org.sidiff.graphpattern.Bundle;
import org.sidiff.graphpattern.EdgePattern;
import org.sidiff.graphpattern.GraphPattern;
import org.sidiff.graphpattern.GraphpatternFactory;
import org.sidiff.graphpattern.GraphpatternPackage;
import org.sidiff.graphpattern.NodePattern;
import org.sidiff.graphpattern.Parameter;
import org.sidiff.graphpattern.Pattern;
import org.sidiff.graphpattern.profile.constraints.util.ConstraintProfileUtil;
import org.sidiff.graphpattern.profile.henshin.util.HenshinProfileUtil;

public class GraphPatternGeneratorUtil {

	public static EClass pseudoResourceClass = GraphpatternPackage.eINSTANCE.getResource();

	public static void removePseudoResourceNode(GraphPattern editRule) {

		// Remove (pseudo) resource node:
		for (Iterator<NodePattern> iterator = editRule.getNodes().iterator(); iterator.hasNext();) {
			NodePattern node = iterator.next();

			if (node.getType().equals(pseudoResourceClass)) {
				Parameter parameter = editRule.getPattern().getParameter(node.getName());

				if (parameter != null) {
					EcoreUtil.remove(parameter);
				}

				node.removeIncident();
				iterator.remove();
			}
		}
	}

	public static boolean isContext(NodePattern node) {
		if (ConstraintProfileUtil.isPositiveCondition(node)) {
			return node.getIncomings().stream().anyMatch(e -> e.getStereotypes().isEmpty())
					|| node.getOutgoings().stream().anyMatch(e -> e.getStereotypes().isEmpty());
		} else {
			// TODO: Enforce this by a constraint!?
			return !node.getIncomings().stream().anyMatch(e -> e.getType().isContainment())
					|| node.getIncomings().stream().anyMatch(e -> ConstraintProfileUtil.isPositiveCondition(e))
					|| node.getOutgoings().stream().anyMatch(e -> ConstraintProfileUtil.isPositiveCondition(e));
		}
	}

	public static boolean hasContent(NodePattern node) {
		return node.getOutgoings().stream().map(EdgePattern::getType).anyMatch(EReference::isContainment);
	}

	public static boolean isUnmodifiable(EdgePattern edge) {
		return !edge.getType().isContainer()
				&& (!edge.getType().isChangeable() || edge.getType().isDerived() || edge.getType().isTransient());
	}

	public static boolean isUnmodifiable(AttributePattern attribute) {
		return !attribute.getType().isChangeable() || attribute.getType().isDerived()
				|| attribute.getType().isTransient();
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

	public static void generateInputParameters(Pattern pattern) {

		for (GraphPattern editRule : pattern.getGraphs()) {
			for (NodePattern eoNode : editRule.getNodes()) {

				// Filter OUT parameters:
				if (isInputNode(eoNode)) {
					generateParameter(pattern, eoNode.getName());
				}

				for (AttributePattern attribute : eoNode.getAttributes()) {
					for (String variable : attribute.getVariables()) {
						generateParameter(pattern, variable);
					}
				}
			}
		}
	}
	
	public static boolean isInputNode(NodePattern node) {
		return (HenshinProfileUtil.isPreserve(node) && HenshinProfileUtil.hasChanges(node))
			|| HenshinProfileUtil.isDelete(node);
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
