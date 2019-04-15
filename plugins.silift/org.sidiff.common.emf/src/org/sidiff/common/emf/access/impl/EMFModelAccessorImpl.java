package org.sidiff.common.emf.access.impl;

import java.util.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.collections.FilterUtil;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.emf.access.EMFMetaAccess;
import org.sidiff.common.emf.access.EdgeSemantic;
import org.sidiff.common.emf.access.tree.TreeVisitor;
import org.sidiff.common.emf.collections.EMFSelectors;
import org.sidiff.common.emf.exceptions.NoOrderedContainmentException;

public class EMFModelAccessorImpl implements EMFModelAccessor {

	@Override
	public List<EObject> getNodeNeighbors(EObject object) {
		List<EObject> result = new ArrayList<EObject>();
		EList<EReference> references = object.eClass().getEAllReferences();
		for (EReference reference : references) {
			result.addAll(EMFUtil.getReferenceTargets(object, reference));
		}
		return Collections.unmodifiableList(result);
	}

	@Override
	public List<EObject> getNodeNeighbors(EObject object, EReference... types) {
		List<EObject> result = new ArrayList<EObject>();
		for (EReference type : types) {
			result.addAll(EMFUtil.getReferenceTargets(object, type));
		}
		return Collections.unmodifiableList(result);
	}

	@Override
	public List<EObject> getNodeNeighbors(EObject object, EClass... types) {
		List<EObject> result = new ArrayList<EObject>();
		List<EClass> myTypes = Arrays.asList(types);
		for (EObject obj : getNodeNeighbors(object)) {
			if (myTypes.contains(obj.eClass()))
				result.add(obj);
		}
		return Collections.unmodifiableList(result);
	}

	@Override
	public List<EObject> getNodeNeighbors(EObject object, EdgeSemantic semantic) {
		List<EObject> result = new ArrayList<EObject>();
		EList<EReference> references = object.eClass().getEAllReferences();
		for (EReference reference : references) {
			if (!semantic.checkSemantic(reference))
				continue;
			result.addAll(EMFUtil.getReferenceTargets(object, reference));
		}
		return Collections.unmodifiableList(result);
	}

	@Override
	public List<EObject> getNodeNeighbors(EObject object, EdgeSemantic semantic, EClass... types) {
		List<EObject> result = new ArrayList<EObject>();
		List<EClass> myTypes = Arrays.asList(types);
		for (EObject obj : getNodeNeighbors(object, semantic)) {
			if (myTypes.contains(obj.eClass()))
				result.add(obj);
		}
		return Collections.unmodifiableList(result);
	}
	
	@Override
	public List<EObject> getMandatoryNodeNeighbors(EObject object) {
		List<EObject> result = new ArrayList<EObject>();
		EList<EReference> references = object.eClass().getEAllReferences();
		for (EReference reference : references) {
			if(reference.getLowerBound() > 0){
				result.addAll(EMFUtil.getReferenceTargets(object, reference));
			}
		}
		return Collections.unmodifiableList(result);
	}

	@Override
	public List<EObject> getChildren(EObject object, EReference type) {
		if (!type.isContainment())
			throw new IllegalArgumentException("Not a containment edge: " + type);
		return EMFUtil.getReferenceTargets(object, type);
	}

	@Override
	public List<EObject> getChildren(EObject object, EClass type) {
		return Collections.unmodifiableList(FilterUtil.filter(object.eContents(), true, EMFSelectors.byClass(type)));
	}

	@Override
	public List<EClass> getChildrenTypes(EObject object) {
		List<EClass> result = new ArrayList<EClass>();
		for (EObject child : object.eContents())
			if (!result.contains(child.eClass()))
				result.add(child.eClass());
		return result;
	}
	
	@Override
	public List<EObject> getStereoTypes(EObject eObject){
		List<EObject> result = new ArrayList<EObject>();
		for(EObject obj : EMFUtil.getAllContentAsIterable(eObject.eResource())){
			for (EStructuralFeature baseReference : EMFMetaAccess
					.getEStructuralFeaturesByRegEx(obj.eClass(),
							"^(base)_\\w+", true)) {				
				if(obj.eGet(baseReference).equals(eObject)){
					result.add(obj);
				}
			}
		}		
		return Collections.unmodifiableList(result);
	}
	
	@Override
	public List<EObject> getRequiredStereoTypes(EObject eObject){
		List<EObject> result = new ArrayList<EObject>();
		for(EObject obj : EMFUtil.getAllContentAsIterable(eObject.eResource())){
			for (EStructuralFeature baseReference : EMFMetaAccess
					.getEStructuralFeaturesByRegEx(obj.eClass(),
							"^(base)_\\w+", true)) {				
				if(obj.eGet(baseReference).equals(eObject) && baseReference.getLowerBound() == 1 ){
					result.add(obj);
				}
			}
		}		
		return Collections.unmodifiableList(result);
	}

