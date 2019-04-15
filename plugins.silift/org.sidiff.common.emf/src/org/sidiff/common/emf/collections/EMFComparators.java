package org.sidiff.common.emf.collections;

import java.util.Comparator;

import org.eclipse.emf.ecore.*;
import org.sidiff.common.emf.EMFAdapter;
import org.sidiff.common.emf.annotation.AnnotateableElement;

/**
 * Different comparators to be used for EMF objects.
 * @author wenzel / reuling
 *
 */
public class EMFComparators {
	
	/**
	 * Compares EAttributes by their names. 
	 */
	public static Comparator<EAttribute> ATTRIBUTE_BY_NAME = new Comparator<EAttribute>(){
		@Override
		public int compare(EAttribute eAttribute0, EAttribute eAttribute1) {
			return eAttribute1.getName().compareTo(eAttribute0.getName());
		}
	};
	
	/**
	 * Compares EReferences by their names. 
	 */
	public static Comparator<EReference> REFERENCE_BY_NAME = new Comparator<EReference>(){
		@Override
		public int compare(EReference eReference0, EReference eReference1) {
			return eReference1.getName().compareTo(eReference0.getName());
		}
	};
	
	/**
	 * Compares EObjects by their annotation value stored under the given key.
	 * @param annotationKey
	 * @return
	 */
	public static Comparator<EObject> createObjectByAnnotationComparator(final String annotationKey) {
		return new Comparator<EObject>() {
			@Override
			public int compare(EObject obj1, EObject obj2) {
				AnnotateableElement annotateable1 = EMFAdapter.INSTANCE.adapt(obj1, AnnotateableElement.class);
				AnnotateableElement annotateable2 = EMFAdapter.INSTANCE.adapt(obj2, AnnotateableElement.class);
				String value1 = (String) annotateable1.getAnnotation(annotationKey, String.class);
				String value2 = (String) annotateable2.getAnnotation(annotationKey, String.class);
				if (value1==null && value2==null)
					return 0;
				if (value1==null && value2!=null)
					return 1;
				if (value1!=null && value2==null)
					return -1;
				return value1.compareTo(value2);
			}
		};
	}
	
	/**
	 * Compares EObjects by their types. 
	 */
	public static Comparator<EObject> EOBJECT_BY_TYPE = new Comparator<EObject>(){
		@Override
		public int compare(EObject obj1, EObject obj2) {
			return obj2.eClass().getName().compareTo(obj1.eClass().getName());
		}
	};
}
