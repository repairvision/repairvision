package org.sidiff.history.revision.difference.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.common.emf.access.EMFMetaAccess;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.SymmetricFactory;
import org.sidiff.history.revision.IVersion;
import org.sidiff.history.revision.util.SymmetricDifferenceUtil;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.Matching;
import org.sidiff.matching.model.MatchingModelFactory;

public class TechnicalDifferenceBuilder {

	private static final SymmetricFactory DIFFERENCE_FACTORY = SymmetricFactory.eINSTANCE;
	
	private static final MatchingModelFactory MATCHING_FACTORY = MatchingModelFactory.eINSTANCE;

	public TechnicalDifferenceBuilder() {
	}

	public SymmetricDifference deriveTechDiff(
			Iterator<EObject> modelA,
			Iterator<EObject> modelB, 
			Iterator<Correspondence> matching) {
		
		SymmetricDifference diff = initDifference(modelA, modelB, matching);
		
		// TODO: Should be indexed by difference!
		Set<EObject> unmatchedA = new HashSet<>(diff.getMatching().getUnmatchedA());
		Set<EObject> unmatchedB = new HashSet<>(diff.getMatching().getUnmatchedB());
		
		processUnmatchedA(diff, unmatchedA);
		processUnmatchedB(diff, unmatchedB);
		processMatched(diff, unmatchedA, unmatchedB);

		return diff;
	}
	
	public Iterator<EObject> getModel(IVersion version, Scope scope) {
		if (scope.equals(Scope.RESOURCE)) {
			return getResourceScope(version);
		} else {
			return getResourceSetScope(version);
		}
	}
	
	protected Iterator<EObject> getResourceSetScope(IVersion version) {
		return version.getResources().stream()
				.filter(r -> (r.getResourceSet() == version.getTargetResource().getResourceSet())) // filter registry resources...
				.flatMap(r -> StreamSupport.stream(((Iterable<EObject>) () -> r.getAllContents()).spliterator(), false))
				.iterator();
	}
	
	protected Iterator<EObject> getResourceScope(IVersion version) {
		return version.getTargetResource().getAllContents();
	}
	
	protected URI getDifferenceURI(URI modelA, URI modelB) {
		return SymmetricDifferenceUtil.getDifferenceURI(modelA, modelB);
	}
	
	private SymmetricDifference initDifference(
			Iterator<EObject> modelA, 
			Iterator<EObject> modelB, 
			Iterator<Correspondence> matching) {
		
		SymmetricDifference diff = DIFFERENCE_FACTORY.createSymmetricDifference();
		Matching match = MATCHING_FACTORY.createMatching();
		diff.setMatching(match);
		
		for (Correspondence correspondence : (Iterable<Correspondence>) () -> matching) {
			diff.addCorrespondence(correspondence);
		}
		
		for (EObject elementA : (Iterable<EObject>) () -> modelA) {
			if (diff.getCorrespondenceOfModelA(elementA) == null) {
				match.getUnmatchedA().add(elementA);
			}
		}
		
		for (EObject elementB : (Iterable<EObject>) () -> modelB) {
			if (diff.getCorrespondenceOfModelB(elementB) == null) {
				match.getUnmatchedB().add(elementB);
			}
		}
		
		return diff;
	}

