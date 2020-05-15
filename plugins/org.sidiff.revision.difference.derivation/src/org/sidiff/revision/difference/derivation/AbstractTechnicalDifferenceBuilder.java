package org.sidiff.revision.difference.derivation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.sidiff.common.utilities.emf.DocumentType;
import org.sidiff.common.utilities.emf.EMFMetaAccess;
import org.sidiff.common.utilities.emf.Scope;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Correspondence;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.DifferenceFactory;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.difference.RemoveReference;
import org.sidiff.revision.difference.derivation.util.EObjectLocation;

/**
 * Abstract base class for deriving a low-level difference (which is called
 * technical difference here for some historical reasons) from a given matching.
 * 
 * Subclasses can add unconsideredNodeTypes, unconsideredEdgeTypes and
 * unconsideredAttributeTypes in order to filter the low-level difference.
 * 
 * @author kehrer
 */
public abstract class AbstractTechnicalDifferenceBuilder implements ITechnicalDifferenceBuilder {

	private Difference diff;
	private Scope scope;

	private final DifferenceFactory factory = DifferenceFactory.eINSTANCE;

	// information provided by subclasses
	private Set<EClass> unconsideredNodeTypes;
	private Set<EReference> unconsideredEdgeTypes;
	private Set<EAttribute> unconsideredAttributeTypes;

	protected AbstractTechnicalDifferenceBuilder() {
		unconsideredNodeTypes = getUnconsideredNodeTypes();
		unconsideredEdgeTypes = getUnconsideredEdgeTypes();
		unconsideredAttributeTypes = getUnconsideredAttributeTypes();
	}

	@Override
	public Difference deriveTechDiff(Difference difference, Scope scope) {
		this.diff = difference;
		this.scope = scope;

		processUnmatchedA();
		processUnmatchedB();
		processCorrespondences();

		return diff;
	}

	private void processCorrespondences() {
		for (Iterator<Correspondence> iterator = diff.getCorrespondences().iterator(); iterator.hasNext();) {
			Correspondence c = iterator.next();
			EObject nodeA = c.getMatchedA();
			EObject nodeB = c.getMatchedB();
			EClass nodeType = nodeA.eClass();

			// filter

			if (!doProcess(nodeA)) {
				continue;
			}

			if (unconsideredNodeTypes.contains(nodeType)) {
				iterator.remove();
				continue;
			}

			EObjectLocation objectALocation = locate(diff.getModelA(), nodeA);
			EObjectLocation objectBLocation = locate(diff.getModelB(), nodeB);
			assert (objectALocation == objectBLocation) : "different object locations not yet supported!";

			if (objectALocation == EObjectLocation.PACKAGE_REGISTRY) {
				// skip, but do no delete correspondence
				continue;
			}

			if (scope == Scope.RESOURCE && objectALocation == EObjectLocation.RESOURCE_SET_INTERNAL) {
				// skip, but do not delete correspondence
				continue;
			}

			// end filter

			// EReferences
			for (EReference edgeType : nodeType.getEAllReferences()) {
				Set<EObject> nodesetA = new HashSet<EObject>();
				addReferencedObjects(edgeType, nodeA, nodesetA);
				Set<EObject> nodesetB = new HashSet<EObject>();
				addReferencedObjects(edgeType, nodeB, nodesetB);

				// Diff A
				@SuppressWarnings("unchecked")
				Set<EObject> diffA = differenceA(nodesetA, nodesetB);
				deriveDiffA(edgeType, nodeA, diffA);

				// Diff B
				@SuppressWarnings("unchecked")
				Set<EObject> diffB = differenceB(nodesetA, nodesetB);
				deriveDiffB(edgeType, nodeB, diffB);
			}

			// EAttributes
			for (EAttribute attributeType : nodeType.getEAllAttributes()) {
				if (!attributeType.isDerived()) {
					deriveAttributeValueChange(nodeA, nodeB, attributeType);
				}
			}
		}
	}

	private void processUnmatchedA() {

		for(EObject elementA : diff.getUnmatchedA()){
			if (!doProcess(elementA)) {
				continue;
			}
			if (unconsideredNodeTypes.contains(elementA.eClass())) {
				continue;
			}

			// Special in A
			removeNode(elementA);

			// Outgoing edges
			EClass nodeType = elementA.eClass();
			for (EReference edgeType : nodeType.getEAllReferences()) {
				Set<EObject> diffA = new HashSet<EObject>();
				addReferencedObjects(edgeType, elementA, diffA);
				deriveDiffA(edgeType, elementA, diffA);
			}
		}


	}

