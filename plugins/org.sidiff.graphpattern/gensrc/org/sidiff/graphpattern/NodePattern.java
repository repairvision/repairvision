/**
 */
package org.sidiff.graphpattern;

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
 *   <li>{@link org.sidiff.graphpattern.NodePattern#getOutgoings <em>Outgoings</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.NodePattern#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.NodePattern#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.NodePattern#getMatching <em>Matching</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.NodePattern#getIncomings <em>Incomings</em>}</li>
 *   <li>{@link org.sidiff.graphpattern.NodePattern#getAssociations <em>Associations</em>}</li>
 * </ul>
 *
 * @see org.sidiff.graphpattern.GraphpatternPackage#getNodePattern()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='TheNameOfANodeMustBeUniqueWithinAGraph'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot TheNameOfANodeMustBeUniqueWithinAGraph='not(self.graph.nodes-&gt;exists(n | n &lt;&gt; self and n.name &lt;&gt; null and n.name = self.name))'"
 * @generated
 */
public interface NodePattern extends GraphElement {
	/**
	 * Returns the value of the '<em><b>Outgoings</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.EdgePattern}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.EdgePattern#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoings</em>' containment reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getNodePattern_Outgoings()
	 * @see org.sidiff.graphpattern.EdgePattern#getSource
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
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getNodePattern_Type()
	 * @model required="true"
	 * @generated
	 */
	EClass getType();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.NodePattern#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClass value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.AttributePattern}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.AttributePattern#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getNodePattern_Attributes()
	 * @see org.sidiff.graphpattern.AttributePattern#getNode
	 * @model opposite="node" containment="true"
	 * @generated
	 */
	EList<AttributePattern> getAttributes();

	/**
	 * Returns the value of the '<em><b>Matching</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.Matching#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matching</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matching</em>' containment reference.
	 * @see #setMatching(Matching)
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getNodePattern_Matching()
	 * @see org.sidiff.graphpattern.Matching#getNode
	 * @model opposite="node" containment="true"
	 * @generated
	 */
	Matching getMatching();

	/**
	 * Sets the value of the '{@link org.sidiff.graphpattern.NodePattern#getMatching <em>Matching</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matching</em>' containment reference.
	 * @see #getMatching()
	 * @generated
	 */
	void setMatching(Matching value);

	/**
	 * Returns the value of the '<em><b>Incomings</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.EdgePattern}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.EdgePattern#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incomings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incomings</em>' reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getNodePattern_Incomings()
	 * @see org.sidiff.graphpattern.EdgePattern#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<EdgePattern> getIncomings();
	
	/**
	 * Returns the value of the '<em><b>Associations</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.graphpattern.Association}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.graphpattern.Association#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associations</em>' containment reference list.
	 * @see org.sidiff.graphpattern.GraphpatternPackage#getNodePattern_Associations()
	 * @see org.sidiff.graphpattern.Association#getSource
	 * @model opposite="source" containment="true"
	 * @generated
	 */
	EList<Association> getAssociations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<EdgePattern> getOutgoings(EReference type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EdgePattern getIncoming(EReference type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<EdgePattern> getIncomings(EReference type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<EdgePattern> getIncident();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<EdgePattern> getIncident(NodePattern adjacent);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<EdgePattern> removeIncident();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<EdgePattern> removeIncident(NodePattern node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<NodePattern> getAdjacent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	AttributePattern getAttribute(EAttribute type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EdgePattern getOutgoing(EReference type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EdgePattern getOutgoing(EReference type, NodePattern target);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EdgePattern getOutgoing(EReference type, NodePattern target, Stereotype stereotype);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	void removeEdge(EdgePattern edge);

} // NodePattern
