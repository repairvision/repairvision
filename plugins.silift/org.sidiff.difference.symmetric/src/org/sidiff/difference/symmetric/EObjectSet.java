/**
 */
package org.sidiff.difference.symmetric;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EObject Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.difference.symmetric.EObjectSet#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.sidiff.difference.symmetric.SymmetricPackage#getEObjectSet()
 * @model
 * @generated
 */
public interface EObjectSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' reference list.
	 * @see org.sidiff.difference.symmetric.SymmetricPackage#getEObjectSet_Elements()
	 * @model suppressedSetVisibility="true"
	 * @generated
	 */
	EList<EObject> getElements();
	
	void addElement(EObject element);
	
	void replaceElement(EObject oldElement, EObject newElement);
	
	void addElements(Collection<EObject> element);
	
	Set<EObject> toJavaSet();

} // EObjectSet