	private void processUnmatchedB() {

		for(EObject elementB : diff.getUnmatchedB()){
			
			if (!doProcess(elementB)) {
				continue;
			}
			if (unconsideredNodeTypes.contains(elementB.eClass())) {
				continue;
			}

			// Special in B
			addNode(elementB);

			// Outgoing edges
			EClass nodeType = elementB.eClass();
			for (EReference edgeType : nodeType.getEAllReferences()) {
				Set<EObject> diffB = new HashSet<EObject>();
				addReferencedObjects(edgeType, elementB, diffB);
				deriveDiffB(edgeType, elementB, diffB);
			}
		}
	}

	private void deriveDiffA(EReference edgeType, EObject nodeA, Set<EObject> diffA) {
		if (edgeType.isDerived()) {
			return;
		}
		if (unconsideredEdgeTypes.contains(edgeType)) {
			return;
		}

		for (EObject tgt : diffA) {
			removeEdge(nodeA, tgt, edgeType);
		}
	}

	private void deriveDiffB(EReference edgeType, EObject nodeB, Set<EObject> diffB) {
		if (edgeType.isDerived()) {
			return;
		}
		if (unconsideredEdgeTypes.contains(edgeType)) {
			return;
		}

		for (EObject tgt : diffB) {
			addEdge(nodeB, tgt, edgeType);
		}
	}

	@SuppressWarnings("rawtypes")
	private Set differenceA(Set a, Set b) {
		@SuppressWarnings("unchecked")
		HashSet res = new HashSet(a);
		for (Iterator iterator = a.iterator(); iterator.hasNext();) {
			EObject ea = (EObject) iterator.next();

			if (b.contains(diff.getCorrespondingObjectInB(ea))) {
				res.remove(ea);
			}
		}

		return res;
	}

	@SuppressWarnings("rawtypes")
	private Set differenceB(Set a, Set b) {
		@SuppressWarnings("unchecked")
		HashSet res = new HashSet(b);
		for (Iterator iterator = b.iterator(); iterator.hasNext();) {
			EObject eb = (EObject) iterator.next();

			if (a.contains(diff.getCorrespondingObjectInA(eb))) {
				res.remove(eb);
			}
		}

		return res;
	}

	private void deriveAttributeValueChange(EObject nodeA, EObject nodeB, EAttribute attributeType) {
		if (unconsideredAttributeTypes.contains(attributeType)) {
			return;
		}

		Object valueA = null;
		Object valueB = null;
		
		try {
			valueA = nodeA.eGet(attributeType);
			valueB = nodeB.eGet(attributeType);
		} catch(IllegalArgumentException e) {
		}

//		// Normalize null values of String attributes: We consider null to be
//		// conceptually equal to ""
//		if (attributeType.getEAttributeType().getName().equals("EString")) {
//			if (valueA == null) {
//				valueA = "";
//			}
//			if (valueB == null) {
//				valueB = "";
//			}
//		}

		// TODO: This section needs to be revised if we want to support
		// multi-valued attributes!

		// Check for multi value attribute
		// Change comparison style if so
		if (valueA instanceof EDataTypeEList) {
			EDataTypeEList<?> valueAList = (EDataTypeEList<?>) valueA;
			assert (valueAList.size() <= 1) : "'Real' multi-valued attributes not yet supported: " + valueAList;

			String compareString = "";
			if (valueAList.size() > 0) {
				compareString = valueAList.toString();
				compareString = compareString.replace("[", "");
				compareString = compareString.replace("]", "");
			}

			valueA = compareString;
		}

		if (valueB instanceof EDataTypeEList) {
			EDataTypeEList<?> valueBList = (EDataTypeEList<?>) valueB;
			assert (valueBList.size() <= 1) : "'Real' multi-valued attributes not yet supported: " + valueBList;

			String compareString = "";
			if (valueBList.size() > 0) {
				compareString = valueBList.toString();
				compareString = compareString.replace("[", "");
				compareString = compareString.replace("]", "");
			}

			valueB = compareString;
		}

		if (EMFMetaAccess.isUnconsideredStructualFeature(attributeType)
				|| (valueA != null && valueB != null && valueA.equals(valueB)) || (valueA == null && valueB == null)) {

			// no value change
			return;
		}

		if ((nodeA != null) && (nodeB != null)) {
			AttributeValueChange change = factory.createAttributeValueChange();
			change.setObjA(nodeA);
			change.setObjB(nodeB);
			change.setType(attributeType);
			diff.getChanges().add(change);
		}

	}

