/**
 */
package org.sidiff.consistency.graphpattern.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.sidiff.consistency.graphpattern.EObjectList;
import org.sidiff.consistency.graphpattern.GraphpatternPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EObject List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.consistency.graphpattern.impl.EObjectListImpl#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EObjectListImpl extends MinimalEObjectImpl.Container implements EObjectList {
	/**
	 * The cached value of the '{@link #getContent() <em>Content</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContent()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> content;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EObjectListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphpatternPackage.Literals.EOBJECT_LIST;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EObject> getContent() {
		if (content == null) {
			content = new NoneUniqueList<EObject>(EObject.class, this, GraphpatternPackage.EOBJECT_LIST__CONTENT);
		}
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphpatternPackage.EOBJECT_LIST__CONTENT:
				return getContent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphpatternPackage.EOBJECT_LIST__CONTENT:
				getContent().clear();
				getContent().addAll((Collection<? extends EObject>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GraphpatternPackage.EOBJECT_LIST__CONTENT:
				getContent().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GraphpatternPackage.EOBJECT_LIST__CONTENT:
				return content != null && !content.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		StringBuffer print = new StringBuffer();
		print.append("List@" + Integer.toHexString(this.hashCode()) + "<EObject> (size: " + getContent().size() + "):\n");
		
		for (EObject content : getContent()) {
			print.append("  " + content + "\n");
		}
		
		return print.toString();
	}
	
	// FIXME: By generation!?
	private class NoneUniqueList<E> extends EObjectResolvingEList<E> {

		private static final long serialVersionUID = 2212011175983499758L;

		public NoneUniqueList(Class<?> dataClass, InternalEObject owner, int featureID) {
			super(dataClass, owner, featureID);
		}
		
		@Override
		protected boolean isUnique() {
			return false;
		}
	}

} //EObjectListImpl
