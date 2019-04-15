/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.difference.symmetric;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.Matching;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Difference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.difference.symmetric.SymmetricDifference#getChanges <em>Changes</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.SymmetricDifference#getChangeSets <em>Change Sets</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.SymmetricDifference#getModelA <em>Model A</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.SymmetricDifference#getModelB <em>Model B</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.SymmetricDifference#getUriModelA <em>Uri Model A</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.SymmetricDifference#getUriModelB <em>Uri Model B</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.SymmetricDifference#getNotOverlappings <em>Not Overlappings</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.SymmetricDifference#getUnusedChangeSets <em>Unused Change Sets</em>}</li>
 *   <li>{@link org.sidiff.difference.symmetric.SymmetricDifference#getMatching <em>Matching</em>}</li>
 * </ul>
 *
 * @see org.sidiff.difference.symmetric.SymmetricPackage#getSymmetricDifference()
 * @model
 * @generated
 */
public interface SymmetricDifference extends EObject {
	/**
	 * Returns the value of the '<em><b>Changes</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.difference.symmetric.Change}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Changes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Changes</em>' containment reference list.
	 * @see org.sidiff.difference.symmetric.SymmetricPackage#getSymmetricDifference_Changes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Change> getChanges();

	/**
	 * Returns the value of the '<em><b>Change Sets</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.difference.symmetric.SemanticChangeSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Change Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Change Sets</em>' containment reference list.
	 * @see org.sidiff.difference.symmetric.SymmetricPackage#getSymmetricDifference_ChangeSets()
	 * @model containment="true"
	 * @generated
	 */
	EList<SemanticChangeSet> getChangeSets();

	/**
	 * Returns the value of the '<em><b>Model A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model A</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model A</em>' attribute.
	 * @see org.sidiff.difference.symmetric.SymmetricPackage#getSymmetricDifference_ModelA()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Resource getModelA();

	/**
	 * Returns the value of the '<em><b>Model B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model B</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model B</em>' attribute.
	 * @see org.sidiff.difference.symmetric.SymmetricPackage#getSymmetricDifference_ModelB()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Resource getModelB();

	/**
	 * Returns the value of the '<em><b>Uri Model A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri Model A</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri Model A</em>' attribute.
	 * @see #setUriModelA(String)
	 * @see org.sidiff.difference.symmetric.SymmetricPackage#getSymmetricDifference_UriModelA()
	 * @model
	 * @generated
	 */
	String getUriModelA();

	/**
	 * Sets the value of the '{@link org.sidiff.difference.symmetric.SymmetricDifference#getUriModelA <em>Uri Model A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri Model A</em>' attribute.
	 * @see #getUriModelA()
	 * @generated
	 */
	void setUriModelA(String value);

	/**
	 * Returns the value of the '<em><b>Uri Model B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri Model B</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri Model B</em>' attribute.
	 * @see #setUriModelB(String)
	 * @see org.sidiff.difference.symmetric.SymmetricPackage#getSymmetricDifference_UriModelB()
	 * @model
	 * @generated
	 */
	String getUriModelB();

	/**
	 * Sets the value of the '{@link org.sidiff.difference.symmetric.SymmetricDifference#getUriModelB <em>Uri Model B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri Model B</em>' attribute.
	 * @see #getUriModelB()
	 * @generated
	 */
	void setUriModelB(String value);

	/**
	 * Returns the value of the '<em><b>Not Overlappings</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.difference.symmetric.SemanticChangeSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Not Overlappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not Overlappings</em>' reference list.
	 * @see org.sidiff.difference.symmetric.SymmetricPackage#getSymmetricDifference_NotOverlappings()
	 * @model
	 * @generated
	 */
	EList<SemanticChangeSet> getNotOverlappings();

	/**
	 * Returns the value of the '<em><b>Unused Change Sets</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.difference.symmetric.SemanticChangeSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unused Change Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unused Change Sets</em>' containment reference list.
	 * @see org.sidiff.difference.symmetric.SymmetricPackage#getSymmetricDifference_UnusedChangeSets()
	 * @model containment="true"
	 * @generated
	 */
	EList<SemanticChangeSet> getUnusedChangeSets();

	/**
	 * Returns the value of the '<em><b>Matching</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matching</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matching</em>' containment reference.
	 * @see #setMatching(Matching)
	 * @see org.sidiff.difference.symmetric.SymmetricPackage#getSymmetricDifference_Matching()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Matching getMatching();

	/**
	 * Sets the value of the '{@link org.sidiff.difference.symmetric.SymmetricDifference#getMatching <em>Matching</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matching</em>' containment reference.
	 * @see #getMatching()
	 * @generated
	 */
	void setMatching(Matching value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EObject getCorrespondingObjectInA(EObject objectInB);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EObject getCorrespondingObjectInB(EObject objectInA);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Correspondence getCorrespondenceOfModelA(EObject objectInA);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Correspondence getCorrespondenceOfModelB(EObject objectInB);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addCorrespondence(Correspondence correspondence);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void removeCorrespondence(Correspondence correspondence);

} // SymmetricDifference
