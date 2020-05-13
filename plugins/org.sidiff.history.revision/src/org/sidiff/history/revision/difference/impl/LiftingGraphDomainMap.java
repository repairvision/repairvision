// TODO[Clone]: package org.sidiff.difference.lifting.recognitionengine.ruleapplication;
package org.sidiff.history.revision.difference.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.Difference;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.difference.RemoveReference;
import org.sidiff.revision.difference.DifferencePackage;

/**
 * <ul>
 * <li>
 * Index of change types (Remove-/Add-/Object, Remove-/Add-Reference,
 * Attribute-Value-Change by the type of the changed object) to candidates.
 * </li>
 * <li>
 * Index of model A/B objects to their correspondences.
 * </li>
 * </ul>
 * 
 * @author Manuel Ohrndorf
 */
public class LiftingGraphDomainMap {

	private static final DifferencePackage SYMMMETRIC_PACKAGE = DifferencePackage.eINSTANCE;
	
	private Difference difference;

	private IndexSet<EClass, Set<EClass>> subTypes;

	private IndexList<EClass, List<AddObject>> addObjects;

	private IndexList<EClass, List<RemoveObject>> removeObjects;

	private IndexList<EReference, List<AddReference>> addReference;

	private IndexList<EReference, List<RemoveReference>> removeReference;

	private IndexList<EAttribute, List<AttributeValueChange>> attributeValueChange;
	
	private Set<EStructuralFeature> typeNodes;

	/**
	 * Creates a new {@link LiftingGraphDomainMap}.
	 * 
	 * @param difference
	 *            The difference containing the changes.
	 */
	public LiftingGraphDomainMap(Difference difference) {
		this.difference = difference;

		subTypes = new IndexSet<EClass, Set<EClass>>();
		addObjects = new IndexList<EClass, List<AddObject>>();
		removeObjects = new IndexList<EClass, List<RemoveObject>>();
		addReference = new IndexList<EReference, List<AddReference>>();
		removeReference = new IndexList<EReference, List<RemoveReference>>();
		attributeValueChange = new IndexList<EAttribute, List<AttributeValueChange>>();
		typeNodes = new HashSet<EStructuralFeature>();
		
		createChangeDomainMap(difference);
	}
	
	private class IndexList<K, C extends List<?>> extends HashMap<K, C> {

		private static final long serialVersionUID = 1L;

		@SuppressWarnings("unchecked")
		@Override
		public C get(Object key) {
			C results = super.get(key);
			
			if (results == null) {
				return (C) Collections.emptyList();
			} else {
				return results;
			}
		}
		
		@SuppressWarnings("unchecked")
		public C getModifiable(K key) {
			C results = super.get(key);
			
			if (results == null) {
				@SuppressWarnings("rawtypes")
				C newIndex = (C) new ArrayList();
				put(key, newIndex);
				return newIndex;
			} else {
				return results;
			}
		}
	}
	
	private class IndexSet<K, C extends Set<?>> extends HashMap<K, C> {

		private static final long serialVersionUID = 1L;

		@SuppressWarnings("unchecked")
		@Override
		public C get(Object key) {
			C results = super.get(key);
			
			if (results == null) {
				return (C) Collections.emptySet();
			} else {
				return results;
			}
		}
		
		@SuppressWarnings("unchecked")
		public C getModifiable(K key) {
			C results = super.get(key);
			
			if (results == null) {
				@SuppressWarnings("rawtypes")
				C newIndex = (C) new HashSet();
				put(key, newIndex);
				return newIndex;
			} else {
				return results;
			}
		}
	}

