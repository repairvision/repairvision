package org.sidiff.revision.impact.changetree.change.actions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.revision.common.emf.MetaModelUtil;
import org.sidiff.revision.impact.changetree.IDecisionLeaf;

public abstract class StructuralFeatureChangeAction extends ChangeAction  {

	protected EObject context;
	
	protected EStructuralFeature feature;
	
	public StructuralFeatureChangeAction(RepairType type, EObject source, EStructuralFeature feature) {
		super(type);
		this.context = source;
		this.feature = feature;
	}
	
	public EObject getContext() {
		return context;
	}

	public EStructuralFeature getFeature() {
		return feature;
	}
	
	@Override
	public int compareTo(IDecisionLeaf leaf) {
		
		if (leaf == this) {
			return 0;
		}
		
		if (leaf instanceof StructuralFeatureChangeAction) {
			StructuralFeatureChangeAction otherRepair = (StructuralFeatureChangeAction) leaf;
			
			if (this.getType().equals(otherRepair.getType())) {
				if (this.getFeature().equals(otherRepair.getFeature())) {
					if (this.getContext().equals(otherRepair.getContext())) {
						return 0;
					}
				}
			}
		}
		
		return this.toString().compareTo(leaf.toString());
	}
	
	public boolean match(RepairType type, EObject context, EStructuralFeature feature) {
		if (this.type.equals(RepairType.MODIFY) || this.type.equals(type)) {
			if (this.context == context) {
				if (this.feature.equals(feature)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean match(RepairType type, EClass contextType, EStructuralFeature feature, boolean strict) {
		if (this.type.equals(RepairType.MODIFY) || this.type.equals(type)) {
			if (this.feature.equals(feature)) {
				if (!strict || contextType.equals(this.context.eClass())) {
					if (strict || MetaModelUtil.isAssignableTo(this.context.eClass(), contextType)) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
