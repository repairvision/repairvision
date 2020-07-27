/**
 */
package org.sidiff.revision.difference;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Difference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.revision.difference.Difference#getChanges <em>Changes</em>}</li>
 *   <li>{@link org.sidiff.revision.difference.Difference#getCorrespondences <em>Correspondences</em>}</li>
 *   <li>{@link org.sidiff.revision.difference.Difference#getUriModelA <em>Uri Model A</em>}</li>
 *   <li>{@link org.sidiff.revision.difference.Difference#getUriModelB <em>Uri Model B</em>}</li>
 *   <li>{@link org.sidiff.revision.difference.Difference#getModelA <em>Model A</em>}</li>
 *   <li>{@link org.sidiff.revision.difference.Difference#getModelB <em>Model B</em>}</li>
 * </ul>
 *
 * @see org.sidiff.revision.difference.DifferencePackage#getDifference()
 * @model
 * @generated
 */
public interface Difference extends EObject {
	/**
	 * Returns the value of the '<em><b>Changes</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.revision.difference.Change}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Changes</em>' containment reference list.
	 * @see org.sidiff.revision.difference.DifferencePackage#getDifference_Changes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Change> getChanges();

	/**
	 * Returns the value of the '<em><b>Uri Model A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri Model A</em>' attribute.
	 * @see #setUriModelA(String)
	 * @see org.sidiff.revision.difference.DifferencePackage#getDifference_UriModelA()
	 * @model
	 * @generated
	 */
	String getUriModelA();

	/**
	 * Sets the value of the '{@link org.sidiff.revision.difference.Difference#getUriModelA <em>Uri Model A</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri Model B</em>' attribute.
	 * @see #setUriModelB(String)
	 * @see org.sidiff.revision.difference.DifferencePackage#getDifference_UriModelB()
	 * @model
	 * @generated
	 */
	String getUriModelB();

	/**
	 * Sets the value of the '{@link org.sidiff.revision.difference.Difference#getUriModelB <em>Uri Model B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri Model B</em>' attribute.
	 * @see #getUriModelB()
	 * @generated
	 */
	void setUriModelB(String value);

	/**
	 * Returns the value of the '<em><b>Model A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model A</em>' attribute.
	 * @see #setModelA(Resource)
	 * @see org.sidiff.revision.difference.DifferencePackage#getDifference_ModelA()
	 * @model transient="true" derived="true" ordered="false"
	 * @generated
	 */
	Resource getModelA();

	/**
	 * Sets the value of the '{@link org.sidiff.revision.difference.Difference#getModelA <em>Model A</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model A</em>' attribute.
	 * @see #getModelA()
	 * @generated
	 */
	void setModelA(Resource value);

	/**
	 * Returns the value of the '<em><b>Model B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model B</em>' attribute.
	 * @see #setModelB(Resource)
	 * @see org.sidiff.revision.difference.DifferencePackage#getDifference_ModelB()
	 * @model transient="true" derived="true" ordered="false"
	 * @generated
	 */
	Resource getModelB();

	/**
	 * Sets the value of the '{@link org.sidiff.revision.difference.Difference#getModelB <em>Model B</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model B</em>' attribute.
	 * @see #getModelB()
	 * @generated
	 */
	void setModelB(Resource value);

	/**
	 * Returns the value of the '<em><b>Correspondences</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.revision.difference.Correspondence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correspondences</em>' containment reference list.
	 * @see org.sidiff.revision.difference.DifferencePackage#getDifference_Correspondences()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Correspondence> getCorrespondences();

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
	 * @model objARequired="true" objBRequired="true"
	 * @generated
	 */
	void addCorrespondence(EObject objA, EObject objB);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void removeCorrespondence(Correspondence correspondence);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean isUnmatchedA(EObject objectInA);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean isUnmatchedB(EObject objectInB);

} // Difference
