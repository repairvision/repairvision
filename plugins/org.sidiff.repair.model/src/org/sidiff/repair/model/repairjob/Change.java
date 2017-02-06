/**
 */
package org.sidiff.repair.model.repairjob;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.henshin.model.GraphElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.model.repairjob.Change#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getChange()
 * @model
 * @generated
 */
public interface Change extends EObject {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(GraphElement)
	 * @see org.sidiff.repair.model.repairjob.RepairjobPackage#getChange_Element()
	 * @model
	 * @generated
	 */
	GraphElement getElement();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.model.repairjob.Change#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(GraphElement value);

} // Change
