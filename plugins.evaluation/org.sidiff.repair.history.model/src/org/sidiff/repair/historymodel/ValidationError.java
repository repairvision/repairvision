/**
 */
package org.sidiff.repair.historymodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Validation Error</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.repair.historymodel.ValidationError#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.ValidationError#getIntroducedIn <em>Introduced In</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.ValidationError#getResolvedIn <em>Resolved In</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.ValidationError#getMessage <em>Message</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.ValidationError#getSource <em>Source</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.ValidationError#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.ValidationError#isIntroduced <em>Introduced</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.ValidationError#isResolved <em>Resolved</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.ValidationError#getPrec <em>Prec</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.ValidationError#getSucc <em>Succ</em>}</li>
 *   <li>{@link org.sidiff.repair.historymodel.ValidationError#getInvalidElement <em>Invalid Element</em>}</li>
 * </ul>
 *
 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getValidationError()
 * @model
 * @generated
 */
public interface ValidationError extends EObject {
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
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getValidationError_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.historymodel.ValidationError#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Introduced In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Introduced In</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Introduced In</em>' reference.
	 * @see #setIntroducedIn(Version)
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getValidationError_IntroducedIn()
	 * @model
	 * @generated
	 */
	Version getIntroducedIn();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.historymodel.ValidationError#getIntroducedIn <em>Introduced In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Introduced In</em>' reference.
	 * @see #getIntroducedIn()
	 * @generated
	 */
	void setIntroducedIn(Version value);

	/**
	 * Returns the value of the '<em><b>Resolved In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolved In</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved In</em>' reference.
	 * @see #setResolvedIn(Version)
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getValidationError_ResolvedIn()
	 * @model
	 * @generated
	 */
	Version getResolvedIn();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.historymodel.ValidationError#getResolvedIn <em>Resolved In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved In</em>' reference.
	 * @see #getResolvedIn()
	 * @generated
	 */
	void setResolvedIn(Version value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getValidationError_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.historymodel.ValidationError#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getValidationError_Source()
	 * @model
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.historymodel.ValidationError#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * The default value is <code>"UNKNOWN"</code>.
	 * The literals are from the enumeration {@link org.sidiff.repair.historymodel.ValidationSeverity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see org.sidiff.repair.historymodel.ValidationSeverity
	 * @see #setSeverity(ValidationSeverity)
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getValidationError_Severity()
	 * @model default="UNKNOWN"
	 * @generated
	 */
	ValidationSeverity getSeverity();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.historymodel.ValidationError#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see org.sidiff.repair.historymodel.ValidationSeverity
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(ValidationSeverity value);

	/**
	 * Returns the value of the '<em><b>Introduced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Introduced</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Introduced</em>' attribute.
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getValidationError_Introduced()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isIntroduced();

	/**
	 * Returns the value of the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolved</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved</em>' attribute.
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getValidationError_Resolved()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isResolved();

	/**
	 * Returns the value of the '<em><b>Prec</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.repair.historymodel.ValidationError#getSucc <em>Succ</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prec</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prec</em>' reference.
	 * @see #setPrec(ValidationError)
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getValidationError_Prec()
	 * @see org.sidiff.repair.historymodel.ValidationError#getSucc
	 * @model opposite="succ"
	 * @generated
	 */
	ValidationError getPrec();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.historymodel.ValidationError#getPrec <em>Prec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prec</em>' reference.
	 * @see #getPrec()
	 * @generated
	 */
	void setPrec(ValidationError value);

	/**
	 * Returns the value of the '<em><b>Succ</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.repair.historymodel.ValidationError#getPrec <em>Prec</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Succ</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Succ</em>' reference.
	 * @see #setSucc(ValidationError)
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getValidationError_Succ()
	 * @see org.sidiff.repair.historymodel.ValidationError#getPrec
	 * @model opposite="prec"
	 * @generated
	 */
	ValidationError getSucc();

	/**
	 * Sets the value of the '{@link org.sidiff.repair.historymodel.ValidationError#getSucc <em>Succ</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Succ</em>' reference.
	 * @see #getSucc()
	 * @generated
	 */
	void setSucc(ValidationError value);

	/**
	 * Returns the value of the '<em><b>Invalid Element</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invalid Element</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invalid Element</em>' reference list.
	 * @see org.sidiff.repair.historymodel.HistoryModelPackage#getValidationError_InvalidElement()
	 * @model changeable="false"
	 * @generated
	 */
	EList<EObject> getInvalidElement();

} // ValidationError
