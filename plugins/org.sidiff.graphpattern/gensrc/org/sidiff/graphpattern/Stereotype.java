/**
 */
package org.sidiff.graphpattern;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stereotype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.Stereotype#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.Stereotype#getProfile <em>Profile</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getStereotype()
 * @model
 * @generated
 */
public interface Stereotype extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getStereotype_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.Stereotype#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Profile</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.Profile#getStereotypes <em>Stereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profile</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profile</em>' container reference.
	 * @see #setProfile(Profile)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getStereotype_Profile()
	 * @see org.sidiff.graphpattern.Profile#getStereotypes
	 * @model opposite="stereotypes" required="true" transient="false"
	 * @generated
	 */
	Profile getProfile();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.Stereotype#getProfile <em>Profile</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Profile</em>' container reference.
	 * @see #getProfile()
	 * @generated
	 */
	void setProfile(Profile value);

} // Stereotype
