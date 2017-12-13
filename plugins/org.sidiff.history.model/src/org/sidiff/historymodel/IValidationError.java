/**
 */
package org.sidiff.historymodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IValidation Error</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.historymodel.IValidationError#getIntroducedIn <em>Introduced In</em>}</li>
 *   <li>{@link org.sidiff.historymodel.IValidationError#getResolvedIn <em>Resolved In</em>}</li>
 *   <li>{@link org.sidiff.historymodel.IValidationError#getException <em>Exception</em>}</li>
 *   <li>{@link org.sidiff.historymodel.IValidationError#getMessage <em>Message</em>}</li>
 *   <li>{@link org.sidiff.historymodel.IValidationError#getSource <em>Source</em>}</li>
 *   <li>{@link org.sidiff.historymodel.IValidationError#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.sidiff.historymodel.IValidationError#getCharacterizingMessageFragment <em>Characterizing Message Fragment</em>}</li>
 *   <li>{@link org.sidiff.historymodel.IValidationError#isResolved <em>Resolved</em>}</li>
 *   <li>{@link org.sidiff.historymodel.IValidationError#getPrec <em>Prec</em>}</li>
 *   <li>{@link org.sidiff.historymodel.IValidationError#getSucc <em>Succ</em>}</li>
 *   <li>{@link org.sidiff.historymodel.IValidationError#getInvalidElement <em>Invalid Element</em>}</li>
 * </ul>
 *
 * @see org.sidiff.historymodel.HistoryModelPackage#getIValidationError()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IValidationError extends EObject {
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
	 * @see org.sidiff.historymodel.HistoryModelPackage#getIValidationError_IntroducedIn()
	 * @model
	 * @generated
	 */
	Version getIntroducedIn();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.IValidationError#getIntroducedIn <em>Introduced In</em>}' reference.
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
	 * @see org.sidiff.historymodel.HistoryModelPackage#getIValidationError_ResolvedIn()
	 * @model
	 * @generated
	 */
	Version getResolvedIn();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.IValidationError#getResolvedIn <em>Resolved In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved In</em>' reference.
	 * @see #getResolvedIn()
	 * @generated
	 */
	void setResolvedIn(Version value);

	/**
	 * Returns the value of the '<em><b>Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception</em>' attribute.
	 * @see #setException(Throwable)
	 * @see org.sidiff.historymodel.HistoryModelPackage#getIValidationError_Exception()
	 * @model dataType="org.sidiff.historymodel.Throwable"
	 * @generated
	 */
	Throwable getException();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.IValidationError#getException <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception</em>' attribute.
	 * @see #getException()
	 * @generated
	 */
	void setException(Throwable value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.sidiff.historymodel.HistoryModelPackage#getIValidationError_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.IValidationError#getMessage <em>Message</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see org.sidiff.historymodel.HistoryModelPackage#getIValidationError_Source()
	 * @model
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.IValidationError#getSource <em>Source</em>}' attribute.
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
	 * The literals are from the enumeration {@link org.sidiff.historymodel.ValidationSeverity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see org.sidiff.historymodel.ValidationSeverity
	 * @see #setSeverity(ValidationSeverity)
	 * @see org.sidiff.historymodel.HistoryModelPackage#getIValidationError_Severity()
	 * @model default="UNKNOWN"
	 * @generated
	 */
	ValidationSeverity getSeverity();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.IValidationError#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see org.sidiff.historymodel.ValidationSeverity
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(ValidationSeverity value);

	/**
	 * Returns the value of the '<em><b>Characterizing Message Fragment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Characterizing Message Fragment</em>' attribute.
	 * @see #setCharacterizingMessageFragment(String)
	 * @see org.sidiff.historymodel.HistoryModelPackage#getIValidationError_CharacterizingMessageFragment()
	 * @model
	 * @generated
	 */
	String getCharacterizingMessageFragment();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.IValidationError#getCharacterizingMessageFragment <em>Characterizing Message Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Characterizing Message Fragment</em>' attribute.
	 * @see #getCharacterizingMessageFragment()
	 * @generated
	 */
	void setCharacterizingMessageFragment(String value);

	/**
	 * Returns the value of the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolved</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved</em>' attribute.
	 * @see org.sidiff.historymodel.HistoryModelPackage#getIValidationError_Resolved()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isResolved();

	/**
	 * Returns the value of the '<em><b>Prec</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.historymodel.IValidationError#getSucc <em>Succ</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prec</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prec</em>' reference.
	 * @see #setPrec(IValidationError)
	 * @see org.sidiff.historymodel.HistoryModelPackage#getIValidationError_Prec()
	 * @see org.sidiff.historymodel.IValidationError#getSucc
	 * @model opposite="succ"
	 * @generated
	 */
	IValidationError getPrec();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.IValidationError#getPrec <em>Prec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prec</em>' reference.
	 * @see #getPrec()
	 * @generated
	 */
	void setPrec(IValidationError value);

	/**
	 * Returns the value of the '<em><b>Succ</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.historymodel.IValidationError#getPrec <em>Prec</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Succ</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Succ</em>' reference.
	 * @see #setSucc(IValidationError)
	 * @see org.sidiff.historymodel.HistoryModelPackage#getIValidationError_Succ()
	 * @see org.sidiff.historymodel.IValidationError#getPrec
	 * @model opposite="prec"
	 * @generated
	 */
	IValidationError getSucc();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.IValidationError#getSucc <em>Succ</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Succ</em>' reference.
	 * @see #getSucc()
	 * @generated
	 */
	void setSucc(IValidationError value);

	/**
	 * Returns the value of the '<em><b>Invalid Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invalid Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invalid Element</em>' reference.
	 * @see org.sidiff.historymodel.HistoryModelPackage#getIValidationError_InvalidElement()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EObject getInvalidElement();

} // IValidationError
