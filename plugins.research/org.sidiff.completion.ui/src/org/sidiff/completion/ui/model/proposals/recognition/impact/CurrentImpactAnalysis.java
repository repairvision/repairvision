package org.sidiff.completion.ui.model.proposals.recognition.impact;

import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.validation.constraint.impact.ImpactAnalysis;
import org.sidiff.validation.constraint.impact.PotentialImpactAnalysis;

public class CurrentImpactAnalysis implements ImpactAnalysis, PotentialImpactAnalysis {

	private Set<EObject> context;
	
	public CurrentImpactAnalysis(Set<EObject> context) {
		this.context = context;
	}
	
	@Override
	public boolean onCreate(EReference containingReference, EClass objectType, boolean strict) {
		
		for (EObject contextElement : context) {
			if (objectType.isInstance(contextElement)) {
				if (!strict || (objectType == contextElement.eClass())) {
					if (contextElement.eContainmentFeature() == containingReference) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	@Override
	public boolean onDelete(EReference containingReference, EClass objectType, boolean strict) {
		
		for (EObject contextElement : context) {
			if (objectType.isInstance(contextElement)) {
				if (!strict || (objectType == contextElement.eClass())) {
					if (contextElement.eContainmentFeature() == containingReference) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	@Override
	public boolean onCreate(EClass sourceContextType, EReference reference, boolean strict) {
		
		for (EObject contextElement : context) {
			if (sourceContextType.isInstance(contextElement)) {
				if (!strict || (sourceContextType == contextElement.eClass())) {
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean onDelete(EClass sourceContextType, EReference reference, boolean strict) {
		
		for (EObject contextElement : context) {
			if (sourceContextType.isInstance(contextElement)) {
				if (!strict || (sourceContextType == contextElement.eClass())) {
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean onModify(EClass containerContextType, EAttribute attribute, boolean strict) {
		
		for (EObject contextElement : context) {
			if (containerContextType.isInstance(contextElement)) {
				if (!strict || (containerContextType == contextElement.eClass())) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public boolean onCreate(EObject object) {
		return context.contains(object);
	}
	
	@Override
	public boolean onDelete(EObject object) {
		return context.contains(object);
	}

	@Override
	public boolean onCreate(EObject sourceContext, EReference reference) {
		return context.contains(sourceContext);
	}

	@Override
	public boolean onDelete(EObject sourceContext, EReference reference) {
		return context.contains(sourceContext);
	}

	@Override
	public boolean onModify(EObject containerContext, EAttribute attribute) {
		return context.contains(containerContext);
	}

	@Override
	public Set<EObject> getScope() {
		return context;
	}

}