	private void removeNode(EObject obj) {
		RemoveObject r = factory.createRemoveObject();
		r.setObj(obj);
		diff.getChanges().add(r);
	}

	private void addNode(EObject obj) {
		AddObject a = factory.createAddObject();
		a.setObj(obj);
		diff.getChanges().add(a);
	}

	private void removeEdge(EObject src, EObject tgt, EReference type) {
		RemoveReference c = factory.createRemoveReference();
		c.setSrc(src);
		c.setTgt(tgt);
		c.setType(type);
		diff.getChanges().add(c);
	}

	private void addEdge(EObject src, EObject tgt, EReference type) {
		AddReference c = factory.createAddReference();
		c.setSrc(src);
		c.setTgt(tgt);
		c.setType(type);
		diff.getChanges().add(c);
	}

	@SuppressWarnings("unchecked")
	private void addReferencedObjects(EReference refType, EObject src, Collection<EObject> referencedObjects) {
		try {
			if (refType.isMany()) {
				referencedObjects.addAll((Collection<EObject>) src.eGet(refType));
			} else {
				EObject obj = (EObject) src.eGet(refType);

				if (obj != null) {
					referencedObjects.add(obj);
				}
			}
		} catch (IllegalArgumentException e) {
		}
	}

	@Override
	public String getKey() {
		return getClass().getName();
	}

	protected boolean doProcess(EObject object) {
		// generic td builders can process every eObject
		return getDocumentTypes().contains(DocumentType.GENERIC_DOCUMENT_TYPE)
				|| getDocumentTypes().contains(DocumentType.getDocumentType(object));
	}

	@Override
	public boolean canHandleDocTypes(Set<String> documentTypes) {
		// generic td builders can handle every model
		return getDocumentTypes().contains(DocumentType.GENERIC_DOCUMENT_TYPE)
				|| getDocumentTypes().containsAll(documentTypes);
	}
	
	@Override
	public boolean canHandleModels(Resource modelA, Resource modelB) {

		Set<String> docTypes = DocumentType.getDocumentTypes(modelA, Scope.RESOURCE_SET);
		docTypes.addAll(DocumentType.getDocumentTypes(modelB, Scope.RESOURCE_SET));

		return canHandleDocTypes(docTypes);
	}

	protected abstract String getObjectName(EObject obj);

	/**
	 * Subclasses have to decide which nodes (i.e. EObjects) shall be ignored by
	 * the difference builder. This is done by specifying the types of the nodes
	 * that are to be ignored.
	 * 
	 * @return
	 */
	protected abstract Set<EClass> getUnconsideredNodeTypes();

	/**
	 * Subclasses have to decide which edges (i.e. Links) shall be ignored by
	 * the difference builder. This is done by specifying the types of the edges
	 * that are to be ignored.
	 * 
	 * @return
	 */
	protected abstract Set<EReference> getUnconsideredEdgeTypes();

	/**
	 * Subclasses have to decide which attributes shall be ignored by the
	 * difference builder. This is done by specifying the types of the
	 * attributes that are to be ignored.
	 * 
	 * @return
	 */
	protected abstract Set<EAttribute> getUnconsideredAttributeTypes();

	public EObjectLocation locate(Resource model, EObject eObject) {
		// RESOURCE_INTERNAL..?
		if (contains(model, eObject)) {
			return EObjectLocation.RESOURCE_INTERNAL;
		}

		// RESOURCE_SET_INTERNAL..?
		for (Resource r : model.getResourceSet().getResources()) {
			if (r == model) {
				continue;
			}
			if (contains(r, eObject)) {
				return EObjectLocation.RESOURCE_SET_INTERNAL;
			}
		}

		// Must be found in PACKAGE_REGISTRY
		assert (EPackage.Registry.INSTANCE.containsValue(eObject.eClass().getEPackage())) : "" + eObject;
		
		return EObjectLocation.PACKAGE_REGISTRY;
	}

	protected boolean contains(Resource resource, EObject eObject) {
		if(eObject.eResource() == null)
			return false;
		return eObject.eResource().equals(resource);
	}
}
