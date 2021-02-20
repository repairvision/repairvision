/**
 */
package org.sidiff.reverseengineering.systemmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.reverseengineering.systemmodel.Version#getModelVersionID <em>Model Version ID</em>}</li>
 *   <li>{@link org.sidiff.reverseengineering.systemmodel.Version#getDate <em>Date</em>}</li>
 *   <li>{@link org.sidiff.reverseengineering.systemmodel.Version#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.sidiff.reverseengineering.systemmodel.Version#getCommitMessage <em>Commit Message</em>}</li>
 * </ul>
 *
 * @see org.sidiff.reverseengineering.systemmodel.SystemModelPackage#getVersion()
 * @model
 * @generated
 */
public interface Version extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Version ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Version ID</em>' attribute.
	 * @see #setModelVersionID(String)
	 * @see org.sidiff.reverseengineering.systemmodel.SystemModelPackage#getVersion_ModelVersionID()
	 * @model
	 * @generated
	 */
	String getModelVersionID();

	/**
	 * Sets the value of the '{@link org.sidiff.reverseengineering.systemmodel.Version#getModelVersionID <em>Model Version ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Version ID</em>' attribute.
	 * @see #getModelVersionID()
	 * @generated
	 */
	void setModelVersionID(String value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(String)
	 * @see org.sidiff.reverseengineering.systemmodel.SystemModelPackage#getVersion_Date()
	 * @model
	 * @generated
	 */
	String getDate();

	/**
	 * Sets the value of the '{@link org.sidiff.reverseengineering.systemmodel.Version#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(String value);

	/**
	 * Returns the value of the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' attribute.
	 * @see #setAuthor(String)
	 * @see org.sidiff.reverseengineering.systemmodel.SystemModelPackage#getVersion_Author()
	 * @model
	 * @generated
	 */
	String getAuthor();

	/**
	 * Sets the value of the '{@link org.sidiff.reverseengineering.systemmodel.Version#getAuthor <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' attribute.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(String value);

	/**
	 * Returns the value of the '<em><b>Commit Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commit Message</em>' attribute.
	 * @see #setCommitMessage(String)
	 * @see org.sidiff.reverseengineering.systemmodel.SystemModelPackage#getVersion_CommitMessage()
	 * @model
	 * @generated
	 */
	String getCommitMessage();

	/**
	 * Sets the value of the '{@link org.sidiff.reverseengineering.systemmodel.Version#getCommitMessage <em>Commit Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Commit Message</em>' attribute.
	 * @see #getCommitMessage()
	 * @generated
	 */
	void setCommitMessage(String value);

} // Version
