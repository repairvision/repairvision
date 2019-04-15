/**
 */
package org.sidiff.difference.symmetric;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fragment Join</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.difference.symmetric.FragmentJoin#getScs <em>Scs</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.FragmentJoin#getJoinFrom <em>Join From</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.FragmentJoin#getJoinInto <em>Join Into</em>}</li>
 * </ul>
 *
 * @see org.sidiff.difference.symmetric.SymmetricPackage#getFragmentJoin()
 * @model
 * @generated
 */
public interface FragmentJoin extends EObject {
	/**
	 * Returns the value of the '<em><b>Scs</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.difference.symmetric.SemanticChangeSet#getJoins <em>Joins</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scs</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scs</em>' container reference.
	 * @see #setScs(SemanticChangeSet)
	 * @see org.sidiff.difference.symmetric.SymmetricPackage#getFragmentJoin_Scs()
	 * @see org.sidiff.difference.symmetric.SemanticChangeSet#getJoins
	 * @model opposite="joins" required="true" transient="false"
	 * @generated
	 */
	SemanticChangeSet getScs();

	/**
	 * Sets the value of the '{@link org.sidiff.difference.symmetric.FragmentJoin#getScs <em>Scs</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scs</em>' container reference.
	 * @see #getScs()
	 * @generated
	 */
	void setScs(SemanticChangeSet value);

	/**
	 * Returns the value of the '<em><b>Join From</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Join From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Join From</em>' reference list.
	 * @see org.sidiff.difference.symmetric.SymmetricPackage#getFragmentJoin_JoinFrom()
	 * @model lower="2"
	 * @generated
	 */
	EList<EObject> getJoinFrom();

	/**
	 * Returns the value of the '<em><b>Join Into</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Join Into</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Join Into</em>' reference list.
	 * @see org.sidiff.difference.symmetric.SymmetricPackage#getFragmentJoin_JoinInto()
	 * @model required="true"
	 * @generated
	 */
	EList<EObject> getJoinInto();

} // FragmentJoin
