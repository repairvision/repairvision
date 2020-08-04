package org.sidiff.revision.impact.changetree.change;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.revision.impact.changetree.change.actions.AttributeChangeAction;
import org.sidiff.revision.impact.changetree.change.actions.ObjectChangeAction;
import org.sidiff.revision.impact.changetree.change.actions.ReferenceChangeAction;
import org.sidiff.revision.impact.changetree.change.actions.StructuralFeatureChangeAction;
import org.sidiff.revision.impact.changetree.change.actions.ChangeAction.RepairType;

public class ChangeActionFactory {
	
	public static ChangeActionFactory actionFactory;
			
	public static ChangeActionFactory getInstance() {
		
		if (actionFactory == null) {
			actionFactory = new ChangeActionFactory();
		}
		
		return actionFactory;
	}
	
	public ObjectChangeAction create(RepairType type, EReference containingReference, EClass objectType) {
		return new ObjectChangeAction(type, containingReference, objectType);
	}
	
	public ObjectChangeAction create(RepairType type, EReference containingReference, EClass objectType, EObject object) {
		return new ObjectChangeAction(type, containingReference, objectType, object);
	}
	
	public StructuralFeatureChangeAction create(RepairType type, EObject context, EStructuralFeature feature) {
		if (feature instanceof EAttribute) {
			return create(type, context, (EAttribute) feature);
		}
		if (feature instanceof EReference) {
			return create(type, context, (EReference) feature);
		}
		return null;
	}
	
	public StructuralFeatureChangeAction create(RepairType type, EObject context, EStructuralFeature feature, Object object) {
		if (feature instanceof EAttribute) {
			return create(type, context, (EAttribute) feature, object);
		}
		if ((feature instanceof EReference) && (object instanceof EObject)) {
			return create(type, context, (EReference) feature, (EObject) object);
		}
		return null;
	} 
	
	public AttributeChangeAction create(RepairType type, EObject context, EAttribute attribtue) {
		return new AttributeChangeAction(type, context, attribtue);
	}
	
	public AttributeChangeAction create(RepairType type, EObject context, EAttribute attribtue, Object value) {
		return new AttributeChangeAction(type, context, attribtue, value);
	}
	
	public ReferenceChangeAction create(RepairType type, EObject context, EReference reference) {
		return new ReferenceChangeAction(type, context, reference);
	}
	
	public ReferenceChangeAction create(RepairType type, EObject context, EReference reference, EObject target) {
		return new ReferenceChangeAction(type, context, reference, target);
	}
}
