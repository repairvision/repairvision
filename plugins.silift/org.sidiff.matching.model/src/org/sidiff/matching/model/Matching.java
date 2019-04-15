/**
 */
package org.sidiff.matching.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Matching</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.matching.model.Matching#getCorrespondences <em>Correspondences</em>}</li>
 *   <li>{@link org.sidiff.matching.model.Matching#getUnmatchedA <em>Unmatched A</em>}</li>
 *   <li>{@link org.sidiff.matching.model.Matching#getUnmatchedB <em>Unmatched B</em>}</li>
 *   <li>{@link org.sidiff.matching.model.Matching#getEResourceA <em>EResource A</em>}</li>
 *   <li>{@link org.sidiff.matching.model.Matching#getEResourceB <em>EResource B</em>}</li>
 *   <li>{@link org.sidiff.matching.model.Matching#getUriA <em>Uri A</em>}</li>
 *   <li>{@link org.sidiff.matching.model.Matching#getUriB <em>Uri B</em>}</li>
 * </ul>
 *
 * @see org.sidiff.matching.model.MatchingModelPackage#getMatching()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='UnmatchedANotInResourceA UnmatchedBNotInResourceB UnhandledElementA UnhandledElementB'"
 * @generated
 */
public interface Matching extends EObject {
	/**
	 * Returns the value of the '<em><b>Correspondences</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.matching.model.Correspondence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correspondences</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correspondences</em>' containment reference list.
	 * @see org.sidiff.matching.model.MatchingModelPackage#getMatching_Correspondences()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Correspondence> getCorrespondences();

	/**
	 * Returns the value of the '<em><b>Unmatched A</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unmatched A</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unmatched A</em>' reference list.
	 * @see org.sidiff.matching.model.MatchingModelPackage#getMatching_UnmatchedA()
	 * @model ordered="false"
	 * @generated
	 */
	EList<EObject> getUnmatchedA();

	/**
	 * Returns the value of the '<em><b>Unmatched B</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unmatched B</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unmatched B</em>' reference list.
	 * @see org.sidiff.matching.model.MatchingModelPackage#getMatching_UnmatchedB()
	 * @model ordered="false"
	 * @generated
	 */
	EList<EObject> getUnmatchedB();

	/**
	 * Returns the value of the '<em><b>EResource A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EResource A</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EResource A</em>' attribute.
	 * @see #setEResourceA(Resource)
	 * @see org.sidiff.matching.model.MatchingModelPackage#getMatching_EResourceA()
	 * @model required="true" transient="true" derived="true" ordered="false"
	 * @generated
	 */
	Resource getEResourceA();

	/**
	 * Sets the value of the '{@link org.sidiff.matching.model.Matching#getEResourceA <em>EResource A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EResource A</em>' attribute.
	 * @see #getEResourceA()
	 * @generated
	 */
	void setEResourceA(Resource value);

	/**
	 * Returns the value of the '<em><b>EResource B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EResource B</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EResource B</em>' attribute.
	 * @see #setEResourceB(Resource)
	 * @see org.sidiff.matching.model.MatchingModelPackage#getMatching_EResourceB()
	 * @model required="true" transient="true" derived="true" ordered="false"
	 * @generated
	 */
	Resource getEResourceB();

	/**
	 * Sets the value of the '{@link org.sidiff.matching.model.Matching#getEResourceB <em>EResource B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EResource B</em>' attribute.
	 * @see #getEResourceB()
	 * @generated
	 */
	void setEResourceB(Resource value);

	/**
	 * Returns the value of the '<em><b>Uri A</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri A</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri A</em>' attribute.
	 * @see #setUriA(String)
	 * @see org.sidiff.matching.model.MatchingModelPackage#getMatching_UriA()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	String getUriA();

	/**
	 * Sets the value of the '{@link org.sidiff.matching.model.Matching#getUriA <em>Uri A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri A</em>' attribute.
	 * @see #getUriA()
	 * @generated
	 */
	void setUriA(String value);

	/**
	 * Returns the value of the '<em><b>Uri B</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri B</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri B</em>' attribute.
	 * @see #setUriB(String)
	 * @see org.sidiff.matching.model.MatchingModelPackage#getMatching_UriB()
	 * @model default="" required="true" ordered="false"
	 * @generated
	 */
	String getUriB();

	/**
	 * Sets the value of the '{@link org.sidiff.matching.model.Matching#getUriB <em>Uri B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri B</em>' attribute.
	 * @see #getUriB()
	 * @generated
	 */
	void setUriB(String value);

} // Matching