	@Override
	public String getDocumentType(Set<String> docTypes) {
		assert (docTypes.size() > 0) : "No document type";
		
		List<String> documentTypes = new LinkedList<String>();
		documentTypes.addAll(docTypes);	
		
		if (documentTypes.size() == 1) {
			// documentType is nonambiguous
			return documentTypes.get(0);
		}

		// Remove irrelevant docTypes
		for (Iterator<String> iterator = documentTypes.iterator(); iterator.hasNext();) {
			String docType = (String) iterator.next();
			if (docType.contains("UML") || docType.contains("Henshin/Trace")){
				iterator.remove();
			}
		}
		
		if (documentTypes.size() == 1){
			return documentTypes.get(0);
		} else {
			return docTypes.iterator().next();
		}
	}
	
	@Override
	public String getDocumentType(EObject object) {
		EPackage pkg = object.eClass().getEPackage();
		while (pkg != null && pkg.getESuperPackage() != null) {
			pkg = pkg.getESuperPackage();
		}
		return pkg.getNsURI();
	}

	@Override
	public String getDocumentType(Resource model) {
		if (model.getContents().isEmpty()){
			return null;
		}
		
		// Collect all document types of root objects
		Set<String> documentTypes = new HashSet<String>();
		for (EObject root : model.getContents()) {
			documentTypes.add(getDocumentType(root));				
		}
		
		// return most proper docType
		return getDocumentType(documentTypes);
	}

	@SuppressWarnings("unchecked")
	@Override
	public EObject getLeftSibling(EObject object) {
		if (!object.eContainmentFeature().isOrdered())
			throw new NoOrderedContainmentException("The containment feature ", object.eContainmentFeature(), " is not ordered.");
		EList<EObject> sibs = (EList<EObject>) object.eContainer().eGet(object.eContainmentFeature());
		int index = sibs.indexOf(object);
		if (index == 0)
			return null;
		else
			return sibs.get(index - 1);
	}

	@Override
	public List<EObject> getReferencedObjects(EObject object) {
		List<EObject> result = new ArrayList<EObject>();
		for (EReference reference : EMFMetaAccess.getReferences(object.eClass())) {
			result.addAll(EMFUtil.getReferenceTargets(object, reference));
		}
		return Collections.unmodifiableList(result);
	}

	@Override
	public List<EObject> getReferencedObjects(EObject object, EClass type) {
		List<EObject> result = new ArrayList<EObject>();
		for (EObject ref : getReferencedObjects(object))
			if (type.isInstance(ref))
				result.add(ref);
		return Collections.unmodifiableList(result);
	}

	@Override
	public List<EObject> getReferencedObjects(EObject object, EdgeSemantic semantic) {
		List<EObject> result = new ArrayList<EObject>();
		for (EReference reference : EMFMetaAccess.getReferences(object.eClass(), semantic)) {
			result.addAll(EMFUtil.getReferenceTargets(object, reference));
		}
		return Collections.unmodifiableList(result);
	}

	@Override
	public List<EObject> getReferencedObjects(EObject object, EdgeSemantic semantic, EClass type) {
		List<EObject> result = new ArrayList<EObject>();
		for (EObject ref : getReferencedObjects(object, semantic))
			if (type.isInstance(ref))
				result.add(ref);
		return Collections.unmodifiableList(result);
	}

	@SuppressWarnings("unchecked")
	@Override
	public EObject getRightSibling(EObject object) {
		if (!object.eContainmentFeature().isOrdered())
			throw new NoOrderedContainmentException("The containment feature ", object.eContainmentFeature(), " is not ordered.");
		EList<EObject> sibs = (EList<EObject>) object.eContainer().eGet(object.eContainmentFeature());
		int index = sibs.indexOf(object);
		if (index == sibs.size() - 1)
			return null;
		else
			return sibs.get(index + 1);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EObject> getSiblings(EObject object) {
		List<EObject> result = new ArrayList<EObject>();
		if (object.eContainer()!= null && object.eContainmentFeature().isMany())
			for (EObject sibling : (EList<EObject>) object.eContainer().eGet(object.eContainmentFeature()))
				if (sibling != object)
					result.add(sibling);
		return Collections.unmodifiableList(result);
	}

	@Override
	public void traverse(Resource resource, TreeVisitor visitor) {

		for (EObject object : resource.getContents()){
			traverse(object, visitor);
		}
	}
	


	@Override
	public void traverse(EObject object, TreeVisitor visitor) {
		
		if(visitor.preExecute(object)){
			// descend
			for(EObject child : object.eContents()){
				traverse(child, visitor);
			}
		}
		visitor.postExecute(object);
	}

}
