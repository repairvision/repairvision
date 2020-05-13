/**
 */
package org.sidiff.historymodel.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.sidiff.historymodel.util.HistoryModelResourceFactoryImpl
 * @generated
 */
public class HistoryModelResourceImpl extends XMIResourceImpl {
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public HistoryModelResourceImpl(URI uri) {
		super(uri);
	}
	
	@Override
	protected boolean assignIDsWhileLoading() {
		return true;
	}
	
	@Override
	protected boolean useUUIDs() {
		return true;
	}
} //HistoryModelResourceImpl
