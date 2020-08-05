package org.sidiff.revision.difference.builder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.common.emf.document.Scope;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.DifferenceFactory;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.difference.RemoveReference;
import org.sidiff.revision.difference.matcher.util.MatcherUtil;

/**
 * Generic technical difference builder. Accepts any model type and filters nothing domain specific.
 */
public class GenericDifferenceBuilder implements IDifferenceBuilder {

	private static final DifferenceFactory DIFFERENCE_FACTORY = DifferenceFactory.eINSTANCE;
	
	private Difference difference;
	
	private Scope scope;

	@Override
	public Difference deriveTechDiff(Difference difference, Scope scope) {
		this.difference = difference;
		this.scope = scope;
		
		processMatched(); // TODO: Call first -> "We do not support meta-model matching yet."
		processUnmatchedA();
		processUnmatchedB();

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

	private void processMatched() {
		
		for (Iterator<Correspondence> iterator = difference.getCorrespondences().iterator(); iterator.hasNext();) {
			Correspondence correspondence = iterator.next();
			EObject elementA = correspondence.getMatchedA();
			EObject elementB = correspondence.getMatchedB();
			EClass nodeType = elementA.eClass();
			
			if (elementA.eClass() != elementB.eClass()) {
				iterator.remove(); // TODO: We do not support meta-model matching yet.
			} else if (isConsideredNode(nodeType)) {
				
				// Outgoing edges:
				for (EReference edgeType : nodeType.getEAllReferences()) {
					if (isConsideredEdgeType(edgeType)) {
						
						// Outgoing removed edges:
						deriveRemovedEdges(elementA, elementB, edgeType);
						
						// Outgoing added edges:
						deriveAddedEdge(elementA, elementB, edgeType);
					}
				}
				
				// Changed attributes:
				for (EAttribute attributeType : nodeType.getEAllAttributes()) {
					if (isConsideredAttribute(attributeType)) {
						deriveAttributeValueChange(elementA, elementB, attributeType);
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
	private void deriveRemovedEdges(EObject sourceA, EObject sourceB, EReference edgeType) {
		
		if (edgeType.isMany()) {
			Collection<?> targetsA = (Collection<Object>) sourceA.eGet(edgeType);
			Collection<?> targetsB = getEdgeIndex(sourceB, edgeType, targetsA.size());
			
			for (Object targetA : targetsA) {
				if (targetA instanceof EObject) {
					EObject targetB = difference.getCorrespondingObjectInB((EObject) targetA);
					
					if (targetB != null) {
						if (!targetsB.contains(targetB)) {
							createRemoveEdge(sourceA, (EObject) targetA, edgeType);
						}
					} else {
						if (isRemoveReferenceInScope((EObject) targetA, targetsB, true)) {
							createRemoveEdge(sourceA, (EObject) targetA, edgeType);
						}
					}
				}
			}
		} else {
			Object targetA = sourceA.eGet(edgeType);
	
			if (targetA instanceof EObject) {
				EObject targetB = difference.getCorrespondingObjectInB((EObject) targetA);
				
				if (targetB != null) {
					if (sourceB.eGet(edgeType) != targetB) {
						createRemoveEdge(sourceA, (EObject) targetA, edgeType);
					}
				} else {
					if (isRemoveReferenceInScope((EObject) targetA, (EObject) sourceB.eGet(edgeType), false)) {
						createRemoveEdge(sourceA, (EObject) targetA, edgeType);
					}
				}
			}
		}
	}

	protected boolean isRemoveReferenceInScope(EObject targetA, Object targetB, boolean isMany) {
		
		// NOTE: Allow reference to external resource (e.g. registry)
		Resource targetModelA = targetA.eResource();
		Resource modelA = difference.getModelA();
		
		if (targetModelA == null) {
			return false;
		}
		
		if (scope == Scope.RESOURCE) {
			if (targetModelA == modelA) {
				return true;
			} else {
				if (targetModelA.getResourceSet() == modelA.getResourceSet()) {
					return false; // filter references to other resources in the resource set
				} else {
					return matchExternalReference(targetA, targetB, isMany);
				}
			}
		} else {
			assert (scope == Scope.RESOURCE_SET);
			
			if (targetModelA.getResourceSet() != modelA.getResourceSet()) {
				return matchExternalReference(targetA, targetB, isMany);
			} else {
				return true;
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void deriveAddedEdge(EObject sourceA, EObject sourceB, EReference edgeType) {
		if (edgeType.isMany()) {
			Collection<?> targetsB = (Collection<Object>) sourceB.eGet(edgeType);
			Collection<?> targetsA = getEdgeIndex(sourceA, edgeType, targetsB.size());
			
			for (Object targetB : targetsB) {
				if (targetB instanceof EObject) {
					EObject targetA = difference.getCorrespondingObjectInA((EObject) targetB);
					
					if (targetA != null) {
						if (!targetsA.contains(targetA)) {
							createAddEdge(sourceB, (EObject) targetB, edgeType);
						}
					} else {
						if (isAddReferenceInScope((EObject) targetB,targetsA, true)) {
							createAddEdge(sourceB, (EObject) targetB, edgeType);
						}
					}
				}
			}
		} else {
			Object targetB = sourceB.eGet(edgeType);
			
			if (targetB instanceof EObject) {
				EObject targetA = difference.getCorrespondingObjectInA((EObject) targetB);
				
				if (targetA != null) {
					if (sourceA.eGet(edgeType) != targetA) {
						createAddEdge(sourceB, (EObject) targetB, edgeType);
					}
				} else {
					if (isAddReferenceInScope((EObject) targetB, sourceA.eGet(edgeType), false)) {
						createAddEdge(sourceB, (EObject) targetB, edgeType);
					}
				}
			}
		}
	}

	protected boolean isAddReferenceInScope(EObject targetB, Object targetA, boolean isMany) {
		
		// NOTE: Allow reference to external resource (e.g. registry)
		Resource targetModelB = targetB.eResource();
		Resource modelB = difference.getModelB();
		
		if (targetModelB == null) {
			return false;
		}
		
		if (scope == Scope.RESOURCE) {
			if (targetModelB == modelB) {
				return true;
			} else {
				if (targetModelB.getResourceSet() == modelB.getResourceSet()) {
					return false; // filter references to other resources in the resource set
				} else {
					return matchExternalReference(targetB, targetA, isMany);
				}
			}
		} else {
			assert (scope == Scope.RESOURCE_SET);
			
			if (targetModelB.getResourceSet() != modelB.getResourceSet()) {
				return matchExternalReference(targetB, targetA, isMany);
			} else {
				return true;
			}
		}
	}

	private boolean matchExternalReference(EObject object, Object referenced, boolean isMany) {
		if (isMany) {
			return !((Collection<?>) referenced).contains(object);
		} else {
			return referenced != object;
		}
	}

	private void deriveAttributeValueChange(EObject nodeA, EObject nodeB, EAttribute attributeType) {
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
			changeAttribute(nodeA, nodeB, attributeType);
		}
	}

	@SuppressWarnings("unchecked")
	private void processUnmatchedA() {
		List<Resource> resourceSetA = MatcherUtil.getResourceScope(difference.getModelA(), scope);
		
		for (Resource resourceA : resourceSetA) {
			for (EObject elementA : (Iterable<EObject>) () -> resourceA.getAllContents()) { 
				if (difference.isUnmatchedA(elementA)) {
					
					// Special in A:
					createRemoveNode(elementA);

					// Outgoing removed edges:
					EClass nodeType = elementA.eClass();

					for (EReference edgeType : nodeType.getEAllReferences()) {
						if (isConsideredEdgeType(edgeType)) {
							if (edgeType.isMany()) {
								for (Object targetA : (Iterable<Object>) elementA.eGet(edgeType)) {
									if (targetA instanceof EObject) {
										createRemoveEdge(elementA, (EObject) targetA, edgeType);
									}
								}
							} else {
								Object targetA = elementA.eGet(edgeType);
								
								if (targetA instanceof EObject) {
									createRemoveEdge(elementA, (EObject) targetA, edgeType);
								}
							}
						}
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void processUnmatchedB() {
		List<Resource> resourceSetB = MatcherUtil.getResourceScope(difference.getModelB(), scope);

		for (Resource resourceB : resourceSetB) {
			for (EObject elementB : (Iterable<EObject>) () -> resourceB.getAllContents()) { 
				if (difference.isUnmatchedB(elementB)) {

					// Special in B:
					createAddNode(elementB);

					// Outgoing added edges:
					EClass nodeType = elementB.eClass();

					for (EReference edgeType : nodeType.getEAllReferences()) {
						if (isConsideredEdgeType(edgeType)) {
							if (edgeType.isMany()) {
								for (Object targetB : (Iterable<Object>) elementB.eGet(edgeType)) {
									if (targetB instanceof EObject) {
										createAddEdge(elementB, (EObject) targetB, edgeType);
									}
								}
							} else {
								Object targetB = elementB.eGet(edgeType);

								if (targetB instanceof EObject) {
									createAddEdge(elementB, (EObject) targetB, edgeType);
								}
							}
						}
					}
				}
			}
		}
	}

	protected void createRemoveNode(EObject obj) {
		RemoveObject r = DIFFERENCE_FACTORY.createRemoveObject();
		r.setObj(obj);
		difference.getChanges().add(r);
	}

	protected void createAddNode(EObject obj) {
		AddObject a = DIFFERENCE_FACTORY.createAddObject();
		a.setObj(obj);
		difference.getChanges().add(a);
	}

	protected void createRemoveEdge(EObject src, EObject tgt, EReference type) {
		RemoveReference c = DIFFERENCE_FACTORY.createRemoveReference();
		c.setSrc(src);
		c.setTgt(tgt);
		c.setType(type);
		difference.getChanges().add(c);
	}

	protected void createAddEdge(EObject src, EObject tgt, EReference type) {
		AddReference c = DIFFERENCE_FACTORY.createAddReference();
		c.setSrc(src);
		c.setTgt(tgt);
		c.setType(type);
		difference.getChanges().add(c);
	}
	
	private void changeAttribute(EObject nodeA, EObject nodeB, EAttribute attributeType) {
		AttributeValueChange change = DIFFERENCE_FACTORY.createAttributeValueChange();
		change.setObjA(nodeA);
		change.setObjB(nodeB);
		change.setType(attributeType);
		difference.getChanges().add(change);
	}
}
