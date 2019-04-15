package org.sidiff.common.emf.access;

import java.util.*;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.emf.access.path.EMFPath;
import org.sidiff.common.emf.access.value.RemoteAttribute;
import org.sidiff.common.emf.exceptions.UnknownDocumentTypeException;

public class EMFMetaAccess {

	private static final String PACKAGE_DELIMITER_CHAR = ".";
	private static final String PACKAGE_DELIMITER_CHAR_REGEX = "\\.";

	/**
	 * Returns the {@link EClassifier} of the given type from meta model 
	 * with the given package namespace. If the type contains dots, it 
	 * is interpreted as fully qualified name within the meta model.
	 * 
	 * @param packageNS
	 * @param type
	 * @return
	 */
	public static EClassifier getMetaObjectByName(String packageNS, String type) {
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(packageNS);
		// if nsURI of model is not registered, extend the URI with the package path
		if (ePackage == null) {
			String subpackage = type.substring(0, type.lastIndexOf(EMFMetaAccess.PACKAGE_DELIMITER_CHAR)).replaceAll(PACKAGE_DELIMITER_CHAR_REGEX, "/");
			type = type.substring(type.lastIndexOf(EMFMetaAccess.PACKAGE_DELIMITER_CHAR) + 1);
			ePackage = EPackage.Registry.INSTANCE.getEPackage(packageNS + "/" + subpackage);
		}
		if (ePackage == null)
			throw new UnknownDocumentTypeException("Not a valid package namespace. ", packageNS);
		if (type.indexOf(EMFMetaAccess.PACKAGE_DELIMITER_CHAR) == -1)
			return ePackage.getEClassifier(type);
		else {
			String subpackage = type.substring(0, type.lastIndexOf(EMFMetaAccess.PACKAGE_DELIMITER_CHAR));
			ePackage = getSubpackageByName(packageNS, subpackage);
			if (ePackage == null)
				return null;
			return ePackage.getEClassifier(type.substring(type.lastIndexOf(EMFMetaAccess.PACKAGE_DELIMITER_CHAR) + 1));
		}
	}
	
	/**
	 * Returns the {@link EClassifier} of the given type from meta model 
	 * with the given package namespace.
	 * This method invokes {@link getMetaObjectByName} recursively..
	 * 
	 * @param packageNS
	 * @param type
	 * @return
	 */
	public static EClassifier getMetaObjectByNameRecursively(String packageNS, String type) {

		// Call {@link getMetaObjectByName}
		EClassifier result = getMetaObjectByName(packageNS, type);

		// If not already contained in package
		if (result == null) {
			
			EPackage epackage = EPackage.Registry.INSTANCE.getEPackage(packageNS);

			// Iterate through all subpackes and call {@link getClassifier}
			// recursively
			for (EPackage subpackage : epackage.getESubpackages()) {

				result = getMetaObjectByNameRecursively(subpackage.getNsURI(), type);

				// Return if type found
				if (result != null)
					break;
			}

		}
		return result;

	}
	

	/**
	 * Returns a subpackage from the meta model with the given package namespace.
	 * The package name is given as fully qualified name using dots. 
	 * If the given subpackage name is null or empty, the meta model package 
	 * itself is returned.
	 * 
	 * @param packageNS
	 * @param subpackage
	 * @return
	 */
	private static EPackage getSubpackageByName(String packageNS, String subpackage) {
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(packageNS);
		if (ePackage == null)
			throw new UnknownDocumentTypeException("Not a valid package namespace.", packageNS);
		if (subpackage == null || "".equals(subpackage))
			return ePackage;
		return getSubpackageByName(ePackage, subpackage);
	}

	/**
	 * Returns a subpackage of the given package. The package name is given as
	 * fully qualified name using dots starting from the current package.
	 * 
	 * @param packageNS
	 * @param subpackage
	 * @return
	 */
	private static EPackage getSubpackageByName(EPackage ePackage, String subpackage) {
		EPackage result = null;
		String[] subnames = subpackage.split(EMFMetaAccess.PACKAGE_DELIMITER_CHAR_REGEX, 2);
		for (EPackage sub : ePackage.getESubpackages()) {
			if (sub.getName().equals(subnames[0])) {
				result = sub;
				break;
			}
		}
		if (result != null && subnames.length > 1)
			return getSubpackageByName(result, subnames[1]);
		return result;
	}

	/**
	 * Returns a list of the {@link EClassifier}s in the root package of the 
	 * meta model with the given package namespace.
	 * 
	 * @param packageNS
	 * @return
	 */
	public static EList<EClassifier> getMetaClassesForPackage(String packageNS) {
		return getMetaClassesForPackage(packageNS, null);
	}

