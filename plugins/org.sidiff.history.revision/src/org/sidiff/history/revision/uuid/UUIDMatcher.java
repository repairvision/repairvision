package org.sidiff.history.revision.uuid;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.candidates.ICandidates;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.correspondences.matchingmodel.MatchingModelCorrespondences;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matcher.mode.MatcherMode;

public class UUIDMatcher implements IMatcher {
	
	private ICorrespondences correspondencesService;
	
	private Collection<Resource> models;
	
	private MatcherMode mode = MatcherMode.SINGLE;
	
	@Override
	public void reset() {
		if(correspondencesService != null){
			this.correspondencesService.reset();
		}
	}
	
	@Override
	public String getName() {
		return "UUID Resource Matcher";
	}
	
	@Override
	public String getKey() {
		return getName();
	}
	
	@Override
	public String getDescription() {
		return "UUID Resource Matcher";
	}
	
	@Override
	public String getServiceID() {
		return SERVICE_ID + "." + getKey();
	}

	@Override
	public Set<String> getDocumentTypes() {
		return Collections.singleton(EMFModelAccess.GENERIC_DOCUMENT_TYPE);
	}

	@Override
	public boolean canHandleDocTypes(Set<String> documentTypes) {
		return getDocumentTypes().contains(EMFModelAccess.GENERIC_DOCUMENT_TYPE)
				|| getDocumentTypes().containsAll(documentTypes);
	}
	
	@Override
	public boolean canHandleModels(Collection<Resource> models) {
		Set<String> docTypes = new HashSet<String>();
		
		for (Resource model : models) {
			if (isResourceSetCapable()) {
				docTypes.addAll(EMFModelAccess.getDocumentTypes(model, Scope.RESOURCE_SET));
			} else {
				docTypes.addAll(EMFModelAccess.getDocumentTypes(model, Scope.RESOURCE));
			}
		}

		return canHandleDocTypes(docTypes);
	}
	
	@Override
	public boolean isResourceSetCapable() {
		return true;
	}
	
	@Override
	public Collection<Resource> getModels() {
		return models;
	}
	
	@Override
	public void startMatching(Collection<Resource> models, Scope scope) {
		this.models = models;
		init(models, scope);
		match(models, scope);
	}
	
	protected void init(Collection<Resource> models, Scope scope) {
	
		this.correspondencesService = new MatchingModelCorrespondences() {

			@Override
			public void init(Collection<Resource> models) {
				super.init(models);

				Iterator<Resource> modelsIterator = models.iterator();
				initUnmatchedResourceSet(modelsIterator.next(), modelsIterator.next());
			}

			// NOTE: Make matching model resource set capable!
			private void initUnmatchedResourceSet(Resource modelA, Resource modelB) {

				// add unmatched A:
				for (Resource resourceA : modelA.getResourceSet().getResources()) {
					if (resourceA != modelA) { // already initialized
						for (Iterator<EObject> iterator = resourceA.getAllContents(); iterator.hasNext();) {
							EObject obj = iterator.next();
							getMatching().getUnmatchedA().add(obj);
						}
					}
				}

				// add unmatched B:
				for (Resource resourceB : modelB.getResourceSet().getResources()) {
					if (resourceB != modelB) { // already initialized
						for (Iterator<EObject> iterator = resourceB.getAllContents(); iterator.hasNext();) {
							EObject obj = iterator.next();
							getMatching().getUnmatchedB().add(obj);
						}
					}
				}
			}
		};
		
		if (this.mode.equals(MatcherMode.SINGLE)){
			this.correspondencesService.init(models);
		}
	}
	
	protected void match(Collection<Resource> models, Scope scope) {
		Iterator<Resource> modelesIterator = models.iterator();
		Resource modelA = modelesIterator.next();
		Resource modelB = modelesIterator.next();
		
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
				
				// Check type:
				if ((elementB != null) && elementA.eClass().equals(elementB.eClass())) {
					// Allow correspondences only between pairs of elements:
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
	
	// ---------- Getter and Setter Methods ----------
	
	@Override
	public MatcherMode getMode() {
		return mode;
	}

	@Override
	public void setMode(MatcherMode mode) {
		
		// NOTE: Matcher uses own fixed correspondence service...
		if (!this.mode.equals(MatcherMode.SINGLE)){
			throw new UnsupportedOperationException();
		}
		
		this.mode = mode;
	}
	
	@Override
	public void setCandidatesService(ICandidates candidatesService) {
	}
	
	@Override
	public ICandidates getCandidatesService() {
		return null;
	}

	@Override
	public void setCorrespondencesService(ICorrespondences correspondencesService) {
	}

	@Override
	public ICorrespondences getCorrespondencesService() {
		return correspondencesService;
	}
}
