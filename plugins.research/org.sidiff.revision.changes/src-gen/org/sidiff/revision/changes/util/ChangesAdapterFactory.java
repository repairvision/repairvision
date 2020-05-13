/**
 */
package org.sidiff.revision.changes.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.sidiff.revision.changes.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.revision.changes.ChangesPackage
 * @generated
 */
public class ChangesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ChangesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ChangesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangesSwitch<Adapter> modelSwitch = new ChangesSwitch<Adapter>() {
		@Override
		public Adapter caseChange(Change object) {
			return createChangeAdapter();
		}

		@Override
		public Adapter caseNodeChange(NodeChange object) {
			return createNodeChangeAdapter();
		}

		@Override
		public Adapter caseNodeDomain(NodeDomain object) {
			return createNodeDomainAdapter();
		}

		@Override
		public Adapter caseNodeBinding(NodeBinding object) {
			return createNodeBindingAdapter();
		}

		@Override
		public Adapter caseAttributeDomain(AttributeDomain object) {
			return createAttributeDomainAdapter();
		}

		@Override
		public Adapter caseAttributeChange(AttributeChange object) {
			return createAttributeChangeAdapter();
		}

		@Override
		public Adapter caseAttributeBinding(AttributeBinding object) {
			return createAttributeBindingAdapter();
		}

		@Override
		public Adapter caseEdgeChange(EdgeChange object) {
			return createEdgeChangeAdapter();
		}

		@Override
		public Adapter caseEdgeDomain(EdgeDomain object) {
			return createEdgeDomainAdapter();
		}

		@Override
		public Adapter caseEdgeBinding(EdgeBinding object) {
			return createEdgeBindingAdapter();
		}

		@Override
		public Adapter caseAttributeInstantiation(AttributeInstantiation object) {
			return createAttributeInstantiationAdapter();
		}

		@Override
		public Adapter caseChangeInstantiation(ChangeInstantiation object) {
			return createChangeInstantiationAdapter();
		}

		@Override
		public Adapter caseNodeInstantiation(NodeInstantiation object) {
			return createNodeInstantiationAdapter();
		}

		@Override
		public Adapter caseEdgeInstantiation(EdgeInstantiation object) {
			return createEdgeInstantiationAdapter();
		}

		@Override
		public Adapter caseAttributeNodeDomainDefinition(AttributeNodeDomainDefinition object) {
			return createAttributeNodeDomainDefinitionAdapter();
		}

		@Override
		public Adapter caseAttributeValueDomainDefinition(AttributeValueDomainDefinition object) {
			return createAttributeValueDomainDefinitionAdapter();
		}

		@Override
		public Adapter caseAttributeNodeDomain(AttributeNodeDomain object) {
			return createAttributeNodeDomainAdapter();
		}

		@Override
		public Adapter caseAttributeValueDomain(AttributeValueDomain object) {
			return createAttributeValueDomainAdapter();
		}

		@Override
		public Adapter caseAttributeNodeBinding(AttributeNodeBinding object) {
			return createAttributeNodeBindingAdapter();
		}

		@Override
		public Adapter caseAttributeValueBinding(AttributeValueBinding object) {
			return createAttributeValueBindingAdapter();
		}

		@Override
		public Adapter caseEdgeSourceDomainDefinition(EdgeSourceDomainDefinition object) {
			return createEdgeSourceDomainDefinitionAdapter();
		}

		@Override
		public Adapter caseEdgeTargetDomainDefinition(EdgeTargetDomainDefinition object) {
			return createEdgeTargetDomainDefinitionAdapter();
		}

		@Override
		public Adapter caseEdgeSourceDomain(EdgeSourceDomain object) {
			return createEdgeSourceDomainAdapter();
		}

		@Override
		public Adapter caseEdgeTargetDomain(EdgeTargetDomain object) {
			return createEdgeTargetDomainAdapter();
		}

		@Override
		public Adapter caseEdgeSourceBinding(EdgeSourceBinding object) {
			return createEdgeSourceBindingAdapter();
		}

		@Override
		public Adapter caseEdgeTargetBinding(EdgeTargetBinding object) {
			return createEdgeTargetBindingAdapter();
		}

		@Override
		public Adapter caseNodeChangeDomainDefinition(NodeChangeDomainDefinition object) {
			return createNodeChangeDomainDefinitionAdapter();
		}

