package org.sidiff.revision.difference.builder;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.sidiff.common.utilities.emf.Scope;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.DifferenceFactory;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.difference.RemoveReference;

/**
 * Generic technical difference builder. Accepts any model type and filters nothing domain specific.
 */
public class GenericDifferenceBuilder implements IDifferenceBuilder {

	private static final DifferenceFactory DIFFERENCE_FACTORY = DifferenceFactory.eINSTANCE;

	@Override
	public Difference deriveTechDiff(Difference difference, Scope scope) {
		
		// TODO: Should be indexed by difference!
		Set<EObject> unmatchedA = new HashSet<>(difference.getUnmatchedA());
		Set<EObject> unmatchedB = new HashSet<>(difference.getUnmatchedB());
		
		processUnmatchedA(difference, unmatchedA);
		processUnmatchedB(difference, unmatchedB);
		processMatched(difference, unmatchedA, unmatchedB);

		return difference;
	}
	
	protected boolean isConsideredNode(EObject node) {
		return true;
	}
	
	protected boolean isConsideredAttribute(EAttribute attribute) {
		return !attribute.isDerived();
	}
	
	protected boolean isConsideredEdgeType(EReference reference) {
		return !reference.isDerived();
	}

	private void processMatched(Difference diff, Set<EObject> unmatchedA, Set<EObject> unmatchedB) {
		
		for (Correspondence c : diff.getCorrespondences()) {
			EObject elementA = c.getMatchedA();
			EObject elementB = c.getMatchedB();
			EClass nodeType = elementA.eClass();

			if (isConsideredNode(nodeType)) {
				
				// Outgoing edges:
				for (EReference edgeType : nodeType.getEAllReferences()) {
					if (isConsideredEdgeType(edgeType)) {
						
						// Outgoing removed edges:
						deriveRemovedEdges(diff, unmatchedA, elementA, elementB, edgeType);
						
						// Outgoing added edges:
						deriveAddedEdge(diff, unmatchedB, elementA, elementB, edgeType);
					}
				}
				
				// Changed attributes:
				for (EAttribute attributeType : nodeType.getEAllAttributes()) {
					if (isConsideredAttribute(attributeType)) {
						deriveAttributeValueChange(diff.getChanges(), elementA, elementB, attributeType);
					}
				}
			}
		}
	}
	
	protected Collection<?> getEdgeIndex(EObject element, EReference edgeType, int compareSize) {
		Collection<?> targetsB = (Collection<?>) element.eGet(edgeType);
		
		if (compareSize > 2 && targetsB.size() > 2) {
			return new HashSet<>(targetsB); // index larger set comparisons
		} else {
			return targetsB;
		}
	}

