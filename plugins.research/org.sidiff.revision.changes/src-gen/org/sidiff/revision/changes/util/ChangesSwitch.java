/**
 */
package org.sidiff.revision.changes.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sidiff.revision.changes.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.sidiff.revision.changes.ChangesPackage
 * @generated
 */
public class ChangesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ChangesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangesSwitch() {
		if (modelPackage == null) {
			modelPackage = ChangesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case ChangesPackage.CHANGE: {
			Change change = (Change) theEObject;
			T result = caseChange(change);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.NODE_CHANGE: {
			NodeChange nodeChange = (NodeChange) theEObject;
			T result = caseNodeChange(nodeChange);
			if (result == null)
				result = caseChange(nodeChange);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.NODE_DOMAIN: {
			NodeDomain nodeDomain = (NodeDomain) theEObject;
			T result = caseNodeDomain(nodeDomain);
			if (result == null)
				result = caseNodeInstantiation(nodeDomain);
			if (result == null)
				result = caseChangeInstantiation(nodeDomain);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.NODE_BINDING: {
			NodeBinding nodeBinding = (NodeBinding) theEObject;
			T result = caseNodeBinding(nodeBinding);
			if (result == null)
				result = caseNodeInstantiation(nodeBinding);
			if (result == null)
				result = caseChangeInstantiation(nodeBinding);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.ATTRIBUTE_DOMAIN: {
			AttributeDomain attributeDomain = (AttributeDomain) theEObject;
			T result = caseAttributeDomain(attributeDomain);
			if (result == null)
				result = caseAttributeInstantiation(attributeDomain);
			if (result == null)
				result = caseChangeInstantiation(attributeDomain);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.ATTRIBUTE_CHANGE: {
			AttributeChange attributeChange = (AttributeChange) theEObject;
			T result = caseAttributeChange(attributeChange);
			if (result == null)
				result = caseChange(attributeChange);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.ATTRIBUTE_BINDING: {
			AttributeBinding attributeBinding = (AttributeBinding) theEObject;
			T result = caseAttributeBinding(attributeBinding);
			if (result == null)
				result = caseAttributeInstantiation(attributeBinding);
			if (result == null)
				result = caseChangeInstantiation(attributeBinding);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.EDGE_CHANGE: {
			EdgeChange edgeChange = (EdgeChange) theEObject;
			T result = caseEdgeChange(edgeChange);
			if (result == null)
				result = caseChange(edgeChange);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.EDGE_DOMAIN: {
			EdgeDomain edgeDomain = (EdgeDomain) theEObject;
			T result = caseEdgeDomain(edgeDomain);
			if (result == null)
				result = caseEdgeInstantiation(edgeDomain);
			if (result == null)
				result = caseChangeInstantiation(edgeDomain);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.EDGE_BINDING: {
			EdgeBinding edgeBinding = (EdgeBinding) theEObject;
			T result = caseEdgeBinding(edgeBinding);
			if (result == null)
				result = caseEdgeInstantiation(edgeBinding);
			if (result == null)
				result = caseChangeInstantiation(edgeBinding);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.ATTRIBUTE_INSTANTIATION: {
			AttributeInstantiation attributeInstantiation = (AttributeInstantiation) theEObject;
			T result = caseAttributeInstantiation(attributeInstantiation);
			if (result == null)
				result = caseChangeInstantiation(attributeInstantiation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.CHANGE_INSTANTIATION: {
			ChangeInstantiation changeInstantiation = (ChangeInstantiation) theEObject;
			T result = caseChangeInstantiation(changeInstantiation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.NODE_INSTANTIATION: {
			NodeInstantiation nodeInstantiation = (NodeInstantiation) theEObject;
			T result = caseNodeInstantiation(nodeInstantiation);
			if (result == null)
				result = caseChangeInstantiation(nodeInstantiation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.EDGE_INSTANTIATION: {
			EdgeInstantiation edgeInstantiation = (EdgeInstantiation) theEObject;
			T result = caseEdgeInstantiation(edgeInstantiation);
			if (result == null)
				result = caseChangeInstantiation(edgeInstantiation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.ATTRIBUTE_NODE_DOMAIN_DEFINITION: {
			AttributeNodeDomainDefinition attributeNodeDomainDefinition = (AttributeNodeDomainDefinition) theEObject;
			T result = caseAttributeNodeDomainDefinition(attributeNodeDomainDefinition);
			if (result == null)
				result = caseAttributeDomain(attributeNodeDomainDefinition);
			if (result == null)
				result = caseAttributeInstantiation(attributeNodeDomainDefinition);
			if (result == null)
				result = caseChangeInstantiation(attributeNodeDomainDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.ATTRIBUTE_VALUE_DOMAIN_DEFINITION: {
			AttributeValueDomainDefinition attributeValueDomainDefinition = (AttributeValueDomainDefinition) theEObject;
			T result = caseAttributeValueDomainDefinition(attributeValueDomainDefinition);
			if (result == null)
				result = caseAttributeDomain(attributeValueDomainDefinition);
			if (result == null)
				result = caseAttributeInstantiation(attributeValueDomainDefinition);
			if (result == null)
				result = caseChangeInstantiation(attributeValueDomainDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.ATTRIBUTE_NODE_DOMAIN: {
			AttributeNodeDomain attributeNodeDomain = (AttributeNodeDomain) theEObject;
			T result = caseAttributeNodeDomain(attributeNodeDomain);
			if (result == null)
				result = caseAttributeNodeDomainDefinition(attributeNodeDomain);
			if (result == null)
				result = caseAttributeDomain(attributeNodeDomain);
			if (result == null)
				result = caseAttributeInstantiation(attributeNodeDomain);
			if (result == null)
				result = caseChangeInstantiation(attributeNodeDomain);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.ATTRIBUTE_VALUE_DOMAIN: {
			AttributeValueDomain attributeValueDomain = (AttributeValueDomain) theEObject;
			T result = caseAttributeValueDomain(attributeValueDomain);
			if (result == null)
				result = caseAttributeValueDomainDefinition(attributeValueDomain);
			if (result == null)
				result = caseAttributeDomain(attributeValueDomain);
			if (result == null)
				result = caseAttributeInstantiation(attributeValueDomain);
			if (result == null)
				result = caseChangeInstantiation(attributeValueDomain);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.ATTRIBUTE_NODE_BINDING: {
			AttributeNodeBinding attributeNodeBinding = (AttributeNodeBinding) theEObject;
			T result = caseAttributeNodeBinding(attributeNodeBinding);
			if (result == null)
				result = caseAttributeBinding(attributeNodeBinding);
			if (result == null)
				result = caseAttributeInstantiation(attributeNodeBinding);
			if (result == null)
				result = caseChangeInstantiation(attributeNodeBinding);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.ATTRIBUTE_VALUE_BINDING: {
			AttributeValueBinding attributeValueBinding = (AttributeValueBinding) theEObject;
			T result = caseAttributeValueBinding(attributeValueBinding);
			if (result == null)
				result = caseAttributeBinding(attributeValueBinding);
			if (result == null)
				result = caseAttributeInstantiation(attributeValueBinding);
			if (result == null)
				result = caseChangeInstantiation(attributeValueBinding);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.EDGE_SOURCE_DOMAIN_DEFINITION: {
			EdgeSourceDomainDefinition edgeSourceDomainDefinition = (EdgeSourceDomainDefinition) theEObject;
			T result = caseEdgeSourceDomainDefinition(edgeSourceDomainDefinition);
			if (result == null)
				result = caseEdgeDomain(edgeSourceDomainDefinition);
			if (result == null)
				result = caseEdgeInstantiation(edgeSourceDomainDefinition);
			if (result == null)
				result = caseChangeInstantiation(edgeSourceDomainDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.EDGE_TARGET_DOMAIN_DEFINITION: {
			EdgeTargetDomainDefinition edgeTargetDomainDefinition = (EdgeTargetDomainDefinition) theEObject;
			T result = caseEdgeTargetDomainDefinition(edgeTargetDomainDefinition);
			if (result == null)
				result = caseEdgeDomain(edgeTargetDomainDefinition);
			if (result == null)
				result = caseEdgeInstantiation(edgeTargetDomainDefinition);
			if (result == null)
				result = caseChangeInstantiation(edgeTargetDomainDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.EDGE_SOURCE_DOMAIN: {
			EdgeSourceDomain edgeSourceDomain = (EdgeSourceDomain) theEObject;
			T result = caseEdgeSourceDomain(edgeSourceDomain);
			if (result == null)
				result = caseEdgeSourceDomainDefinition(edgeSourceDomain);
			if (result == null)
				result = caseEdgeDomain(edgeSourceDomain);
			if (result == null)
				result = caseEdgeInstantiation(edgeSourceDomain);
			if (result == null)
				result = caseChangeInstantiation(edgeSourceDomain);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.EDGE_TARGET_DOMAIN: {
			EdgeTargetDomain edgeTargetDomain = (EdgeTargetDomain) theEObject;
			T result = caseEdgeTargetDomain(edgeTargetDomain);
			if (result == null)
				result = caseEdgeTargetDomainDefinition(edgeTargetDomain);
			if (result == null)
				result = caseEdgeDomain(edgeTargetDomain);
			if (result == null)
				result = caseEdgeInstantiation(edgeTargetDomain);
			if (result == null)
				result = caseChangeInstantiation(edgeTargetDomain);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.EDGE_SOURCE_BINDING: {
			EdgeSourceBinding edgeSourceBinding = (EdgeSourceBinding) theEObject;
			T result = caseEdgeSourceBinding(edgeSourceBinding);
			if (result == null)
				result = caseEdgeBinding(edgeSourceBinding);
			if (result == null)
				result = caseEdgeInstantiation(edgeSourceBinding);
			if (result == null)
				result = caseChangeInstantiation(edgeSourceBinding);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.EDGE_TARGET_BINDING: {
			EdgeTargetBinding edgeTargetBinding = (EdgeTargetBinding) theEObject;
			T result = caseEdgeTargetBinding(edgeTargetBinding);
			if (result == null)
				result = caseEdgeBinding(edgeTargetBinding);
			if (result == null)
				result = caseEdgeInstantiation(edgeTargetBinding);
			if (result == null)
				result = caseChangeInstantiation(edgeTargetBinding);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.NODE_CHANGE_DOMAIN_DEFINITION: {
			NodeChangeDomainDefinition nodeChangeDomainDefinition = (NodeChangeDomainDefinition) theEObject;
			T result = caseNodeChangeDomainDefinition(nodeChangeDomainDefinition);
			if (result == null)
				result = caseNodeDomain(nodeChangeDomainDefinition);
			if (result == null)
				result = caseNodeInstantiation(nodeChangeDomainDefinition);
			if (result == null)
				result = caseChangeInstantiation(nodeChangeDomainDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ChangesPackage.NODE_CHANGE_DOMAIN: {
			NodeChangeDomain nodeChangeDomain = (NodeChangeDomain) theEObject;
			T result = caseNodeChangeDomain(nodeChangeDomain);
			if (result == null)
				result = caseNodeChangeDomainDefinition(nodeChangeDomain);
			if (result == null)
				result = caseNodeDomain(nodeChangeDomain);
			if (result == null)
				result = caseNodeInstantiation(nodeChangeDomain);
			if (result == null)
				result = caseChangeInstantiation(nodeChangeDomain);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChange(Change object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeChange(NodeChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeDomain(NodeDomain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeBinding(NodeBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeDomain(AttributeDomain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeChange(AttributeChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeBinding(AttributeBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Change</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Change</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgeChange(EdgeChange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgeDomain(EdgeDomain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgeBinding(EdgeBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Instantiation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Instantiation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeInstantiation(AttributeInstantiation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Change Instantiation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Change Instantiation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChangeInstantiation(ChangeInstantiation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Instantiation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Instantiation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeInstantiation(NodeInstantiation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Instantiation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Instantiation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgeInstantiation(EdgeInstantiation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Node Domain Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Node Domain Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeNodeDomainDefinition(AttributeNodeDomainDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Value Domain Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Value Domain Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeValueDomainDefinition(AttributeValueDomainDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Node Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Node Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeNodeDomain(AttributeNodeDomain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Value Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Value Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeValueDomain(AttributeValueDomain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Node Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Node Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeNodeBinding(AttributeNodeBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Value Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Value Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeValueBinding(AttributeValueBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Source Domain Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Source Domain Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgeSourceDomainDefinition(EdgeSourceDomainDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Target Domain Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Target Domain Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgeTargetDomainDefinition(EdgeTargetDomainDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Source Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Source Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgeSourceDomain(EdgeSourceDomain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Target Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Target Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgeTargetDomain(EdgeTargetDomain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Source Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Source Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgeSourceBinding(EdgeSourceBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge Target Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge Target Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdgeTargetBinding(EdgeTargetBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Change Domain Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Change Domain Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeChangeDomainDefinition(NodeChangeDomainDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Change Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Change Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeChangeDomain(NodeChangeDomain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ChangesSwitch
