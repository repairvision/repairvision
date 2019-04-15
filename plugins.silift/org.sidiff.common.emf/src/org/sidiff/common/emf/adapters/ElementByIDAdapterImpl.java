package org.sidiff.common.emf.adapters;

import java.util.TreeMap;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.exceptions.SiDiffRuntimeException;

/**
 * Adapter that holds an index of all model elements inside a resource.
 * The adapter is assigned to a Resource.
 * @author wenzel
 *
 */
public class ElementByIDAdapterImpl extends SiDiffAdapterImpl implements ElementByIDAdapter {

	private TreeMap<Object, EObject> map;
	
	public ElementByIDAdapterImpl(Resource resource) {
		map = new TreeMap<Object, EObject>();
		TreeIterator<EObject> ti = resource.getAllContents();
		while (ti.hasNext()) {
			EObject element = ti.next();
			Object id = EMFUtil.getEObjectID(element);
			if (map.containsKey(id))
				throw new SiDiffRuntimeException("IDs are not unique!");
			map.put(id, element);
		}
	}
	
	@Override
	public EObject getElement(String id) {
		return map.get(id);
	}

}
