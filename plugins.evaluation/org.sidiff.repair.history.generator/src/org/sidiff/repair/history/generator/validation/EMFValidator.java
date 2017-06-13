package org.sidiff.repair.history.generator.validation;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.sidiff.repair.historymodel.HistoryModelFactory;
import org.sidiff.repair.historymodel.ValidationError;
import org.sidiff.repair.historymodel.ValidationSeverity;

/**
 * Delegates the validation
 * 
 * to the EMF validation framework.
 * 
 * @author kehrer, cpietsch
 */
public class EMFValidator implements IValidator {
	
	private static final int DOCTYPE_UML = 1;
	
	private static final int DOCTYPE_ECORE = 2;
	
	@Override
	public Collection<ValidationError> validate(Resource resource) {
		int docType = 0;
		
		if (resource instanceof UMLResource) {
			docType = DOCTYPE_UML;
		}
		if (resource.getURI().lastSegment().endsWith("ecore")) {
			docType = DOCTYPE_ECORE;
		}
		
		assert (docType != 0);
		
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
		
		Collection<ValidationError> res = new ArrayList<ValidationError>();
		for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
			if ((childDiagnostic.getSeverity() == Diagnostic.ERROR)
					|| (childDiagnostic.getSeverity() == Diagnostic.WARNING)) {
				
				ValidationError validationError = HistoryModelFactory.eINSTANCE.createValidationError();
				validationError.setMessage(childDiagnostic.getMessage());
				validationError.setSource(childDiagnostic.getSource());
				
				if (childDiagnostic.getSeverity() == Diagnostic.ERROR) {
					validationError.setSeverity(ValidationSeverity.ERROR);
				} else if (childDiagnostic.getSeverity() == Diagnostic.WARNING) {
					validationError.setSeverity(ValidationSeverity.WARNING);
				} else {
					validationError.setSeverity(ValidationSeverity.UNKNOWN);
				}

				String name = childDiagnostic.getMessage().replaceAll("'.*?'", "").trim();
				name = name.replaceAll("\\s.[^\\s]*@.*?\\s", "");
				
				while (name.contains(" ")) {
					int index = name.indexOf(" ");
					name = name.replace(name.substring(index, index + 2),
							name.substring(index + 1, index + 2).toUpperCase());
				}
				name = name.replaceAll("[^\\p{Alpha}]", "");
				validationError.setName(name);
				
				for (Object obj : childDiagnostic.getData()) {
					if (obj instanceof EObject) {
						validationError.getInvalidElement().add((EObject) obj);
					}
				}
				res.add(validationError);
			}
		}
		
		return res;
	}
	
}
