package org.sidiff.common.emf.adapters;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * Standard implementation of a SiDiffAdapter
 * @author wenzel
 *
 */
public class SiDiffAdapterImpl extends AdapterImpl implements SiDiffAdapter {

	private SiDiffAdapterFactory adapterFactory;

	public void setAdapterFactory(SiDiffAdapterFactory factory) {
		adapterFactory = factory;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		super.setTarget(newTarget);
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return adapterFactory.isFactoryForType(type);
	}

}
