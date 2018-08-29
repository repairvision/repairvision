package org.sidiff.history.revision.metamodel.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

public class SubTypeIndex {

	private EPackage ePackage;
	
	private Map<EClass, Set<EClass>> subTypes = new HashMap<>();
	
	public SubTypeIndex(EPackage ePackage) {
		this.ePackage = ePackage;
		createSubtypeIndex(ePackage);
	}
	
	public EPackage getePackage() {
		return ePackage;
	}
	
	/**
	 * @param superType
	 *            A meta-class of the domain model.
	 * @return All corresponding sub-types (i.e. sub-meta-classes).
	 */
	public Set<EClass> getSubTypes(EClass superType) {
		Set<EClass> subTypes = this.subTypes.get(superType);
		
		if (subTypes == null) {
			createSubtypeIndex(superType.getEPackage());
			subTypes = this.subTypes.get(superType);
		}
		
		return subTypes;
	}
	
	private void createSubtypeIndex(EPackage ePackage) {

		// Iterate over all classes in the package
		for (Iterator<EObject> i = ePackage.eAllContents(); i.hasNext();) {
			EObject obj = i.next();

			if (obj instanceof EClass) {
				// Next class (A)
				EClass eSubClass = (EClass) obj;

				if (!subTypes.containsKey(eSubClass)) {
					subTypes.put(eSubClass, new HashSet<EClass>(0));
				}

				// Lookup the super types (X,Y,Z) of class (A) and add
				// class (A) as sub type to the classes (X, Y, Z)
				for (EClass eSuperClass : eSubClass.getEAllSuperTypes()) {
					Set<EClass> allSubTypes = subTypes.get(eSuperClass);

					if (allSubTypes == null) {
						allSubTypes = new HashSet<EClass>(0);
						subTypes.put(eSuperClass, allSubTypes);
					}

					allSubTypes.add(eSubClass);
				}
			}
		}
	}
}
