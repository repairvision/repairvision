package org.sidiff.revision.model;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A view on an abstract syntax graph/tree (ASG) of a model.
 * 
 * @author Manuel Ohrndorf
 */
public interface ModelASG extends ModelAST {

	/**
	 * @param element A model element.
	 * @return The meta-class defining the abstract structure of the given element.
	 */
	EClass eClass(Object element);

	/**
	 * @param element A model element.
	 * @param feature A meta-attribute or meta-reference of the meta-class defining
	 *                the abstract structure of the given element.
	 * @return The value of the given attribute or reference of this object.
	 */
	Object eGet(Object element, EStructuralFeature feature);
}
