package org.sidiff.revision.editrules.generation.difference;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.revision.common.utilities.java.StringUtil;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.difference.RemoveReference;
import org.sidiff.revision.editrules.generation.difference.builder.IEditRuleBuilder;
import org.sidiff.revision.editrules.generation.difference.configuration.TransformationConfiguration;
import org.sidiff.revision.editrules.generation.difference.util.Pair;

public class DifferenceToEditRule<Rule, Node, Edge, Attibute> {
	
	private IEditRuleBuilder<Rule, Node, Edge, Attibute> builder;
	
	private TransformationConfiguration config;
	
	private Map<EObject, Node> traceA2LHS;
	
	private Map<EObject, Node> traceB2RHS;
	
	private Set<String> names;
	
	public DifferenceToEditRule(
			IEditRuleBuilder<Rule, Node, Edge, Attibute> builder, 
			TransformationConfiguration transformationConfiguration) {
		
		this.config = transformationConfiguration;
		this.builder = builder;
	}
	
	public Map<EObject, Node> getTraceModelAtoLHS() {
		return traceA2LHS;
	}
	
	public Map<EObject, Node> getTraceModelBtoRHS() {
		return traceB2RHS;
	}
	
	public IEditRuleBuilder<Rule, Node, Edge, Attibute> getBuilder() {
		return builder;
	}
	
	public Rule transform() {
		
		// Create rule container:
		Rule editRule = builder.createEditRule(config.getEditRuleName()); 
		
		// Transform difference to edit-rule:
		traceA2LHS = new HashMap<>();
		traceB2RHS = new HashMap<>();
		
		names = new HashSet<>();
		names.add(config.getUnknownNamesPrefix());
		
		convertCorrespondenceObjects();
		convertCorrespondenceAttributes();
		convertAttributeValueChanges();
		convertRemoveObjects();
		convertRemoveAttributes();
		convertAddObjects();
		convertAddAttributes();
		convertRemoveReferences();
		convertAddReferences();
		convertCorrespondenceReferences();
		
		return editRule;
	}

	private void convertCorrespondenceObjects() {
		for (Correspondence correspondence : config.getDifference().getCorrespondences()) {
			if (!config.getFilters().getCorrespondenceObjectFilter().filter(correspondence)) {
				convertToPreserveNode(correspondence);
			}
		}
	}

	protected void convertToPreserveNode(Correspondence correspondence) {
		Pair<Node> preserveNode = builder.createPreservedNode(
				getName(correspondence.getMatchedB(), names), correspondence.getMatchedA().eClass());
		traceA2LHS.put(correspondence.getMatchedA(), preserveNode.getLhs());
		traceB2RHS.put(correspondence.getMatchedB(), preserveNode.getRhs());
	}
	
	private void convertCorrespondenceAttributes() {
		for (Correspondence correspondence : config.getDifference().getCorrespondences()) {
			for (EAttribute eAttribute : correspondence.getMatchedB().eClass().getEAllAttributes()) {
				if (!config.getFilters().getCorrespondenceAttributeFilter().filter(correspondence, eAttribute)) {
					convertToPreserveAttribute(correspondence, eAttribute);
				}
			}
		}
	}

	protected void convertToPreserveAttribute(Correspondence correspondence, EAttribute type) {
		Node lhsNode = traceA2LHS.get(correspondence.getMatchedA());
		Node rhsNode = traceB2RHS.get(correspondence.getMatchedB());

		Object valueA = correspondence.getMatchedA().eGet(type);
		Object valueB = correspondence.getMatchedB().eGet(type);

		if ((lhsNode != null) && (rhsNode != null)) {
			if ((valueA != null && valueA.equals(valueB)) || ((valueA == null) && (valueB == null))) {
				Pair<Node> preserveNode = new Pair<Node>(lhsNode, rhsNode);
				builder.createPreserveAttribute(preserveNode, type, valueB);
			}
		} else {
			if (Activator.getLog().isLoggable(Level.WARNING)) {
				Activator.getLog().log(Level.WARNING, "Missing Context Node: " + correspondence + " Type: " + type);
			}
		}
	}
	
	private void convertAttributeValueChanges() {
		for (AttributeValueChange avc : config.getDifference().getChangesAttributeValueChange()) {
			if (!config.getFilters().getAttributeValueChangeFilter().filter(avc)) {
				convertToModifyAttribute(avc);
			}
		}
	}

	protected void convertToModifyAttribute(AttributeValueChange avc) {
		Node lhsNode = traceA2LHS.get(avc.getObjA());
		Node rhsNode = traceB2RHS.get(avc.getObjB());

		Object valueA = avc.getObjA().eGet(avc.getType());
		Object valueB = avc.getObjB().eGet(avc.getType());

		if ((lhsNode != null) && (rhsNode != null)) {
			Pair<Node> preserveNode = new Pair<Node>(lhsNode, rhsNode);
			builder.createAttributeValueChange(preserveNode, avc.getType(), valueA, valueB);
		} else {
			if (Activator.getLog().isLoggable(Level.WARNING)) {
				Activator.getLog().log(Level.WARNING, "Missing Context Node: " + avc);
			}
		}
	}
	