	/**
	 * Returns a list of the {@link EClassifier}s in one subpackage of the 
	 * meta model with the given package namespace. If the subpackage name is null, 
	 * the classes of the root package are returned.
	 * 
	 * @param packageNS
	 * @param subpackage
	 * @return
	 */
	public static EList<EClassifier> getMetaClassesForPackage(String packageNS, String subpackage) {
		EPackage ePackage = getSubpackageByName(packageNS, subpackage);
		if (ePackage == null)
			throw new UnknownDocumentTypeException("Not a valid package namespace.", packageNS);
		return ePackage.getEClassifiers();
	}

	/**
	 * Returns a list of all {@link EClassifier}s in one meta model with 
	 * the given package namespace.
	 * 
	 * @param packageNS
	 * @return
	 */
	public static EList<EClassifier> getAllMetaClassesForPackage(String packageNS) {
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(packageNS);
		if (ePackage == null)
			throw new UnknownDocumentTypeException("Not a valid package namespace.", packageNS);
		return getAllMetaClassesForPackage(ePackage);
	}

	/**
	 * Returns a list of all {@link EClassifier}s in the given package (including subpackages).
	 * 
	 * @param epackage
	 * @return
	 */
	public static EList<EClassifier> getAllMetaClassesForPackage(EPackage ePackage) {
		EList<EClassifier> result = new BasicEList<EClassifier>();
		result.addAll(ePackage.getEClassifiers());
		for (EPackage sub : ePackage.getESubpackages())
			result.addAll(getAllMetaClassesForPackage(sub));
		return result;
	}

	/**
	 * Takes a comma separated list of names and returns a respective list 
	 * of {@link EClass}es or {@link EClassifier}s (depending on the given type class).
	 * 
	 * @param <T>
	 * @param packageNS
	 * @param commaSepList
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> getMetaObjectListByString(String packageNS, String commaSepList, Class<T> type) {
		List<T> result = new LinkedList<T>();
		String[] names = commaSepList.split(",");
		for (String name : names) {
			result.add((T) getMetaObjectByName(packageNS, name.trim()));
		}
		return Collections.unmodifiableList(result);
	}

	/**
	 * Returns the {@link EReference} with the given name of a type in a meta model.
	 * 
	 * @param packageNS
	 * @param type
	 * @param referenceName
	 * @return
	 */
	public static EReference getMetaReferenceByName(String packageNS, String type, String referenceName) {
		return (EReference) ((EClass) getMetaObjectByName(packageNS, type)).getEStructuralFeature(referenceName);
	}

	/**
	 * Returns a list of all references of the given class, which are not 
	 * container-containment references (i.e. relationships between parents and children)
	 * 
	 * @param eClass
	 * @return
	 */
	public static List<EReference> getReferences(EClass eClass) {
		List<EReference> result = new ArrayList<EReference>();
		for (EReference reference : eClass.getEAllReferences()) {
			if (reference.isContainment() || reference.isContainer())
				continue;
			result.add(reference);
		}
		return Collections.unmodifiableList(result);
	}

	/**
	 * Returns a list of all references of the given class, which are not 
	 * container-containment references and which apply to the given {@link EdgeSemantic}
	 * 
	 * @param eClass
	 * @param semantic
	 * @return
	 */
	public static List<EReference> getReferences(EClass eClass, EdgeSemantic semantic) {
		List<EReference> result = new ArrayList<EReference>();
		for (EReference reference : eClass.getEAllReferences()) {
			if (reference.isContainment() || reference.isContainer() || !semantic.checkSemantic(reference))
				continue;
			result.add(reference);
		}
		return Collections.unmodifiableList(result);
	}

	/**
	 * Returns all references with point to children/containments.
	 * 
	 * @param eClass
	 * @return
	 */
	public static List<EReference> getChildrenReferences(EClass eClass) {
		return Collections.unmodifiableList(eClass.getEAllContainments());

	}

	/**
	 * Returns a list of references. names is thereby a comma separated 
	 * list of names or a regular expression.
	 * 
	 * @param eClass
	 * @param names
	 * @return
	 */
	public static List<EReference> getReferencesByNames(EClass eClass, String names) {
		List<EReference> result = new LinkedList<EReference>();
		if (names.indexOf(",") != -1) {
			String[] names2 = names.split(",");
			for (String refType : names2) {
				EReference ref = (EReference) eClass.getEStructuralFeature(refType);
				if (ref != null)
					result.add(ref);
			}
		} else {
			for (EReference ref : eClass.getEAllReferences()) {
				if (ref.getName().matches(names))
					result.add(ref);
			}
		}
		return Collections.unmodifiableList(result);
	}

