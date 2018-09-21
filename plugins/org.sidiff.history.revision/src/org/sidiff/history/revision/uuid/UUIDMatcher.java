package org.sidiff.history.revision.uuid;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.matcher.BaseMatcher;

public class UUIDMatcher extends BaseMatcher {
	
	@Override
	public String getName() {
		return "UUID Resource Matcher";
	}

	@Override
	public Set<String> getDocumentTypes() {
		return Collections.singleton(EMFModelAccess.GENERIC_DOCUMENT_TYPE);
	}

	@Override
	public String getDescription() {
		return "UUID Resource Matcher";
	}
	
	@Override
	protected void match() {
		Iterator<Resource> models = getModels().iterator();
		Resource modelA = models.next();
		Resource modelB = models.next();
		
		ICorrespondences correspondences = getCorrespondencesService();
		List<Resource> resourceSetA;
		List<Resource> resourceSetB;
		
		if (scope.equals(Scope.RESOURCE_SET)) {
			resourceSetA = modelA.getResourceSet().getResources();
			resourceSetB = modelB.getResourceSet().getResources();
		} else {
			resourceSetA = Collections.singletonList(modelB);
			resourceSetB = Collections.singletonList(modelA);
		}
		
		for (Resource resourceA : resourceSetA) {
			resourceA.getAllContents().forEachRemaining(elementA -> {
				EObject elementB = getCorresponding(resourceA, elementA, resourceSetB);
				
				if ((elementB != null) && elementA.eClass().equals(elementB.eClass())) {
					if (!(correspondences.hasCorrespondences(elementB))) {
						correspondences.addCorrespondence(elementA, elementB);
					} 
				}
			});
		}
	}
	
	protected EObject getCorresponding(Resource resource, EObject element, List<Resource> resources) {
		boolean isDynamic = UUIDResource.isDynamic(element);
		
		for (Resource otherResource : resources) {
			EObject corresponding = null;
			
			if (!isDynamic) {
				corresponding = otherResource.getEObject(EcoreUtil.getURI(element).fragment());
			} else {
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
