package org.sidiff.validation.constraint.impact;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

public interface PotentialImpactAnalysis {

	boolean onCreate(EClass sourceContextType, EReference reference, boolean strict);
	
	boolean onDelete(EClass sourceContextType, EReference reference, boolean strict);

	boolean onModify(EClass containerContextType, EAttribute attribute, boolean strict);
}
