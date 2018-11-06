package org.sidiff.history.analysis.validation;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.historymodel.Problem;
import org.sidiff.historymodel.Version;

/**
 * Encapsulates a concrete validation framework.
 * 
 * @author kehrer, Manuel Ohrndorf
 */
public interface IValidator {

	void validate(Version version);
	
	boolean matchProblems(Problem validationErrorA, Problem validationErrorB);
	
	EObject getContextElement(Problem validationError);
}
