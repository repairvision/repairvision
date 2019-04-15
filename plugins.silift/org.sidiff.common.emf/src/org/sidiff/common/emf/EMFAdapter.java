package org.sidiff.common.emf;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.emf.adapters.SiDiffAdapterFactory;
import org.sidiff.common.emf.modelstorage.ModelStorage;

/**
 * We implemented our own EMFAdapter registry for comfortabily and speedup reasons.
 */
public class EMFAdapter {
	
	private List<AdapterFactory> factories=null;
	
	public EMFAdapter() {
		this.factories = new ArrayList<AdapterFactory>();
	}

	public boolean addAdapterFactory(SiDiffAdapterFactory e) {
		ModelStorage.getInstance().registerAdapterFactory(e);
		return factories.add(e);
	}

	public boolean removeAdapterFactory(SiDiffAdapterFactory o) {
		ModelStorage.getInstance().unregisterAdapterFactory(o);
		return factories.remove(o);
	}

	@SuppressWarnings("unchecked")
	public <T> T adapt(Notifier target, Class<T> type) {
		
		AdapterFactory factory = EcoreUtil.getAdapterFactory(factories, type);
		if (factory != null) {
			return (T) factory.adapt(target, type);
		} 
		if (target instanceof EObject)
			return (T)EcoreUtil.getRegisteredAdapter((EObject)target, type);
		else if (target instanceof Resource)
			return (T)EcoreUtil.getRegisteredAdapter((Resource)target, type);
		else
			throw new UnsupportedOperationException("EMFAdapter cannot adapt "+target.getClass().getName());
	}

	public static EMFAdapter INSTANCE = new EMFAdapter();
}
