package org.sidiff.editrule.partialmatcher.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.difference.symmetric.SymmetricDifference;
import org.sidiff.difference.symmetric.SymmetricPackage;

public class RecognitionRuleUtil {

	private static final SymmetricPackage SYMMETRIC_PACKAGE = SymmetricPackage.eINSTANCE;
	
	public static SymmetricDifference getSymmetricDifference(ResourceSet rss) {
		SymmetricDifference difference = null;
		
		for (Resource res : rss.getResources()) {
			if ((res.getContents() != null) && (res.getContents().get(0) instanceof SymmetricDifference)) {
				difference = (SymmetricDifference) res.getContents().get(0);
				break;
			}
		}
		
		return difference;
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
}
