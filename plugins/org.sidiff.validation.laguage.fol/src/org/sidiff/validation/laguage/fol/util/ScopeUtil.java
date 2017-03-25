package org.sidiff.validation.laguage.fol.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Constraint;
import org.sidiff.validation.laguage.fol.firstOrderLogic.ConstraintLibrary;
import org.sidiff.validation.laguage.fol.firstOrderLogic.FirstOrderLogicPackage;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Get;
import org.sidiff.validation.laguage.fol.firstOrderLogic.Quantifier;
import org.sidiff.validation.laguage.fol.firstOrderLogic.VariableRef;

public class ScopeUtil extends DefaultTerminalConverters {

	public static Collection<EClassifier> getAllTypes(EObject context) {
		ConstraintLibrary rulebase = getConstraintLibrary(context);

		if (rulebase != null) {
			EPackage domainPackage = EPackage.Registry.INSTANCE.getEPackage(rulebase.getDomain().trim());
			
			if (domainPackage != null) {
				return domainPackage.getEClassifiers();
			}
		}
		
		return null;
	}
	
	private static ConstraintLibrary getConstraintLibrary(EObject context) {
		EObject root = context.eResource().getContents().get(0);
		
		if (root instanceof ConstraintLibrary) {
			return (ConstraintLibrary) root;
		} else {
			return null;
		}
	}
	
	public static EClassifier getType(EObject obj) {
		EClassifier type = getBoundedType(obj);

		while ((type == null) && (obj != null)) {
			obj = obj.eContainer();
			type = getBoundedType(obj);
		}

		return type;
	}
	
	private static EClassifier getBoundedType(EObject obj) {
		if (obj instanceof Constraint) {
			return ((Constraint) obj).getVariable().getType();
		} else if (obj instanceof Quantifier) {
			return ((Quantifier) obj).getName().getType();
		} else if (obj instanceof VariableRef) {
			return ((VariableRef) obj).getName().getType();
		} else if (obj instanceof Get) {
			Get get = ((Get) obj);

			// explicit type?
			if (!isProxy(get, FirstOrderLogicPackage.eINSTANCE.getGet_Type()) && (get.getType() != null)) {
				return get.getType();
			}

			// get accessed type:
			else if ((get.eContainer() instanceof Get) && (((Get) get.eContainer()).getName() != null)) {
				return ((Get) get.eContainer()).getName().getEType();
			}
		}
		return null;
	}
	
	public static Collection<EClass> getAllSubTypes(EObject context) {
		Collection<EClass> subTypes = new ArrayList<>();
		EClassifier type = getType(context);
		
		// Iterate over all classes in the package
		for (EClassifier classifier : getAllTypes(context)) {

			if (classifier instanceof EClass) {
				if (((EClass) classifier).getEAllSuperTypes().contains(type)) {
					subTypes.add((EClass) classifier);
				}
			}
		}
		
		return subTypes;
	}
	
	public static Collection<EStructuralFeature> getAllFeatures(EObject context) {
		EClassifier type = getType(context);
		
		if (type instanceof EClass) {
			return ((EClass) type).getEAllStructuralFeatures();
		}
		
		return Collections.emptyList();
	}
	
	private static boolean isProxy(EObject obj, EStructuralFeature feature) {
		Object value = obj.eGet(feature, false);
		
		if (value instanceof EObject) {
			return ((EObject) value).eIsProxy();
		}
		
		return false;
	}
}
