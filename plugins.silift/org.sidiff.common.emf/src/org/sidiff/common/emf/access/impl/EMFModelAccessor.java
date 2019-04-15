package org.sidiff.common.emf.access.impl;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.access.EdgeSemantic;
import org.sidiff.common.emf.access.tree.*;

public interface EMFModelAccessor {

	public List<EObject> getChildren(EObject eObject, EReference type);

	public List<EObject> getChildren(EObject eObject, EClass type);

	public List<EClass> getChildrenTypes(EObject eObject);
	
	public List<EObject> getStereoTypes(EObject eObject);

	public List<EObject> getRequiredStereoTypes(EObject eObject);


	//public boolean isTree(Resource resource);

	public void traverse(Resource resource, TreeVisitor visitor);

	public void traverse(EObject eObject, TreeVisitor visitor);

	//public EObject getTreeRoot(EObject eObject);

	public List<EObject> getReferencedObjects(EObject eObject);

	public List<EObject> getReferencedObjects(EObject eObject, EClass type);

	public List<EObject> getReferencedObjects(EObject eObject, EdgeSemantic semantic);

	public List<EObject> getReferencedObjects(EObject eObject, EdgeSemantic semantic, EClass type);

	public List<EObject> getSiblings(EObject eObject);

	public EObject getLeftSibling(EObject eObject);

	public EObject getRightSibling(EObject eObject);

	public String getDocumentType(Set<String> documentTypes);
		
	public String getDocumentType(EObject object);

	public String getDocumentType(Resource model);

	public List<EObject> getNodeNeighbors(EObject object);

	public List<EObject> getNodeNeighbors(EObject object, EReference... types);

	public List<EObject> getNodeNeighbors(EObject object, EClass... types);

	public List<EObject> getNodeNeighbors(EObject object, EdgeSemantic semantic);

	public List<EObject> getNodeNeighbors(EObject object, EdgeSemantic semantic, EClass... types);
	
	public List<EObject> getMandatoryNodeNeighbors(EObject object);

}
