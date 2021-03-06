/**
 */
package org.sidiff.reverseengineering.systemmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.reverseengineering.systemmodel.View#getSystem <em>System</em>}</li>
 *   <li>{@link org.sidiff.reverseengineering.systemmodel.View#getDocumentTypes <em>Document Types</em>}</li>
 *   <li>{@link org.sidiff.reverseengineering.systemmodel.View#getKind <em>Kind</em>}</li>
 *   <li>{@link org.sidiff.reverseengineering.systemmodel.View#getModel <em>Model</em>}</li>
 *   <li>{@link org.sidiff.reverseengineering.systemmodel.View#getChanges <em>Changes</em>}</li>
 * </ul>
 *
 * @see org.sidiff.reverseengineering.systemmodel.SystemModelPackage#getView()
 * @model
 * @generated
 */
public interface View extends DescribableElement {
	/**
	 * Returns the value of the '<em><b>System</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.reverseengineering.systemmodel.SystemModel#getViews <em>Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System</em>' container reference.
	 * @see #setSystem(SystemModel)
	 * @see org.sidiff.reverseengineering.systemmodel.SystemModelPackage#getView_System()
	 * @see org.sidiff.reverseengineering.systemmodel.SystemModel#getViews
	 * @model opposite="views" transient="false"
	 * @generated
	 */
	SystemModel getSystem();

	/**
	 * Sets the value of the '{@link org.sidiff.reverseengineering.systemmodel.View#getSystem <em>System</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System</em>' container reference.
	 * @see #getSystem()
	 * @generated
	 */
	void setSystem(SystemModel value);

	/**
	 * Returns the value of the '<em><b>Document Types</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Document Types</em>' attribute list.
	 * @see org.sidiff.reverseengineering.systemmodel.SystemModelPackage#getView_DocumentTypes()
	 * @model
	 * @generated
	 */
	EList<String> getDocumentTypes();

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see #setKind(String)
	 * @see org.sidiff.reverseengineering.systemmodel.SystemModelPackage#getView_Kind()
	 * @model
	 * @generated
	 */
	String getKind();

	/**
	 * Sets the value of the '{@link org.sidiff.reverseengineering.systemmodel.View#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(String value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(EObject)
	 * @see org.sidiff.reverseengineering.systemmodel.SystemModelPackage#getView_Model()
	 * @model
	 * @generated
	 */
	EObject getModel();

	/**
	 * Sets the value of the '{@link org.sidiff.reverseengineering.systemmodel.View#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(EObject value);

	/**
	 * Returns the value of the '<em><b>Changes</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.reverseengineering.systemmodel.Change}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Changes</em>' containment reference list.
	 * @see org.sidiff.reverseengineering.systemmodel.SystemModelPackage#getView_Changes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Change> getChanges();

} // View
