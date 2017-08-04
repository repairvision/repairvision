package org.sidiff.consistency.common.emf;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

public class ModelingUtil {
	
	public static Iterator<EObject> getRootPath(EObject element) {
		return new Iterator<EObject>() {
			
			private EObject location = element;
			
			@Override
			public EObject next() {
				location = location.eContainer();
				return location;
			}
			
			@Override
			public boolean hasNext() {
				return location.eContainer() != null;
			}
		};
	}

	/**
	 * Creates a deep copy (i.e. full tree content) of the given object.
	 * 
	 * @param original
	 *            The root object which will be copied.
	 * @return The copy trace: Original -> Copy
	 */
	public static Map<EObject, EObject> deepCopy(EObject original) {

		// Copier = Map: Original -> Copy
		Copier copier = new Copier();

		// Root:
		copier.copy(original);

		// References:
		copier.copyReferences();

		return copier;
	}

	/**
	 * Creates a deep copy (i.e. full tree content) of the given resource.
	 * 
	 * @param original
	 *            The resource which will be copied.
	 * @param copy
	 *            An empty target resource.
	 * 
	 * @return The copy trace: Original -> Copy
	 */
	public static Map<EObject, EObject> deepCopy(Resource original, Resource copy) {
		Map<EObject, EObject> trace = null;

		for (EObject root : original.getContents()) {
			Map<EObject, EObject> rootTrace = deepCopy(root);
			copy.getContents().add(rootTrace.get(root));

			if (trace == null) {
				trace = rootTrace;
			} else {
				trace.putAll(trace);
			}
		}

		return trace;
	}

	/**
	 * Creates a of the given object.
	 * 
	 * @param original
	 *            The object which will be copied.
	 * @return The copied object.
	 */
	public static EObject copy(EObject original) {

		// Copier = Map: Original -> Copy
		@SuppressWarnings("serial")
		Copier copier = new Copier() {

			@Override
			public EObject copy(EObject eObject) {
				if (eObject == null) {
					return null;
				} else {
					EObject copyEObject = createCopy(eObject);

					if (copyEObject != null) {
						put(eObject, copyEObject);
						EClass eClass = eObject.eClass();

						for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i) {
							EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);

							if (eStructuralFeature.isChangeable() && !eStructuralFeature.isDerived()) {
								if (eStructuralFeature instanceof EAttribute) {
									copyAttribute((EAttribute) eStructuralFeature, eObject, copyEObject);
								}
							}
						}

						copyProxyURI(eObject, copyEObject);
					}

					return copyEObject;
				}
			}
		};

		copier.copy(original);
		return copier.get(original);
	}

	/**
	 * @param copy
	 *            The copied object.
	 * @param copyTrace
	 *            The copy trace: Original -> Copy
	 * @return The original object.
	 */
	public static EObject getReverseTrace(EObject copy, Map<EObject, EObject> copyTrace) {

		for (Entry<EObject, EObject> trace : copyTrace.entrySet()) {
			if (trace.getValue() == copy) {
				return trace.getKey();
			}
		}

		return null;
	}
	
	public static String getNames(Collection<? extends EObject> objects) {
		StringBuffer string = new StringBuffer();
		
		string.append("[");
		
		for (EObject object : objects) {
			string.append(getName(object));
			string.append(", ");
		}
		string.replace(string.length() - 2, string.length(), "");
		string.append("]");
		
		return string.toString();
	}
	
	public static String getName(EObject obj) {
		try {
			return (String) obj.eGet(obj.eClass().getEStructuralFeature("name"));
		} catch (Exception e) {
			return "" + obj;
		}
	}
}