	/**
	 * Creates the change domain map.
	 * 
	 * @param difference
	 *            The difference containing the changes.
	 */
	private void createChangeDomainMap(Difference difference) {

		Set<EPackage> packages = new HashSet<EPackage>();

		for (Change change : difference.getChanges()) {

			if (change instanceof AddObject) {
				EClass type = ((AddObject) change).getObj().eClass();
				addObjects.getModifiable(type).add((AddObject) change);
				
				// Generic AddObject pattern needs inheritance map:
				packages.add(type.getEPackage());
			}

			else if (change instanceof RemoveObject) {
				EClass type = ((RemoveObject) change).getObj().eClass();
				removeObjects.getModifiable(type).add((RemoveObject) change);

				// RemoveObject pattern needs inheritance map:
				packages.add(type.getEPackage());
			}

			else if (change instanceof AddReference) {
				EReference type = ((AddReference) change).getType();
				addReference.getModifiable(type).add((AddReference) change);
				
				// Record meta-model type nodes:
				typeNodes.add(((AddReference) change).getType());
			}

			else if (change instanceof RemoveReference) {
				EReference type = ((RemoveReference) change).getType();
				removeReference.getModifiable(type).add((RemoveReference) change);
				
				// Record meta-model type nodes:
				typeNodes.add(((RemoveReference) change).getType());
			}

			else if (change instanceof AttributeValueChange) {
				EAttribute type = ((AttributeValueChange) change).getType();
				attributeValueChange.getModifiable(type).add((AttributeValueChange) change);
				
				// Record meta-model type nodes:
				typeNodes.add(((AttributeValueChange) change).getType());
			}
		}

		subTypes = getSubtypeIndex(packages);
	}
	
	/**
	 * Get all candidates which are compatible with the given change type. This
	 * returns a fresh and modifiable list.
	 * 
	 * @param changeType
	 *            The type of the change ({@link AddObject},
	 *            {@link RemoveObject}, {@link AddReference},
	 *            {@link RemoveReference}, {@link AttributeValueChange})
	 * @param changeDomainType
	 *            The (meta) type of the changed objects ({@link EClass},
	 *            {@link EReference}, {@link EAttribute}).
	 * @return A set of candidates compatible with the change type.
	 */
	public List<EObject> getChangeDomain(EClass changeType, EObject changeDomainType) {

		// AddObject:
		if ((changeType == SYMMMETRIC_PACKAGE.getAddObject())
				&& (changeDomainType instanceof EClass)) {
			return getAddObjectDomain((EClass) changeDomainType);
		}

		// RemoveObject:
		else if ((changeType == SYMMMETRIC_PACKAGE.getRemoveObject())
				&& (changeDomainType instanceof EClass)) {
			return getRemoveObjectDomain((EClass) changeDomainType);
		}

		// AddReference:
		else if ((changeType == SYMMMETRIC_PACKAGE.getAddReference())
				&& (changeDomainType instanceof EReference)) {
			return getAddReferenceDomain((EReference) changeDomainType);
		}

		// RemoveReference:
		else if ((changeType == SYMMMETRIC_PACKAGE.getRemoveReference())
				&& (changeDomainType instanceof EReference)) {
			return getRemoveReferenceDomain((EReference) changeDomainType);
		}

		// AttributeValueChange:
		else if ((changeType == SYMMMETRIC_PACKAGE.getAttributeValueChange())
				&& (changeDomainType instanceof EAttribute)) {
			return getAttributeValueChangeDomain((EAttribute) changeDomainType);
		}

		return null;
	}

