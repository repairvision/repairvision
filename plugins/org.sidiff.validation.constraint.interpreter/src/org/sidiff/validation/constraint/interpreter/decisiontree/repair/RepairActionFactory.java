package org.sidiff.validation.constraint.interpreter.decisiontree.repair;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.actions.AttributeRepairAction;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.actions.ObjectRepairAction;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.actions.ReferenceRepairAction;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.actions.StructuralFeatureRepairAction;
import org.sidiff.validation.constraint.interpreter.decisiontree.repair.actions.RepairAction.RepairType;

public class RepairActionFactory {
	
	public static RepairActionFactory actionFactory;
			
	public static RepairActionFactory getInstance() {
		
		if (actionFactory == null) {
			actionFactory = new RepairActionFactory();
		}
		
		return actionFactory;
	}
	
	public ObjectRepairAction create(RepairType type, EReference containingReference, EClass objectType) {
		return new ObjectRepairAction(type, containingReference, objectType);
	}
	
	public ObjectRepairAction create(RepairType type, EReference containingReference, EClass objectType, EObject object) {
		return new ObjectRepairAction(type, containingReference, objectType, object);
	}
	
	public StructuralFeatureRepairAction create(RepairType type, EObject context, EStructuralFeature feature) {
		if (feature instanceof EAttribute) {
			return create(type, context, (EAttribute) feature);
		}
		if (feature instanceof EReference) {
			return create(type, context, (EReference) feature);
		}
		return null;
	}
	
	public StructuralFeatureRepairAction create(RepairType type, EObject context, EStructuralFeature feature, Object object) {
		if (feature instanceof EAttribute) {
			return create(type, context, (EAttribute) feature, object);
		}
		if ((feature instanceof EReference) && (object instanceof EObject)) {
			return create(type, context, (EReference) feature, (EObject) object);
		}
		return null;
	} 
	
	public AttributeRepairAction create(RepairType type, EObject context, EAttribute attribtue) {
		return new AttributeRepairAction(type, context, attribtue);
	}
	
	public AttributeRepairAction create(RepairType type, EObject context, EAttribute attribtue, Object value) {
		return new AttributeRepairAction(type, context, attribtue, value);
	}
	
	public ReferenceRepairAction create(RepairType type, EObject context, EReference reference) {
		return new ReferenceRepairAction(type, context, reference);
	}
	
	public ReferenceRepairAction create(RepairType type, EObject context, EReference reference, EObject target) {
		return new ReferenceRepairAction(type, context, reference, target);
	}
}
