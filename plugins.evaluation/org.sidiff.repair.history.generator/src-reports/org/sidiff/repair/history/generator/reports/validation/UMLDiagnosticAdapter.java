package org.sidiff.repair.history.generator.reports.validation;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.repair.history.generator.reports.util.UMLUtil;

public class UMLDiagnosticAdapter extends EMFDiagnosticAdapter {

	public UMLDiagnosticAdapter(Diagnostic diagnostic) {
		super(diagnostic);
	}

	@Override
	protected String getIdentificationString() {
		String res = getCharacterizingMessageFragment();
		res += "::";
		
		for (Object o : getAdaptee().getData()) {
			if (o instanceof EObject){
				res += EMFUtil.getXmiId((EObject) o);
				res += "::";
			}
		}
		
		return res;
	}

	@Override
	protected List<String> getCharacterizingMessageFragments() {
		return UMLUtil.getCharacterizingMessageFragments();
	}
}
