/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.difference.symmetric.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.sidiff.common.stringresolver.util.LabelPrinter;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.SymmetricPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ChangeImpl extends EObjectImpl implements Change {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SymmetricPackage.Literals.CHANGE;
	}
	
	/**
	 * @return The label printer of this difference which generates human
	 *         readable strings for the changes.
	 *         
	 * @generated NOT
	 */
	public LabelPrinter getLabelPrinter() {
		EObject container = eContainer();
		
		if ((container != null) && (container instanceof SymmetricDifferenceImpl)) {
			return ((SymmetricDifferenceImpl) container).getLabelPrinter();
		}

		return new LabelPrinter(null);
	}

} //ChangeImpl
