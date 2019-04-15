/**
 */
package org.sidiff.matching.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
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
 *   <li>{@link org.sidiff.matching.model.Correspondence#getMatchedA <em>Matched A</em>}</li>
 *   <li>{@link org.sidiff.matching.model.Correspondence#getMatchedB <em>Matched B</em>}</li>
 *   <li>{@link org.sidiff.matching.model.Correspondence#getContainerCorrespondence <em>Container Correspondence</em>}</li>
 *   <li>{@link org.sidiff.matching.model.Correspondence#getContainmentCorrespondences <em>Containment Correspondences</em>}</li>
 *   <li>{@link org.sidiff.matching.model.Correspondence#getEClass <em>EClass</em>}</li>
 * </ul>
 *
 * @see org.sidiff.matching.model.MatchingModelPackage#getCorrespondence()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='MissingMatching MatchedANotInResourceA MatchedBNotInResourceB TypeMismatch ContainerMismatchA ContainerMismatchB ContainerCorrespondenceInDifferentMatching'"
 * @generated
 */
public interface Correspondence extends ExtendableObject {
	/**
	 * Returns the value of the '<em><b>Matched A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matched A</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matched A</em>' reference.
	 * @see #setMatchedA(EObject)
	 * @see org.sidiff.matching.model.MatchingModelPackage#getCorrespondence_MatchedA()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EObject getMatchedA();

	/**
	 * Sets the value of the '{@link org.sidiff.matching.model.Correspondence#getMatchedA <em>Matched A</em>}' reference.
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
	 * <p>
	 * If the meaning of the '<em>Matched B</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matched B</em>' reference.
	 * @see #setMatchedB(EObject)
	 * @see org.sidiff.matching.model.MatchingModelPackage#getCorrespondence_MatchedB()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EObject getMatchedB();

	/**
	 * Sets the value of the '{@link org.sidiff.matching.model.Correspondence#getMatchedB <em>Matched B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matched B</em>' reference.
	 * @see #getMatchedB()
	 * @generated
	 */
	void setMatchedB(EObject value);

	/**
	 * Returns the value of the '<em><b>Container Correspondence</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.matching.model.Correspondence#getContainmentCorrespondences <em>Containment Correspondences</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Correspondence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Correspondence</em>' reference.
	 * @see #setContainerCorrespondence(Correspondence)
	 * @see org.sidiff.matching.model.MatchingModelPackage#getCorrespondence_ContainerCorrespondence()
	 * @see org.sidiff.matching.model.Correspondence#getContainmentCorrespondences
	 * @model opposite="containmentCorrespondences" ordered="false"
	 * @generated
	 */
	Correspondence getContainerCorrespondence();

	/**
	 * Sets the value of the '{@link org.sidiff.matching.model.Correspondence#getContainerCorrespondence <em>Container Correspondence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container Correspondence</em>' reference.
	 * @see #getContainerCorrespondence()
	 * @generated
	 */
	void setContainerCorrespondence(Correspondence value);

	/**
	 * Returns the value of the '<em><b>Containment Correspondences</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.matching.model.Correspondence}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.matching.model.Correspondence#getContainerCorrespondence <em>Container Correspondence</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containment Correspondences</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containment Correspondences</em>' reference list.
	 * @see org.sidiff.matching.model.MatchingModelPackage#getCorrespondence_ContainmentCorrespondences()
	 * @see org.sidiff.matching.model.Correspondence#getContainerCorrespondence
	 * @model opposite="containerCorrespondence" ordered="false"
	 * @generated
	 */
	EList<Correspondence> getContainmentCorrespondences();

	/**
	 * Returns the value of the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EClass</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EClass</em>' reference.
	 * @see org.sidiff.matching.model.MatchingModelPackage#getCorrespondence_EClass()
	 * @model resolveProxies="false" required="true" transient="true" changeable="false" derived="true" ordered="false"
	 * @generated
	 */
	EClass getEClass();

} // Correspondence
