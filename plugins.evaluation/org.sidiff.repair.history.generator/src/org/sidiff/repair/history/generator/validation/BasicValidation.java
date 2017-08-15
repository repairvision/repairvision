package org.sidiff.repair.history.generator.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.repair.historymodel.ValidationError;

public abstract class BasicValidation implements IValidator {
	
	public boolean matchValidationError(ValidationError validationErrorA, ValidationError validationErrorB) {

		if  (validationErrorA.getName().equals(validationErrorB.getName())) {
			
//			Set<String> invalidElementAIDs = new HashSet<>();
//			
//			for (EObject invalidElementA : validationErrorA.getInvalidElement()) {
//				String id = EMFUtil.getXmiId(invalidElementA);
//				
//				if (id != null) {
//					invalidElementAIDs.add(id);
//				} else {
//					invalidElementAIDs.add(EcoreUtil.getURI(invalidElementA).fragment().toString());
//				}
//			}
//			
//			Set<String> invalidElementBIDs = new HashSet<>();
//			
//			for (EObject invalidElementB : validationErrorB.getInvalidElement()) {
//				String id = EMFUtil.getXmiId(invalidElementB);
//				
//				if (id != null) {
//					invalidElementBIDs.add(id);
//				} else {
//					invalidElementBIDs.add(EcoreUtil.getURI(invalidElementB).fragment().toString());
//				}
//			}
			
			return getObjectID(getContextElement(validationErrorA)).equals(getObjectID(getContextElement(validationErrorB)));
		}
		
		return false;
	}
	
	protected String getObjectID(EObject obj) {
		String id = EMFUtil.getXmiId(obj);
		
		if (id == null) {
			id = EcoreUtil.getURI(obj).fragment().toString();
		}
		
		return id;
	}
	
	@Override
	public EObject getContextElement(ValidationError validationError) {
		if (validationError.getContext() == null) {
			return validationError.getInvalidElement().get(0);
		} else {
			return validationError.getContext();
		}
	}
}
