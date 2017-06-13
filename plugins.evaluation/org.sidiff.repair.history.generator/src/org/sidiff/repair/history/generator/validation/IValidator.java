package org.sidiff.repair.history.generator.validation;

import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.repair.historymodel.ValidationError;

/**
 * Encapsulates a concrete validation framework.
 * 
 * @author kehrer
 */
public interface IValidator {

	public Collection<ValidationError> validate(Resource resource);
	
}