	/**
	 * Returns the size of the domain for a change type. The returned number
	 * equals the size of the list returned by
	 * {@link #getAddObjectDomain(EClass)}. This method should be used whenever
	 * the actual objects are not needed.
	 * 
	 * @param changeType
	 *            The type of the change ({@link AddObject},
	 *            {@link RemoveObject}, {@link AddReference},
	 *            {@link RemoveReference}, {@link AttributeValueChange})
	 * @param changeDomainType
	 *            The type of the changed objects ({@link EClass},
	 *            {@link EReference}, {@link EAttribute}).
	 * @return The count of candidates compatible with the change type.
	 */
	public int getChangeDomainSize(EClass changeType, EObject changeDomainType) {

		// AddObject:
		if ((changeType == SYMMMETRIC_PACKAGE.getAddObject())
				&& (changeDomainType instanceof EClass)) {
			return getAddObjectDomainSize((EClass) changeDomainType);
		}

		// RemoveObject:
		else if ((changeType == SYMMMETRIC_PACKAGE.getRemoveObject())
				&& (changeDomainType instanceof EClass)) {
			return getRemoveObjectDomainSize((EClass) changeDomainType);
		}

		// AddReference:
		else if ((changeType == SYMMMETRIC_PACKAGE.getAddReference())
				&& (changeDomainType instanceof EReference)) {
			return getAddReferenceDomainSize((EReference) changeDomainType);
		}

		// RemoveReference:
		else if ((changeType == SYMMMETRIC_PACKAGE.getRemoveReference())
				&& (changeDomainType instanceof EReference)) {
			return getRemoveReferenceDomainSize((EReference) changeDomainType);
		}

		// AttributeValueChange:
		else if ((changeType == SYMMMETRIC_PACKAGE.getAttributeValueChange())
				&& (changeDomainType instanceof EAttribute)) {
			return getAttributeValueChangeDomainSize((EAttribute) changeDomainType);
		}

		return -1;
	}

	/**
	 * Get all candidates which are compatible with the given change type. This
	 * returns a fresh and modifiable list.
	 * 
	 * @param type
	 *            The type of the added objects.
	 * @return A set of candidates compatible with the type.
	 */
	public List<EObject> getAddObjectDomain(EClass type) {
		List<EObject> domain = new ArrayList<EObject>(addObjects.get(type));
		
		// Support for generic creation edit rules:
		if (type.isAbstract() || type.isInterface()) {
			for (EClass subtype : getSubTypes(type)) {
				domain.addAll(addObjects.get(subtype));
			}
		}
		
		return domain;
	}

	/**
	 * Returns the size of the domain for a change type. The returned number
	 * equals the size of the list returned by
	 * {@link #getAddObjectDomain(EClass)}. This method should be used whenever
	 * the actual objects are not needed.
	 * 
	 * @param type
	 *            The type of the added objects.
	 * @return The count of candidates compatible with the change type.
	 */
	public int getAddObjectDomainSize(EClass type) {
		int domainSize = addObjects.get(type).size();
		
		// Support for generic creation edit rules:
		if (type.isAbstract() || type.isInterface()) {
			for (EClass subtype : getSubTypes(type)) {
				domainSize += addObjects.get(subtype).size();
			}
		}
		
		return domainSize;
	}

	/**
	 * Get all candidates which are compatible with the given change type. This
	 * returns a fresh and modifiable list.
	 * 
	 * @param type
	 *            The type of the removed objects.
	 * @return A set of candidates compatible with the type.
	 */
	public List<EObject> getRemoveObjectDomain(EClass type) {
		List<EObject> domain = new ArrayList<EObject>(removeObjects.get(type));

		for (EClass subtype : getSubTypes(type)) {
			domain.addAll(removeObjects.get(subtype));
		}

		return domain;
	}

	/**
	 * Returns the size of the domain for a change type. The returned number
	 * equals the size of the list returned by
	 * {@link #getRemoveObjectDomain(EClass)}. This method should be used
	 * whenever the actual objects are not needed.
	 * 
	 * @param type
	 *            The type of the removed objects.
	 * @return The count of candidates compatible with the change type.
	 */
	public int getRemoveObjectDomainSize(EClass type) {
		int domainSize = removeObjects.get(type).size();

		for (EClass subtype : getSubTypes(type)) {
			domainSize += removeObjects.get(subtype).size();
		}

		return domainSize;
	}

	/**
	 * Get all candidates which are compatible with the given change type. This
	 * returns a fresh and modifiable list.
	 * 
	 * @param type
	 *            The type of the added references.
	 * @return A set of candidates compatible with the type.
	 */
	public List<EObject> getAddReferenceDomain(EReference type) {
		return new ArrayList<EObject>(addReference.get(type));
	}

