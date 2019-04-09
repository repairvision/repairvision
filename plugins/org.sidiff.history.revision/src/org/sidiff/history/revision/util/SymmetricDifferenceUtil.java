package org.sidiff.history.revision.util;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.difference.symmetric.AddObject;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveObject;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.difference.symmetric.SymmetricPackage;

public class SymmetricDifferenceUtil {

	private static final SymmetricPackage SYMMETRIC_PACKAGE = SymmetricPackage.eINSTANCE;
	
	public static URI getDifferenceURI(URI modelA, URI modelB) {
		return URI.createURI(
				modelA.trimFileExtension().toString() + "_to_" +
				modelB.trimFileExtension().appendFileExtension(".symmetric").lastSegment());
	}
	
	public static boolean validateChange(Change change) {
		
		if (change instanceof AddObject) {
			return isResolvable(((AddObject) change).getObj());
		} else if (change instanceof RemoveObject) {
			return isResolvable(((RemoveObject) change).getObj());
		} else if (change instanceof AddReference) {
			return isResolvable(((AddReference) change).getSrc()) && isResolvable(((AddReference) change).getTgt());
		} else if (change instanceof RemoveReference) {
			return isResolvable(((RemoveReference) change).getSrc()) && isResolvable(((RemoveReference) change).getTgt());
		} else if (change instanceof AttributeValueChange) {
			return isResolvable(((AttributeValueChange) change).getObjA()) && isResolvable(((AttributeValueChange) change).getObjB());
		}
		
		return true;
	}
	
	private static boolean isResolvable(EObject obj) {
		if (obj.eIsProxy()) {
			if ((obj.eResource() != null) && (obj.eResource().getResourceSet() != null)) {
				if (obj != EcoreUtil.resolve(obj, obj.eResource().getResourceSet())) {
					return true;
				}
			}
			return false;
		}
		return true;
	}
	
	public static boolean isChangeType(EClass type) {
		
		if ((type == SYMMETRIC_PACKAGE.getAddObject())
				|| (type == SYMMETRIC_PACKAGE.getRemoveObject())
				|| (type == SYMMETRIC_PACKAGE.getAddReference())
				|| (type == SYMMETRIC_PACKAGE.getRemoveReference())
				|| (type == SYMMETRIC_PACKAGE.getAttributeValueChange())) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isChangeReference(EReference type) {
		
		if ((type == SYMMETRIC_PACKAGE.getAddObject_Obj())
				|| (type == SYMMETRIC_PACKAGE.getRemoveObject_Obj())
				|| (type == SYMMETRIC_PACKAGE.getAddReference_Src())
				|| (type == SYMMETRIC_PACKAGE.getAddReference_Tgt())
				|| (type == SYMMETRIC_PACKAGE.getRemoveReference_Src())
				|| (type == SYMMETRIC_PACKAGE.getRemoveReference_Tgt())
				|| (type == SYMMETRIC_PACKAGE.getAttributeValueChange_ObjA())
				|| (type == SYMMETRIC_PACKAGE.getAttributeValueChange_ObjB())) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isChangeTypeReference(EReference type) {
		
		if ((type == SYMMETRIC_PACKAGE.getAddReference_Type())
				|| (type == SYMMETRIC_PACKAGE.getRemoveReference_Type())
				|| (type == SYMMETRIC_PACKAGE.getAttributeValueChange_Type())) {
			return true;
		}
		
		return false;
	}
	
	public boolean isChangeEqual(Set<Change> changeSetA, Set<Change> changeSetB) {

		if (changeSetA.size() == changeSetB.size()) {
			Set<Change> mappedChangesB = new HashSet<>();
			
			for (Change changeA : changeSetA) {
				if (getEqualChange(changeA, changeSetB, mappedChangesB) == null) {
					return false;
				}
			}
			
			return true;
		}
		
		return false;
	}
	
	private static Change getEqualChange(Change changeA, Set<Change> changeSetB, Set<Change> mappedChangesB) {
		
		for (Change changeB : changeSetB) {
			if (!mappedChangesB.contains(changeB)) {
				if (isEqualChange(changeA, changeB)) {
					mappedChangesB.add(changeB);
					return changeB;
				}
			}
		}
		return null;
	}
	
	public static boolean isEqualChange(Change changeA, Change changeB) {
		
		if (changeA.getClass() == changeB.getClass()) {
			
			if (changeA instanceof RemoveObject) {
				if (((RemoveObject) changeA).getObj().eClass() == ((RemoveObject) changeB).getObj().eClass()) {
					return true;
				}
			}
			
			else if (changeA instanceof RemoveReference) {
				if (((RemoveReference) changeA).getType().eClass() == ((RemoveReference) changeB).getType().eClass()) {
					if (((RemoveReference) changeA).getSrc().eClass() == ((RemoveReference) changeB).getSrc().eClass()) {
						if (((RemoveReference) changeA).getTgt().eClass() == ((RemoveReference) changeB).getTgt().eClass()) {
							return true;
						}
					}
				}
			}
			
			else if (changeA instanceof AddObject) {
				if (((AddObject) changeA).getObj().eClass() == ((AddObject) changeB).getObj().eClass()) {
					return true;
				}
			}
			
			else if (changeA instanceof AddReference) {
				if (((AddReference) changeA).getType().eClass() == ((AddReference) changeB).getType().eClass()) {
					if (((AddReference) changeA).getSrc().eClass() == ((AddReference) changeB).getSrc().eClass()) {
						if (((AddReference) changeA).getTgt().eClass() == ((AddReference) changeB).getTgt().eClass()) {
							return true;
						}
					}
				}
			}
			
			else if (changeA instanceof AttributeValueChange) {
				if (((AttributeValueChange) changeA).getType().eClass() == ((AttributeValueChange) changeB).getType().eClass()) {
					if (((AttributeValueChange) changeA).getObjA().eClass() == ((AttributeValueChange) changeB).getObjA().eClass()) {
						if (((AttributeValueChange) changeA).getObjB().eClass() == ((AttributeValueChange) changeB).getObjB().eClass()) {
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
}
