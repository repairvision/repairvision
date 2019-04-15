package org.sidiff.common.emf.metamodel.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;

/**
 * An instance of this class will hold additional information a selected EClassifier.
 * It is created during the meta-model analysis with the {@link EClassiferInfoManagement}.
 * These additional information (e.g. mandatory children, optional neighbors, stereotypes, 
 * attached constraints, etc.)are made available by various public methods.
 * 
 * @author mrindt
 *
 */
public class EClassifierInfo {
	
	/**
	 * The EClassifier which is extended
	 */
	private EClassifier theEClassifier = null;
	
	/**
	 * The direct mandatory children and the respective containment EReference
	 * (direct = No super types considered here)
	 */
	private HashMap<EReference, List<EClassifier>> mandatoryChildren = new HashMap<EReference, List<EClassifier>>();
	
	/**
	 * The direct mandatory neighbours and the respective non-containment EReference
	 * (direct = No super types considered here)
	 */
	private HashMap<EReference, List<EClassifier>> mandatoryNeighbours = new HashMap<EReference, List<EClassifier>>();
	
	/**
	 * The direct mandatory parent contexts and the respective containment EReference
	 * (from mandatory parent context to child)
	 * (direct = No super types considered here)
	 */
	private HashMap<EReference, List<EClassifier>> mandatoryParentContext = new HashMap<EReference, List<EClassifier>>();
	
	/**
	 * The direct mandatory neighbour contexts and the respective non-containment EReference
	 * (from mandatory neighbour context to neighbour)
	 * (direct = No super types considered here)
	 */
	private HashMap<EReference, List<EClassifier>> mandatoryNeighbourContext = new HashMap<EReference, List<EClassifier>>();
	
	/**
	 * The direct optional children and the respective containment EReference
	 * (direct = No super types considered here)
	 */
	private HashMap<EReference, List<EClassifier>> optionalChildren = new HashMap<EReference, List<EClassifier>>();
	
	/**
	 * The direct optional neighbours and the respective non-containment EReference
	 * (direct = No super types considered here)
	 */
	private HashMap<EReference, List<EClassifier>> optionalNeighbours = new HashMap<EReference, List<EClassifier>>();
	
	/**
	 * The direct optional parent contexts and the respective containment EReference
	 * (from optional parent context to child)
	 * (direct = No super types considered here)
	 */
	private HashMap<EReference, List<EClassifier>> optionalParentContext = new HashMap<EReference, List<EClassifier>>();
	
	/**
	 * The direct optional neighbour contexts and the respective non-containment EReference
	 * (from optional neighbour context to neighbour)
	 * (direct = No super types considered here)
	 */
	private HashMap<EReference, List<EClassifier>> optionalNeighbourContext = new HashMap<EReference, List<EClassifier>>();
	
	/**
	 * The list of steretypes attachable to this EClassifier
	 */
	private ArrayList<EClassifier> stereotypes = new ArrayList<EClassifier>();
	
	/**
	 * The list of meta-classes this EClassifier extends
	 */
	private ArrayList<EClassifier> extendedMetaClasses = new ArrayList<EClassifier>();
	
	/**
	 * The set of discovered containment cycles
	 */
	private Set<ContainmentCycle> containmentCycles = new HashSet<ContainmentCycle>();
	
	/**
	 * The set of Masks {@link Mask}
	 */
	private List<Mask> masks = new ArrayList<Mask>(); 
	
	/**
	 * All relationships.
	 */
	public enum Relationships {	MANDATORY_CHILDREN, MANDATORY_NEIGHBOURS, MANDATORY_PARENT_CONTEXT,
								OPTIONAL_CHILDREN,OPTIONAL_NEIGHBOURS, OPTIONAL_PARENT_CONTEXT,
								OPTIONAL_NEIGHBOUR_CONTEXT;
	}
		
	
	/**	
	 * Constructor
	 * 
	 * @param eClassifier
	 */
	public EClassifierInfo(EClassifier eClassifier) {
		this.theEClassifier = eClassifier;
	}
	
