/**
 */
package org.sidiff.repair.historymodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.sidiff.difference.symmetric.SymmetricDifference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>History</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.historymodel.History#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.History#getVersions <em>Versions</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.History#getTechnicalDifferences <em>Technical Differences</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.History#getAllValidationErrors <em>All Validation Errors</em>}</li>
 * </ul>
 *
 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getHistory()
 * @model
 * @generated
 */
public interface History extends EObject {
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
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getHistory_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.historymodel.History#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Versions</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.repair.historymodel.Version}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Versions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Versions</em>' containment reference list.
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getHistory_Versions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Version> getVersions();

	/**
	 * Returns the value of the '<em><b>Technical Differences</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.difference.symmetric.SymmetricDifference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Technical Differences</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Technical Differences</em>' reference list.
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getHistory_TechnicalDifferences()
	 * @model
	 * @generated
	 */
	EList<SymmetricDifference> getTechnicalDifferences();

	/**
	 * Returns the value of the '<em><b>All Validation Errors</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.repair.historymodel.ValidationError}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Validation Errors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Validation Errors</em>' reference list.
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getHistory_AllValidationErrors()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<ValidationError> getAllValidationErrors();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Version> getPrecessorRevisions(Version version);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Version> getSuccessorRevisions(Version version);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SymmetricDifference getTechnicalDifference(Version old, Version new_);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<ValidationError> getValidationErrors(boolean introduced, boolean resolved);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<ValidationError> getUniqueValidationErrors();

} // History
