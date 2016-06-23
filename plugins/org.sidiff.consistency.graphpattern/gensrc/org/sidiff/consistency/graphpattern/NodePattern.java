/**
 */
package org.sidiff.consistency.graphpattern;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.NodePattern#getOutgoings <em>Outgoings</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.NodePattern#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.NodePattern#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.NodePattern#getEvaluation <em>Evaluation</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.NodePattern#getGraph <em>Graph</em>}</li>
 *   <li>{@link org.sidiff.consistency.graphpattern.NodePattern#getIncomings <em>Incomings</em>}</li>
 * </ul>
 *
 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getNodePattern()
 * @model
 * @generated
 */
public interface NodePattern extends GraphPredicate {
	/**
	 * Returns the value of the '<em><b>Outgoings</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.consistency.graphpattern.EdgePattern}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.consistency.graphpattern.EdgePattern#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoings</em>' containment reference list.
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getNodePattern_Outgoings()
	 * @see org.sidiff.consistency.graphpattern.EdgePattern#getSource
	 * @model opposite="source" containment="true"
	 * @generated
	 */
	EList<EdgePattern> getOutgoings();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EClass)
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getNodePattern_Type()
	 * @model required="true"
	 * @generated
	 */
	EClass getType();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.NodePattern#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClass value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.consistency.graphpattern.AttributePattern}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.consistency.graphpattern.AttributePattern#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getNodePattern_Attributes()
	 * @see org.sidiff.consistency.graphpattern.AttributePattern#getNode
	 * @model opposite="node" containment="true"
	 * @generated
	 */
	EList<AttributePattern> getAttributes();

	/**
	 * Returns the value of the '<em><b>Evaluation</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.consistency.graphpattern.Evaluation#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evaluation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evaluation</em>' containment reference.
	 * @see #setEvaluation(Evaluation)
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getNodePattern_Evaluation()
	 * @see org.sidiff.consistency.graphpattern.Evaluation#getNode
	 * @model opposite="node" containment="true" transient="true"
	 * @generated
	 */
	Evaluation getEvaluation();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.NodePattern#getEvaluation <em>Evaluation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Evaluation</em>' containment reference.
	 * @see #getEvaluation()
	 * @generated
	 */
	void setEvaluation(Evaluation value);

	/**
	 * Returns the value of the '<em><b>Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.consistency.graphpattern.GraphPattern#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' container reference.
	 * @see #setGraph(GraphPattern)
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getNodePattern_Graph()
	 * @see org.sidiff.consistency.graphpattern.GraphPattern#getNodes
	 * @model opposite="nodes" required="true" transient="false"
	 * @generated
	 */
	GraphPattern getGraph();

	/**
	 * Sets the value of the '{@link org.sidiff.consistency.graphpattern.NodePattern#getGraph <em>Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' container reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(GraphPattern value);

	/**
	 * Returns the value of the '<em><b>Incomings</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.consistency.graphpattern.EdgePattern}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.consistency.graphpattern.EdgePattern#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incomings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incomings</em>' reference list.
	 * @see org.sidiff.consistency.graphpattern.GraphpatternPackage#getNodePattern_Incomings()
	 * @see org.sidiff.consistency.graphpattern.EdgePattern#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<EdgePattern> getIncomings();

	// TODO -> Model
	EdgePattern getOutgoing(EReference type);
	
	// TODO -> Model
	EdgePattern getIncoming(EReference type);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<EdgePattern> getEdges(EReference type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	AttributePattern getAttribute(EAttribute type);

} // NodePattern
