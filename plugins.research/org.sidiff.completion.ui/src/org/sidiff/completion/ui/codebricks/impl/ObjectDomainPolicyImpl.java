/**
 */
package org.sidiff.completion.ui.codebricks.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.sidiff.completion.ui.codebricks.CodebricksPackage;
import org.sidiff.completion.ui.codebricks.ObjectDomainPolicy;
import org.sidiff.completion.ui.codebricks.ObjectPlaceholderBrick;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Domain Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ObjectDomainPolicyImpl extends MinimalEObjectImpl.Container implements ObjectDomainPolicy {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectDomainPolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodebricksPackage.Literals.OBJECT_DOMAIN_POLICY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<EObject> getDomain(ObjectPlaceholderBrick brick) {
		return ECollections.emptyEList();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void assignObject(ObjectPlaceholderBrick brick, EObject element) {
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case CodebricksPackage.OBJECT_DOMAIN_POLICY___GET_DOMAIN__OBJECTPLACEHOLDERBRICK:
				return getDomain((ObjectPlaceholderBrick)arguments.get(0));
			case CodebricksPackage.OBJECT_DOMAIN_POLICY___ASSIGN_OBJECT__OBJECTPLACEHOLDERBRICK_EOBJECT:
				assignObject((ObjectPlaceholderBrick)arguments.get(0), (EObject)arguments.get(1));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //ObjectDomainPolicyImpl
