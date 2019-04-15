package org.sidiff.common.emf.adapters;

import org.eclipse.emf.common.notify.Adapter;

/**
 * Interface for EMF adapters provided by SiDiff.
 * @author wenzel
 *
 */
public interface SiDiffAdapter extends Adapter {

	/**
	 * Sets the AdapterFactory which has been used to create this adapter. Has to be called by the factory.
	 * 
	 * @param factory
	 *            AdapterFactory which has been used to create this adapter.
	 */
	public void setAdapterFactory(SiDiffAdapterFactory factory);

}
