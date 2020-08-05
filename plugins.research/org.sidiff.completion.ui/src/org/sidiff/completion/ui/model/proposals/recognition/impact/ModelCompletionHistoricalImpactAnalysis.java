package org.sidiff.completion.ui.model.proposals.recognition.impact;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.revision.common.emf.MetaModelUtil;
import org.sidiff.revision.difference.AddObject;
import org.sidiff.revision.difference.AddReference;
import org.sidiff.revision.difference.AttributeValueChange;
import org.sidiff.revision.difference.Change;
import org.sidiff.revision.difference.RemoveObject;
import org.sidiff.revision.difference.RemoveReference;
import org.sidiff.revision.impact.analysis.ImpactAnalysis;
import org.sidiff.revision.impact.analysis.PotentialImpactAnalysis;

public class ModelCompletionHistoricalImpactAnalysis implements PotentialImpactAnalysis, ImpactAnalysis {

	private List<Change> contextChanges;
	
	public ModelCompletionHistoricalImpactAnalysis(List<Change> contextChanges) {
		this.contextChanges = contextChanges;
	}
	
	@Override
	public boolean onCreateObject(EReference containingReference, EClass objectType, boolean strict) {
		
		for (Change contextChange : contextChanges) {
			if (contextChange instanceof AddObject) {
				EClass addObjectType = ((AddObject) contextChange).getObj().eClass();
				
				if (!strict || objectType.equals(addObjectType)) {
					if (strict || MetaModelUtil.isAssignableTo(objectType, addObjectType)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	@Override
	public boolean onDeleteObject(EReference containingReference, EClass objectType, boolean strict) {
		
		for (Change contextChange : contextChanges) {
			if (contextChange instanceof RemoveObject) {
				EClass addObjectType = ((RemoveObject) contextChange).getObj().eClass();
				
				if (!strict || objectType.equals(addObjectType)) {
					if (strict || MetaModelUtil.isAssignableTo(objectType, addObjectType)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	@Override
	public boolean onCreateReference(EClass sourceContextType, EReference reference, boolean strict) {
		
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
	public boolean onDeleteReference(EClass sourceContextType, EReference reference, boolean strict) {
		
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
	public boolean onModifyAttribute(EClass containerContextType, EAttribute attribute, boolean strict) {
		
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
	public boolean onCreateObject(EReference containingReference, EObject object) {
		
		for (Change contextChange : contextChanges) {
			if (contextChange instanceof AddObject) {
				if (((AddObject) contextChange).getObj() == object) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public boolean onDeleteObject(EReference containingReference, EObject object) {
		
		for (Change contextChange : contextChanges) {
			if (contextChange instanceof RemoveObject) {
				if (((RemoveObject) contextChange).getObj() == object) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public boolean onCreateReference(EObject sourceContext, EReference reference) {
		
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
	public boolean onDeleteReference(EObject sourceContext, EReference reference) {
		
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
	public boolean onModifyAttribute(EObject containerContext, EAttribute attribute) {
		
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

}