	/** Getter ****************************************************************************/
	
	public HashMap<EReference, List<EClassifier>> getMandatoryChildren() {
		return mandatoryChildren;
	}
	public HashMap<EReference, List<EClassifier>> getMandatoryNeighbours() {
		return mandatoryNeighbours;
	}
	public HashMap<EReference, List<EClassifier>> getMandatoryParentContext() {
		return mandatoryParentContext;
	}
	public HashMap<EReference, List<EClassifier>> getMandatoryNeighbourContext() {
		return mandatoryNeighbourContext;
	}
	public HashMap<EReference, List<EClassifier>> getOptionalChildren() {
		return optionalChildren;
	}
	public HashMap<EReference, List<EClassifier>> getOptionalNeighbours() {
		return optionalNeighbours;
	}
	public HashMap<EReference, List<EClassifier>> getOptionalParentContext() {
		return optionalParentContext;
	}
	public HashMap<EReference, List<EClassifier>> getOptionalNeighbourContext() {
		return optionalNeighbourContext;
	}
	public EClassifier getTheEClassifier() {
		return theEClassifier;
	}	
	public ArrayList<EClassifier> getStereotypes() {
		return stereotypes;
	}
	public ArrayList<EClassifier> getExtendedMetaClasses() {
		return extendedMetaClasses;
	}
	public List<Mask> getMasks() {
		return masks;
	}
	public Set<ContainmentCycle> getContainmentCycles() {
		return containmentCycles;
	}

	/** Setter ****************************************************************************/
	
	public void addExtendedMetaClass(EClassifier extendedMetaClass) {
		if(!extendedMetaClasses.contains(extendedMetaClass)) {
			extendedMetaClasses.add(extendedMetaClass);
		}
	}
	
	public void addStereotype(EClassifier stereotype) {
		if(!stereotypes.contains(stereotype)) {
			stereotypes.add(stereotype);
		}
	}

	public void addMask(Mask mask) {
		if(!masks.contains(mask)) {
			masks.add(mask);
		}
	}
	public void addContainmentCycle(ContainmentCycle cc) {
		containmentCycles.add(cc);
	}
	
	/** Convenience methods ***************************************************************/
	
	/**
	 * Returns all direct, global optional and mandatory children of the given EClassifier
	 * (i.e., inclusive all inherited children resulting from the supertype of the specified classifier
	 * but not the sub types of the children of this specified classifier.
	 * direct = only the first children, not further descending children
	 * global = the own children and also inherited children from the supertype of this classifier).
	 * Compare also {@link #getAllDirectLocalMandatoryChildren(EClassifier)}.
	 * @param childEClassifier
	 * 
	 * @return
	 * 		A List of EClassifiers and their respective containment EReferences
	 */
	public HashMap<EReference, List<EClassifier>> getAllDirectChildren(EClassifier childEClassifier)  {
		
		HashMap<EReference, List<EClassifier>> allDirectChildren = new HashMap<EReference, List<EClassifier>>();
		
		// get all direct children (mandatory and optional)
		allDirectChildren.putAll(getMandatoryChildren());
		allDirectChildren.putAll(getOptionalChildren());

		return allDirectChildren;
		
	}
	
	/**
	 * Returns all direct, local mandatory children of the given EClassifier
	 * (i.e., exclusive all inherited children resulting from the supertype of the specified classifier
	 * and also exclusive the sub types of the children of this specified classifier.
	 * direct = only the children, not further descending children (children of children... etc.)
	 * local = only the own children, not children inherited from the supertype of this classifier
	 * and also not the sub types of the local children
	 * mandatory = only children, where the containment reference has a lowerbound > 0).
	 * See also {@link #getAllDirectChildren(EClassifier)}.
	 * @param eClassifier
	 * 
	 * @return
	 * 		A List of EClassifiers and their respective containment EReferences
	 */
	public HashMap<EReference, List<EClassifier>> getAllDirectLocalMandatoryChildren(EClassifier eClassifier) {
		
		HashMap<EReference, List<EClassifier>> allLocalDirectMandatoryChildren = new HashMap<EReference, List<EClassifier>>();
		
		List<EReference> localReferences = ((EClass)eClassifier).getEReferences();
		
		for(EReference ref: localReferences) {
			
			if(ref.isContainment() && EReferenceInfo.isRequired(ref)) {
				List<EClassifier> targets = new ArrayList<EClassifier>();
				targets.add(ref.getEType());
				allLocalDirectMandatoryChildren.put(ref, targets);

				
			}			
		}
		
		return allLocalDirectMandatoryChildren;
		
	}
	
