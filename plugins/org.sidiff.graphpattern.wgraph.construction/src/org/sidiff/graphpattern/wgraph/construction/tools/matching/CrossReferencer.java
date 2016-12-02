package org.sidiff.graphpattern.wgraph.construction.tools.matching;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class CrossReferencer {

	private ECrossReferenceAdapter adapter;
	
	/**
	 * @param modelElement
	 *            Any object of the model.
	 */
	public CrossReferencer(ResourceSet resourceSet) {
		adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(resourceSet);
		
		if (adapter == null) {
			adapter = new ECrossReferenceAdapter();
			resourceSet.eAdapters().add(adapter);
		}
	}
	
	public Iterator<? extends EObject> getInverse(EObject source, EReference inverse) {

		Iterator<EStructuralFeature.Setting> it = new EcoreUtil.FilteredSettingsIterator(
				adapter.getNonNavigableInverseReferences(source, true), inverse, null);

		return new Iterator<EObject>() {

			@Override
			public boolean hasNext() {
				return it.hasNext();
			}

			@Override
			public EObject next() {
				return it.next().getEObject();
			}
		};
		
//		List<EObject> crossReferences = new ArrayList<EObject>();
//		it.forEachRemaining(crossReference -> crossReferences.add(crossReference.getEObject()));
//		
//		return crossReferences;
	}

//	private static Notifier getContext(EObject object) {
//		EObject root = EcoreUtil.getRootContainer(object);
//		Resource resource = root.eResource();
//		
//		if (resource != null) {
//			ResourceSet resourceSet = resource.getResourceSet();
//			return resourceSet != null ? (Notifier) resourceSet : resource;
//		}
//		
//		return root;
//	}
}