		@Override
		public Adapter caseNodeChangeDomain(NodeChangeDomain object) {
			return createNodeChangeDomainAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.Change <em>Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.Change
	 * @generated
	 */
	public Adapter createChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.NodeChange <em>Node Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.NodeChange
	 * @generated
	 */
	public Adapter createNodeChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.NodeDomain <em>Node Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.NodeDomain
	 * @generated
	 */
	public Adapter createNodeDomainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.NodeBinding <em>Node Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.NodeBinding
	 * @generated
	 */
	public Adapter createNodeBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.AttributeDomain <em>Attribute Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.AttributeDomain
	 * @generated
	 */
	public Adapter createAttributeDomainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.AttributeChange <em>Attribute Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.AttributeChange
	 * @generated
	 */
	public Adapter createAttributeChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.AttributeBinding <em>Attribute Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.AttributeBinding
	 * @generated
	 */
	public Adapter createAttributeBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.EdgeChange <em>Edge Change</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.EdgeChange
	 * @generated
	 */
	public Adapter createEdgeChangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.EdgeDomain <em>Edge Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.EdgeDomain
	 * @generated
	 */
	public Adapter createEdgeDomainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.EdgeBinding <em>Edge Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.EdgeBinding
	 * @generated
	 */
	public Adapter createEdgeBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.AttributeInstantiation <em>Attribute Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.AttributeInstantiation
	 * @generated
	 */
	public Adapter createAttributeInstantiationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.ChangeInstantiation <em>Change Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.ChangeInstantiation
	 * @generated
	 */
	public Adapter createChangeInstantiationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.NodeInstantiation <em>Node Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.NodeInstantiation
	 * @generated
	 */
	public Adapter createNodeInstantiationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.EdgeInstantiation <em>Edge Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.EdgeInstantiation
	 * @generated
	 */
	public Adapter createEdgeInstantiationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.AttributeNodeDomainDefinition <em>Attribute Node Domain Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.AttributeNodeDomainDefinition
	 * @generated
	 */
	public Adapter createAttributeNodeDomainDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.AttributeValueDomainDefinition <em>Attribute Value Domain Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.AttributeValueDomainDefinition
	 * @generated
	 */
	public Adapter createAttributeValueDomainDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.AttributeNodeDomain <em>Attribute Node Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.AttributeNodeDomain
	 * @generated
	 */
	public Adapter createAttributeNodeDomainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.AttributeValueDomain <em>Attribute Value Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.AttributeValueDomain
	 * @generated
	 */
	public Adapter createAttributeValueDomainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.AttributeNodeBinding <em>Attribute Node Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.AttributeNodeBinding
	 * @generated
	 */
	public Adapter createAttributeNodeBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.AttributeValueBinding <em>Attribute Value Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.AttributeValueBinding
	 * @generated
	 */
	public Adapter createAttributeValueBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.EdgeSourceDomainDefinition <em>Edge Source Domain Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.EdgeSourceDomainDefinition
	 * @generated
	 */
	public Adapter createEdgeSourceDomainDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.EdgeTargetDomainDefinition <em>Edge Target Domain Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.EdgeTargetDomainDefinition
	 * @generated
	 */
	public Adapter createEdgeTargetDomainDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.EdgeSourceDomain <em>Edge Source Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.EdgeSourceDomain
	 * @generated
	 */
	public Adapter createEdgeSourceDomainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.EdgeTargetDomain <em>Edge Target Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.EdgeTargetDomain
	 * @generated
	 */
	public Adapter createEdgeTargetDomainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.EdgeSourceBinding <em>Edge Source Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.EdgeSourceBinding
	 * @generated
	 */
	public Adapter createEdgeSourceBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.EdgeTargetBinding <em>Edge Target Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.EdgeTargetBinding
	 * @generated
	 */
	public Adapter createEdgeTargetBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.NodeChangeDomainDefinition <em>Node Change Domain Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.NodeChangeDomainDefinition
	 * @generated
	 */
	public Adapter createNodeChangeDomainDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sidiff.revision.changes.NodeChangeDomain <em>Node Change Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sidiff.revision.changes.NodeChangeDomain
	 * @generated
	 */
	public Adapter createNodeChangeDomainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ChangesAdapterFactory