	/**
	 * Returns the size of the domain for a change type. The returned number
	 * equals the size of the list returned by
	 * {@link #getAddReferenceDomain(EClass)}. This method should be used
	 * whenever the actual objects are not needed.
	 * 
	 * @param type
	 *            The type of added references.
	 * @return The count of candidates compatible with the change type.
	 */
	public int getAddReferenceDomainSize(EReference type) {
		return addReference.get(type).size();
	}

	/**
	 * Get all candidates which are compatible with the given change type. This
	 * returns a fresh and modifiable list.
	 * 
	 * @param type
	 *            The type of removed references.
	 * @return A set of candidates compatible with the type.
	 */
	public List<EObject> getRemoveReferenceDomain(EReference type) {
		return new ArrayList<EObject>(removeReference.get(type));
	}

	/**
	 * Returns the size of the domain for a change type. The returned number
	 * equals the size of the list returned by
	 * {@link #getRemoveReferenceDomain(EClass)}. This method should be used
	 * whenever the actual objects are not needed.
	 * 
	 * @param type
	 *            The type of the removed references.
	 * @return The count of candidates compatible with the change type.
	 */
	public int getRemoveReferenceDomainSize(EReference type) {
		return removeReference.get(type).size();
	}

	/**
	 * Get all candidates which are compatible with the given change type. This
	 * returns a fresh and modifiable list.
	 * 
	 * @param type
	 *            The type of the changed attribute.
	 * @return A set of candidates compatible with the change type.
	 */
	public List<EObject> getAttributeValueChangeDomain(EAttribute type) {
		return new ArrayList<EObject>(attributeValueChange.get(type));
	}

	/**
	 * Returns the size of the domain for a change type. The returned number
	 * equals the size of the list returned by
	 * {@link #getAttributeValueChangeDomain(EClass)}. This method should be
	 * used whenever the actual objects are not needed.
	 * 
	 * @param type
	 *            The type of the changed attribute.
	 * @return The count of candidates compatible with the change type.
	 */
	public int getAttributeValueChangeDomainSize(EAttribute type) {
		return attributeValueChange.get(type).size();
	}
	
	/**
	 * @return All meta-model types used by the corresponding difference.
	 */
	public Set<EStructuralFeature> getTypeNodes() {
		return typeNodes;
	}

	/**
	 * Returns all sub-types of the given EClass.
	 * 
	 * @param type
	 *            The super-type.
	 * @return All sub-types of the given EClass.
	 */
	// TODO: Centralize...
	private Set<EClass> getSubTypes(EClass type) {
		return subTypes.get(type);
	}

	/**
	 * Creates a map form each class in the package to its corresponding
	 * sub-types (in the package).
	 * 
	 * @param ePackage
	 *            The package containing the sub- and super-classes.
	 * @return A map EClass -> Set of EClass sup-types.
	 */
	// TODO: Centralize...
	protected IndexSet<EClass, Set<EClass>> getSubtypeIndex(Set<EPackage> ePackages) {

		// Class (A) -> [Sub classes (X, Y, Z)]
		IndexSet<EClass, Set<EClass>> subTypes = new IndexSet<EClass, Set<EClass>>();

		// Iterate over all docType packages
		for (EPackage ePackage : ePackages) {

			// Iterate over all classes in the package
			for (Iterator<EObject> i = ePackage.eAllContents(); i.hasNext();) {
				EObject obj = i.next();

				if (obj instanceof EClass) {
					// Next class (A)
					EClass eSubClass = (EClass) obj;

					if (subTypes.get(eSubClass) == null) {
						subTypes.put(eSubClass, null);
					}

					// Lookup the super types (X,Y,Z) of class (A) and add
					// class (A) as sub type to the classes (X, Y, Z)
					for (EClass eSuperClass : eSubClass.getEAllSuperTypes()) {
						Set<EClass> allSubTypes = subTypes.getModifiable(eSuperClass);
						allSubTypes.add(eSubClass);
					}
				}
			}
		}

		return subTypes;
	}

	/**
	 * @return The corresponding difference.
	 */
	public Difference getDifference() {
		return difference;
	}
}