	private void convertRemoveObjects() {
		for (RemoveObject removeObject : config.getDifference().getChangesRemoveObject()) {
			if (!config.getFilters().getRemoveObjectFilter().filter(removeObject)) {
				convertToDeleteNode(removeObject);
			}
		}
	}
	
	protected void convertToDeleteNode(RemoveObject removeObject) {
		Node removeNode = builder.createDeleteNode(
				getName(removeObject.getObj(), names), 
				removeObject.getObj().eClass());
		traceA2LHS.put(removeObject.getObj(), removeNode);
	}
	
	private void convertRemoveAttributes() {
		for (RemoveObject removeObject : config.getDifference().getChangesRemoveObject()) {
			Node removeNode = traceA2LHS.get(removeObject.getObj());
			
			if (removeNode != null) {
				for (EAttribute eAttribute : removeObject.getObj().eClass().getEAllAttributes()) {
					Object attValue = removeObject.getObj().eGet(eAttribute);
					
					if (!config.getFilters().getRemoveAttributeFilter().filter(removeObject.getObj(), eAttribute)) {
						convertToDeleteAttribute(removeNode, eAttribute, attValue);
					}
				}
			}
		}
	}

	protected void convertToDeleteAttribute(Node createNode, EAttribute eAttribute, Object attValue) {
		builder.createDeleteAttribute(createNode, eAttribute, attValue);
	}
	
	private void convertAddObjects() {
		for (AddObject addObject : config.getDifference().getChangesAddObject()) {
			if (!config.getFilters().getAddObjectFilter().filter(addObject)) {
				convertToCreateNode(addObject);
			}
		}
	}
	
	protected void convertToCreateNode(AddObject addObject) {
		String name = getName(addObject.getObj(), names);
		Node addNode = builder.createCreateNode(
				name, addObject.getObj().eClass());
		traceB2RHS.put(addObject.getObj(), addNode);
	}
	
	private void convertAddAttributes() {
		for (AddObject addObject : config.getDifference().getChangesAddObject()) {
			Node createNode = traceB2RHS.get(addObject.getObj());
			
			if (createNode != null) {
				for (EAttribute eAttribute : addObject.getObj().eClass().getEAllAttributes()) {
					Object attValue = addObject.getObj().eGet(eAttribute);
					
					if (!config.getFilters().getAddAttributeFilter().filter(addObject.getObj(), eAttribute)) {
						convertToCreateAttribute(createNode, eAttribute, attValue);
					}
				}
			}
		}
	}

	protected void convertToCreateAttribute(Node createNode, EAttribute eAttribute, Object attValue) {
		builder.createCreateAttribute(createNode, eAttribute, attValue);
	}
	
	private void convertRemoveReferences() {
		for (RemoveReference removeReference : config.getDifference().getChangesRemoveReference()) {
			if (!config.getFilters().getRemoveReferenceFilter().filter(removeReference)) {
				convertToDeleteEdge(removeReference);
			}
		}
	}
	
	protected void convertToDeleteEdge(RemoveReference rmvRef) {
		Node srcNode = traceA2LHS.get(rmvRef.getSrc());
		Node tgtNode = traceA2LHS.get(rmvRef.getTgt());

		if (srcNode == null) {
			if (!config.getFilters().getObjectFilter().filter(rmvRef.getSrc())) {
				Pair<Node> srcPreserveNode = builder.createPreservedNode(getName(rmvRef.getSrc()), rmvRef.getSrc().eClass());
				traceA2LHS.put(rmvRef.getSrc(), srcPreserveNode.getLhs());
				traceB2RHS.put(rmvRef.getSrc(), srcPreserveNode.getRhs()); // if the element is in a common resource (e.g. EMF registry)
				srcNode = srcPreserveNode.getLhs();
			}
		}

		if (tgtNode == null) {
			if (!config.getFilters().getObjectFilter().filter(rmvRef.getTgt())) {
				Pair<Node> tgtPreserveNode = builder.createPreservedNode(getName(rmvRef.getTgt()), rmvRef.getTgt().eClass());
				traceA2LHS.put(rmvRef.getTgt(), tgtPreserveNode.getLhs());
				traceB2RHS.put(rmvRef.getTgt(), tgtPreserveNode.getRhs()); // if the element is in a common resource (e.g. EMF registry)
				tgtNode = tgtPreserveNode.getLhs();
			}
		}

		if ((srcNode != null) && (tgtNode != null)) {
			builder.createDeleteEdge(srcNode, tgtNode, rmvRef.getType());
		} else {
			if (Activator.getLog().isLoggable(Level.WARNING)) {
				Activator.getLog().log(Level.WARNING, "Missing Context Node: " + rmvRef);
			}
		}
	}
	
	private void convertAddReferences() {
		for (AddReference addReference : config.getDifference().getChangesAddReference()) {
			if (!config.getFilters().getAddReferenceFilter().filter(addReference)) {
				convertToCreateEdge(addReference);
			}
		}
	}
	