	@SuppressWarnings("unchecked")
	private void processMatched(SymmetricDifference diff, Set<EObject> unmatchedA, Set<EObject> unmatchedB) {
		for (Correspondence c : diff.getMatching().getCorrespondences()) {
			EObject elementA = c.getMatchedA();
			EObject elementB = c.getMatchedB();
			EClass nodeType = elementA.eClass();

			// Outgoing edges:
			for (EReference edgeType : nodeType.getEAllReferences()) {
				if (!EMFMetaAccess.isUnconsideredStructualFeature(edgeType)) {
					
					// Outgoing removed edges:
					if (edgeType.isMany()) {
						for (Object targetA : (Iterable<Object>) elementA.eGet(edgeType)) {
							if (targetA instanceof EObject) {
								if (unmatchedA.contains(targetA)) {
									removeEdge(diff.getChanges(), elementA, (EObject) targetA, edgeType);
								} else {
									EObject targetB = diff.getCorrespondingObjectInB((EObject) targetA);
									
									if (targetB != null) {
										if (!((Collection<?>) elementB.eGet(edgeType)).contains(targetB)) {
											removeEdge(diff.getChanges(), elementA, (EObject) targetA, edgeType);
										}
									} else {
										// Common resource:
										if (!((Collection<?>) elementB.eGet(edgeType)).contains(targetA)) {
											removeEdge(diff.getChanges(), elementA, (EObject) targetA, edgeType);
										}
									}
								}
							}
						}
					} else {
						Object targetA = elementA.eGet(edgeType);

						if (targetA instanceof EObject) {
							if (unmatchedA.contains(targetA)) {
								removeEdge(diff.getChanges(), elementA, (EObject) targetA, edgeType);
							} else {
								EObject targetB = diff.getCorrespondingObjectInB((EObject) targetA);
								
								if (targetB != null) {
									if (elementB.eGet(edgeType) != targetB) {
										removeEdge(diff.getChanges(), elementA, (EObject) targetA, edgeType);
									}
								} else {
									// Common resource:
									if (elementB.eGet(edgeType) != targetA) {
										removeEdge(diff.getChanges(), elementA, (EObject) targetA, edgeType);
									}
								}
							}
						}
					}
					
					// Outgoing added edges:
					if (edgeType.isMany()) {
						for (Object targetB : (Iterable<Object>) elementB.eGet(edgeType)) {
							if (targetB instanceof EObject) {
								if (unmatchedA.contains(targetB)) {
									addEdge(diff.getChanges(), elementB, (EObject) targetB, edgeType);
								} else {
									EObject targetA = diff.getCorrespondingObjectInA((EObject) targetB);
									
									if (targetA != null) {
										if (!((Collection<?>) elementA.eGet(edgeType)).contains(targetA)) {
											addEdge(diff.getChanges(), elementB, (EObject) targetB, edgeType);
										}
									} else {
										// Common resource:
										if (!((Collection<?>) elementA.eGet(edgeType)).contains(targetB)) {
											addEdge(diff.getChanges(), elementB, (EObject) targetB, edgeType);
										}
									}
								}
							}
						}
					} else {
						Object targetB = elementB.eGet(edgeType);
						
						if (targetB instanceof EObject) {
							if (unmatchedB.contains(targetB)) {
								addEdge(diff.getChanges(), elementB, (EObject) targetB, edgeType);
							} else {
								EObject targetA = diff.getCorrespondingObjectInA((EObject) targetB);
								
								if (targetA != null) {
									if (elementA.eGet(edgeType) != targetA) {
										addEdge(diff.getChanges(), elementB, (EObject) targetB, edgeType);
									}
								} else {
									// Common resource:
									if (elementA.eGet(edgeType) != targetB) {
										addEdge(diff.getChanges(), elementB, (EObject) targetB, edgeType);
									}
								}
							}
						}
					}
				}
			}

			// Changed attributes:
			for (EAttribute attributeType : nodeType.getEAllAttributes()) {
				if (!EMFMetaAccess.isUnconsideredStructualFeature(attributeType)) {
					deriveAttributeValueChange(diff.getChanges(), elementA, elementB, attributeType);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void processUnmatchedA(SymmetricDifference diff, Set<EObject> unmatchedA) {
		for (EObject elementA : diff.getMatching().getUnmatchedA()) {

			// Special in A:
			removeNode(diff.getChanges(), elementA);

			// Outgoing removed edges:
			EClass nodeType = elementA.eClass();

			for (EReference edgeType : nodeType.getEAllReferences()) {
				if (!EMFMetaAccess.isUnconsideredStructualFeature(edgeType)) {
					if (edgeType.isMany()) {
						for (Object targetA : (Iterable<Object>) elementA.eGet(edgeType)) {
							if (targetA instanceof EObject) {
								
								// TODO: Config -> Check scope:
//								if ((diff.getCorrespondenceOfModelA((EObject) targetA) != null) || unmatchedA.contains(targetA)) {
									removeEdge(diff.getChanges(), elementA, (EObject) targetA, edgeType);
//								}
							}
						}
					} else {
						Object targetA = elementA.eGet(edgeType);
						
						if (targetA instanceof EObject) {
							
							// TODO: Config -> Check scope:
//							if ((diff.getCorrespondenceOfModelA((EObject) targetA) != null) || unmatchedA.contains(targetA)) {
								removeEdge(diff.getChanges(), elementA, (EObject) targetA, edgeType);
//							}
						}
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void processUnmatchedB(SymmetricDifference diff, Set<EObject> unmatchedB) {
		for (EObject elementB : diff.getMatching().getUnmatchedB()) {

			// Special in B:
			addNode(diff.getChanges(), elementB);

			// Outgoing added edges:
			EClass nodeType = elementB.eClass();

			for (EReference edgeType : nodeType.getEAllReferences()) {
				if (!EMFMetaAccess.isUnconsideredStructualFeature(edgeType)) {
					if (edgeType.isMany()) {
						for (Object targetB : (Iterable<Object>) elementB.eGet(edgeType)) {
							if (targetB instanceof EObject) {
								
								// TODO: Config -> Check scope:
//								if ((diff.getCorrespondenceOfModelB((EObject) targetB) != null) || unmatchedB.contains(targetB)) {
									addEdge(diff.getChanges(), elementB, (EObject) targetB, edgeType);
//								}
							}
						}
					} else {
						Object targetB = elementB.eGet(edgeType);
						
						if (targetB instanceof EObject) {
							
							// TODO: Config -> Check scope:
//							if ((diff.getCorrespondenceOfModelB((EObject) targetB) != null) || unmatchedB.contains(targetB)) {
								addEdge(diff.getChanges(), elementB, (EObject) targetB, edgeType);
//							}
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

	private void removeNode(List<Change> changes, EObject obj) {
		RemoveObject r = DIFFERENCE_FACTORY.createRemoveObject();
		r.setObj(obj);
		changes.add(r);
	}

	private void addNode(List<Change> changes, EObject obj) {
		AddObject a = DIFFERENCE_FACTORY.createAddObject();
		a.setObj(obj);
		changes.add(a);
	}

	private void removeEdge(List<Change> changes, EObject src, EObject tgt, EReference type) {
		RemoveReference c = DIFFERENCE_FACTORY.createRemoveReference();
		c.setSrc(src);
		c.setTgt(tgt);
		c.setType(type);
		changes.add(c);
	}

	private void addEdge(List<Change> changes, EObject src, EObject tgt, EReference type) {
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
