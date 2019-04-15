package org.sidiff.common.emf.collections;

import java.util.List;

import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.collections.Selector;
import org.sidiff.common.emf.access.EMFMetaAccess;

/**
 * Different selectors to be used by the FilterUtil and the ViewUtil.
 * @author wenzel
 *
 */
public class EMFSelectors {
	
	/**
	 * Filters EObjects by a given EClass.
	 * @param eClass
	 * @return
	 */
	public static Selector<EObject> byClass(final EClass eClass) {
		return new Selector<EObject>(){
			public boolean select(EObject item) {
				//return eClass == item.eClass();
				return eClass.isSuperTypeOf(item.eClass());
			}
		};
	}
	
	/**
	 * Filters EObjects that are an instance of the given EClass or subclasses.
	 * @param eClass
	 * @return
	 */
	public static Selector<EObject> byInstance(final EClass eClass) {
		return new Selector<EObject>(){
			public boolean select(EObject item) {
				return eClass.isInstance(item);
			}
		};
	}

	/**
	 * Filters elements by the given resource.
	 * @param resource
	 * @return
	 */
	public static Selector<EObject> byResource(final Resource resource) {
		return new Selector<EObject>(){
			public boolean select(EObject item) {
				return item.eResource()==resource;
			}
		};
	}
	
	/**
	 * Filters elements by the given metamodel.
	 * @param metamodelPackage
	 * @return
	 */
	public static Selector<EObject> byMetaModel(EPackage metamodelPackage) {
		final List<EClassifier> classes = EMFMetaAccess.getAllMetaClassesForPackage(metamodelPackage);
		return new Selector<EObject>(){
			public boolean select(EObject item) {
				return classes.contains(item.eClass());
			}
		};
	}

}