	protected void convertToCreateEdge(AddReference addRef) {
		Node srcNode = traceB2RHS.get(addRef.getSrc());
		Node tgtNode = traceB2RHS.get(addRef.getTgt());

		if (srcNode == null) {
			if (!config.getFilters().getObjectFilter().filter(addRef.getSrc())) {
				Pair<Node> srcPreserveNode = builder.createPreservedNode(getName(addRef.getSrc()), addRef.getSrc().eClass());
				traceA2LHS.put(addRef.getSrc(), srcPreserveNode.getLhs()); // if the element is in a common resource (e.g. EMF registry)
				traceB2RHS.put(addRef.getSrc(), srcPreserveNode.getRhs());
				srcNode = srcPreserveNode.getRhs();
			}
		}

		if (tgtNode == null) {
			if (!config.getFilters().getObjectFilter().filter(addRef.getTgt())) {
				Pair<Node> tgtPreserveNode = builder.createPreservedNode(getName(addRef.getTgt()), addRef.getTgt().eClass());
				traceA2LHS.put(addRef.getTgt(), tgtPreserveNode.getLhs()); // if the element is in a common resource (e.g. EMF registry)
				traceB2RHS.put(addRef.getTgt(), tgtPreserveNode.getRhs());
				tgtNode = tgtPreserveNode.getRhs();
			}
		}

		if ((srcNode != null) && (tgtNode != null)) {
			builder.createCreateEdge(srcNode, tgtNode, addRef.getType());
		} else {
			if (Activator.getLog().isLoggable(Level.WARNING)) {
				Activator.getLog().log(Level.WARNING, "Missing Context Node: " + addRef);
			}
		}
	}
	
	private void convertCorrespondenceReferences() {

		// Preserve edges:
		for (Correspondence source : config.getDifference().getCorrespondences()) {
			EObject objASource = source.getMatchedA();
			EObject objBSource = source.getMatchedB();

			for (EReference refType : objBSource.eClass().getEAllReferences()) {
				for (EObject objATarget : getTargets(objASource, refType)) {
					Correspondence target = config.getDifference().getCorrespondenceOfModelA(objATarget);

					if (target != null) {
						if (!config.getFilters().getCorrespondenceReferenceFilter().filter(source, refType, target)) {
							EObject objBTarget = target.getMatchedB();
							convertToPreserveEdge(objASource, objBSource, refType, objATarget, objBTarget);
						}
					}
				}
			}
		}
	}

	protected void convertToPreserveEdge(
			EObject objASource, EObject objBSource, EReference refType,
			EObject objATarget, EObject objBTarget) {
		
		Node srcNodeLHS = traceA2LHS.get(objASource);
		Node srcNodeRHS = traceB2RHS.get(objBSource);
		Pair<Node> srcNode = new Pair<Node>(srcNodeLHS, srcNodeRHS);

		Node tgtNodeLHS = traceA2LHS.get(objATarget);
		Node tgtNodeRHS = traceB2RHS.get(objBTarget);
		Pair<Node> tgtNode = new Pair<Node>(tgtNodeLHS, tgtNodeRHS);

		if ((srcNodeLHS != null) && (srcNodeRHS != null)) {
			if ((tgtNodeLHS != null) && (tgtNodeRHS != null)) {
				builder.createPreservedEdge(srcNode, refType, tgtNode);
			} else {
				if (Activator.getLog().isLoggable(Level.WARNING)) {
					Activator.getLog().log(Level.WARNING, "Missing Context Node: " + objATarget + ", " + objBTarget);
				}
			}
		} else {
			if (Activator.getLog().isLoggable(Level.WARNING)) {
				Activator.getLog().log(Level.WARNING, "Missing Context Node: " + objASource + ", " + objBSource);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private static Collection<EObject> getTargets(EObject obj, EReference feature) {
		Collection<EObject> targets = Collections.emptyList();
		Object value = obj.eGet(feature);

		if (value != null) {
			if (feature.isMany()) {
				targets = (Collection<EObject>) value;
			} else {
				targets = (Collection<EObject>) (Object) Collections.singletonList(obj.eGet(feature));
			}
		}
		
		return targets;
	}
	
	protected String getName(EObject obj, Set<String> names) {
		String name = getName(obj);
		
		// If this isn't unique:
		if (names.contains(name)) {
			int occurence = 1;

			while (names.contains(name + occurence)) {
				++occurence;
			}

			name = name + occurence;
		}

		names.add(name);
		return name;
	}
	
	protected String getName(EObject obj) {
		EClass eClass = (obj != null) ? obj.eClass() : null;
		EStructuralFeature nameFeature = (eClass != null) ? eClass.getEStructuralFeature("name") : null;
		
		if (nameFeature != null) {
			Object nameFeatureValue = obj.eGet(nameFeature);
			
			if (nameFeatureValue instanceof String) {
				return StringUtil.toLowerFirst((String) nameFeatureValue);
			}
		}
		
		return StringUtil.toLowerFirst(config.getUnknownNamesPrefix());
	}

}