	/**
	 * Returns a list of attributes with match a given regular 
	 * expression (regexExpectedResult==true) or not (regexExpectedResult==false)
	 * 
	 * @param eClass
	 * @param regex
	 * @param regexExpectedResult
	 * @return
	 */
	public static List<EAttribute> getAttributesByRegEx(EClass eClass, String regex, boolean regexExpectedResult) {
		List<EAttribute> list = new LinkedList<EAttribute>();
		for (EAttribute att : eClass.getEAllAttributes()) {
			if (att.getName().matches(regex) == regexExpectedResult)
				list.add(att);
		}
		return Collections.unmodifiableList(list);
	}

	/**
	 * Returns a list of structural features with match a given regular 
	 * expression (regexExpectedResult==true) or not (regexExpectedResult==false)
	 * 
	 * @param eClass
	 * @param regex
	 * @param regexExpectedResult
	 * @return
	 */
	public static List<EStructuralFeature> getEStructuralFeaturesByRegEx(EClass eClass, String regex, boolean regexExpectedResult) {
		List<EStructuralFeature> list = new LinkedList<EStructuralFeature>();
		for (EStructuralFeature att : eClass.getEAllStructuralFeatures()) {
			if (att.getName().matches(regex) == regexExpectedResult)
				list.add(att);
		}
		return Collections.unmodifiableList(list);
	}
	
	/**
	 * Returns a handle to evaluate a given Path expression 
	 * 
	 * @param eClass Starting class of the Path expression.
	 * @param path Textual Path expression.
	 * @return A Path Handle to evaluate the Path .
	 */
	public static EMFPath translatePath(EClass eClass, String path) {
		return EMFModelAccess.pathAccessor.translatePath(eClass, path);
	}
	
	/**
	 * Returns a handle to specified RemoteEAttribute for futher usage.
	 *  
	 * @param eClass Starting point of the remote attribute description.
	 * @param eAttributePath An engine specific, textual description.
	 * @return A engine specific handle to the path semantic.
	 */
	public static RemoteAttribute translateRemoteAttribute(EClass eClass, String remoteAttribute){
		return EMFModelAccess.remoteValueAccessor.translateRemoteAttribute(eClass, remoteAttribute);
	}
	
	/**
	 * Tries to infer the result type of a given EMF-Path.
	 * The Method may return null if no common type could be found or the
	 * underlying engine is still not able to infer a result type.
	 * 
	 * @param path The Path whose result type should be inferred.
	 * @return a type (may a supertype) of all objects that could be 
	 * returned as a evaluation result of the given Path.
	 */
	public static EClass inferResultType(EMFPath path){
		return EMFModelAccess.pathAccessor.inferResultType(path);
	}
	
	/**
	 * Resolves the EAttribute of given RemoteEAttribute.
	 * The Method may returns null if no EAttribute could be determed, or the
	 * underlaying engine is still not able to lookup the EAttribute. 
	 * 
	 * @param remoteEAttribute The RemoteEAttribute witchs resultype shoult be inferd.
	 * @return The EAttribute that was adressed by the given remoteEAttribute.
	 */
	public static EAttribute getEAttribute(RemoteAttribute remoteEAttribute){
		return EMFModelAccess.remoteValueAccessor.getEAttribute(remoteEAttribute);
	}

	/**
	 * Returns the (direct) subtypes of the given <code>eClass</code>
	 * in the given <code>ePackages</code>.
	 * 
	 * @param eClass
	 * @param ePackages
	 * @return
	 */
	public static List<EClass> getSubclasses(EClass eClass, EPackage[] ePackages) {
		return getSubclasses(eClass, ePackages, false);
	}
	
	/**
	 * Returns all subtypes of the given <code>eClass</code> in the given <code>ePackages</code>.
	 * 
	 * @param eClass
	 * @param ePackages
	 * @return
	 */
	public static List<EClass> getAllSubclasses(EClass eClass, EPackage[] ePackages) {
		return getSubclasses(eClass, ePackages, true);
	}
	
	private static List<EClass> getSubclasses(EClass eClass, EPackage[] ePackages, boolean all) {
		Set<EClass> allClasses = new HashSet<EClass>();
		for (EPackage ePackage : ePackages) {
			for (EClassifier eClassifier : getAllMetaClassesForPackage(ePackage)) {
				if (eClassifier instanceof EClass) {
					allClasses.add((EClass) eClassifier);
				}
			}
		}
		List<EClass> result = new LinkedList<EClass>();
		for (EClass c : allClasses) {
			if (all){
				if (c.getEAllSuperTypes().contains(eClass)) {
					result.add(c);
				}
			}else{
				if (c.getESuperTypes().contains(eClass)) {
					result.add(c);
				}
			}			
		}
		return Collections.unmodifiableList(result);
	}

