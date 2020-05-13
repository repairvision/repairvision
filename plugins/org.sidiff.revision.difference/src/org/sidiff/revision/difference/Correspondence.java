/**
 */
package org.sidiff.revision.difference;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Correspondence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.revision.difference.Correspondence#getMatchedA <em>Matched A</em>}</li>
 *   <li>{@link org.sidiff.revision.difference.Correspondence#getMatchedB <em>Matched B</em>}</li>
 * </ul>
 *
 * @see org.sidiff.revision.difference.DifferencePackage#getCorrespondence()
 * @model
 * @generated
 */
public interface Correspondence extends EObject {
	/**
	 * Returns the value of the '<em><b>Matched A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matched A</em>' reference.
	 * @see #setMatchedA(EObject)
	 * @see org.sidiff.revision.difference.DifferencePackage#getCorrespondence_MatchedA()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EObject getMatchedA();

	/**
	 * Sets the value of the '{@link org.sidiff.revision.difference.Correspondence#getMatchedA <em>Matched A</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matched A</em>' reference.
	 * @see #getMatchedA()
	 * @generated
	 */
	void setMatchedA(EObject value);

	/**
	 * Returns the value of the '<em><b>Matched B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matched B</em>' reference.
	 * @see #setMatchedB(EObject)
	 * @see org.sidiff.revision.difference.DifferencePackage#getCorrespondence_MatchedB()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EObject getMatchedB();

	/**
	 * Sets the value of the '{@link org.sidiff.revision.difference.Correspondence#getMatchedB <em>Matched B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matched B</em>' reference.
	 * @see #getMatchedB()
	 * @generated
	 */
	void setMatchedB(EObject value);

} // Correspondence
