package org.sidiff.validation.constraint.impact;

import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public interface ImpactAnalysis {

	boolean onCreate(EObject sourceContext, EReference reference);
	
	boolean onDelete(EObject sourceContext, EReference reference);

	boolean onModify(EObject containerContext, EAttribute attribute);
	
	/**
	 * @return All context elements of the impact scope.
	 */
	Set<EObject> getScope();
}
