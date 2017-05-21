package org.sidiff.editrule.partialmatcher.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

public class IndexedCrossReferencer implements ICrossReferencer {

	private Map<EClass, List<EReference>> incomingReferences = new HashMap<>();

	private Map<EObject, List<List<EObject>>> crossReferences = new HashMap<>();
	
	public List<EReference> getIncomingReferences(EClass type) {
		return incomingReferences.get(type);
	}
	
	@Override
	public Iterator<? extends EObject> getInverse(EObject source, EReference incoming) {
		if (incoming.isContainment()) {
			return Collections.singletonList(source.eContainer()).iterator();
		} else {
			List<List<EObject>> sourceAllCrossReferences = crossReferences.get(source);
			
			if (sourceAllCrossReferences != null) {
				int featureIndex = getFeatureIndex(source, incoming);
				
				if (featureIndex < sourceAllCrossReferences.size()) {
					List<EObject> sourceCrossReferences = sourceAllCrossReferences.get(featureIndex);
					
					if (sourceCrossReferences != null) {
						return sourceCrossReferences.iterator();
					}
				}
			}
		}
		
		return Collections.emptyIterator();
	}
	
	public static boolean hasOpposite(EReference reference) {
		return ((reference.getEOpposite() == null) && !reference.isContainment());
	}
	
	@SuppressWarnings("unchecked")
	public void addResource(Resource resource) {
		
		for (Iterator<EObject> iterator = resource.getAllContents(); iterator.hasNext();) {
			EObject source = iterator.next();

			for (EReference reference : source.eClass().getEAllReferences()) {
				if (hasOpposite(reference)) {
					
					if (reference.isMany()) {
						for (EObject target : (Iterable<EObject>) source.eGet(reference)) {
							addInverse(source, reference, target);
						}
					} else {
						EObject target = (EObject) source.eGet(reference);
						addInverse(source, reference, target);
					}
				}
			}
		}
	}

	private void addInverse(EObject source, EReference reference, EObject target) {
		if (target != null) {
			List<List<EObject>> incomings = crossReferences.get(target);
			int featureIndex = getFeatureIndex(target, reference);
			
			if (incomings == null) {
				incomings = new ArrayList<>(5);
				crossReferences.put(target, incomings);
			}
			
			if (featureIndex >= incomings.size()) {
				List<EObject> incoming = new ArrayList<>(5);
				incoming.add(source);
				
				for (int i = incomings.size(); i <= featureIndex; i++) {
					if (i == featureIndex) {
						incomings.add(incoming);
					} else {
						incomings.add(null);
					}
				}
			} else {
				List<EObject> incoming = incomings.get(featureIndex);
				
				if (incoming == null) {
					incoming = new ArrayList<>(5);
					incomings.set(featureIndex, incoming);
				}
				
				incomings.get(featureIndex).add(source);
			}
		}
	}

	private int getFeatureIndex(EObject obj, EReference incoming) {
		List<EReference> incomings = incomingReferences.get(obj.eClass());
		
		if (incomings == null) {
			incomings = new ArrayList<>(5);
			incomings.add(incoming);
			incomingReferences.put(obj.eClass(), incomings);
			return 0;
		} else {
			int featureIndex = incomings.indexOf(incoming);
			
			if (featureIndex == -1) {
				incomings.add(incoming);
				return incomings.size() - 1;
			} else {
				return featureIndex;
			}
		}
	}
}
