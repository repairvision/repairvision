/**
 */
package org.sidiff.historymodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.historymodel.Version#getProblems <em>Problems</em>}</li>
 *   <li>{@link org.sidiff.historymodel.Version#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.historymodel.Version#getModelURI <em>Model URI</em>}</li>
 *   <li>{@link org.sidiff.historymodel.Version#getModel <em>Model</em>}</li>
 *   <li>{@link org.sidiff.historymodel.Version#getStatus <em>Status</em>}</li>
 *   <li>{@link org.sidiff.historymodel.Version#getRepositoryVersion <em>Repository Version</em>}</li>
 *   <li>{@link org.sidiff.historymodel.Version#getHistory <em>History</em>}</li>
 * </ul>
 *
 * @see org.sidiff.historymodel.HistoryModelPackage#getVersion()
 * @model
 * @generated
 */
public interface Version extends EObject {
	/**
	 * Returns the value of the '<em><b>Problems</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.historymodel.Problem}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.historymodel.Problem#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Problems</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Problems</em>' containment reference list.
	 * @see org.sidiff.historymodel.HistoryModelPackage#getVersion_Problems()
	 * @see org.sidiff.historymodel.Problem#getVersion
	 * @model opposite="version" containment="true"
	 * @generated
	 */
	EList<Problem> getProblems();

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
	 * @see org.sidiff.historymodel.HistoryModelPackage#getVersion_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.Version#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Model URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model URI</em>' attribute.
	 * @see #setModelURI(String)
	 * @see org.sidiff.historymodel.HistoryModelPackage#getVersion_ModelURI()
	 * @model
	 * @generated
	 */
	String getModelURI();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.Version#getModelURI <em>Model URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model URI</em>' attribute.
	 * @see #getModelURI()
	 * @generated
	 */
	void setModelURI(String value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' attribute.
	 * @see #setModel(Resource)
	 * @see org.sidiff.historymodel.HistoryModelPackage#getVersion_Model()
	 * @model dataType="org.sidiff.historymodel.Resource" transient="true" derived="true"
	 * @generated
	 */
	Resource getModel();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.Version#getModel <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' attribute.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(Resource value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The default value is <code>"UNKNOWN"</code>.
	 * The literals are from the enumeration {@link org.sidiff.historymodel.ModelStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see org.sidiff.historymodel.ModelStatus
	 * @see #setStatus(ModelStatus)
	 * @see org.sidiff.historymodel.HistoryModelPackage#getVersion_Status()
	 * @model default="UNKNOWN"
	 * @generated
	 */
	ModelStatus getStatus();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.Version#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see org.sidiff.historymodel.ModelStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(ModelStatus value);

	/**
	 * Returns the value of the '<em><b>Repository Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Version</em>' attribute.
	 * @see #setRepositoryVersion(String)
	 * @see org.sidiff.historymodel.HistoryModelPackage#getVersion_RepositoryVersion()
	 * @model
	 * @generated
	 */
	String getRepositoryVersion();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.Version#getRepositoryVersion <em>Repository Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Version</em>' attribute.
	 * @see #getRepositoryVersion()
	 * @generated
	 */
	void setRepositoryVersion(String value);

	/**
	 * Returns the value of the '<em><b>History</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.historymodel.History#getVersions <em>Versions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>History</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>History</em>' container reference.
	 * @see #setHistory(History)
	 * @see org.sidiff.historymodel.HistoryModelPackage#getVersion_History()
	 * @see org.sidiff.historymodel.History#getVersions
	 * @model opposite="versions" transient="false"
	 * @generated
	 */
	History getHistory();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.Version#getHistory <em>History</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>History</em>' container reference.
	 * @see #getHistory()
	 * @generated
	 */
	void setHistory(History value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EObject getElement(String id);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Version getPredecessor();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Version getSuccessor();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getIndex();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	EObject eResolveProxyByVersion(InternalEObject proxy);

} // Version
