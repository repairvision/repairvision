package org.sidiff.candidates.type;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.collections.Classifier;

/**
 * Classifiers to be used with the ClassificationUtil.
 */
public class EMFClassifiers {

	/**
	 * Classifies EObjects by their EClass
	 */
	public final static Classifier<EClass, EObject> ELEMENT_BY_CLASS = new Classifier<EClass, EObject>() {
		@Override
		public EClass classify(EObject item) {
			return item.eClass();
		}
	};
}