	@SuppressWarnings("unchecked")
	private void deriveRemovedEdges(Difference diff, Set<EObject> unmatchedA, EObject elementA, EObject elementB, EReference edgeType) {
		
		if (edgeType.isMany()) {
			Collection<?> targetsA = (Collection<Object>) elementA.eGet(edgeType);
			Collection<?> targetsB = getEdgeIndex(elementB, edgeType, targetsA.size());
			
			for (Object targetA : targetsA) {
				if (targetA instanceof EObject) {
					if (unmatchedA.contains(targetA)) {
						createRemoveEdge(diff.getChanges(), elementA, (EObject) targetA, edgeType);
					} else {
						EObject targetB = diff.getCorrespondingObjectInB((EObject) targetA);
						
						if (targetB != null) {
							if (!targetsB.contains(targetB)) {
								createRemoveEdge(diff.getChanges(), elementA, (EObject) targetA, edgeType);
							}
						} else {
							// Reference to common resource (e.g. registry)?
							if (!targetsB.contains(targetA)) {
								createRemoveEdge(diff.getChanges(), elementA, (EObject) targetA, edgeType);
							}
						}
					}
				}
			}
		} else {
			Object targetA = elementA.eGet(edgeType);
	
			if (targetA instanceof EObject) {
				if (unmatchedA.contains(targetA)) {
					createRemoveEdge(diff.getChanges(), elementA, (EObject) targetA, edgeType);
				} else {
					EObject targetB = diff.getCorrespondingObjectInB((EObject) targetA);
					
					if (targetB != null) {
						if (elementB.eGet(edgeType) != targetB) {
							createRemoveEdge(diff.getChanges(), elementA, (EObject) targetA, edgeType);
						}
					} else {
						// Reference to common resource (e.g. registry)?
						if (elementB.eGet(edgeType) != targetA) {
							createRemoveEdge(diff.getChanges(), elementA, (EObject) targetA, edgeType);
						}
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void deriveAddedEdge(Difference diff, Set<EObject> unmatchedB, EObject elementA, EObject elementB, EReference edgeType) {
		if (edgeType.isMany()) {
			Collection<?> targetsB = (Collection<Object>) elementB.eGet(edgeType);
			Collection<?> targetsA = getEdgeIndex(elementA, edgeType, targetsB.size());
			
			for (Object targetB : targetsB) {
				if (targetB instanceof EObject) {
					if (unmatchedB.contains(targetB)) {
						createAddEdge(diff.getChanges(), elementB, (EObject) targetB, edgeType);
					} else {
						EObject targetA = diff.getCorrespondingObjectInA((EObject) targetB);
						
						if (targetA != null) {
							if (!targetsA.contains(targetA)) {
								createAddEdge(diff.getChanges(), elementB, (EObject) targetB, edgeType);
							}
						} else {
							// Reference to common resource (e.g. registry)?
							if (!targetsA.contains(targetB)) {
								createAddEdge(diff.getChanges(), elementB, (EObject) targetB, edgeType);
							}
						}
					}
				}
			}
		} else {
			Object targetB = elementB.eGet(edgeType);
			
			if (targetB instanceof EObject) {
				if (unmatchedB.contains(targetB)) {
					createAddEdge(diff.getChanges(), elementB, (EObject) targetB, edgeType);
				} else {
					EObject targetA = diff.getCorrespondingObjectInA((EObject) targetB);
					
					if (targetA != null) {
						if (elementA.eGet(edgeType) != targetA) {
							createAddEdge(diff.getChanges(), elementB, (EObject) targetB, edgeType);
						}
					} else {
						// Reference to common resource (e.g. registry)?
						if (elementA.eGet(edgeType) != targetB) {
							createAddEdge(diff.getChanges(), elementB, (EObject) targetB, edgeType);
						}
					}
				}
			}
		}
	}

	private void deriveAttributeValueChange(List<Change> changes, EObject nodeA, EObject nodeB, EAttribute attributeType) {
		Object valueA = nodeA.eGet(attributeType);
		Object valueB = nodeB.eGet(attributeType);
		
		if ((attributeType.isChangeable() == false) ||
			(attributeType.isDerived() == true) ||
			(attributeType.isTransient() == true) ||
			(valueA != null && valueB != null && valueA.equals(valueB)) ||
			(valueA == null && valueB == null)) {
			
			// No value change!
			return;
		} else {
			changeAttribute(changes, nodeA, nodeB, attributeType);
		}
	}

	@SuppressWarnings("unchecked")
	private void processUnmatchedA(Difference diff, Set<EObject> unmatchedA) {
		for (EObject elementA : diff.getUnmatchedA()) {

			// Special in A:
			createRemoveNode(diff.getChanges(), elementA);

			// Outgoing removed edges:
			EClass nodeType = elementA.eClass();

			for (EReference edgeType : nodeType.getEAllReferences()) {
				if (isConsideredEdgeType(edgeType)) {
					if (edgeType.isMany()) {
						for (Object targetA : (Iterable<Object>) elementA.eGet(edgeType)) {
							if (targetA instanceof EObject) {
								createRemoveEdge(diff.getChanges(), elementA, (EObject) targetA, edgeType);
							}
						}
					} else {
						Object targetA = elementA.eGet(edgeType);
						
						if (targetA instanceof EObject) {
							createRemoveEdge(diff.getChanges(), elementA, (EObject) targetA, edgeType);
						}
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void processUnmatchedB(Difference diff, Set<EObject> unmatchedB) {
		for (EObject elementB : diff.getUnmatchedB()) {

			// Special in B:
			createAddNode(diff.getChanges(), elementB);

			// Outgoing added edges:
			EClass nodeType = elementB.eClass();

			for (EReference edgeType : nodeType.getEAllReferences()) {
				if (isConsideredEdgeType(edgeType)) {
					if (edgeType.isMany()) {
						for (Object targetB : (Iterable<Object>) elementB.eGet(edgeType)) {
							if (targetB instanceof EObject) {
								createAddEdge(diff.getChanges(), elementB, (EObject) targetB, edgeType);
							}
						}
					} else {
						Object targetB = elementB.eGet(edgeType);
						
						if (targetB instanceof EObject) {
							createAddEdge(diff.getChanges(), elementB, (EObject) targetB, edgeType);
						}
					}
				}
			}
		}
	}

	protected void createRemoveNode(List<Change> changes, EObject obj) {
		RemoveObject r = DIFFERENCE_FACTORY.createRemoveObject();
		r.setObj(obj);
		changes.add(r);
	}

	protected void createAddNode(List<Change> changes, EObject obj) {
		AddObject a = DIFFERENCE_FACTORY.createAddObject();
		a.setObj(obj);
		changes.add(a);
	}

	protected void createRemoveEdge(List<Change> changes, EObject src, EObject tgt, EReference type) {
		RemoveReference c = DIFFERENCE_FACTORY.createRemoveReference();
		c.setSrc(src);
		c.setTgt(tgt);
		c.setType(type);
		changes.add(c);
	}
	
	public static boolean isDynamic(EObject element) {
		EReference containment = element.eContainmentFeature();
		
		if ((containment != null) 
				&& (containment.isTransient() 
						|| containment.isVolatile() 
						|| containment.isDerived()
						// FIXME: How to handle the eGenericSuperTypes reference? Is dynamic until a type argument will be added!
						|| containment.equals(EcorePackage.eINSTANCE.getEClass_EGenericSuperTypes()))) {
			return true;
		}
		
		return false;
	}

	protected void createAddEdge(List<Change> changes, EObject src, EObject tgt, EReference type) {
		AddReference c = DIFFERENCE_FACTORY.createAddReference();
		c.setSrc(src);
		c.setTgt(tgt);
		c.setType(type);
		changes.add(c);
	}
	
	private void changeAttribute(List<Change> changes, EObject nodeA, EObject nodeB, EAttribute attributeType) {
		AttributeValueChange change = DIFFERENCE_FACTORY.createAttributeValueChange();
		change.setObjA(nodeA);
		change.setObjB(nodeB);
		change.setType(attributeType);
		changes.add(change);
	}
}
