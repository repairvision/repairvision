package org.sidiff.completion.ui.model.proposals.recognition.impact;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.difference.symmetric.AddReference;
import org.sidiff.difference.symmetric.AttributeValueChange;
import org.sidiff.difference.symmetric.Change;
import org.sidiff.difference.symmetric.RemoveReference;
import org.sidiff.validation.constraint.impact.ImpactAnalysis;
import org.sidiff.validation.constraint.impact.PotentialImpactAnalysis;

public class HistoricalImpactAnalysis implements ImpactAnalysis, PotentialImpactAnalysis  {

	private Set<EObject> context;
	
	private List<Change> contextChanges;
	
	public HistoricalImpactAnalysis(Set<EObject> context, List<Change> contextChanges) {
		this.context = context;
		this.contextChanges = contextChanges;
	}
	
	@Override
	public boolean onCreate(EClass sourceContextType, EReference reference, boolean strict) {
		
		for (Change contextChange : contextChanges) {
			if (contextChange instanceof AddReference) {
				if (((AddReference) contextChange).getType() == reference) {
					if (!strict || sourceContextType.isInstance(((AddReference) contextChange).getSrc())) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean onDelete(EClass sourceContextType, EReference reference, boolean strict) {
		
		for (Change contextChange : contextChanges) {
			if (contextChange instanceof RemoveReference) {
				if (((RemoveReference) contextChange).getType() == reference) {
					if (!strict || sourceContextType.isInstance(((RemoveReference) contextChange).getSrc())) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean onModify(EClass containerContextType, EAttribute attribute, boolean strict) {
		
		for (Change contextChange : contextChanges) {
			if (contextChange instanceof AttributeValueChange) {
				if (((AttributeValueChange) contextChange).getType() == attribute) {
					if (!strict || containerContextType.isInstance(((AttributeValueChange) contextChange).getObjA())) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean onCreate(EObject sourceContext, EReference reference) {
		
		for (Change contextChange : contextChanges) {
			if (contextChange instanceof AddReference) {
				if (((AddReference) contextChange).getType() == reference) {
					if (sourceContext == ((AddReference) contextChange).getSrc()) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean onDelete(EObject sourceContext, EReference reference) {
		
		for (Change contextChange : contextChanges) {
			if (contextChange instanceof RemoveReference) {
				if (((RemoveReference) contextChange).getType() == reference) {
					if (sourceContext == ((RemoveReference) contextChange).getSrc()) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean onModify(EObject containerContext, EAttribute attribute) {
		
		for (Change contextChange : contextChanges) {
			if (contextChange instanceof AttributeValueChange) {
				if (((AttributeValueChange) contextChange).getType() == attribute) {
					if ((containerContext == ((AttributeValueChange) contextChange).getObjA())
							|| containerContext == ((AttributeValueChange) contextChange).getObjB()) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	@Override
	public Set<EObject> getScope() {
		return context;
	}

}