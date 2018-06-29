package org.sidiff.repair.history.generator.reports.validation;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * Delegates the validation to the EMF validation framework. Currently the only
 * implementation of an IValidator.
 * 
 * @author kehrer
 */
public class EMFValidator implements IValidator {

	private static final int DOCTYPE_UML = 1;
	private static final int DOCTYPE_ECORE = 2;

	@Override
	public Collection<IValidationError> validate(Resource resource) {
		int docType = 0;

		if (resource instanceof UMLResource) {
			docType = DOCTYPE_UML;
		} 
		if (resource.getURI().lastSegment().endsWith("ecore")){
			docType = DOCTYPE_ECORE;
		}

		assert (docType != 0);

		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(resource.getContents().get(0));

		Collection<IValidationError> res = new ArrayList<IValidationError>();
		for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
			if ((childDiagnostic.getSeverity() == Diagnostic.ERROR)
					|| (childDiagnostic.getSeverity() == Diagnostic.WARNING)) {

				if (docType == DOCTYPE_UML) {
					res.add(new UMLDiagnosticAdapter(childDiagnostic));
				}
				if (docType == DOCTYPE_ECORE) {
					res.add(new EcoreDiagnosticAdapter(childDiagnostic));
				}
			}
		}

		return res;
	}

}
