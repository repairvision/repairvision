package org.sidiff.history.analysis.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.historymodel.Problem;
import org.sidiff.revision.common.emf.EMFStorage;

public abstract class BasicValidation implements IValidator {
	
	@Override
	public boolean matchProblems(Problem problemA, Problem problemB) {

		if  (problemA.getName().equals(problemB.getName())) {
			return getObjectID(getContextElement(problemA)).equals(getObjectID(getContextElement(problemB)));
		}
		
		return false;
	}
	
	protected String getObjectID(EObject obj) {
		String id = EMFStorage.getXmiId(obj);
		
		if (id == null) {
			id = EcoreUtil.getURI(obj).fragment().toString();
		}
		
		return id;
	}
	
	@Override
	public EObject getContextElement(Problem problem) {
		if (problem.getContextElement() == null) {
			return problem.getInvalidElements().get(0);
		} else {
			return problem.getContextElement();
		}
	}
}
