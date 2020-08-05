package org.sidiff.generic.matcher.uuid;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.revision.common.emf.EMFStorage;
import org.sidiff.revision.common.emf.document.Scope;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.matcher.IMatcher;
import org.sidiff.revision.difference.matcher.util.MatcherUtil;

public class UUIDMatcher implements IMatcher {
	
	@Override
	public void startMatching(Difference difference, Resource modelA, Resource modelB, Scope scope) {
		List<Resource> resourceSetA = MatcherUtil.getResourceScope(modelA, scope);
		List<Resource> resourceSetB = MatcherUtil.getResourceScope(modelB, scope);
		
		for (Resource resourceA : resourceSetA) {
			for (EObject elementA : (Iterable<EObject>) () -> resourceA.getAllContents()) { 
				EObject elementB = getCorresponding(resourceA, elementA, resourceSetB);
				addCorrespondence(difference, elementA, elementB);
			}
		}
	}

	private boolean addCorrespondence(Difference difference, EObject elementA, EObject elementB) {
		
		// Check type:
		if ((elementB != null) && elementA.eClass().equals(elementB.eClass())) {
			// Allow correspondences only between pairs of elements:
			if (difference.isUnmatchedB(elementB)) {
				difference.addCorrespondence(elementA, elementB);
				return true;
			} 
		}
		
		return false;
	}
	
	protected EObject getCorresponding(Resource resource, EObject element, List<Resource> resources) {
		String id = EMFStorage.getXmiId(element);
		String fragment = resource.getURIFragment(element);
		Boolean isDynamic = null;
		
		for (Resource otherResource : resources) {
			EObject corresponding = null;
			
			if (id != null) {
				corresponding = otherResource.getEObject(id);
			} 
			
			if ((corresponding == null) && (fragment != null) && (fragment != id)) {
				corresponding = otherResource.getEObject(fragment);
			}
			
			if (isDynamic == null) {
				isDynamic = UUIDResource.isDynamic(element);
			}
			
			if ((corresponding == null) && isDynamic) {
				// Handle dynamic objects (e.g. EGenerics in Ecore):
				EObject containerElement = element.eContainer();
				
				if (containerElement != null) {
					EObject correspondingContainer = getCorresponding(otherResource, containerElement, resources);
					
					if (correspondingContainer != null) {
						EReference containment = element.eContainmentFeature();
						Object correspondingDynamic = correspondingContainer.eGet(containment);
						
						if (correspondingDynamic != null) {
							if (containment.isMany()) {
								int index = ((List<?>) containerElement.eGet(containment)).indexOf(element);
								
								if (index != -1) {
									if (((List<?>) correspondingDynamic).size() > index) {
										return (EObject) ((List<?>) correspondingDynamic).get(index);
									}
								}
							} else {
								return (EObject) correspondingDynamic;
							}
						}
					}
				}
			}
			
			if (corresponding != null) {
				return corresponding;
			}
		}
		return null;
	}
}
