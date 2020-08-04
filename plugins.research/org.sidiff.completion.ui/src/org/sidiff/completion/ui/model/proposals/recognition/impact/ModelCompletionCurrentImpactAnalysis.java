package org.sidiff.completion.ui.model.proposals.recognition.impact;

import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.revision.impact.analysis.ImpactAnalysis;
import org.sidiff.revision.impact.analysis.PotentialImpactAnalysis;

public class ModelCompletionCurrentImpactAnalysis implements PotentialImpactAnalysis, ImpactAnalysis {

	private Set<EObject> context;
	
	public ModelCompletionCurrentImpactAnalysis(Set<EObject> context) {
		this.context = context;
	}
	
	@Override
	public boolean onCreateObject(EReference containingReference, EClass objectType, boolean strict) {
		
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
	public boolean onDeleteObject(EReference containingReference, EClass objectType, boolean strict) {
		
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
	public boolean onCreateReference(EClass sourceContextType, EReference reference, boolean strict) {
		
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
	public boolean onDeleteReference(EClass sourceContextType, EReference reference, boolean strict) {
		
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
	public boolean onModifyAttribute(EClass containerContextType, EAttribute attribute, boolean strict) {
		
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
	public boolean onCreateObject(EReference containingReference, EObject object) {
		return context.contains(object);
	}
	
	@Override
	public boolean onDeleteObject(EReference containingReference, EObject object) {
		return context.contains(object);
	}

	@Override
	public boolean onCreateReference(EObject sourceContext, EReference reference) {
		return context.contains(sourceContext);
	}

	@Override
	public boolean onDeleteReference(EObject sourceContext, EReference reference) {
		return context.contains(sourceContext);
	}

	@Override
	public boolean onModifyAttribute(EObject containerContext, EAttribute attribute) {
		return context.contains(containerContext);
	}



}
