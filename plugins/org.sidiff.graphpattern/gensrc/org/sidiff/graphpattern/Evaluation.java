/**
 */
package org.sidiff.graphpattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Evaluation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.graphpattern.Evaluation#getNode <em>Node</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.Evaluation#getMatches <em>Matches</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.Evaluation#getStore <em>Store</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getEvaluation()
 * @model
 * @generated
 */
public interface Evaluation extends EObject {
	/**
	 * Returns the value of the '<em><b>Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.NodePattern#getEvaluation <em>Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' container reference.
	 * @see #setNode(NodePattern)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getEvaluation_Node()
	 * @see org.sidiff.graphpattern.NodePattern#getEvaluation
	 * @model opposite="evaluation" required="true"
	 * @generated
	 */
	NodePattern getNode();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.Evaluation#getNode <em>Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' container reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(NodePattern value);

	/**
	 * Returns the value of the '<em><b>Matches</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matches</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matches</em>' reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getEvaluation_Matches()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<EObject> getMatches();

	/**
	 * Returns the value of the '<em><b>Store</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.DataStore#getEvaluation <em>Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Store</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Store</em>' reference.
	 * @see #setStore(DataStore)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getEvaluation_Store()
	 * @see org.sidiff.graphpattern.DataStore#getEvaluation
	 * @model opposite="evaluation" required="true"
	 * @generated
	 */
	DataStore getStore();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.Evaluation#getStore <em>Store</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Store</em>' reference.
	 * @see #getStore()
	 * @generated
	 */
	void setStore(DataStore value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void initialize();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void accept(Visitor visitor);

} // Evaluation
