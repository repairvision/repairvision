package org.sidiff.historymodel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.sidiff.historymodel.Version;

public class EObjectResolvingEListByVersion<E> extends EObjectResolvingEList<E> {

	private static final long serialVersionUID = 1L;
	
	private Version version;

	public EObjectResolvingEListByVersion(Class<?> dataClass, InternalEObject owner, int featureID, Version version) {
		super(dataClass, owner, featureID);
		this.version = version;
	}
	
	@Override
	protected EObject resolveProxy(EObject eObject) {
		return eObject.eIsProxy() ? version.eResolveProxyByVersion((InternalEObject)eObject) : eObject;
	}
}