	/**
	 * Returns all classes whose instances can be containers of objects of the given type.
	 * @param type
	 * @return
	 */
	public static List<EClass> getContainerClasses(EClass type) {
		ArrayList<EClass> result = new ArrayList<EClass>();
		for (EClassifier type2 : EMFMetaAccess.getAllMetaClassesForPackage(EMFUtil.getRootPackage(type))) {
			if (!(type2 instanceof EClass))
				continue;
			EClass cls = (EClass) type2;
			for (EReference ref : cls.getEAllReferences()) {
				if (ref.isContainment() && (ref.getEType() == type || type.getEAllSuperTypes().contains(ref.getEType()))) {
					result.add(cls);
				}
			}
		}
		return result;
	}
	
	/**
	 * Returns all classes whose instances can be contained by objects of the given type.
	 * @param type
	 * @return
	 */
	public static List<EClass> getChildrenClasses(EClass type) {
		ArrayList<EClass> result = new ArrayList<EClass>();
		for (EReference ref : type.getEAllReferences()) {
			if (ref.isContainment() && ref.getEType() instanceof EClass) {
				for (EClassifier type2 : EMFMetaAccess.getAllMetaClassesForPackage(EMFUtil.getRootPackage(type))) {
					EClass eClass = ((EClass)ref.getEType());
					if (eClass == type2 || (type2 instanceof EClass && ((EClass)type2).getEAllSuperTypes().contains(eClass))) {
						if (!result.contains(type2))
							result.add((EClass)type2);
					}
				}
			}
		}
		return result;
	}
	

	/**
	 * infers and returns the lowest common supertype from 
	 * a collection of classes. in case only one class is in the collection, the class
	 * itself is the common supertype. in case the common supertype 
	 * can't be infered (because there is none or more than one)the EObject EClass is returned
	 * 
	 * @param type
	 * @return the common supertype or EObject EClass (if there is none or more than one)
	 */
	public static EClass inferCommonSupertype(Collection<EClass> classes) {
		
		//just on class -> the class itself is the common supertype
		if (classes.size() == 1) return classes.iterator().next();
		
		//otherwise we have to check for the common supertype

		//copy all supertypes of first eclass into modifiable list
		ArrayList<EClass> supertypeCandidates = new ArrayList<EClass>();
		for (EClass c : classes.iterator().next().getEAllSuperTypes())
			supertypeCandidates.add(c);
		
		// retain all supertypes that are not supertypes of every other eclass
		for (EClass c : classes)
		{	
			BasicEList<EClass> currClass = ((BasicEList<EClass>) c.getEAllSuperTypes());
			supertypeCandidates.retainAll(currClass);
		}	
		
		 
		//now only eclasses are left, that are real supertypes
		//0 or 1 candidates = we can stop here
		if (supertypeCandidates.isEmpty()) return new EcoreFactoryImpl().createEObject().eClass();
		if (supertypeCandidates.size() == 1 ) return supertypeCandidates.get(0);
		
		//otherwise we have to check if we can determine exactly the lowest common supertype
		//if we find more than one, we can't determine the lowest common supertype
		List<EClass> supertypes = new ArrayList<EClass>();
		for (EClass c : supertypeCandidates)
		{
			boolean isLeaf = true;
			
			for (EClass d : supertypeCandidates)
			{
				if (!d.equals(c))
					isLeaf &= !c.isSuperTypeOf(d);
			}
			
			if (isLeaf) supertypes.add(c);
		
		}
	
	//more than one common supertype (emf supports multi-inheritance) 	
	if (supertypes.size() > 1) return new EcoreFactoryImpl().createEObject().eClass();
		
	//otherwise return first element
	return supertypes.get(0);
	}
	
	/**
	 * (Meta-) attributes which are not changeable, derived or transient are
	 * unconsidered while model comparison.
	 * 
	 * @param structualFeatureType
	 *            The attribute to test.
	 * @return <code>true</code> if the attribute is unconsidered while model
	 *         comparison; <code>false</code> otherwise;
	 */
	public static boolean isUnconsideredStructualFeature(EStructuralFeature structualFeatureType) {
		if ((structualFeatureType.isChangeable() == false)
				|| (structualFeatureType.isDerived() == true)
				|| (structualFeatureType.isTransient() == true)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Is class A assignable to class B.
	 * 
	 * @param a
	 *            From class A.
	 * @param b
	 *            To class B.
	 * @return <code>true</code> if A is assignable to B; <code>false</code> otherwise.
	 */
	public static boolean isAssignableTo(EClass a, EClass b) {
		return a.getEAllSuperTypes().contains(b) || a.equals(b) || b.equals(EcorePackage.eINSTANCE.getEObject());
	}
	
	
	/**
	 * Is class A assignable to class B or vice versa.
	 * 
	 * @param a
	 *            Class A
	 * @param b
	 *            Class B
	 * @return <code>true</code> if A is assignable to B or B is assignable to A; <code>false</code> otherwise.
	 */
	public static boolean assignable(EClass a, EClass b) {
		return isAssignableTo(a, b) || isAssignableTo(b, a);
	}
}
