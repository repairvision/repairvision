package org.sidiff.history.analysis.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.historymodel.Problem;

public abstract class BasicValidation implements IValidator {
	
	public boolean matchValidationError(Problem validationErrorA, Problem validationErrorB) {

		if  (validationErrorA.getName().equals(validationErrorB.getName())) {
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
	public EObject getContextElement(Problem validationError) {
		if (validationError.getContextElement() == null) {
			return validationError.getInvalidElements().get(0);
		} else {
			return validationError.getContextElement();
		}
	}
}
