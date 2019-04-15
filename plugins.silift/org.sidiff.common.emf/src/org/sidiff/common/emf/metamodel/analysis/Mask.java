package org.sidiff.common.emf.metamodel.analysis;

import org.eclipse.emf.ecore.*;

/**
 * Some meta-models contain EClassifiers with encapsulated type information; i.e., the type of an instance of this
 * EClassifier is not as significant as a contained EAttribute with an EEnumLiterals value representing the
 * actual type of the EClassifier instance (e.g. UML PseudoStates).
 * Since our editrules should be named as understandable for non expert users as possible, we want to allow the usage of
 * artificial types (a.k.a. "Masks") representing the encapsulated types while masking the original type names.
 * 
 * An example Mask for the UML Pseudostate can be 'InitialPseudostate' masking a Pseudostate with its
 * kind-EAttribute set to "initial".
 *
 *@author mrindt
 */
public class Mask {

	/**
	 * The name of the mask
	 */
	private String name;
	
	/**
	 * The original classifier which should be masked
	 */
	private EClassifier eClassifier;
	
	/**
	 * The EAttribut which contains the type information
	 */
	private EAttribute eAttribute;
	
	/**
	 * The type value
	 */
	private EEnumLiteral eAttributeValue;
	
	public Mask(String name, EClassifier eClassifier, EAttribute eAttribute, EEnumLiteral eAttributeValue) {
		this.name = name;
		this.eClassifier = eClassifier;
		this.eAttribute = eAttribute;
		this.eAttributeValue = eAttributeValue;
	}
	
	/**
	 * Returns the name of a mask as set on the SERGe configuration file.
	 * @return
	 * 		  name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the container EClassifier which beholds the concealed type information.
	 * @return
	 */
	public EClassifier getOriginalEClassifier() {
		return eClassifier;
	}

	/**
	 * Returns the attribute that contains the type.
	 * @return
	 * 		 eAttribute
	 */
	public EAttribute getEAttributeContainingFakeType() {
		return eAttribute;
	}

	/**
	 * Returns which type is actually meant.
	 * @return
	 * 		eenumliteral
	 */
	public EEnumLiteral getTypeExtension() {
		return eAttributeValue;
	}
	
}
