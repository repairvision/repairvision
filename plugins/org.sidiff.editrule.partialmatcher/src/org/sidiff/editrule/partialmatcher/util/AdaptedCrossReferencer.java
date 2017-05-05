package org.sidiff.editrule.partialmatcher.util;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class AdaptedCrossReferencer implements ICrossReferencer {

	private ECrossReferenceAdapter adapter;
	
	public AdaptedCrossReferencer(ResourceSet resourceSet) {
		adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(resourceSet);
		
		if (adapter == null) {
			adapter = new ECrossReferenceAdapter();
			resourceSet.eAdapters().add(adapter);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.sidiff.editrule.partialmatcher.util.ICrossReferencer#getInverse(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EReference)
	 */
	@Override
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
	}
}
