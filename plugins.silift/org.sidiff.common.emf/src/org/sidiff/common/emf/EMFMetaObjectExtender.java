package org.sidiff.common.emf;

import java.util.*;

import org.eclipse.emf.ecore.*;

/**
 * Utility class to store configurations that are assigned to metamodel elements.
 * @param <T>
 */
public class EMFMetaObjectExtender<T> {

	private EPackage ePackage = null;
	private Map<EClassifier, T> map = null;

	public EMFMetaObjectExtender(String packageNsUri) {
		this(EPackage.Registry.INSTANCE.getEPackage(packageNsUri));
	}

	public EMFMetaObjectExtender(EPackage ePackage) {

		if (ePackage != null) {
			this.ePackage = ePackage;
			this.map = new HashMap<EClassifier, T>();
		} else {
			throw new IllegalArgumentException("Package cannot be null!");
		}
	}

	public T putData(String classifierName, T data) {
		if (classifierName != null) {
			EClassifier classifier = this.ePackage.getEClassifier(classifierName);
			if (classifier != null) {
				return this.map.put(classifier, data);
			} else {
				throw new IllegalArgumentException("Metaobject '" + classifierName + "' not found in Package '" + this.ePackage.getName() + "'");
			}
		} else {
			throw new IllegalArgumentException("No name given");
		}
	}

	public T putData(EClassifier classifier, T data) {
		if (classifier != null) {
			return this.map.put(classifier, data);
		} else {
			throw new IllegalArgumentException("No classifier given");
		}
	}

	public T getDataByInstance(EObject instance) {
		return getDataByMetaObject(instance.eClass());
	}

	public T getDataByMetaObject(EClassifier classifier) {
		return this.map.get(classifier);
	}

	public Collection<T> values() {
		return Collections.unmodifiableCollection(map.values());
	}
	
	public Set<EClassifier> keySet(){
		return Collections.unmodifiableSet(map.keySet());
	}
}
