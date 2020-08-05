package org.sidiff.completion.ui.model.proposals.recognition.impact;

import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.revision.common.emf.MetaModelUtil;
import org.sidiff.revision.impact.analysis.ImpactAnalysis;
import org.sidiff.revision.impact.analysis.ImpactScope;
import org.sidiff.revision.impact.analysis.PotentialImpactScope;

public class ModelCompletionImpactScope implements PotentialImpactScope, ImpactScope {

	private Set<EObject> context;
	
	private ImpactAnalysis impact;
	
	public ModelCompletionImpactScope(Set<EObject> context, ImpactAnalysis impact) {
		this.context = context;
		this.impact = impact;
	}
	
	@Override
	public Iterator<EObject> onCreateObject(EReference containingReference, EClass objectType, boolean strict) {
		return context.stream()
				.filter(obj -> matchType(obj, objectType, strict))
				.filter(obj -> impact.onCreateObject(containingReference, obj))
				.collect(Collectors.toList()).iterator();
	}

	@Override
	public Iterator<EObject> onDeleteObject(EReference containingReference, EClass objectType, boolean strict) {
		return context.stream()
				.filter(obj -> matchType(obj, objectType, strict))
				.filter(obj -> impact.onCreateObject(containingReference, obj))
				.collect(Collectors.toList()).iterator();
	}

	@Override
	public Iterator<EObject> onCreateReference(EClass contextType, EReference referenceType, boolean strict) {
		return context.stream()
				.filter(obj -> matchType(obj, contextType, strict))
				.filter(obj -> impact.onCreateReference(obj, referenceType))
				.collect(Collectors.toList()).iterator();
	}

	@Override
	public Iterator<EObject> onDeleteReference(EClass contextType, EReference referenceType, boolean strict) {
		return context.stream()
				.filter(obj -> matchType(obj, contextType, strict))
				.filter(obj -> impact.onCreateReference(obj, referenceType))
				.collect(Collectors.toList()).iterator();
	}

	@Override
	public Iterator<EObject> onModifyAttribute(EClass contextType, EAttribute attributeType, boolean strict) {
		return context.stream()
				.filter(obj -> matchType(obj, contextType, strict))
				.filter(obj -> impact.onModifyAttribute(obj, attributeType))
				.collect(Collectors.toList()).iterator();
	}

	@Override
	public Set<EObject> getScope() {
		return context;
	}
	
	private boolean matchType(EObject obj, EClass objectType, boolean strict) {
		if (!strict || objectType.equals(obj.eClass())) {
			if (strict || MetaModelUtil.isAssignableTo(obj.eClass(), objectType)) {
				return true;
			}
		}
		return false;
	}

}
