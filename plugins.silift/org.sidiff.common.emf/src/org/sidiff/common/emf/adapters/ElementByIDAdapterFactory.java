package org.sidiff.common.emf.adapters;

import org.eclipse.emf.common.notify.*;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Factory for ElementByID adapters.
 * @author wenzel
 *
 */
public class ElementByIDAdapterFactory extends SiDiffAdapterFactory implements AdapterFactory {

	@Override
	protected Adapter createAdapter(Notifier target) {
		if (!(target instanceof Resource)) {
			throw new UnsupportedOperationException("ElementByIDAdapterFactory can only adapt Resource objects!");
		}
		SiDiffAdapter adapter = new ElementByIDAdapterImpl((Resource)target);
		adapter.setTarget(target);
		adapter.setAdapterFactory(this);
		return adapter;
	}

	public ElementByIDAdapterFactory() {
		super(ElementByIDAdapter.class);
	}

	@Override
	protected SiDiffAdapter createAdapter() {
		return null;
	}

}