	/**
	 * Returns all direct, local mandatory neighbors of the given EClassifier
	 * (i.e., exclusive all inherited neighbors resulting from the supertype of the specified classifier
	 * and also exclusive the sub types of the neighbors of this specified classifier.
	 * direct = only the first neighbors, not further neighbors connected to these neighbors (neighbors of neighbor... etc.)
	 * local = only the own children, not children inherited from the supertype of this classifier and also not the sub types of
	 * the local neighbors
	 * mandatory = only neighbors, where the reference has a lowerbound > 0).
	 * @param eClassifier
	 * 
	 * @return
	 * 		A List of EClassifiers and their respective none-containment eReferences
	 */
	public HashMap<EReference, List<EClassifier>> getAllDirectLocalMandatoryNeighbors(EClassifier eClassifier) {
		
		HashMap<EReference, List<EClassifier>> allLocalDirectMandatoryNeighbors = new HashMap<EReference, List<EClassifier>>();
		
		List<EReference> localReferences = ((EClass)eClassifier).getEReferences();
		
		for(EReference ref: localReferences) {
			
			if(!ref.isContainment() && EReferenceInfo.isRequired(ref)) {
				List<EClassifier> targets = new ArrayList<EClassifier>();
				targets.add(ref.getEType());
				allLocalDirectMandatoryNeighbors.put(ref, targets);

				
			}			
		}
		
		return allLocalDirectMandatoryNeighbors;
		
	}
	
	/**
	 * Returns all direct, inherited mandatory neighbors of the given EClassifier
	 * (i.e., all inherited neighbors resulting from the supertypes of the specified classifier
	 * but exclusive the sub types of the neighbors of this specified classifier.
	 * direct = only the first neighbors, not further neighbors connected to these neighbors (neighbors of neighbor... etc.)
	 * mandatory = only neighbors, where the reference has a lowerbound > 0).
	 * @param eClassifier
	 * 
	 * @return
	 * 		A List of EClassifiers and their respective none-containment eReferences
	 */
	public HashMap<EReference, List<EClassifier>> getAllDirectInheritedMandatoryNeighbors(EClassifier eClassifier) {
		
		HashMap<EReference, List<EClassifier>> allInheritedDirectMandatoryNeighbors = new HashMap<EReference, List<EClassifier>>();
		
		for(EClass superType: ((EClass) eClassifier).getEAllSuperTypes()) {
					
			List<EReference> localSuperTypeReferences = ((EClass)superType).getEReferences();
			
			for(EReference ref: localSuperTypeReferences) {
				
				if(!ref.isContainment() && EReferenceInfo.isRequired(ref)) {
					List<EClassifier> targets = new ArrayList<EClassifier>();
					targets.add(ref.getEType());
					allInheritedDirectMandatoryNeighbors.put(ref, targets);				
				}			
			}		
		}
		
		return allInheritedDirectMandatoryNeighbors;
		
	}
	
	
	/**
	 * Returns a set of all EClassifiers which are types of EAttributes contained
	 * by the given EClassifier
	 * 
	 * @param eClassifier
	 * 
	 * @return
	 * 		Set of EClassifier
	 */
	public HashSet<EClassifier> getClassifiersOfAttributesForEClassifier(EClassifier eClassifier)
	{
		HashSet<EClassifier> attributeClassifiers = new HashSet<EClassifier>();
		
		for (EAttribute eAttribute : eClassifier.eClass().getEAllAttributes())
			attributeClassifiers.add(eAttribute.getEType());
		
		return attributeClassifiers;
	}
	
