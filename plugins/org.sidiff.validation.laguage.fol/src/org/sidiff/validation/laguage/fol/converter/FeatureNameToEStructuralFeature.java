package org.sidiff.validation.laguage.fol.converter;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Constraint;
import org.sidiff.validation.laguage.fol.firstOrderLogic.ConstraintRuleBase;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Get;
import org.sidiff.validation.laguage.fol.firstOrderLogic.GetTerm;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Quantifier;

public class FeatureNameToEStructuralFeature extends DefaultTerminalConverters {

//	private Map<EClass, Set<EClass>> subTypes = new HashMap<>();
	
	public static EClass getClass(Get context) {
		ConstraintRuleBase rulebase = getConstraintRuleBase(context);
		
		if (rulebase != null) {
			EPackage domainPackage = EPackage.Registry.INSTANCE.getEPackage(rulebase.getDomain().trim());
			
			if (domainPackage != null) {
				
				// explicit type?
				String type = context.getType();
				
				// get bounded type:
				if (type == null) {
					type = getParentType(context);
				}
				
				EClassifier classifier = domainPackage.getEClassifier(type);
				
				if (classifier instanceof EClass) {
					return (EClass) classifier;
				}
			}
		}
		
		return null;
	}
	
	private static ConstraintRuleBase getConstraintRuleBase(EObject obj) {
		EObject root = obj.eResource().getContents().get(0);
		
		if (root instanceof ConstraintRuleBase) {
			return (ConstraintRuleBase) root;
		} else {
			return null;
		}
	}
	
	private static String getParentType(EObject obj) {
		String type = null;

		while ((type == null) && (obj != null)) {
			obj = obj.eContainer();
			type = getType(obj);
		}
		
		return type;
	}
	
	private static String getType(EObject obj) {
		if (obj instanceof Constraint) {
			return ((Constraint) obj).getVariable().getType();
		} else if (obj instanceof Quantifier) {
			return ((Quantifier) obj).getName().getType();
		} else if (obj instanceof GetTerm) {
			return ((GetTerm) obj).getName().getType();
		} else if (obj instanceof Get) {
			Get get = ((Get) obj);
			
			if ((get.getName() != null) && (!get.eIsProxy())) {
				return ((Get) obj).getName().getEType().getName();
			}
		}
		return null;
	}
	
//	private EStructuralFeature getFeatureFromSubType(EClass classifier, String name) {
//		Collection<EClass> subTypes = getSubTypes(classifier);
//		EStructuralFeature feature = null;
//		
//		String supportedSubClasses = null;
//		int supportedSubClassesCount = 0;
//		
//		for (EClass eClass : subTypes) {
//			EStructuralFeature subFeature = eClass.getEStructuralFeature(name);
//			
//			if (subFeature != null) {
//				if (supportedSubClassesCount == 0) {
//					feature = subFeature;
//					
//					supportedSubClasses = eClass.getName();
//					++supportedSubClassesCount;
//				} else {
//					// avoid ambiguities:
//					supportedSubClasses += ", " + eClass.getName();
//					
//					if (subFeature != feature) {
//						++supportedSubClassesCount;
//					}
//				}
//			} 
//		}
//		
//		if (supportedSubClassesCount > 1) {
//			throw new ValueConverterException("Add explicit cast to: " + supportedSubClasses + "!", node, null);
//		} else {
//			return feature;
//		}
//	}
//	
//	/**
//	 * @param superType
//	 *            A meta-class of the domain model.
//	 * @return All corresponding sub-types (i.e. sub-meta-classes).
//	 */
//	private Set<EClass> getSubTypes(EClass superType) {
//		Set<EClass> subTypes = this.subTypes.get(superType);
//		
//		if (subTypes == null) {
//			createSubtypeIndex(superType.getEPackage());
//			subTypes = this.subTypes.get(superType);
//		}
//		
//		return subTypes;
//	}
//	
//	private void createSubtypeIndex(EPackage ePackage) {
//
//		// Iterate over all classes in the package
//		for (Iterator<EObject> i = ePackage.eAllContents(); i.hasNext();) {
//			EObject obj = i.next();
//
//			if (obj instanceof EClass) {
//				// Next class (A)
//				EClass eSubClass = (EClass) obj;
//
//				if (!subTypes.containsKey(eSubClass)) {
//					subTypes.put(eSubClass, new HashSet<EClass>(0));
//				}
//
//				// Lookup the super types (X,Y,Z) of class (A) and add
//				// class (A) as sub type to the classes (X, Y, Z)
//				for (EClass eSuperClass : eSubClass.getEAllSuperTypes()) {
//					Set<EClass> allSubTypes = subTypes.get(eSuperClass);
//
//					if (allSubTypes == null) {
//						allSubTypes = new HashSet<EClass>(0);
//						subTypes.put(eSuperClass, allSubTypes);
//					}
//
//					allSubTypes.add(eSubClass);
//				}
//			}
//		}
//	}
}
