/**
 */
package org.sidiff.historymodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Problem</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.historymodel.Problem#getVersion <em>Version</em>}</li>
 *   <li>{@link org.sidiff.historymodel.Problem#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.historymodel.Problem#getIntroducedIn <em>Introduced In</em>}</li>
 *   <li>{@link org.sidiff.historymodel.Problem#isIntroduced <em>Introduced</em>}</li>
 *   <li>{@link org.sidiff.historymodel.Problem#getResolvedIn <em>Resolved In</em>}</li>
 *   <li>{@link org.sidiff.historymodel.Problem#isResolved <em>Resolved</em>}</li>
 *   <li>{@link org.sidiff.historymodel.Problem#getMessage <em>Message</em>}</li>
 *   <li>{@link org.sidiff.historymodel.Problem#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.sidiff.historymodel.Problem#getPredecessor <em>Predecessor</em>}</li>
 *   <li>{@link org.sidiff.historymodel.Problem#getSuccessor <em>Successor</em>}</li>
 *   <li>{@link org.sidiff.historymodel.Problem#getInvalidElements <em>Invalid Elements</em>}</li>
 *   <li>{@link org.sidiff.historymodel.Problem#getContextElement <em>Context Element</em>}</li>
 *   <li>{@link org.sidiff.historymodel.Problem#getModifications <em>Modifications</em>}</li>
 *   <li>{@link org.sidiff.historymodel.Problem#getModificationClassification <em>Modification Classification</em>}</li>
 *   <li>{@link org.sidiff.historymodel.Problem#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 *
 * @see org.sidiff.historymodel.HistoryModelPackage#getProblem()
 * @model
 * @generated
 */
public interface Problem extends EObject {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.historymodel.Version#getProblems <em>Problems</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' container reference.
	 * @see #setVersion(Version)
	 * @see org.sidiff.historymodel.HistoryModelPackage#getProblem_Version()
	 * @see org.sidiff.historymodel.Version#getProblems
	 * @model opposite="problems" transient="false"
	 * @generated
	 */
	Version getVersion();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.Problem#getVersion <em>Version</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' container reference.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(Version value);

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
	 * @see org.sidiff.historymodel.HistoryModelPackage#getProblem_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.Problem#getName <em>Name</em>}' attribute.
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
	 * @see org.sidiff.historymodel.HistoryModelPackage#getProblem_IntroducedIn()
	 * @model
	 * @generated
	 */
	Version getIntroducedIn();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.Problem#getIntroducedIn <em>Introduced In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Introduced In</em>' reference.
	 * @see #getIntroducedIn()
	 * @generated
	 */
	void setIntroducedIn(Version value);

	/**
	 * Returns the value of the '<em><b>Introduced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Introduced</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Introduced</em>' attribute.
	 * @see org.sidiff.historymodel.HistoryModelPackage#getProblem_Introduced()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isIntroduced();

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
	 * @see org.sidiff.historymodel.HistoryModelPackage#getProblem_ResolvedIn()
	 * @model
	 * @generated
	 */
	Version getResolvedIn();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.Problem#getResolvedIn <em>Resolved In</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolved In</em>' reference.
	 * @see #getResolvedIn()
	 * @generated
	 */
	void setResolvedIn(Version value);

	/**
	 * Returns the value of the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolved</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolved</em>' attribute.
	 * @see org.sidiff.historymodel.HistoryModelPackage#getProblem_Resolved()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isResolved();

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
	 * @see org.sidiff.historymodel.HistoryModelPackage#getProblem_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.Problem#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * The default value is <code>"UNKNOWN"</code>.
	 * The literals are from the enumeration {@link org.sidiff.historymodel.ProblemSeverity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see org.sidiff.historymodel.ProblemSeverity
	 * @see #setSeverity(ProblemSeverity)
	 * @see org.sidiff.historymodel.HistoryModelPackage#getProblem_Severity()
	 * @model default="UNKNOWN"
	 * @generated
	 */
	ProblemSeverity getSeverity();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.Problem#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see org.sidiff.historymodel.ProblemSeverity
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(ProblemSeverity value);

	/**
	 * Returns the value of the '<em><b>Predecessor</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.historymodel.Problem#getSuccessor <em>Successor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predecessor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predecessor</em>' reference.
	 * @see #setPredecessor(Problem)
	 * @see org.sidiff.historymodel.HistoryModelPackage#getProblem_Predecessor()
	 * @see org.sidiff.historymodel.Problem#getSuccessor
	 * @model opposite="successor"
	 * @generated
	 */
	Problem getPredecessor();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.Problem#getPredecessor <em>Predecessor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predecessor</em>' reference.
	 * @see #getPredecessor()
	 * @generated
	 */
	void setPredecessor(Problem value);

	/**
	 * Returns the value of the '<em><b>Successor</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.historymodel.Problem#getPredecessor <em>Predecessor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successor</em>' reference.
	 * @see #setSuccessor(Problem)
	 * @see org.sidiff.historymodel.HistoryModelPackage#getProblem_Successor()
	 * @see org.sidiff.historymodel.Problem#getPredecessor
	 * @model opposite="predecessor"
	 * @generated
	 */
	Problem getSuccessor();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.Problem#getSuccessor <em>Successor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Successor</em>' reference.
	 * @see #getSuccessor()
	 * @generated
	 */
	void setSuccessor(Problem value);

	/**
	 * Returns the value of the '<em><b>Invalid Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invalid Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invalid Elements</em>' reference list.
	 * @see org.sidiff.historymodel.HistoryModelPackage#getProblem_InvalidElements()
	 * @model changeable="false"
	 * @generated
	 */
	EList<EObject> getInvalidElements();

	/**
	 * Returns the value of the '<em><b>Context Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Element</em>' reference.
	 * @see #setContextElement(EObject)
	 * @see org.sidiff.historymodel.HistoryModelPackage#getProblem_ContextElement()
	 * @model
	 * @generated
	 */
	EObject getContextElement();

	/**
	 * Sets the value of the '{@link org.sidiff.historymodel.Problem#getContextElement <em>Context Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Element</em>' reference.
	 * @see #getContextElement()
	 * @generated
	 */
	void setContextElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Modifications</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.historymodel.ChangeSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifications</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifications</em>' containment reference list.
	 * @see org.sidiff.historymodel.HistoryModelPackage#getProblem_Modifications()
	 * @model containment="true"
	 * @generated
	 */
	EList<ChangeSet> getModifications();

	/**
	 * Returns the value of the '<em><b>Modification Classification</b></em>' attribute list.
	 * The list contents are of type {@link org.sidiff.historymodel.ModificationClassification}.
	 * The literals are from the enumeration {@link org.sidiff.historymodel.ModificationClassification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modification Classification</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modification Classification</em>' attribute list.
	 * @see org.sidiff.historymodel.ModificationClassification
	 * @see org.sidiff.historymodel.HistoryModelPackage#getProblem_ModificationClassification()
	 * @model default="UNKNOWN"
	 * @generated
	 */
	EList<ModificationClassification> getModificationClassification();

	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.historymodel.Annotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference list.
	 * @see org.sidiff.historymodel.HistoryModelPackage#getProblem_Annotations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Annotation> getAnnotations();

} // Problem