	/**
	 * Returns a set of direct EClassifiers which are mandatory
	 * children, neihghbours, parent contexts or neighbour contexts
	 * 
	 * @return
	 * 		Set of EClassifiers
	 */
	public HashSet<EClassifier> getAllMandatoryClassifiers()
	{
		HashSet<EClassifier> mandatoryClassifiers = new HashSet<EClassifier>();
		
		//Identify all mandatory children classifiers
		for (EReference ref : getMandatoryChildren().keySet())
		{
			for (EClassifier classifier : getMandatoryChildren().get(ref))
			if (!mandatoryClassifiers.contains(classifier))
				mandatoryClassifiers.add(classifier);
		}
		
		//Identify all mandatory neighbour classifiers
		for (EReference ref : getMandatoryNeighbours().keySet())
		{
			for (EClassifier classifier : getMandatoryNeighbours().get(ref))
			if (!mandatoryClassifiers.contains(classifier))
				mandatoryClassifiers.add(classifier);
		}
		
		//Identify all mandatory neighbour context classifiers
		for (EReference ref : getMandatoryNeighbourContext().keySet())
		{
			for (EClassifier classifier : getMandatoryNeighbourContext().get(ref))
			if (!mandatoryClassifiers.contains(classifier))
				mandatoryClassifiers.add(classifier);
		}
		
		//Identify all mandatory parent context classifiers
		for (EReference ref : getMandatoryParentContext().keySet())
		{
			for (EClassifier classifier : getMandatoryParentContext().get(ref))
			if (!mandatoryClassifiers.contains(classifier))
				mandatoryClassifiers.add(classifier);
		}
		
		//Identify all attribute classifiers
		mandatoryClassifiers.addAll(getClassifiersOfAttributesForEClassifier(theEClassifier));
			
		return mandatoryClassifiers;
	}
	
	/**
	 * Checks if the EClassifier may be a focal Element of a Transformation
	 * (only considering by meta-model restrictions here).
	 * 
	 * @return
	 * 		true | false
	 */
	public boolean selfMayHaveTransformations(){
		if(!optionalParentContext.isEmpty() || !optionalNeighbourContext.isEmpty()
				|| (mandatoryParentContext.isEmpty() && mandatoryNeighbourContext.isEmpty())) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns whether or not this EClassifier has mandatory children or neighbors
	 * 
	 * @return
	 * 		true | false
	 */
	public boolean hasMandatories() {
		if(!mandatoryChildren.isEmpty() || !mandatoryNeighbours.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns whether or not this EClassifier has a user configured mask.
	 * 
	 * @return
	 * 		true | false
	 */
	public boolean hasMasks() {
		return !masks.isEmpty();
	}
	
	/**
	 * Returns whether or not this EClassifier is a stereotype
	 * 
	 * @return
	 * 		true | false
	 */
	public boolean isStereotype() {
		return stereotypes.isEmpty();
	}
	
	/**
	 * Returns whether or not this EClassifier is a meta-class for a stereotype
	 * 
	 * @return
	 * 		true | false
	 */
	public boolean isExtendedMetaClass(){
		return extendedMetaClasses.isEmpty();
	}
	
	/**
	 * This convenience method returns all mandatory parent contexts and all mandatory neighbour contexts.
	 * 
	 * @return
	 * 			HashMap of EReferences (EReferences from context to EClassifier) and lists of EClassifier (contexts).
	 */
	public HashMap<EReference, List<EClassifier>> getMandatoryContexts() {
		
		HashMap<EReference, List<EClassifier>> mandatoryContexts = new  HashMap<EReference, List<EClassifier>>();
		
		mandatoryContexts.putAll(getMandatoryParentContext());
		mandatoryContexts.putAll(getMandatoryNeighbourContext());
		
		return mandatoryContexts;
	}
}
